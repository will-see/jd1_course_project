package DAO;

import dto.BookDto;
import entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao extends DAO<Book> {

    Book getByNameAndGanr(String name, String ganr) throws SQLException;
    void updateCount(long bookId,  int bookCount) throws SQLException;
    List<BookDto> getAll() throws SQLException;
}
