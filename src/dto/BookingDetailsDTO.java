package dto;

public class BookingDetailsDTO {
    private String reserved_class ;
    private int reserved_seat_count ;
    private int st_class_seat_price ;

    public BookingDetailsDTO(String reserved_class, int reserved_seat_count, int st_class_seat_price) {
        this.reserved_class = reserved_class;
        this.reserved_seat_count = reserved_seat_count;
        this.st_class_seat_price = st_class_seat_price;
    }

    public int getSt_class_seat_price() {
        return st_class_seat_price;
    }

    public void setSt_class_seat_price(int st_class_seat_price) {
        this.st_class_seat_price = st_class_seat_price;
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

    @Override
    public String toString() {
        return "BookingDetailsDTO{" +
                "reserved_class='" + reserved_class + '\'' +
                ", reserved_seat_count=" + reserved_seat_count +
                ", st_class_seat_price=" + st_class_seat_price +
                '}';
    }
}
