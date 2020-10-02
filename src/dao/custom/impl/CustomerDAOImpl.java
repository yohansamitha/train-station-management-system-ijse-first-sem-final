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
        String sql = "SELECT customer_ID, first_name, last_name, DOB, address, email_address FROM customer " +
                "WHERE customer_ID=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql,s);
        if (resultSet.next()){
            return new customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
                    );
        }
        return null;
    }

    @Override
    public ArrayList<customer> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer";
        return null;
    }

    @Override
    public ArrayList<String> getAllCustomerID() throws SQLException, ClassNotFoundException {
        String sql="SELECT customer_ID,first_name FROM customer";
        ArrayList<String> allCustomerID = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        while (resultSet.next()){
            allCustomerID.add(resultSet.getString(1)+" "+resultSet.getString(2));
        }
        return allCustomerID;
    }
}
