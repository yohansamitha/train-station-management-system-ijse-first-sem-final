package bo.custom;

import bo.SuperBO;
import dto.StationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FindTripBO extends SuperBO {
    ArrayList<String> getAllCustomerName() throws SQLException,ClassNotFoundException;

    ArrayList<StationDTO> getAllStation() throws SQLException,ClassNotFoundException;
}
