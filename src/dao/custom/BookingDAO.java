package dao.custom;

import dao.CrudDAO;
import entity.booking;

import java.sql.SQLException;

public interface BookingDAO extends CrudDAO<booking,String> {
    public int getRowCount() throws SQLException, ClassNotFoundException;
}
