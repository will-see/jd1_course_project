package DAO.impl;

import DAO.UserDao;
import entities.User;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl extends AbstractDao implements UserDao {
    private static volatile UserDao INSTANCE = null;

    private static final String saveUserQuery = "INSERT INTO users (name,LOGIN, password, age, sex, id_role) VALUES (?,?,?,?,?,?)";
    private static final String getUserQuery = "SELECT * FROM users WHERE userId=?";
    private static final String updateUserQuery = "UPDATE users SET name=? WHERE userId=?";
    private static final String deleteUserQuery = "DELETE FROM users WHERE userId=?";
    private static final String getUserByLoginQuery = "SELECT * FROM users WHERE LOGIN = ?";

    private PreparedStatement psSave;
    private PreparedStatement psGet;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    private PreparedStatement psGetByLogin;

    private UserDaoImpl() {
    }

    @Override
    public User save(User user) throws SQLException {
        psSave = prepareStatement(saveUserQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1, user.getName());
        psSave.setString(2, user.getLogin());
        psSave.setString(3, user.getPassword());
        psSave.setInt(4, user.getAge());
        psSave.setString(5, user.getSex());
        psSave.setInt(6, user.getRole());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            user.setUserId(rs.getLong(1));
        }
        close(rs);
        return user;
    }

    @Override
    public User get(Serializable userId) throws SQLException {
        psGet = prepareStatement(getUserQuery);
        psGet.setLong(1, (long) userId);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateProduct(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(User user) throws SQLException {
        psUpdate = prepareStatement(updateUserQuery);
        psUpdate.setLong(7, user.getUserId());
        psUpdate.setString(1, user.getName());
        psUpdate.setString(2, user.getLogin());
        psUpdate.setString(3, user.getPassword());
        psUpdate.setInt(4, user.getAge());
        psUpdate.setString(5, user.getSex());
        psUpdate.setInt(6, user.getRole());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable userId) throws SQLException {
        psDelete = prepareStatement(deleteUserQuery);
        psDelete.setLong(1, (long) userId);
        return psDelete.executeUpdate();
    }


    @Override
    public User getByLogin(String login) throws SQLException {
        psGetByLogin = prepareStatement(getUserByLoginQuery);
        psGetByLogin.setString(1, login);
        ResultSet rs = psGetByLogin.executeQuery();
        if (rs.next()) {
            return populateProduct(rs);
        }
        close(rs);

        return null;
    }


    private User populateProduct(ResultSet rs) throws SQLException {
        User user = new User();
        user.setName(rs.getString(2));
        user.setLogin(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setAge(rs.getInt(5));
        user.setSex(rs.getString(6));
        user.setRole(rs.getInt(7));
        return user;
    }

    public static UserDao getInstance() {
        UserDao userDao = INSTANCE;
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                userDao = INSTANCE;
                if (userDao == null) {
                    INSTANCE = userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }
}