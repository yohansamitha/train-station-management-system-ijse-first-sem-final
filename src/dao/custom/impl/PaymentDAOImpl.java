package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(payment payment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment(payment_ID, booking_ID, paid_price,payment_method) VALUES (?,?,?,?);";
        return CrudUtil.executeUpdate(sql,payment.getPayment_ID(),payment.getBooking_ID(),payment.getPaid_price(),payment.getPayment_method());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM WHERE payment_ID=?";
        return false;
    }

    @Override
    public boolean update(payment payment) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE payment SET " +
                "booking_ID=?," +
                "ticket_price=?," +
                "paid_price=?," +
                "payment_method=?," +
                "WHERE payment_ID=?";
        return false;
    }

    @Override
    public payment search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM WHERE payment_ID=?";
        return null;
    }

    @Override
    public ArrayList<payment> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM payment";
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="SELECT COUNT(payment_ID) FROM payment";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
