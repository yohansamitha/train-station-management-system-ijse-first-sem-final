package dao.custom;

import dao.CrudDAO;
import entity.schedule;

import java.sql.SQLException;

public interface ScheduleDAO extends CrudDAO<schedule,String> {
    int getRowCount() throws SQLException, ClassNotFoundException;
}
