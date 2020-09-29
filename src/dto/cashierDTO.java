package dto;

import java.sql.Date;
import java.time.LocalDate;

public class cashierDTO {
    private String cashier_ID;
    private int user_ID;
    private String first_name;
    private String last_name;
    private LocalDate DOB;
    private String address;
    private String email_address;
    private String reg_date;
    private String position;

    public cashierDTO(String cashier_ID, int user_ID, String first_name, String last_name, LocalDate DOB, String address, String email_address, String reg_date, String position) {
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

    public cashierDTO(String cashier_ID, String first_name, String last_name, LocalDate DOB, String address, String email_address, String reg_date, String position) {
        this.cashier_ID = cashier_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.address = address;
        this.email_address = email_address;
        this.reg_date = reg_date;
        this.position = position;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getCashier_ID() {
        return cashier_ID;
    }

    public void setCashier_ID(String cashier_ID) {
        this.cashier_ID = cashier_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
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
