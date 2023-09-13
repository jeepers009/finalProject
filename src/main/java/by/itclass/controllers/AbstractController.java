package by.itclass.controllers;

import by.itclass.model.services.food.FoodService;
import by.itclass.model.services.cart.CartService;
import by.itclass.model.services.user.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constants.JspConstants.MESSAGE_ATTR;

@WebServlet(name = "abstractController")
public class AbstractController extends HttpServlet {
    protected UserService userservice;
    protected FoodService foodService;
    protected CartService cartService;

    @SneakyThrows
    public void init() {
        userservice = UserService.getService();
        foodService = FoodService.getInstance();
        cartService = CartService.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //просто перейти на некий адрес
    protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    //перегруженный метод... перейти с сообщением
    protected void forward(HttpServletRequest req, HttpServletResponse resp, String url,
                        String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR, message);
        forward(req, resp, url);
    }

    protected void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }
}
