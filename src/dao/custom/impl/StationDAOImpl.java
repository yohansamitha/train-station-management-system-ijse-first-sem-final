package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StationDAO;
import entity.station;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StationDAOImpl implements StationDAO {
    @Override
    public boolean add(station station) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO station VALUES(?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM station WHERE station_ID=?";
        return false;
    }

    @Override
    public boolean update(station station) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE station SET " +
                "station_name=?," +
                "duration=?," +
                "WHERE station_ID=?";
        return false;
    }

    @Override
    public station search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM station WHERE station_ID=?";
        return null;
    }

    @Override
    public ArrayList<station> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM station";
        ArrayList<station> stations = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        while (resultSet.next()){
            stations.add(new station(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
                    ));
        }
        return stations;
    }
}
