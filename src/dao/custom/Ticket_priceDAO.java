package dao.custom;

import dao.CrudDAO;
import entity.ticket_price;

import java.sql.SQLException;

public interface Ticket_priceDAO extends CrudDAO<ticket_price,String> {
    ticket_price ticketPriceSearch(String station_id,String routeID) throws SQLException, ClassNotFoundException;
}
