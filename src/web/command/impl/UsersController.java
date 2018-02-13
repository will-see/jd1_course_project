package web.command.impl;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import dto.FormularDto;
import dto.UsersDto;
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
import java.sql.SQLException;
import java.util.List;

public class UsersController implements Controller {
    private UserService userService = UserServiceImpl.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<UsersDto> usersDto = userService.getAll();

        req.setAttribute("usersDto", usersDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
        String flag = req.getParameter("flag");
        if (flag != null) {
            String id = req.getParameter("userId");
            String role = req.getParameter("role");
            flag = "";
            try {
                User fakeUser = new User(2l," "," "," ",10," "," ");
                User fakeUser = userDao.get(id);
                    System.out.println(fakeUser);
                if (role.equalsIgnoreCase("reader")) {
                    fakeUser.setRole("1");
                    System.out.println(fakeUser);
                    userDao.update(fakeUser);
                } else {
                    fakeUser.setRole("0");
                    userDao.update(fakeUser);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
