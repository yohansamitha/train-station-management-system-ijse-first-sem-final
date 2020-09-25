package dto;

public class UsersDTO {
    private String userName;
    private String userPassword;
    private String position;

    public UsersDTO(String userName, String userPassword, String position) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
