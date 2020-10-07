package bo.custom;

import bo.SuperBO;
import dto.BookingDTO;
import dto.CustomerDTO;
import dto.StationDTO;
import dto.TicketPriceDTO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FindTripBO extends SuperBO {
    int[] getRemainingSeatCount(String schedule_id, String engine_number) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllCustomerName() throws SQLException,ClassNotFoundException;

    ArrayList<StationDTO> getAllStation() throws SQLException,ClassNotFoundException;

    CustomerDTO getCustomerDetails(String customer) throws SQLException,ClassNotFoundException;

    ArrayList<customEntity> findSchedule(String date, String station) throws SQLException,ClassNotFoundException;

    TicketPriceDTO getTicketPrice(String routeID, String stationName) throws SQLException, ClassNotFoundException;

    boolean createBooking(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException;
}
