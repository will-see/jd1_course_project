package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang3.math.NumberUtils;
import services.FormularService;
import services.impl.FormularServiceImpl;


@WebServlet("/forward")
public class CreateOrderForwardServlet extends HttpServlet {

    private FormularService formularService = FormularServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = NumberUtils.toLong(req.getParameter("userId"));
        long bookId = NumberUtils.toLong(req.getParameter("formularId"));
        formularService.createFormulal(userId, bookId);
        req.setAttribute("userId", userId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/formulars");
        dispatcher.forward(req, resp);
    }
}
