package entity;

public class booking_details {
    private String booking_Details_ID ;
    private String booking_ID ;
    private String reserved_class ;
    private int reserved_seat_count ;
    private int reserved_seat_price;

    public booking_details(String booking_Details_ID, String booking_ID, String reserved_class, int reserved_seat_count, int reserved_seat_price) {
        this.booking_Details_ID = booking_Details_ID;
        this.booking_ID = booking_ID;
        this.reserved_class = reserved_class;
        this.reserved_seat_count = reserved_seat_count;
        this.reserved_seat_price = reserved_seat_price;
    }

    public int getReserved_seat_price() {
        return reserved_seat_price;
    }

    public void setReserved_seat_price(int reserved_seat_price) {
        this.reserved_seat_price = reserved_seat_price;
    }

    public String getBooking_Details_ID() {
        return booking_Details_ID;
    }

    public void setBooking_Details_ID(String booking_Details_ID) {
        this.booking_Details_ID = booking_Details_ID;
    }

    public String getBooking_ID() {
        return booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        this.booking_ID = booking_ID;
    }

    public String getReserved_class() {
        return reserved_class;
    }

    public void setReserved_class(String reserved_class) {
        this.reserved_class = reserved_class;
    }

    public int getReserved_seat_count() {
        return reserved_seat_count;
    }

    public void setReserved_seat_count(int reserved_seat_count) {
        this.reserved_seat_count = reserved_seat_count;
    }
}
