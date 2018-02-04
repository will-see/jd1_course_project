package services;

import entities.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {
    Book createBook(String name, String ganr, int pages, long author, int bookCount);
    Book get(Serializable id);
    void update(Book book);
    int delete(Serializable id);
    Book getByNameAndGanr(String name, String ganr);
    List<Book> getAll();
}
