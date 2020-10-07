package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.Seat_detailsDAO;
import entity.seat_detail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Seat_detailsDAOImpl implements Seat_detailsDAO {
    @Override
    public boolean add(seat_detail seat_detail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO seat_detail VALUES(?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM seat_detail WHERE engine_number=?";
        return false;
    }

    @Override
    public boolean update(seat_detail seat_detail) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE seat_detail SET " +
                "1st_clas_seat_count=?," +
                "2st_clas_seat_count=?," +
                "3st_clas_seat_count=?," +
                "WHERE engine_number=?";
        return false;
    }

    @Override
    public seat_detail search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM seat_detail WHERE engine_number=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, s);
        if (resultSet.next()){
            return new seat_detail(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<seat_detail> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM seat_detail";
        return null;
    }
}
