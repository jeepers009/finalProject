package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.itclass.constants.ApplicationConstants.ORDER_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "orderController", urlPatterns = ORDER_CONTROLLER)
public class OrderController extends AbstractController {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String address = req.getParameter(ADDRESS_PARAM);
        HttpSession session = req.getSession();

        if (orderService.saveOrder(session, address)) {
            String orderId = (String) session.getAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ITEMS_ATTR);
            session.removeAttribute(ORDER_ID_ATTR);
            forward(req, resp, HOME_JSP, "Your order number is " + orderId + ", you can print it on Orders page.");
        } else {
            forward(req, resp, CART_JSP, "BAD");
        }
    }
}
