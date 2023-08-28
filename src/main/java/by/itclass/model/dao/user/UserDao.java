package by.itclass.model.dao.user;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.user.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.itclass.constants.DbConstants.*;

public class UserDao {
    private static UserDao dao;

    public UserDao() throws IOException, ClassNotFoundException {
        ConnectionManager.init();
    }

    public static UserDao getInstance() throws IOException, ClassNotFoundException {
        return dao == null ? new UserDao() : dao;
    }

    public User getUser(String login, String password) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID_COL);
                String name = resultSet.getString(NAME_COL);
                String email = resultSet.getString(EMAIL_COL);
                return new User(id, login, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user, String password) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(INSERT_USER)) {
            if (isAccessible(user.getLogin())) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, password);
                ps.setString(4, user.getEmail());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private boolean isAccessible(String login) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_LOGIN)) {
            ps.setString(1, login);
            return !ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
