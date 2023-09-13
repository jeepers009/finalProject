package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.user.User;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.itclass.constants.ApplicationConstants.*;
import static by.itclass.constants.ApplicationConstants.LOGIN_JSP;
import static by.itclass.constants.JspConstants.*;
import static by.itclass.constants.JspConstants.REGISTRATION_JSP;

@WebServlet(name = "registrationController", urlPatterns = REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter(LOGIN_PARAM);
        String name = req.getParameter(NAME_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String email = req.getParameter(EMAIL_PARAM);
        User user = new User(login, name, email);
        if (userservice.addUser(user, password)) {
            redirect(resp, LOGIN_JSP);
        }else{
            forward(req, resp, REGISTRATION_JSP, USER_NOT_REGISTERED);
        }
    }
}
