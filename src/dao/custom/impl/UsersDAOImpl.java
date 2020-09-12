package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.UsersDAO;
import entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public boolean add(Users users) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users(user_name,user_password) VALUES(?,?)";
        return false;
    }

    @Override
    public boolean delete(String name) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE user_ID=?";
        return false;
    }

    @Override
    public boolean update(Users users) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Users search(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE user_ID=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, code);
        return new Users(
                resultSet.getString(2),
                resultSet.getString(3));
    }

    @Override
    public ArrayList<Users> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users";
        return null;
    }

    @Override
    public boolean validate(String userName, String passWord) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE user_name=? && user_password=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, userName, passWord);
        return resultSet.next();
    }
}
