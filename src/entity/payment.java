package entity;

public class payment {
    private String payment_ID;
    private String booking_ID;
    private double paid_price;
    private String payment_method;

    public payment(String payment_ID, String booking_ID, double paid_price, String payment_method) {
        this.payment_ID = payment_ID;
        this.booking_ID = booking_ID;
        this.paid_price = paid_price;
        this.payment_method = payment_method;
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

    public double getPaid_price() {
        return paid_price;
    }

    public void setPaid_price(double paid_price) {
        this.paid_price = paid_price;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
