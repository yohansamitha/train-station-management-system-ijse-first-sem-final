package dao.custom.impl;

import dao.custom.Booking_DetailsDAO;
import entity.booking_details;

import java.sql.SQLException;
import java.util.ArrayList;

public class Booking_detailsDAOImpl implements Booking_DetailsDAO {
    @Override
    public boolean add(booking_details booking_details) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO booking_Details VALUES(?,?,?,?)";
        return false;
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
}
