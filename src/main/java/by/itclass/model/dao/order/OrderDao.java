package by.itclass.model.dao.order;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.order.OrderItem;
import by.itclass.model.entities.user.User;
import com.sun.tools.javac.util.List;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.itclass.constants.ApplicationConstants.USER_ATTR;
import static by.itclass.constants.DbConstants.INSERT_ORDER;
import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTR;

public class OrderDao {
    private static OrderDao dao;

    public OrderDao() throws IOException, ClassNotFoundException {
        ConnectionManager.init();
    }

    public static OrderDao getInstance() throws IOException, ClassNotFoundException {
        return dao == null
                ? new OrderDao()
                : dao;
    }

    public boolean saveOrder(HttpSession session, String address) {
        User user = (User) session.getAttribute(USER_ATTR);
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("HH-mm"));
        String orderId = user.getName() + "-" + date + "-" + time;

        List<OrderItem> items = (List<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTR);
        saveOrder(orderId, date, user.getId(), address);
        return false;
    }

    private boolean saveOrder(String orderId, String date, int userId, String address){
        try(Connection cn = ConnectionManager.getConnection();
            PreparedStatement ps = cn.prepareStatement(INSERT_ORDER)) {
                ps.setString(1,orderId);
                ps.setString(2,date);
                ps.setInt(3,userId);
                ps.setString(4,address);
                return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
