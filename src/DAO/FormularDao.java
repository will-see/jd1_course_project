package DAO;

import dto.FormularDto;
import entities.Formular;

import java.sql.SQLException;
import java.util.List;

public interface FormularDao extends DAO <Formular> {
        List<Formular> getByUserId(long userId) throws SQLException;
        List<FormularDto> getUserFormular(long userId) throws SQLException;
}
