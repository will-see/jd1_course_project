package web.command.impl;

import dto.FormularDto;
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
import java.util.List;

public class FormularDtoController implements Controller {
    private FormularService formularService = FormularServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String id = req.getParameter("userId");
        if (id!=null){
            List<FormularDto> formularDto = formularService.getUserFormular(Long.parseLong(id));
            req.setAttribute("formularDto", formularDto);
        }else {
            List<FormularDto> formularDto = formularService.getUserFormular(user.getUserId());
            req.setAttribute("formularDto", formularDto);
        }

//        req.setAttribute("formularDto", formularDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
