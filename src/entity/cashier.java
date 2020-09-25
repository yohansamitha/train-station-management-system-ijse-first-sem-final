package entity;

import java.sql.Date;

public class cashier {
    private String cashier_ID;
    private String user_ID;
    private String first_name;
    private String last_name;
    private Date DOB;
    private String address;
    private String email_address;
    private Date reg_date;
    private String position;

    public cashier(String cashier_ID, String user_ID, String first_name, String last_name, Date DOB, String address, String email_address, Date reg_date, String position) {
        this.cashier_ID = cashier_ID;
        this.user_ID = user_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.email_address = email_address;
        this.reg_date = reg_date;
        this.position = position;
    }

    public String getCashier_ID() {
        return cashier_ID;
    }

    public void setCashier_ID(String cashier_ID) {
        this.cashier_ID = cashier_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
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
