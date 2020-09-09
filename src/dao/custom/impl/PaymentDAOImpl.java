package dao.custom.impl;

import dao.custom.PaymentDAO;
import entity.payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(payment payment) throws SQLException, ClassNotFoundException {
        String sql = "";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "";
        return false;
    }

    @Override
    public boolean update(payment payment) throws SQLException, ClassNotFoundException {
        String sql = "";
        return false;
    }

    @Override
    public payment search(String s) throws SQLException, ClassNotFoundException {
        String sql = "";
        return null;
    }

    @Override
    public ArrayList<payment> getAll() throws SQLException, ClassNotFoundException {
        String sql = "";
        return null;
    }
}
