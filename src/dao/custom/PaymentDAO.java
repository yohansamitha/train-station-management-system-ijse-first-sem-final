package dao.custom;

import dao.CrudDAO;
import entity.payment;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<payment,String> {
    int getRowCount() throws SQLException, ClassNotFoundException;
}
