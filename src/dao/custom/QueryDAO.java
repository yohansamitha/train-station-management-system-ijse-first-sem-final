package dao.custom;

import dao.SuperDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException;
}
