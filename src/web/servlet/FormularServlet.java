package web.servlet;

import entities.Formular;
import services.FormularService;
import services.impl.FormularServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class FormularServlet  extends HttpServlet {
        private FormularService formularServiceService = FormularServiceImpl.getInstance();

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            long userId = req.getAttribute("userId") != null ?
                    (long) req.getAttribute("userId") : (long) req.getSession().getAttribute("userId");
            List<Formular> formulars = formularServiceService.getByUserId(userId);

            req.setAttribute("formulars", formulars);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formulars.jsp");
            dispatcher.forward(req, resp);
        /*PrintWriter pw = resp.getWriter();
        pw.print("<html>\n<head>\n<title>Cookie test</title></head>\n" +
                "  <body>Orders<br/><table><tr><th>Order Id</th><th>User Id</th><th>Sum</th></tr>");
        for (Order order : orders) {
            pw.print("<tr>\n<td>"+order.getId()+"</td><td>"+order.getUserId()+"</td><td>"+order.getTotal()+"</td>\n</tr><br/>");
        }

        pw.print("</table></body></html>");*/
        }
    }
