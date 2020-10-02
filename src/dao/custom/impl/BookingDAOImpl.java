package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookingDAO;
import entity.booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean add(booking booking) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO booking VALUES(?,?,?,?)";
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM booking WHERE booking_ID=?";
        return false;
    }

    @Override
    public boolean update(booking booking) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE booking SET " +
                "schedule_ID=?," +
                "customer_ID=?," +
                "ticket_price_ID=?," +
                "WHERE booking_ID=?";
        return false;
    }

    @Override
    public booking search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM booking WHERE booking_ID=?";
        return null;
    }

    @Override
    public ArrayList<booking> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM booking";
        return null;
    }

    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(booking_ID) FROM booking";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }

}
