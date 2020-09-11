package entity;

public class seat_detail {
    private String engine_number;
    private int clas_seat_count1;
    private int clas_seat_count2;
    private int clas_seat_count3;

    public seat_detail(String engine_number, int clas_seat_count1, int clas_seat_count2, int clas_seat_count3) {
        this.engine_number = engine_number;
        this.clas_seat_count1 = clas_seat_count1;
        this.clas_seat_count2 = clas_seat_count2;
        this.clas_seat_count3 = clas_seat_count3;
    }

    public seat_detail() {
    }

    public String getEngine_number() {
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public int getClas_seat_count1() {
        return clas_seat_count1;
    }

    public void setClas_seat_count1(int clas_seat_count1) {
        this.clas_seat_count1 = clas_seat_count1;
    }

    public int getClas_seat_count2() {
        return clas_seat_count2;
    }

    public void setClas_seat_count2(int clas_seat_count2) {
        this.clas_seat_count2 = clas_seat_count2;
    }

    public int getClas_seat_count3() {
        return clas_seat_count3;
    }

    public void setClas_seat_count3(int clas_seat_count3) {
        this.clas_seat_count3 = clas_seat_count3;
    }
}
