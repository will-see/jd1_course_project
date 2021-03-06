package web.command.impl;

import entities.Formular;
import entities.User;
import services.FormularService;
import services.impl.FormularServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yslabko on 08/17/2017.
 */
public class CreateFormularController implements Controller {
    private FormularService formularService = FormularServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        long bookId = (long)req.getAttribute("productId");
        Formular formular = formularService.createFormular(user.getUserId(), bookId);

        req.setAttribute("formular", formular);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}