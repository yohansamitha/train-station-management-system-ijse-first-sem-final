package bo.custom;

import bo.SuperBO;
import dto.UsersDTO;
import entity.Users;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    UsersDTO getValidated(String userName) throws SQLException, ClassNotFoundException;
}
