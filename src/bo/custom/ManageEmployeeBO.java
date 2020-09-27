package bo.custom;

import bo.SuperBO;
import dto.AssistantDriverDTO;
import dto.primary_driverDTO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageEmployeeBO extends SuperBO {
    ArrayList<customEntity> getAllEmployee() throws SQLException, ClassNotFoundException;

    boolean addPrimaryDriver(primary_driverDTO primary_driver) throws SQLException, ClassNotFoundException;

    boolean addAssistantDriver(AssistantDriverDTO assistantDriverDTO) throws SQLException, ClassNotFoundException;

    int getCashierRowCount() throws SQLException, ClassNotFoundException;

    int getAssistantDriverRowCount() throws SQLException, ClassNotFoundException;

    int getPrimaryDriverRowCount() throws SQLException, ClassNotFoundException;

    boolean updatePrimaryDriver(primary_driverDTO primary_driverDTO) throws SQLException, ClassNotFoundException;

    boolean updateAssistantDriver(AssistantDriverDTO assistantDriverDTO) throws SQLException, ClassNotFoundException;
}
