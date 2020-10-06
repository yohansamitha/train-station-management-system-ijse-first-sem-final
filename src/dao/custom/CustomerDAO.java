package dao.custom;

import dao.CrudDAO;
import entity.customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<customer,String> {
    ArrayList<String> getAllCustomerID() throws SQLException, ClassNotFoundException;

    int getRowCount() throws SQLException, ClassNotFoundException;

    ArrayList<customer> liveSearch(String id) throws SQLException, ClassNotFoundException;
}
