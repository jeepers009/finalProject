package by.itclass.model.services.order;

import by.itclass.model.dao.order.OrderDao;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderService {
    private static OrderService service;
    private OrderDao dao;

    public OrderService() throws IOException, ClassNotFoundException {
        dao = OrderDao.getInstance();
    }

    public boolean saveOrder(HttpSession session, String address){
        return dao.saveOrder(session,address);
    }
}
