package services;

import dto.UsersDto;
import entities.User;
import java.io.Serializable;
import java.util.List;

public interface UserService {

    User createUser (String name, String login, String password, int age, String sex);
    User get(Serializable id);
    void update(User user);
    int delete(Serializable id);

    User getByLogin(String login);
    List<UsersDto> getAll();
}
