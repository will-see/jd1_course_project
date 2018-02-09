package DAO.impl;

import DAO.FormularDao;
import entities.Formular;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormularDaoImpl extends AbstractDao implements FormularDao {
    private static volatile FormularDao INSTANCE = null;

    private static final String saveQuery = "INSERT INTO FORMULAR (userId, bookId) VALUES (?, ?)";
    private static final String updateQuery = "UPDATE formular SET bookId=? WHERE formularId=?";
    private static final String getQuery = "SELECT formularId, userId, bookId FROM formular WHERE userId=?";
    private static final String getAllByUserQuery = "SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC";
    private static final String deleteQuery = "DELETE FROM formular WHERE formularId=?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetAllByUserId;
    private PreparedStatement psDelete;

    @Override
    public Formular save(Formular formular) throws SQLException {
        psSave = prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setLong(1, formular.getUserId());
        psSave.setLong(2, formular.getBookId());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            formular.setFormularId(rs.getLong(1));
        }
        close(rs);
        return formular;
    }

    @Override
    public Formular get(Serializable formularId) throws SQLException {
        psGet = prepareStatement(getQuery);
        psGet.setLong(1, (long)formularId);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateFormular(rs);
        }
        close(rs);
        return null;
    }

    @Override
    public void update(Formular formular) throws SQLException {
        psUpdate = prepareStatement(updateQuery);
        psUpdate.setLong(1, formular.getFormularId());
        psUpdate.setLong(2, formular.getBookId());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Formular> getByUserId(long userId) throws SQLException {
        psGetAllByUserId = prepareStatement(getQuery);
        psGetAllByUserId.setLong(1, userId);
        psGetAllByUserId.execute();
        ResultSet rs = psGetAllByUserId.getResultSet();
        List<Formular> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateFormular(rs));
        }
        close(rs);

        return list;
    }

//    @Override
//    public List<Formular> getByUserId(long userId) throws SQLException {
//        psGetAllByUserId = prepareStatement(getAllByUserQuery);
//        psGetAllByUserId.setLong(1, userId);
//        psGetAllByUserId.execute();
//        ResultSet rs = psGetAllByUserId.getResultSet();
//        List<Formular> list = new ArrayList<>();
//        while (rs.next()) {
//            list.add(populateFormular(rs));
//        }
//        close(rs);
//
//        return list;
//    }

    private Formular populateFormular(ResultSet rs) throws SQLException {
        Formular entity = new Formular();
        entity.setFormularId(rs.getLong(1));
        entity.setUserId(rs.getLong(2));
        entity.setBookId(rs.getLong(3));
        return entity;
    }

    public static FormularDao getInstance() {
        FormularDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (ItemDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new FormularDaoImpl();
                }
            }
        }

        return itemDao;
    }
}
