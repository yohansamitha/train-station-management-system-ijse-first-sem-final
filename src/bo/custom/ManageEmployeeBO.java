package bo.custom;

import bo.SuperBO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageEmployeeBO extends SuperBO {
     ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException;
}
