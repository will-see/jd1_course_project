package web.command.impl;

import entities.User;
import services.UserService;
import services.impl.UserServiceImpl;
import web.auth.Encoder;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login==null || password==null) {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
        User user = userService.getByLogin(login);
//        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
        if (user != null && password.equals(user.getPassword())) {
            req.getSession().setAttribute("user", user);
            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath+ "/frontController?command=formular");
            resp.sendRedirect(contextPath+ "/frontController?command=books");
            return;
        } else {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            req.setAttribute("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
//            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
    }
}
