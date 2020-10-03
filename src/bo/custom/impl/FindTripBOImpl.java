package bo.custom.impl;

import bo.custom.FindTripBO;
import dao.DAOFactory;
import dao.custom.*;
import dao.custom.impl.Booking_detailsDAOImpl;
import db.DBConnection;
import dto.*;
import entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindTripBOImpl implements FindTripBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CustomerDAOImpl);
    StationDAO stationDAO = (StationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.StationDAOImpl);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);
    Ticket_priceDAO ticket_priceDAO = (Ticket_priceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Ticket_priceDAOImpl);
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.BookingDAOImpl);
    Booking_detailsDAOImpl booking_detailsDAO = (Booking_detailsDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Booking_detailsDAOImpl);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PaymentDAOImpl);

    @Override
    public ArrayList<String> getAllCustomerName() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllCustomerID();
//        return null;
    }

    @Override
    public ArrayList<StationDTO> getAllStation() throws SQLException, ClassNotFoundException {
        ArrayList<station> allStation = stationDAO.getAll();
        ArrayList<StationDTO> allStationDTO = new ArrayList<>();
        for (station station : allStation) {
            allStationDTO.add(new StationDTO(
                    station.getStation_ID(),
                    station.getRoute_ID(),
                    station.getStation_name(),
                    station.getDistance(),
                    station.getDuration()));
        }
        return allStationDTO;
    }

    @Override
    public CustomerDTO getCustomerDetails(String customer) throws SQLException, ClassNotFoundException {
        entity.customer search = customerDAO.search(customer);
        return new CustomerDTO(
                search.getCustomer_ID(),
                search.getFirst_name(),
                search.getLast_name(),
                search.getDOB(),
                search.getAddress(),
                search.getEmail_address());
    }

    @Override
    public ArrayList<customEntity> findSchedule(String date, String station) throws SQLException, ClassNotFoundException {
        return queryDAO.findSchedule(date, station);
    }

    @Override
    public TicketPriceDTO getTicketPrice(String routeID, String stationName) throws SQLException, ClassNotFoundException {
        station searchStation = stationDAO.search(stationName + " station");
        System.out.println(searchStation.toString() + "get tivk bo");
        ticket_price ticketPrice = ticket_priceDAO.ticketPriceSearch(searchStation.getStation_ID(), routeID);
        return new TicketPriceDTO(
                ticketPrice.getTicket_price_ID(),
                ticketPrice.getRoute_ID(),
                ticketPrice.getStation_ID(),
                ticketPrice.getSt_class_seat_price1(),
                ticketPrice.getSt_class_seat_price2(),
                ticketPrice.getSt_class_seat_price3()
        );
    }

    @Override
    public boolean createBooking(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException {
        System.out.println(bookingDTO.toString() + " create booking in find trip bo");

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            int bookingRowCount = bookingDAO.getRowCount();
            String bookingID = getBookingID(bookingRowCount);

            boolean bookingAdd = bookingDAO.add(new booking(bookingID, bookingDTO.getSchedule_ID(), bookingDTO.getCustomer_ID(), bookingDTO.getTicket_price_ID(), bookingDTO.getCashier_ID()));
            if (bookingAdd) {
                System.out.println("booking added");
                boolean bookingDetailsAdd = addBookingDetails(bookingDTO.getBookingDetailsDTOS(), bookingID);
                if (bookingDetailsAdd) {
                    System.out.println("booking details add");
                    int paymentRowCount = paymentDAO.getRowCount();
                    String paymentID = getPaymentID(paymentRowCount);
                    boolean paymentAdded = paymentDAO.add(new payment(paymentID, bookingID, bookingDTO.getPaidPrice(), bookingDTO.getPaymentMethod()));
                    if (paymentAdded) {
                        System.out.println("payment added");
                        connection.commit();
                        return true;
                    }
                }
            } else {
                connection.rollback();
                return false;
            }
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    private boolean addBookingDetails(ArrayList<BookingDetailsDTO> bookingDetailsDTOS, String bookingID) throws SQLException, ClassNotFoundException {
        boolean bookingDetailsAdd;
        for (int i = 0; i < 3; i++) {
            int bookingDetailsRowCount = booking_detailsDAO.getRowCount();
            String bookingDetailsID = getBookingDetailsID(bookingDetailsRowCount);
            BookingDetailsDTO bookingDetailsDTO = bookingDetailsDTOS.get(i);
            System.out.println(bookingDetailsDTO.toString() + " booking details id");
            bookingDetailsAdd = booking_detailsDAO.add(new booking_details(
                    bookingDetailsID,
                    bookingID,
                    bookingDetailsDTO.getReserved_class(),
                    bookingDetailsDTO.getReserved_seat_count(),
                    bookingDetailsDTO.getSt_class_seat_price()
            ));
            if (!bookingDetailsAdd) {
                return false;
            }
        }
        return true;
    }

    private String getPaymentID(int paymentRowCount) {
        if (paymentRowCount < 9) {
            return "P00" + (paymentRowCount + 1);
        } else if (paymentRowCount < 99) {
            return "P0" + (paymentRowCount + 1);
        } else {
            return "P" + (paymentRowCount + 1);
        }
    }

    private String getBookingDetailsID(int bookingDetailsRowCount) {
        if (bookingDetailsRowCount < 9) {
            return "BD00" + (bookingDetailsRowCount + 1);
        } else if (bookingDetailsRowCount < 99) {
            return "BD0" + (bookingDetailsRowCount + 1);
        } else {
            return "BD" + (bookingDetailsRowCount + 1);
        }
    }

    private String getBookingID(int rowCount) {
        if (rowCount < 9) {
            return "E00" + (rowCount + 1);
        } else if (rowCount < 99) {
            return "E0" + (rowCount + 1);
        } else {
            return "E" + (rowCount + 1);
        }
    }
}
