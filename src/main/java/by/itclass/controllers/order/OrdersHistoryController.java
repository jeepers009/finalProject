package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.order.Order;
import by.itclass.model.entities.user.User;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.itclass.constants.ApplicationConstants.ORDERS_HISTORY_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "ordHistContr", urlPatterns = ORDERS_HISTORY_CONTROLLER)
public class OrdersHistoryController extends AbstractController {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        int userId = ((User) session.getAttribute(USER_ATTR)).getId();
        List<Order> orders = orderService.getOrders(userId);
        req.setAttribute(ORDERS_ATTR, orders);
        forward(req, resp, ORDERS_JSP);
    }
}
