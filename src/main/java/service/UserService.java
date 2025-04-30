package service;

import dao.UserDAO;
import model.user.User;

public class UserService {

    private static final UserDAO userDao = new UserDAO();

    public void registerUser(User user) {
        userDao.saveUser(user);
    }

}
