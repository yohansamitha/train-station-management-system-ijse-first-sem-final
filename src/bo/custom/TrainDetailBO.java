package bo.custom;

import bo.SuperBO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainDetailBO extends SuperBO {
    ArrayList<customEntity> getAllTrain(String value) throws SQLException, ClassNotFoundException;
}
