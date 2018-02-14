package web.command.impl;

import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
//        resp.sendRedirect("/frontController?command=login");
        req.getServletContext().getRequestDispatcher("/frontController?command=books").forward(req, resp);
    }
}
