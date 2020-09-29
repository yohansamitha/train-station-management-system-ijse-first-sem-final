package dto;

public class TicketPriceDTO {
    private String ticket_price_ID;
    private String station_ID;
    private int    st_class_seat_price1;
    private int    st_class_seat_price2;
    private int    st_class_seat_price3;

    public TicketPriceDTO(String ticket_price_ID, String station_ID, int st_class_seat_price1, int st_class_seat_price2, int st_class_seat_price3) {
        this.ticket_price_ID = ticket_price_ID;
        this.station_ID = station_ID;
        this.st_class_seat_price1 = st_class_seat_price1;
        this.st_class_seat_price2 = st_class_seat_price2;
        this.st_class_seat_price3 = st_class_seat_price3;
    }

    public String getTicket_price_ID() {
        return ticket_price_ID;
    }

    public void setTicket_price_ID(String ticket_price_ID) {
        this.ticket_price_ID = ticket_price_ID;
    }

    public String getStation_ID() {
        return station_ID;
    }

    public void setStation_ID(String station_ID) {
        this.station_ID = station_ID;
    }

    public int getSt_class_seat_price1() {
        return st_class_seat_price1;
    }

    public void setSt_class_seat_price1(int st_class_seat_price1) {
        this.st_class_seat_price1 = st_class_seat_price1;
    }

    public int getSt_class_seat_price2() {
        return st_class_seat_price2;
    }

    public void setSt_class_seat_price2(int st_class_seat_price2) {
        this.st_class_seat_price2 = st_class_seat_price2;
    }

    public int getSt_class_seat_price3() {
        return st_class_seat_price3;
    }

    public void setSt_class_seat_price3(int st_class_seat_price3) {
        this.st_class_seat_price3 = st_class_seat_price3;
    }
}
