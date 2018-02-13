package web.command.impl;

import com.google.gson.Gson;
import dto.BookDto;
import entities.Book;
import entities.User;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class getBookController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        BookDto bookDto = (BookDto) req.getSession().getAttribute("bookDto");

//        BasketVO basket = (BasketVO) req.getSession().getAttribute("basket");
//        if (basket == null) {
//            basket = new BasketVO(new HashMap<>());
//            req.getSession().setAttribute("basket", basket);
//        }
//        long bookId = Long.parseLong(req.getParameter("bookId"));
//        String id = req.getReader().readLine();
//        Gson in = new Gson();
//        long productId = in.fromJson(id, Long.class);

//        AtomicInteger count = basket.getBasket().get(bookId);
        User user = (User)req.getSession().getAttribute("user");
        long bookId = Long.parseLong(req.getParameter("bookId"));
//        List<BookDto>

//        int bookCount = Integer.parseInt(req.getParameter("bookCount"));
        int bookCount = Integer.parseInt(req.getParameter("bookCount"));
        int currentCount = bookCount-1;
//        if (count == null) {
//            count = new AtomicInteger();
//            count.set(1);
//            currentCount = 1;
//        } else {
//            currentCount = count.incrementAndGet();
//        }
//        basket.getBasket().put(bookId, count);
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(currentCount));

    }
}
