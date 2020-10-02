package dao;

import dao.custom.impl.*;

public class DAOFactory {
    static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case UserDAOImpl:
                return new UsersDAOImpl();
            case QueryDAOImpl:
                return new QueryDAOImpl();
            case primary_driverDAOImpl:
                return new Primary_driverDAOImpl();
            case assistant_driverDAOImpl:
                return new Assistant_driverDAOImpl();
            case CashierDAOImpl:
                return new CashierDAOImpl();
            case CustomerDAOImpl:
                return new CustomerDAOImpl();
            case StationDAOImpl:
                return new StationDAOImpl();
            case Ticket_priceDAOImpl:
                return new Ticket_priceDAOImpl();
            case BookingDAOImpl:
                return new BookingDAOImpl();
            case Booking_detailsDAOImpl:
                return new Booking_detailsDAOImpl();
            case PaymentDAOImpl:
                return new PaymentDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType {
        UserDAOImpl,
        QueryDAOImpl,
        primary_driverDAOImpl,
        assistant_driverDAOImpl,
        CashierDAOImpl,
        CustomerDAOImpl,
        StationDAOImpl,
        Ticket_priceDAOImpl,
        BookingDAOImpl,
        Booking_detailsDAOImpl,
        PaymentDAOImpl,
    }
}
