package by.itclass.controllers.food;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.OrderItem;
import by.itclass.model.entities.food.FoodItem;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import static by.itclass.constants.ApplicationConstants.*;
import static by.itclass.constants.JspConstants.*;

@WebServlet(name = "cartController", urlPatterns = CART_CONTROLLER)
public class CartController extends AbstractController {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter(FOOD_ID_PARAM));
        int foodType = Integer.parseInt(req.getParameter(FOOD_TYPE_PARAM));
        String foodName = req.getParameter(FOOD_NAME_PARAM);
        double foodPrice = Double.parseDouble(req.getParameter(FOOD_PRICE_PARAM));
        int foodQuantity = Integer.parseInt(req.getParameter(FOOD_QUANTITY_PARAM));

        String cardAction = req.getParameter(CART_ACTION_PARAM);
        OrderItem item = new OrderItem(
                new FoodItem(id, foodType, foodName, foodPrice), foodQuantity);
        HttpSession session = req.getSession();

        ArrayList<OrderItem> items = cartService.processCart(session, cardAction, item);

        session.setAttribute(ORDER_ITEMS_ATTR, items);

        if ("addToCard".equals(cardAction)) {
            redirectToMenuPage(resp, foodType);
        } else {
            redirect(resp, CART_JSP);
        }
    }

    private void redirectToMenuPage(HttpServletResponse resp, int foodType)
            throws IOException {
        switch (foodType) {
            case 1: {
                redirect(resp, PIZZAS_MENU);
                break;
            }
            case 2: {
                redirect(resp, DRINKS_MENU);
                break;
            }
            default: {
                redirect(resp, HOME_JSP);
            }
        }
    }
}
