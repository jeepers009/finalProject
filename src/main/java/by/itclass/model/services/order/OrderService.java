package by.itclass.model.services.order;

import by.itclass.model.dao.order.OrderDao;
import by.itclass.model.entities.order.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderService {
    private static OrderService service;
    private OrderDao dao;

    public OrderService() {
        dao = OrderDao.getInstance();
    }

    public static OrderService getInstance() {
        return service == null ? new OrderService() : service;
    }

    public boolean saveOrder(HttpSession session, String address) {
        return dao.saveOrder(session, address);
    }

    public List<Order> getOrders(int userId) {
        return dao.getOrders(userId);
    }

    public String buildReceipt(String orderId) {
        return dao.buildReceipt(orderId);
    }

}
