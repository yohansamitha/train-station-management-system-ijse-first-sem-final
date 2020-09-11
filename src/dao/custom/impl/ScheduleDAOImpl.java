package dao.custom.impl;

import dao.custom.ScheduleDAO;
import entity.schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean add(schedule schedule) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO schedule VALUES(?,?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM schedule WHERE schedule_ID=?";
        return false;
    }

    @Override
    public boolean update(schedule schedule) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE schedule SET " +
                "engine_number=?," +
                "primary_driver_ID=?," +
                "assistant_driver_ID=?," +
                "route_ID=?," +
                "date=?," +
                "time=?," +
                "WHERE schedule_ID=?";
        return false;
    }

    @Override
    public schedule search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM schedule WHERE schedule_ID=?";
        return null;
    }

    @Override
    public ArrayList<schedule> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM schedule";
        return null;
    }
}
