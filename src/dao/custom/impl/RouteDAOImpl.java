package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RouteDAO;
import entity.route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteDAOImpl implements RouteDAO {
    @Override
    public boolean add(route route) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO route VALUES(?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM WHERE route_ID=?";
        return false;
    }

    @Override
    public boolean update(route route) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE route SET " +
                "route_rank=?," +
                "start=?," +
                "destination=?," +
                "estimated_time=?," +
                "WHERE route_ID=?";
        return false;
    }

    @Override
    public route search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM route WHERE route_ID=?";
        return null;
    }

    @Override
    public ArrayList<route> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM route";
        return null;
    }

    @Override
    public ArrayList<String> getAllRouteID() throws SQLException, ClassNotFoundException {
        String sql = "SELECT route_ID FROM route";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<String> iDS = new ArrayList<>();
        while (resultSet.next()){
            iDS.add(resultSet.getString(1));
        }
        return iDS;
    }
}
