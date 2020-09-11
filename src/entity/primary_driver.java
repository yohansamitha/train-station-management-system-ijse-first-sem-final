package entity;

import java.sql.Date;

public class primary_driver {
    private String primary_driver_ID;
    private String first_name;
    private String last_name;
    private Date DOB;
    private String address;
    private String email_address;
    private Date reg_date;
    private String position;

    public primary_driver(String primary_driver_ID, String first_name, String last_name, Date DOB, String address, String email_address, Date reg_date, String position) {
        this.primary_driver_ID = primary_driver_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.email_address = email_address;
        this.reg_date = reg_date;
        this.position = position;
    }

    public primary_driver() {
    }

    public String getPrimary_driver_ID() {
        return primary_driver_ID;
    }

    public void setPrimary_driver_ID(String primary_driver_ID) {
        this.primary_driver_ID = primary_driver_ID;
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
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
}
