package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.itclass.constants.ApplicationConstants.PRINT_ORDER_CONTROLLER;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "printOrderContr", urlPatterns = PRINT_ORDER_CONTROLLER)
public class PrintOrderController extends AbstractController {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String orderId = req.getParameter(ORDER_ID_ATTR);
        String receipt = orderService.buildReceipt(orderId);
        req.setAttribute(RECEIPT_ATTR, receipt);
        forward(req, resp, RECEIPT_JSP);
    }
}
