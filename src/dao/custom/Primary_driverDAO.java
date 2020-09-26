package dao.custom;

import dao.CrudDAO;
import entity.primary_driver;

import java.sql.SQLException;

public interface Primary_driverDAO extends CrudDAO<primary_driver, String> {
    int getRowCount() throws SQLException, ClassNotFoundException;
}
