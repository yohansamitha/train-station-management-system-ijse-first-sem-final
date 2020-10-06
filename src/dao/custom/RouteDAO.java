package dao.custom;

import dao.CrudDAO;
import entity.route;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RouteDAO extends CrudDAO<route,String> {
    ArrayList<String> getAllRouteID() throws SQLException, ClassNotFoundException;
}
