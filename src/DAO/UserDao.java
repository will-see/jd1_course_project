package DAO;

import entities.User;

import java.sql.SQLException;

public interface UserDao extends DAO<User> {
    User getByLogin(String login) throws SQLException;
}
