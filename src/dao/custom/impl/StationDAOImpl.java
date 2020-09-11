package dao.custom.impl;

import dao.custom.StationDAO;
import entity.station;

import java.sql.SQLException;
import java.util.ArrayList;

public class StationDAOImpl implements StationDAO {
    @Override
    public boolean add(station station) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO station VALUES(?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM station WHERE station_ID=?";
        return false;
    }

    @Override
    public boolean update(station station) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE station SET " +
                "station_name=?," +
                "duration=?," +
                "WHERE station_ID=?";
        return false;
    }

    @Override
    public station search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM station WHERE station_ID=?";
        return null;
    }

    @Override
    public ArrayList<station> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM station";
        return null;
    }
}
