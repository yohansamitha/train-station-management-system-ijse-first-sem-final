package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.customEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException, ClassNotFoundException {
        String sql = "select cashier_ID,first_name,last_name,DOB,address,email_address,reg_date,position from cashier union\n" +
                "select primary_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from primary_driver union\n" +
                "select assistant_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from assistant_driver";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<customEntity> customEntities = new ArrayList<>();
        while (resultSet.next()) {
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
        String sql = "select schedule_ID, schedule.engine_number, train_name, primary_driver_ID, assistant_driver_ID, route_ID, date, time from schedule inner join train\n" +
                "on schedule.engine_number = train.engine_number\n" +
                "where route_ID = ? AND date = ? ;\n";
        ArrayList<customEntity> allSchedule = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql, station, date);
        while (resultSet.next()) {
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
        if (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " cashierID from login to dashboard");
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ArrayList<customEntity> getAllSchedule(String value) throws SQLException, ClassNotFoundException {
//        String sql ="select schedule_ID, schedule.engine_number, train_name, primary_driver_ID, assistant_driver_ID, route_ID, date, time from schedule inner join train\n" +
//                "on schedule.engine_number = train.engine_number\n  order  by schedule_ID desc" ;
//                "where route_ID = ? AND date = ? ;\n";

        String sql = "select schedule_ID, schedule.engine_number, train_name, primary_driver_ID, assistant_driver_ID, route_ID, date, time from schedule inner join train " +
                "on schedule.engine_number = train.engine_number where schedule_ID like ? '%' or schedule.engine_number like ? '%' or route_ID like ? '%' order  by schedule_ID desc;";
        ArrayList<customEntity> allSchedule = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql, value, value, value);
        while (resultSet.next()) {
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
    public ArrayList<customEntity> getAllTrain(String value) throws SQLException, ClassNotFoundException {
        String sql = "SELECT train.engine_number, train_name, engine_type, fuel_capacity, station_ID, 1st_clas_seat_count, 2st_clas_seat_count, 3st_clas_seat_count FROM train\n" +
                "INNER JOIN seat_detail  ON train.engine_number = seat_detail.engine_number where train.engine_number like ? '%' or train_name like ? '%';";
//                "INNER JOIN seat_detail  ON train.engine_number = seat_detail.engine_number;";
        ArrayList<customEntity> allTrain = new ArrayList<>();
        System.out.println(value + " value from get all train");
        ResultSet resultSet = CrudUtil.executeQuery(sql, value, value);
//        ResultSet resultSet = CrudUtil.executeQuery(sql);
        while (resultSet.next()) {
            allTrain.add(new customEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8)
            ));
        }
        return allTrain;
    }

    @Override
    public ArrayList<customEntity> getBookedSeatCount(String schedule_id) throws SQLException, ClassNotFoundException {
        String sql = "select schedule.engine_number , sum(reserved_seat_count)  from booking " +
                "inner join booking_details on booking.booking_ID = booking_details.booking_ID " +
                "inner join schedule on booking.schedule_ID = schedule.schedule_ID WHERE booking.schedule_ID = ? group by booking_Details.reserved_class;";
        ResultSet resultSet = CrudUtil.executeQuery(sql, schedule_id);
        ArrayList<customEntity> seatCount = new ArrayList<>();
        while (resultSet.next()){
            seatCount.add(new customEntity(resultSet.getString(1),resultSet.getInt(2)));
        }
        return seatCount;
    }
}
