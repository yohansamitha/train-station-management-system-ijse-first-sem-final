package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.customEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException {
        String sql="select cashier_ID,first_name,last_name,DOB,address,email_address,reg_date,position from cashier union\n" +
                "select primary_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from primary_driver union\n" +
                "select assistant_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from assistant_driver";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<customEntity> customEntities = new ArrayList<>();
        while (resultSet.next()){
            customEntities.add(new customEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDate(7),
                    resultSet.getString(8)));
        }
        return customEntities;
    }

    @Override
    public ArrayList<customEntity> findSchedule(String date, String station) throws SQLException, ClassNotFoundException {
        String sql ="select schedule_ID, schedule.engine_number, train_name, primary_driver_ID, assistant_driver_ID, route_ID, date, time from schedule inner join train\n" +
                "on schedule.engine_number = train.engine_number\n" +
                "where route_ID = ? AND date = ? ;\n";
        ArrayList<customEntity> allSchedule = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql, station, date);
        while (resultSet.next()){
            allSchedule.add(new customEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDate(7),
                    resultSet.getTime(8)
            ));
        }
        return allSchedule;
    }

    @Override
    public String getCashierID(String txtUserName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT c.cashier_ID  FROM cashier c,users u WHERE c.user_ID = u.user_ID && u.user_Name=?;";
        ResultSet resultSet = CrudUtil.executeQuery(sql, txtUserName);
        if (resultSet.next()){
            System.out.println(resultSet.getString(1)+" cashierID from login to dashboard");
            return resultSet.getString(1);
        }
        return null;
    }
}
