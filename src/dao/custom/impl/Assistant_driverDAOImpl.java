package dao.custom.impl;

import dao.custom.Assistant_driverDAO;
import entity.assistant_driver;

import java.sql.SQLException;
import java.util.ArrayList;

public class Assistant_driverDAOImpl implements Assistant_driverDAO {
    @Override
    public boolean add(assistant_driver assistant_driver) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO assistant_driver VALUES(?,?,?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM assistant_driver WHERE assistant_driver_ID=?";
        return false;
    }

    @Override
    public boolean update(assistant_driver assistant_driver) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE assistant_driver SET " +
                "first_name=?," +
                "last_name=?," +
                "DOB=?," +
                "address=?," +
                "email_address=?," +
                "reg_date=?," +
                "position=?, " +
                "WHERE assistant_driver_ID=?";
        return false;
    }

    @Override
    public assistant_driver search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM assistant_driver WHERE assistant_driver_ID=?";
        return null;
    }

    @Override
    public ArrayList<assistant_driver> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM assistant_driver";
        return null;
    }
}
