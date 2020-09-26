package entity;

import java.sql.Date;

public class assistant_driver {
    private String assistant_driver_ID;
    private String first_name;
    private String last_name;
    private String DOB;
    private String address;
    private String email_address;
    private String reg_date;
    private String position;

    public assistant_driver(String assistant_driver_ID, String first_name, String last_name, String DOB, String address, String email_address, String reg_date, String position) {
        this.assistant_driver_ID = assistant_driver_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.email_address = email_address;
        this.reg_date = reg_date;
        this.position = position;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getAssistant_driver_ID() {
        return assistant_driver_ID;
    }

    public void setAssistant_driver_ID(String assistant_driver_ID) {
        this.assistant_driver_ID = assistant_driver_ID;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
