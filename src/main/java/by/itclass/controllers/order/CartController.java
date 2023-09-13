package by.itclass.controllers.order;

import by.itclass.constants.JspConstants;
import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.food.FoodItem;
import by.itclass.model.entities.OrderItem;

import javax.servlet.ServletException;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(JspConstants.FOOD_ID_PARAM));
        int type = Integer.parseInt(req.getParameter(JspConstants.FOOD_TYPE_PARAM));
        String foodName = req.getParameter(JspConstants.FOOD_NAME_PARAM);
        double foodPrice = Double.parseDouble(req.getParameter(JspConstants.FOOD_PRICE_PARAM));
        int foodQuantity = Integer.parseInt(req.getParameter(JspConstants.FOOD_QUANTITY_PARAM));

        String cartAction = req.getParameter(JspConstants.CART_ACTION_PARAM);

        OrderItem orderItem = new OrderItem(new FoodItem(id, type, foodName, foodPrice), foodQuantity);

        HttpSession session = req.getSession();

        ArrayList<OrderItem> items = cartService.processCart(session, cartAction, orderItem);
        if ("addToCart".equals(cartAction)){
            redirectToMenuPage(resp,type);
        }else{
            redirect(resp, CART_JSP);
        }
    }

    private void redirectToMenuPage(HttpServletResponse resp, int foodType) throws IOException {
        switch (foodType){
            case 1:{
                redirect(resp,PIZZAS_MENU);
                break;
            }
            case 2:{
                redirect(resp,DRINKS_MENU);
                break;
            }
            default:
                redirect(resp,HOME_JSP);
                break;
        }
    }
}
