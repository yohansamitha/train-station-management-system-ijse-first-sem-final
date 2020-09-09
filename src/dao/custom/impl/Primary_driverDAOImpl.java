package dao.custom.impl;

import dao.custom.Primary_driverDAO;
import entity.primary_driver;

import java.sql.SQLException;
import java.util.ArrayList;

public class Primary_driverDAOImpl implements Primary_driverDAO {
    @Override
    public boolean add(primary_driver primary_driver) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO primary_driver VALUES(?,?,?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM primary_driver WHERE primary_driver_ID=?";
        return false;
    }

    @Override
    public boolean update(primary_driver primary_driver) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE primary_driver SET " +
                "first_name=?," +
                "last_name=?," +
                "DOB=?," +
                "address=?," +
                "email_address=?," +
                "reg_date=?," +
                "position=?, " +
                "WHERE primary_driver_ID=?";
        return false;
    }

    @Override
    public primary_driver search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM primary_driver WHERE primary_driver_ID=?";
        return null;
    }

    @Override
    public ArrayList<primary_driver> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM primary_driver";
        return null;
    }
}
