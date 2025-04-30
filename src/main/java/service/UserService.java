package service;

import dao.UserDAO;
import exceptions.user.InvalidEmailFormatException;
import exceptions.user.InvalidPasswordFormat;
import model.user.User;
import util.EncryptPassword;

public class UserService {

    private static final UserDAO userDao = new UserDAO();

    public void registerUser(User user) {
        if(!user.getEmail().contains("@")) {
            throw new InvalidEmailFormatException(user.getEmail());
        } else if (!(user.getPassword().length() > 8)) {
            throw new InvalidPasswordFormat();
        }
        String hashedPassword = EncryptPassword.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userDao.saveUser(user);
    }

}
