package bo.custom;

import bo.SuperBO;
import dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageScheduleBO extends SuperBO {

    int getScheduleRowCount() throws SQLException, ClassNotFoundException;

    boolean createSchedule(ScheduleDTO scheduleDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllEngineNumbers() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllPrimaryDrivers() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllAssistantDrivers() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllRoute() throws SQLException, ClassNotFoundException;
}
