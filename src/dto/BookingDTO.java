package dto;

import java.util.ArrayList;

public class BookingDTO {
    private String schedule_ID;
    private String customer_ID;
    private String ticket_price_ID;
    private String cashier_ID;
    private ArrayList<BookingDetailsDTO> bookingDetailsDTOS;
    private double paidPrice;
    private String paymentMethod;

    public BookingDTO(String schedule_ID, String customer_ID, String ticket_price_ID, String cashier_ID, ArrayList<BookingDetailsDTO> bookingDetailsDTOS, double paidPrice, String paymentMethod) {
        this.schedule_ID = schedule_ID;
        this.customer_ID = customer_ID;
        this.ticket_price_ID = ticket_price_ID;
        this.cashier_ID = cashier_ID;
        this.bookingDetailsDTOS = bookingDetailsDTOS;
        this.paidPrice = paidPrice;
        this.paymentMethod = paymentMethod;
    }

    public String getCashier_ID() {
        return cashier_ID;
    }

    public void setCashier_ID(String cashier_ID) {
        this.cashier_ID = cashier_ID;
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

    public ArrayList<BookingDetailsDTO> getBookingDetailsDTOS() {
        return bookingDetailsDTOS;
    }

    public void setBookingDetailsDTOS(ArrayList<BookingDetailsDTO> bookingDetailsDTOS) {
        this.bookingDetailsDTOS = bookingDetailsDTOS;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "schedule_ID='" + schedule_ID + '\'' +
                ", customer_ID='" + customer_ID + '\'' +
                ", ticket_price_ID='" + ticket_price_ID + '\'' +
                ", cashier_ID='" + cashier_ID + '\'' +
                ", bookingDetailsDTOS=" + bookingDetailsDTOS +
                ", paidPrice=" + paidPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
