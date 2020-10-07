package entity;

import java.sql.Date;
import java.sql.Time;

public class customEntity {
    private String ID;
    private String first_name;
    private String last_name;
    private String DOB;
    private String address;
    private String email_address;
    private Date reg_date;
    private String position;

    private String schedule_ID;
    private String engine_number;
    private String engine_name;
    private String primary_driver_ID;
    private String assistant_driver_ID;
    private String route_ID;
    private Date   date;
    private Time   time;

    private String train_name;
    private String engine_type;
    private int fuel_capacity;
    private String station_ID;
    private int clas_seat_count1;
    private int clas_seat_count2;
    private int clas_seat_count3;
    private int seatCount;

    public customEntity(String engine_number, int seatCount) {
        this.engine_number = engine_number;
        this.seatCount = seatCount;
    }

    public customEntity(String engine_number, String train_name, String engine_type, int fuel_capacity, String station_ID, int clas_seat_count1, int clas_seat_count2, int clas_seat_count3) {
        this.engine_number = engine_number;
        this.train_name = train_name;
        this.engine_type = engine_type;
        this.fuel_capacity = fuel_capacity;
        this.station_ID = station_ID;
        this.clas_seat_count1 = clas_seat_count1;
        this.clas_seat_count2 = clas_seat_count2;
        this.clas_seat_count3 = clas_seat_count3;
    }

    public customEntity(String schedule_ID, String engine_number, String engine_name, String primary_driver_ID, String assistant_driver_ID, String route_ID, Date date, Time time) {
        this.schedule_ID = schedule_ID;
        this.engine_number = engine_number;
        this.engine_name = engine_name;
        this.primary_driver_ID = primary_driver_ID;
        this.assistant_driver_ID = assistant_driver_ID;
        this.route_ID = route_ID;
        this.date = date;
        this.time = time;
    }

    public customEntity(String ID, String first_name, String last_name, String DOB, String address, String email_address, Date reg_date, String position) {
        this.ID = ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.email_address = email_address;
        this.reg_date = reg_date;
        this.position = position;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public int getFuel_capacity() {
        return fuel_capacity;
    }

    public void setFuel_capacity(int fuel_capacity) {
        this.fuel_capacity = fuel_capacity;
    }

    public String getStation_ID() {
        return station_ID;
    }

    public void setStation_ID(String station_ID) {
        this.station_ID = station_ID;
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

    public String getSchedule_ID() {
        return schedule_ID;
    }

    public void setSchedule_ID(String schedule_ID) {
        this.schedule_ID = schedule_ID;
    }

    public String getEngine_number() {
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getEngine_name() {
        return engine_name;
    }

    public void setEngine_name(String engine_name) {
        this.engine_name = engine_name;
    }

    public String getPrimary_driver_ID() {
        return primary_driver_ID;
    }

    public void setPrimary_driver_ID(String primary_driver_ID) {
        this.primary_driver_ID = primary_driver_ID;
    }

    public String getAssistant_driver_ID() {
        return assistant_driver_ID;
    }

    public void setAssistant_driver_ID(String assistant_driver_ID) {
        this.assistant_driver_ID = assistant_driver_ID;
    }

    public String getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(String route_ID) {
        this.route_ID = route_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "customEntity{" +
                "schedule_ID='" + schedule_ID + '\'' +
                ", engine_number='" + engine_number + '\'' +
                ", engine_name='" + engine_name + '\'' +
                ", primary_driver_ID='" + primary_driver_ID + '\'' +
                ", assistant_driver_ID='" + assistant_driver_ID + '\'' +
                ", route_ID='" + route_ID + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
