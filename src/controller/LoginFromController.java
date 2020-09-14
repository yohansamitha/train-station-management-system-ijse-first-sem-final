package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFromController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    LoginBO loginBO = (LoginBO) BOFactory.getInstance().getBO(BOFactory.BoType.LoginBOImpl);

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Login();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Login();
    }

    private void Login() throws IOException {
        try {
            System.out.println("thats ma boy");
            boolean isValidated = loginBO.getValidated(txtUserName.getText(), txtPassword.getText());
            System.out.println(isValidated);
            if (isValidated) {
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
                stage.sizeToScene();
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.show();

//                stage.close();
//                Stage dashBoardScene = new Stage();
//                dashBoardScene.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
//                dashBoardScene.setTitle("Sri Lanka Railway Department");
//                Image image = new Image("/assets/titleIcon.png");
//                dashBoardScene.getIcons().add(image);
//                dashBoardScene.show();
//                root.getChildren().clear();
//                root.resize(1000.0,600.0);
//                boolean add = root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml")));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please check username and password");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
