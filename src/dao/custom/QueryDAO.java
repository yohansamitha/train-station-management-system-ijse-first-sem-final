package dao.custom;

import com.jfoenix.controls.JFXTextField;
import dao.SuperDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException;

    ArrayList<customEntity> findSchedule(String date, String station) throws SQLException,ClassNotFoundException;

    String getCashierID(String txtUserName)throws SQLException,ClassNotFoundException;
}
