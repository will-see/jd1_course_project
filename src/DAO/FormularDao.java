package DAO;

import entities.Formular;

import java.sql.SQLException;
import java.util.List;

public interface FormularDao extends DAO <Formular> {
        List<Formular> getByUserId(long userId) throws SQLException;
}
