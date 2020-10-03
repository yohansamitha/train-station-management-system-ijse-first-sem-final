package dao.custom;

import dao.CrudDAO;
import entity.booking_details;

import java.sql.SQLException;

public interface Booking_DetailsDAO extends CrudDAO<booking_details,String> {
    int getRowCount() throws SQLException, ClassNotFoundException;
}
