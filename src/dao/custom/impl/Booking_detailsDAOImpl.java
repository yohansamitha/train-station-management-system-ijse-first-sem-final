package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.Booking_DetailsDAO;
import entity.booking_details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Booking_detailsDAOImpl implements Booking_DetailsDAO {
    @Override
    public boolean add(booking_details booking_details) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO booking_Details(booking_Details_ID, booking_ID, reserved_class, reserved_seat_count, reserved_seat_price) VALUES (?,?,?,?,?);";
        return CrudUtil.executeUpdate(sql,
                booking_details.getBooking_Details_ID(),
                booking_details.getBooking_ID(),
                booking_details.getReserved_class(),
                booking_details.getReserved_seat_count(),
                booking_details.getReserved_seat_price()
                );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM booking_Details WHERE booking_Details_ID=?";
        return false;
    }

    @Override
    public boolean update(booking_details booking_details) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE booking_Details SET " +
                "reserved_class=?," +
                "reserved_seat_count=?," +
                "WHERE booking_Details_ID=?";
        return false;
    }

    @Override
    public booking_details search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM booking_Details WHERE booking_Details_ID=?";
        return null;
    }

    @Override
    public ArrayList<booking_details> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM booking_Details";
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(booking_Details_ID) FROM booking_Details";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
