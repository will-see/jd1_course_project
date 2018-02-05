package services;

import entities.Author;

import java.util.List;

public interface AuthorService {
    Author getByName(String name);
    List<Author> getAll();
}
