package dao.custom.impl;

import dao.custom.Ticket_priceDAO;
import entity.ticket_price;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ticket_priceDAOImpl implements Ticket_priceDAO {
    @Override
    public boolean add(ticket_price ticket_price) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ticket_prices VALUES(?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM ticket_prices WHERE ticket_prices_id=?";
        return false;
    }

    @Override
    public boolean update(ticket_price ticket_price) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE ticket_prices SET " +
                "station_ID=?," +
                "route_ID=?," +
                "1st_class_seat_price=?," +
                "2st_class_seat_price=?," +
                "3st_class_seat_price=?," +
                "WHERE ticket_prices_ID=?";
        return false;
    }

    @Override
    public ticket_price search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM ticket_prices WHERE ticket_prices_ID=?";
        return null;
    }

    @Override
    public ArrayList<ticket_price> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM ticket_prices";
        return null;
    }
}
