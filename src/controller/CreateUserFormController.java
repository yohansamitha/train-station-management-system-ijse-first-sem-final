package controller;

import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserFormController implements Initializable {
    public JFXButton btnLogin;
    public JFXButton btnCancel;
    public JFXTextField txtUserName;
    public JFXTextField txtPassWord;
    public JFXTextField txtPassWordReEnter;
    public Label txtCashierID;
    public AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        setUserID();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
        new FadeOut(root).play();
    }

    public void setUserID(String text) {
        txtCashierID.setText(text);
    }

}
