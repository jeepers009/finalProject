package by.itclass.model.services.cart;

import by.itclass.model.entities.OrderItem;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService service;

    public static CartService getInstance() {
        return service == null ? new CartService() : service;
    }

    public ArrayList<OrderItem> processCart(HttpSession session, String cardAction, OrderItem item) {
        ArrayList<OrderItem> items = !
                Objects.isNull(session.getAttribute(ORDER_ITEMS_ATTR))
                ? (ArrayList<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTR)
                : new ArrayList<>();
        switch (cardAction) {
            case "addToCard": {
                items.add(item);
                break;
            }
            case "removeFromCart": {
                items.remove(item);
                break;
            }
            default:
                break;
        }
        return items;
    }

}
