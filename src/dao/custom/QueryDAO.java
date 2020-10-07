package dao.custom;

import dao.SuperDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException;

    ArrayList<customEntity> findSchedule(String date, String station) throws SQLException,ClassNotFoundException;

    String getCashierID(String txtUserName)throws SQLException,ClassNotFoundException;

    ArrayList<customEntity> getAllSchedule(String value) throws SQLException, ClassNotFoundException;

    ArrayList<customEntity> getAllTrain(String value) throws SQLException, ClassNotFoundException;

    ArrayList<customEntity> getBookedSeatCount(String schedule_id) throws SQLException, ClassNotFoundException;
}
