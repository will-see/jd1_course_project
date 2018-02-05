package services.impl;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import entities.User;
import services.ServiceException;
import services.UserService;

import java.io.Serializable;
import java.sql.SQLException;

public class UserServiceImpl extends AbstractService implements UserService {
    private static volatile UserService INSTANCE = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public User createUser(String name, String login, String password, int age, String sex, long roleId) {
        User user = new User();
        try {
            startTransaction();
            user.setName(name);
            user = userDao.save(user);
            commit();
            return user;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating User" + user);
        }
    }

    @Override
    public User get(Serializable id) {
        try {
            return userDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by id" + id);
        }
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        } catch (SQLException e) {
            throw new ServiceException("Error updating user book" + user);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            return userDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting User by id" + id);
        }
    }

    @Override
    public User getByLogin(String login) {
        try {
            return userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login" + login);
        }
    }
    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }

        return userService;
    }
}
