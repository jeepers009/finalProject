package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constants.ApplicationConstants.*;
import static by.itclass.constants.JspConstants.LOGIN_PARAM;
import static by.itclass.constants.JspConstants.PASSWORD_PARAM;


@WebServlet(name = "loginController", urlPatterns = "/LOGIN_CONTROLLER")
public class LoginController extends AbstractController {
    public LoginController() throws IOException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        User user = userservice.getUser(login, password);
        if (!Objects.isNull(user)) {
            HttpSession session = req.getSession();
            session.setAttribute(USER_ATTR, user);
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, LOGIN_JSP, USER_NOT_FOUND);
        }
    }


}
