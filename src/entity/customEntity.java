package entity;

import java.sql.Date;

public class customEntity {
    private String ID;
    private String first_name;
    private String last_name;
    private String DOB;
    private String address;
    private String email_address;
    private Date reg_date;
    private String position;

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
                "ID='" + ID + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", DOB=" + DOB +
                ", address='" + address + '\'' +
                ", email_address='" + email_address + '\'' +
                ", reg_date=" + reg_date +
                ", position='" + position + '\'' +
                '}';
    }
}
