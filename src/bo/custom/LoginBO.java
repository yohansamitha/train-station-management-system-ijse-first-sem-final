package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    boolean getValidated(String text, String text1) throws SQLException, ClassNotFoundException;
}
