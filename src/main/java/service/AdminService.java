package service;

import dao.AdminDAO;
import exceptions.user.IncorrectPasswordException;
import exceptions.user.IncorrectUsernameException;
import model.admin.Admin;
import org.mindrot.jbcrypt.BCrypt;

public class AdminService {

    private static final AdminDAO adminDAO = new AdminDAO();

    public void registerAdmin(Admin admin) {
        if(!admin.getEmail().contains("@") && !admin.getEmail().contains("@sws")) {
            System.err.println("Email ou domínio incorretos!");
        } else if (!(admin.getPassword().length() > 8)) {
            System.err.println("Senha precisa ter mais 8 caracteres");
        }
        adminDAO.SaveAdmin(admin);
    }

    public void loginUser(String email, String password) {
        Admin adminNotLogged = adminDAO.findByEmail(email);

        if(adminNotLogged == null) {
            throw new IncorrectUsernameException("Usuário não encontrado!");
        }
        if(!BCrypt.checkpw(password, adminNotLogged.getPassword())) {
            throw new IncorrectPasswordException();
        }
        System.out.println("Login bem-sucedido!");
    }
}
