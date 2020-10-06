package dao.custom;

import dao.CrudDAO;
import entity.train;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainDAO extends CrudDAO<train,String> {
    ArrayList<String> getAllEngineNumbers() throws SQLException, ClassNotFoundException;

    int getRowCount() throws SQLException, ClassNotFoundException;
}
