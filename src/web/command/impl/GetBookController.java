package web.command.impl;

import com.google.gson.Gson;
import dto.BookDto;
import entities.Book;
import entities.Formular;
import entities.User;
import services.BookService;
import services.FormularService;
import services.UserService;
import services.impl.BookServiceImpl;
import services.impl.FormularServiceImpl;
import services.impl.UserServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetBookController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();
    private FormularService formularService = FormularServiceImpl.getInstance();

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
        User user = (User) req.getSession().getAttribute("user");
        long bookId = Long.parseLong(req.getParameter("bookId"));
        long userId = user.getUserId();
//        List<BookDto>

//        int bookCount = Integer.parseInt(req.getParameter("bookCount"));
        Book book = bookService.get(bookId);
        int bookCount = book.getBookCount();
        System.out.println(bookId);
        System.out.println(bookCount);
        if (bookCount > 0) {
            List<Formular> formulars = formularService.getByUserId(userId);
            if (formulars.size() == 0) {
                bookCount--;
                bookService.updateCount(bookId, bookCount);
                formularService.createFormular(userId, bookId);
            } else {
                boolean flag = true;
                for (int i = 0; i < formulars.size(); i++) {
                    if (formulars.get(i).getBookId() == bookId) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    bookCount--;
                    bookService.updateCount(bookId, bookCount);
                    formularService.createFormular(userId, bookId);
                }
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(bookCount));
    }
}
