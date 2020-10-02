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
