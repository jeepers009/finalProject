package by.itclass.model.services.user;

import by.itclass.model.dao.user.UserDao;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.user.User;

import java.io.IOException;

public class UserService {
    private static UserService service;
    private UserDao dao;

    public UserService() throws IOException, ClassNotFoundException {
        dao = UserDao.getInstance();
    }

    public static UserService getService() throws IOException, ClassNotFoundException {
        return service == null ? new UserService() : service;
    }

    public User getUser(String login, String password) {
        return dao.getUser(login, password);
    }

    public boolean addUser(User user, String password) {
        return dao.addUser(user, password);
    }
}
