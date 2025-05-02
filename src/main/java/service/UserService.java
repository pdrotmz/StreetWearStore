package service;

import dao.UserDAO;
import exceptions.user.IncorrectPasswordException;
import exceptions.user.IncorrectUsernameException;
import exceptions.user.InvalidEmailFormatException;
import exceptions.user.InvalidPasswordFormat;
import model.user.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private static final UserDAO userDao = new UserDAO();

    public void registerUser(User user) {
        if(!user.getEmail().contains("@")) {
            throw new InvalidEmailFormatException(user.getEmail());
        } else if (!(user.getPassword().length() > 8)) {
            throw new InvalidPasswordFormat();
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userDao.saveUser(user);
    }

    public void loginUser(String username, String password) {
        User userNotLogged = userDao.findBYUsername(username);

        if(userNotLogged == null) {
            throw new IncorrectUsernameException("Usuário não encontrado!");
        }

        if(!BCrypt.checkpw(password, userNotLogged.getPassword())) {
            throw new IncorrectPasswordException();
        }
        System.out.println("Login bem-sucedido!");
    }
}
