package by.itclass.model.dao.user;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.user.User;

import java.io.IOException;

public class UserDao {
    private static UserDao dao;

    public UserDao() throws IOException, ClassNotFoundException {
        ConnectionManager.init();
    }

    public static UserDao getInstance() throws IOException, ClassNotFoundException {
        return dao == null ? new UserDao() : dao;
    }

    public User getUser(String login, String password) {
        return null;
    }

    public boolean addUser(User user, String password) {
        return true;
    }
}
