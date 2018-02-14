package web.command.impl;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import dto.FormularDto;
import dto.UsersDto;
import entities.Formular;
import entities.User;
import services.FormularService;
import services.UserService;
import services.impl.FormularServiceImpl;
import services.impl.UserServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewFormularController implements Controller{
    private FormularService formularService = FormularServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            User user = (User)req.getSession().getAttribute("user");
        String id = req.getParameter("userId");
        User user = (User)req.getSession().getAttribute("user");
        List<FormularDto> formularDto = formularService.getUserFormular(Long.parseLong(id));

        req.setAttribute("formularDto", formularDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/frontController?command=formular");
        dispatcher.forward(req, resp);
    }
}