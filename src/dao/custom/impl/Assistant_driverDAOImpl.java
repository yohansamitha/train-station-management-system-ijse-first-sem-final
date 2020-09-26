package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.Assistant_driverDAO;
import entity.assistant_driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Assistant_driverDAOImpl implements Assistant_driverDAO {
    @Override
    public boolean add(assistant_driver assistant_driver) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO assistant_driver (assistant_driver_ID, first_name, last_name, DOB, address, email_address, reg_date, position)" +
                "VALUES(?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,
                assistant_driver.getAssistant_driver_ID(),
                assistant_driver.getFirst_name(),
                assistant_driver.getLast_name(),
                assistant_driver.getDOB(),
                assistant_driver.getAddress(),
                assistant_driver.getEmail_address(),
                assistant_driver.getReg_date(),
                assistant_driver.getPosition()
                );
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

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(assistant_driver_ID) FROM assistant_driver";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
