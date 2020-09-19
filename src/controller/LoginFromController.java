package controller;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import animatefx.animation.RotateIn;
import bo.BOFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entity.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFromController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    public JFXComboBox cblUserType;
    LoginBO loginBO = (LoginBO) BOFactory.getInstance().getBO(BOFactory.BoType.LoginBOImpl);

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Login();
    }

    public void cblUserTypeOnAction(ActionEvent actionEvent) {
        txtUserName.requestFocus();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Login();
    }

    private void Login() throws IOException {
        try {
            System.out.println("thats ma boy");
//            boolean isValidated = ;
//            System.out.println(isValidated);
            if (txtUserName.getText().isEmpty() | txtPassword.getText().isEmpty() | cblUserType.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Enter Your Login Details!");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            } else {
                if (loginBO.getValidated(new Users(txtUserName.getText(), txtPassword.getText(), cblUserType.getValue().toString()))) {
                    Stage stage = (Stage) root.getScene().getWindow();
//                    Stage exitStage = (Stage) root.getScene().getWindow();
//                    exitStage.close();
//                    Stage stage = new Stage();
                        Parent parent;
                    if (cblUserType.getValue().toString().equalsIgnoreCase("admin")) {
                        parent = FXMLLoader.load(this.getClass().getResource("../view/AdminDashBoardForm.fxml"));
                    } else {
                        System.out.println("working");
                        parent = FXMLLoader.load(this.getClass().getResource("../view/CashierDashBoardForm.fxml"));
                    }
                    stage.setScene(new Scene(parent));
                    stage.sizeToScene();
                    stage.centerOnScreen();
                    stage.setResizable(false);
                    stage.show();
                    new FadeIn(parent).play();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please check username and password");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}