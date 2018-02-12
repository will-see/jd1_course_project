package web.command.impl;

import com.google.gson.Gson;
import entities.User;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getBookController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User)req.getSession().getAttribute("user");

//        BasketVO basket = (BasketVO) req.getSession().getAttribute("basket");
//        if (basket == null) {
//            basket = new BasketVO(new HashMap<>());
//            req.getSession().setAttribute("basket", basket);
//        }
        long bookId = Long.parseLong(req.getParameter("bookId"));
//        String id = req.getReader().readLine();
//        Gson in = new Gson();
//        long productId = in.fromJson(id, Long.class);
        AtomicInteger count = basket.getBasket().get(bookId);
        int currentCount = 0;
        if (count == null) {
            count = new AtomicInteger();
            count.set(1);
            currentCount = 1;
        } else {
            currentCount = count.incrementAndGet();
        }
        basket.getBasket().put(bookId, count);
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(currentCount));

    }
}
