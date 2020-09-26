package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CashierDAO;
import entity.cashier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public boolean add(cashier cashier) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO cashier (cashier_ID, user_ID, first_name, last_name, DOB, address, email_address, reg_date, position)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(cashier cashier) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public cashier search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<cashier> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(cashier_ID) FROM cashier";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
