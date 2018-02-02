package DAO.impl;

import DAO.ItemDao;
import entities.Item;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends AbstractDao implements ItemDao {
    private static volatile ItemDao INSTANCE = null;

    private static final String saveItemQuery = "INSERT INTO ITEM (ID_FORMULAR, BOOKS_COUNT) VALUES (?, ?)";
    private static final String getItemQuery = "SELECT * FROM ITEM WHERE ITEM_ID=?";
    private static final String updateItemQuery = "UPDATE ITEM SET QUANTITY=?, DISCOUNT=? WHERE ITEM_ID=?";
    private static final String deleteItemQuery = "DELETE FROM ITEM WHERE ITEM_ID=?";
    private static final String getItemsByUserIdQuery = "SELECT * FROM ITEM WHERE ORDER_ID = ?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    private ItemDaoImpl() {
    }

    public static ItemDao getInstance() {
        ItemDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (ItemDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new ItemDaoImpl();
                }
            }
        }

        return itemDao;
    }

    @Override
    public Item save(Item item) throws SQLException {
        psSave = prepareStatement(saveItemQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setLong(1, item.getFormularId());
        psSave.setInt(2, item.getBooksCount());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            item.setId(rs.getLong(1));
        }
        close(rs);
        return item;
    }

    @Override
    public Item get(Serializable id) throws SQLException {
        psGet = prepareStatement(getItemQuery);
        psGet.setLong(1, (long)id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateEntity(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Item item) throws SQLException {
        psUpdate = prepareStatement(updateItemQuery);
        psUpdate.setLong(3, item.getId());
        psUpdate.setLong(1, item.getFormularId());
        psUpdate.setInt(2, item.getBooksCount());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteItemQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Item> getByUserId(long userId) throws SQLException {
        psGetAll = prepareStatement(getItemsByUserIdQuery);
        psGetAll.setLong(1, userId);
        psGetAll.execute();
        List<Item> list = new ArrayList<>();
        ResultSet rs = psGetAll.getResultSet();
        while (rs.next()) {
            list.add(populateEntity(rs));
        }
        close(rs);
        return list;
    }

    private Item populateEntity(ResultSet rs) throws SQLException {
        Item entity = new Item();
        entity.setId(rs.getLong(1));
        entity.setFormularId(rs.getLong(2));
        entity.setBooksCount(rs.getInt(3));
        return entity;
    }
}