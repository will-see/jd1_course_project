package DAO.impl;

import DAO.BookDao;
import entities.Book;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends AbstractDao implements BookDao {
    private static volatile BookDao INSTANCE = null;

    private static final String saveProductQuery = "INSERT INTO books (name, ganr, pages, authorId,book_count ) VALUES (?, ?, ?, ?, ?)";
    private static final String updateProductQuery = "UPDATE books SET book_count=? WHERE bookId=?";
    private static final String getProductQuery = "SELECT * FROM books WHERE bookId=?";
    private static final String getAllProductQuery = "SELECT * FROM books";
    private static final String getByNameAndGanrQuery = "SELECT * FROM books WHERE name=? AND ganr=?";
    private static final String deleteProductQuery = "DELETE FROM books WHERE bookId=?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetByNameAndGanr;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    private BookDaoImpl() {
    }

    @Override
    public Book save(Book book) throws SQLException {
        psSave = prepareStatement(saveProductQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1, book.getName());
        psSave.setString(2, book.getGanr());
        psSave.setInt(3, book.getPages());
        psSave.setLong(4, book.getAuthorId());
        psSave.setInt(5, book.getBookCount());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            book.setBookId(rs.getLong(1));
        }
        close(rs);
        return book;
    }

    @Override
    public Book get(Serializable bookId) throws SQLException {
        psGet = prepareStatement(getProductQuery);
        psGet.setLong(1, (long) bookId);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateProduct(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Book book) throws SQLException {
        psUpdate = prepareStatement(updateProductQuery);
        psUpdate.setLong(6, book.getBookId());
        psUpdate.setString(1, book.getName());
        psUpdate.setString(2, book.getGanr());
        psUpdate.setInt(3, book.getPages());
        psUpdate.setLong(4, book.getAuthorId());
        psUpdate.setInt(5, book.getBookCount());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable bookId) throws SQLException {
        psDelete = prepareStatement(deleteProductQuery);
        psDelete.setLong(1, (long) bookId);
        return psDelete.executeUpdate();
    }

    @Override
    public Book getByNameAndGanr(String name, String ganr) throws SQLException {
        psGetByNameAndGanr = prepareStatement(getByNameAndGanrQuery);
        psGetByNameAndGanr.setString(1, name);
        psGetByNameAndGanr.setString(2, ganr);
        psGetByNameAndGanr.execute();
        ResultSet rs = psGetByNameAndGanr.getResultSet();
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getLong(1));
            book.setName(rs.getString(2));
            book.setGanr(rs.getString(3));
            book.setPages(rs.getInt(4));
            book.setAuthorId(rs.getLong(5));
            book.setBookCount(rs.getInt(6));
        }
        close(rs);

        return null;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        psGetAll = prepareStatement(getAllProductQuery);
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        List<Book> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateProduct(rs));
        }
        close(rs);
        return list;
    }

    private Book populateProduct(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setName(rs.getString(2));
        book.setGanr(rs.getString(3));
        book.setPages(rs.getInt(4));
        book.setAuthorId(rs.getLong(5));
        book.setBookCount(rs.getInt(6));
        return book;
    }

    public static BookDao getInstance() {
        BookDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (BookDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new BookDaoImpl();
                }
            }
        }
        return productDao;
    }
}
