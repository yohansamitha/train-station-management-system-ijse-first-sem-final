package entity;

public class payment {
    private String payment_ID;
    private String booking_ID;
    private String ticket_price;
    private String paid_price;
    private String payment_method;

    public payment(String payment_ID, String booking_ID, String ticket_price, String paid_price, String payment_method) {
        this.payment_ID = payment_ID;
        this.booking_ID = booking_ID;
        this.ticket_price = ticket_price;
        this.paid_price = paid_price;
        this.payment_method = payment_method;
    }

    public payment() {
    }

    public String getPayment_ID() {
        return payment_ID;
    }

    public void setPayment_ID(String payment_ID) {
        this.payment_ID = payment_ID;
    }

    public String getBooking_ID() {
        return booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        this.booking_ID = booking_ID;
    }

    public String getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(String ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getPaid_price() {
        return paid_price;
    }

    public void setPaid_price(String paid_price) {
        this.paid_price = paid_price;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
