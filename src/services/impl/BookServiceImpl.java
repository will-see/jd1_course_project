package services.impl;

import DAO.BookDao;
import DAO.impl.BookDaoImpl;
import entities.Book;
import services.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl extends AbstractService implements services.BookService {
    private static volatile BookServiceImpl INSTANCE = null;

    BookDao bookDao = BookDaoImpl.getInstance();


    @Override
    public Book createBook(String name, String ganr, int pages, long author, int bookCount) {
        Book book = new Book();
        try {
            startTransaction();
            book.setName(name);
            book = bookDao.save(book);
            commit();
            return book;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Book" + book);
        }
    }

    @Override
    public Book get(Serializable id) {
        try {
            return bookDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting Formular by id" + id);
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookDao.update(book);
        } catch (SQLException e) {
            throw new ServiceException("Error updating Formular book" + book);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            return bookDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Book by id" + id);
        }
    }

    @Override
    public Book getByNameAndGanr(String name, String ganr) {
        try {
            return bookDao.getByNameAndGanr(name, ganr);
        } catch (SQLException e) {
            throw new ServiceException("Error getting by BookGanr:" + ganr + " and bookName:" + name);
        }
    }

    @Override
    public List<Book> getAll() {
        try {
            startTransaction();
            List<Book> list = bookDao.getAll();
            commit();
            return list;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Books");
        }
    }

    public static BookServiceImpl getInstance() {
        BookServiceImpl bookServiceImpl = INSTANCE;
        if (bookServiceImpl == null) {
            synchronized (BookServiceImpl.class) {
                bookServiceImpl = INSTANCE;
                if (bookServiceImpl == null) {
                    INSTANCE = bookServiceImpl = new BookServiceImpl();
                }
            }
        }
        return bookServiceImpl;
    }
}
