package services;

import entities.Formular;

import java.io.Serializable;
import java.util.List;


public interface FormularService {

    Formular createFormular(long userId, long bookId);
    Formular get(Serializable id);
    void update(Formular formular);
    int delete(Serializable id);

    List<Formular> getByUserId(long userId);
}
