package bo.custom.impl;

import bo.custom.FindTripBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.StationDAO;
import dto.StationDTO;
import entity.station;

import java.sql.SQLException;
import java.util.ArrayList;

public class FindTripBOImpl implements FindTripBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CustomerDAOImpl);
    StationDAO stationDAO = (StationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.StationDAOImpl);
    @Override
    public ArrayList<String> getAllCustomerName() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllCustomerID();
//        return null;
    }

    @Override
    public ArrayList<StationDTO> getAllStation() throws SQLException, ClassNotFoundException {
        ArrayList<station> allStation = stationDAO.getAll();
        ArrayList<StationDTO> allStationDTO = new ArrayList<>();
        for (station station: allStation) {
            allStationDTO.add(new StationDTO(
                    station.getStation_ID(),
                    station.getRoute_ID(),
                    station.getStation_name(),
                    station.getDistance(),
                    station.getDuration()));
        }
        return allStationDTO;
    }
}
