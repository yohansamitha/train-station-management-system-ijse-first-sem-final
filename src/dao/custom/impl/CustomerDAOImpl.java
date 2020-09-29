package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE customer_ID=?";
        return false;
    }

    @Override
    public boolean update(customer customer) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE customer SET " +
                "first_name=?," +
                "last_name=?," +
                "DOB=?," +
                "address=?," +
                "email_address=?," +
                "WHERE customer_ID=?";
        return false;
    }

    @Override
    public customer search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer WHERE customer_ID=?";
        return null;
    }

    @Override
    public ArrayList<customer> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer";
        return null;
    }

    @Override
    public ArrayList<String> getAllCustomerID() throws SQLException, ClassNotFoundException {
        String sql="SELECT customer_ID FROM customer";
        ArrayList<String> allCustomerID = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        while (resultSet.next()){
            allCustomerID.add(resultSet.getString(1));
        }
        return allCustomerID;
    }
}
