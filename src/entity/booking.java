package entity;

public class booking {
    private String booking_ID;
    private String schedule_ID;
    private String customer_ID;
    private String ticket_price_ID;
    private String cashier_ID;

    public booking(String booking_ID, String schedule_ID, String customer_ID, String ticket_price_ID, String cashier_ID) {
        this.booking_ID = booking_ID;
        this.schedule_ID = schedule_ID;
        this.customer_ID = customer_ID;
        this.ticket_price_ID = ticket_price_ID;
        this.cashier_ID = cashier_ID;
    }

    public String getCashier_ID() {
        return cashier_ID;
    }

    public void setCashier_ID(String cashier_ID) {
        this.cashier_ID = cashier_ID;
    }

    public String getBooking_ID() {
        return booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        this.booking_ID = booking_ID;
    }

    public String getSchedule_ID() {
        return schedule_ID;
    }

    public void setSchedule_ID(String schedule_ID) {
        this.schedule_ID = schedule_ID;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getTicket_price_ID() {
        return ticket_price_ID;
    }

    public void setTicket_price_ID(String ticket_price_ID) {
        this.ticket_price_ID = ticket_price_ID;
    }
}
