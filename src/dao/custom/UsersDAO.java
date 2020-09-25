package dao.custom;

import dao.CrudDAO;
import entity.Users;

import java.sql.SQLException;

public interface UsersDAO extends CrudDAO<Users,String> {
    Users validate(String userName) throws SQLException, ClassNotFoundException;
}
