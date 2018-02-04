package services;

import entities.User;
import java.io.Serializable;

public interface UserService {

    User createUser (String name, String login, String password, int age, String sex, long roleId);
    User get(Serializable id);
    void update(User user);
    int delete(Serializable id);

    User getByLogin(String login);
}
