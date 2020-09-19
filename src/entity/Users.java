package entity;

public class Users {
//    private int userID;
    private String user_name;
    private String user_password;
    private String position;

    public Users(String user_name, String user_password, String position) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
