package test;

import DAO.BookDao;
import DAO.FormularDao;
import DAO.UserDao;
import DAO.impl.BookDaoImpl;
import DAO.impl.FormularDaoImpl;
import DAO.impl.UserDaoImpl;
import db.ConnectionManager;
import entities.Formular;
import org.junit.Test;
import services.AuthorService;
import services.BookService;
import services.FormularService;
import services.impl.AuthorServiceImpl;
import services.impl.BookServiceImpl;
import services.impl.FormularServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TestBook {
    private BookDao bookDao = BookDaoImpl.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();
    private FormularDao formularDao = FormularDaoImpl.getInstance();
    private BookService bookService = BookServiceImpl.getInstance();
    private AuthorService authorService = AuthorServiceImpl.getInstance();
    private FormularService formularService = FormularServiceImpl.getInstance();

    public void initData() {}

    @Test
    public void rbTest() {
        Locale locale = new Locale("en");
        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("login.login"));
        System.out.println(rb.getString("login.register"));
    }

    @Test
    public void fullTest() throws SQLException, Exception {
        Connection connection = ConnectionManager.getConnection();
        connection.setAutoCommit(true);

//        int beforeSave = bookDao.getAll().size();
//        Book newBook = bookDao.save(new Book("lykomorie", "skazka", 100,1,  5));
//        int afterSave = bookDao.getAll().size();
//        Assert.assertNotSame(beforeSave, afterSave);
//
////        connection.rollback();
//
//        newBook.setName("sidoroff");
//        bookDao.update(newBook);
//
//        Book updatedBook = bookDao.get(newBook.getBookId());
//        Assert.assertEquals("Метод update не корректен","sidorov", updatedBook.getName());
//
//        Book item2 = bookDao.getByNameAndGanr("sidoroff", "skazka");
//        Assert.assertNotNull(item2);
//
//        bookDao.delete(newBook.getBookId());
//
//        afterSave = bookDao.getAll().size();
//        Assert.assertEquals(beforeSave, afterSave);
//        System.out.println(bookDao.getAll());

//        System.out.println(userDao.getByLogin("user1").getUserId());

//        System.out.println(UserDaoImpl.getUserQuery);
//        System.out.println(bookDao.getByNameAndGanr("book2","ganr2"));
//        System.out.println(bookDao.save("book2","ganr2"));
//        Book newBook = bookDao.save(new Book("lykomorie", "skazka", 100,1,  5));
//        newBook.setName("kolobok");
//        bookDao.delete(newBook.getBookId());
//        bookDao.delete(newBook.getBookId()-8);

//        test service

//        System.out.println(bookService.get(2l).getName());
//        System.out.println(authorService.getAll());
//        System.out.println(authorService.getByName("pushkin").getAuthorId());
//        System.out.println(AuthorServiceImpl.getInstance().getByName("pushkin").getAuthorId());
//        System.out.println(formularDao.getByUserId(1));
//        System.out.println(FormularServiceImpl.getInstance().getByUserId(0));
//        System.out.println(FormularServiceImpl.getInstance().getByUserId(2));

//        List<Formular> formular = formularService.getByUserId(userDao.getByLogin("user1").getUserId());
//        System.out.println(formular.get(0).getBookId());
//        System.out.println(bookDao.get(2l));
//        System.out.println(formularDao.get(2l).getBookId());
//        System.out.println(formularDao.get(2l).getUserId());
//        System.out.println(formularDao.get(2l).getFormularId());
//        System.out.println(formularDao.getByUserId(2l));
        System.out.println(bookDao.getAll());


//            User user = UserServiceImpl.getInstance().createUser("valera", "user3", "user", 16, "male");
    }



}
