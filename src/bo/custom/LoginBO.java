package bo.custom;

import bo.SuperBO;
import entity.Users;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    boolean getValidated(Users users) throws SQLException, ClassNotFoundException;
}
