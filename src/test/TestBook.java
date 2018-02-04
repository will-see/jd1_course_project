package test;

import DAO.BookDao;
import DAO.impl.BookDaoImpl;
import db.ConnectionManager;
import entities.Book;
import org.junit.Assert;
import org.junit.Test;
import services.BookService;
import services.impl.BookServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class TestBook {
    private BookDao bookDao = BookDaoImpl.getInstance();
    private BookService bookService = BookServiceImpl.getInstance();

    public void initData() {}

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
        System.out.println(bookDao.getAll());
        System.out.println(bookDao.get(2l).getName());
//        System.out.println(bookDao.getByNameAndGanr("book2","ganr2"));
//        System.out.println(bookDao.save("book2","ganr2"));
//        Book newBook = bookDao.save(new Book("lykomorie", "skazka", 100,1,  5));
//        newBook.setName("kolobok");
//        bookDao.delete(newBook.getBookId());
//        bookDao.delete(newBook.getBookId()-8);

//        test service

        System.out.println(bookService.get(2l).getName());
    }



}
