package DAO.impl;

import DAO.AuthorDao;
import entities.Author;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDaoImpl extends AbstractDao implements AuthorDao {
    private static volatile AuthorDao INSTANCE = null;

    private static final String getUser = "SELECT * FROM authors WHERE author_name=?";
    private PreparedStatement psGetByName;

    public Author getByName(String name) throws SQLException {
        psGetByName = prepareStatement(getUser);
        psGetByName.setString(1, name);
        ResultSet rs = psGetByName.executeQuery();
        if (rs.next()) {
            return populateAuthor(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public Author save(Author author) throws SQLException {
        return null;
    }

    @Override
    public Author get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Author author) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
    private Author populateAuthor(ResultSet rs) throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getLong(1));
        author.setName(rs.getString(2));
        author.setYear(rs.getInt(3));
        author.setCountry(rs.getString(4));
        return author;
    }

    public static AuthorDao getInstance() {
        AuthorDao authorDao = INSTANCE;
        if (authorDao == null) {
            synchronized (AuthorDaoImpl.class) {
                authorDao = INSTANCE;
                if (authorDao == null) {
                    INSTANCE = authorDao = new AuthorDaoImpl();
                }
            }
        }

        return authorDao;
    }
}
