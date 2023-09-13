package by.itclass.model.services.order;

import by.itclass.model.entities.OrderItem;
import com.sun.tools.javac.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService service;

    public static CartService getInstance() {
        return service != null
                ? service
                : new CartService();
    }

    public ArrayList<OrderItem> processCart(HttpSession session, String cartAction, OrderItem item){
        ArrayList<OrderItem> items;
        if (session.getAttribute(ORDER_ITEMS_ATTR) == null) items = new ArrayList<>();
        else items = (ArrayList<OrderItem>)session.getAttribute(ORDER_ITEMS_ATTR);

        switch (cartAction){
            case "addToCart":{
                items.add(item);
                break;
            }
            case "removeFromCart":{
                items.remove(item);
                break;
            }
            default: break;
        }

        return items;
    }
}
