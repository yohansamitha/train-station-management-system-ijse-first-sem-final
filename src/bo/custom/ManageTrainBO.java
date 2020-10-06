package bo.custom;

import bo.SuperBO;
import dto.TrainDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageTrainBO extends SuperBO {
    ArrayList<TrainDTO> getAllTrain() throws SQLException, ClassNotFoundException;

    boolean addTrain(TrainDTO trainDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllStationID() throws SQLException, ClassNotFoundException;

    int getTrainRowCount() throws SQLException, ClassNotFoundException;
}
