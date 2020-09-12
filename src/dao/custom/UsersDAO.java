package dao.custom;

import dao.CrudDAO;
import entity.Users;

import java.sql.SQLException;

public interface UsersDAO extends CrudDAO<Users,String> {
    boolean validate(String userName,String passWord) throws SQLException, ClassNotFoundException;
}
