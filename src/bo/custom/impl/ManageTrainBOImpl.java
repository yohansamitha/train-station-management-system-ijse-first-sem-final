package bo.custom.impl;

import bo.custom.ManageTrainBO;
import dao.DAOFactory;
import dao.custom.StationDAO;
import dao.custom.TrainDAO;
import dto.TrainDTO;
import entity.station;
import entity.train;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageTrainBOImpl implements ManageTrainBO {
    TrainDAO trainDAO = (TrainDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TrainDAOImpl);
    StationDAO stationDAO = (StationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.StationDAOImpl);

    @Override
    public ArrayList<TrainDTO> getAllTrain() throws SQLException, ClassNotFoundException {
        ArrayList<train> allTrain = trainDAO.getAll();
        ArrayList<TrainDTO> allTrainDTOs = new ArrayList<>();
        for (train tra : allTrain) {
            allTrainDTOs.add(new TrainDTO(
                    tra.getEngine_number(),
                    tra.getTrain_name(),
                    tra.getEngine_type(),
                    tra.getFuel_capacity(),
                    tra.getStation_ID()
            ));
        }
        return allTrainDTOs;
    }

    @Override
    public boolean addTrain(TrainDTO trainDTO) throws SQLException, ClassNotFoundException {
        return trainDAO.add(new train(
                trainDTO.getEngine_number(),
                trainDTO.getTrain_name(),
                trainDTO.getEngine_type(),
                trainDTO.getFuel_capacity(),
                trainDTO.getStation_ID()
        ));
    }

    @Override
    public ArrayList<String> getAllStationID() throws SQLException, ClassNotFoundException {
        ArrayList<station> all = stationDAO.getAll();
        ArrayList<String> allStation = new ArrayList<>();
        for (station s : all) {
            allStation.add(s.getStation_ID());
        }
        return allStation;
    }

    @Override
    public int getTrainRowCount() throws SQLException, ClassNotFoundException {
        return trainDAO.getRowCount();
    }
}
