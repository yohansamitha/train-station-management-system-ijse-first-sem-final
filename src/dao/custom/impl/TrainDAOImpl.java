package dao.custom.impl;

import dao.custom.TrainDAO;
import entity.train;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDAOImpl implements TrainDAO {
    @Override
    public boolean add(train train) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO train VALUES(?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM train WHERE engine_number=?";
        return false;
    }

    @Override
    public boolean update(train train) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE train SET " +
                "engine_type=?," +
                "fuel_capacity=?," +
                "station_ID=?," +
                "WHERE engine_number=?";
        return false;
    }

    @Override
    public train search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM train WHERE engine_number=?";
        return null;
    }

    @Override
    public ArrayList<train> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM train";
        return null;
    }
}
