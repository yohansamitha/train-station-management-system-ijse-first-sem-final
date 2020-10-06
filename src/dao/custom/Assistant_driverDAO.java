package dao.custom;

import dao.CrudDAO;
import entity.assistant_driver;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Assistant_driverDAO extends CrudDAO<assistant_driver, String> {
    int getRowCount() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllAssistantDriverID() throws SQLException, ClassNotFoundException;
}
