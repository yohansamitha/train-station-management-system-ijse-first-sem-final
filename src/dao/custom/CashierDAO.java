package dao.custom;

import dao.CrudDAO;
import entity.cashier;

import java.sql.SQLException;

public interface CashierDAO extends CrudDAO<cashier,String> {
    int getRowCount() throws SQLException,ClassNotFoundException;
}
