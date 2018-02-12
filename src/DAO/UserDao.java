package DAO;

import dto.UsersDto;
import entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DAO<User> {
    User getByLogin(String login) throws SQLException;
    List<UsersDto> getAll() throws SQLException;
}
