package DAO;

import entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao extends DAO<Book> {
    Book getByNameAndGanr(String name, String ganr) throws SQLException;
    List<Book> getAll() throws SQLException;
}