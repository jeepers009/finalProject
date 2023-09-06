package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.itclass.constants.ApplicationConstants.LOGOUT_CONTROLLER;
import static by.itclass.constants.JspConstants.LOGIN_JSP;

@WebServlet(name = "logoutController", urlPatterns = LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.invalidate();
        redirect(resp,LOGIN_JSP);
    }
}
