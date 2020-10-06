package bo.custom;

import bo.SuperBO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainScheduleBO extends SuperBO {
    ArrayList<customEntity> getAllSchedule(String value) throws SQLException, ClassNotFoundException;
}
