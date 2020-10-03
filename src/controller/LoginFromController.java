package controller;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import animatefx.animation.RotateIn;
import bo.BOFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import dto.UsersDTO;
import entity.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFromController implements Initializable {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    LoginBO loginBO = (LoginBO) BOFactory.getInstance().getBO(BOFactory.BoType.LoginBOImpl);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Login();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
            Login();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Something went Wrong!");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        }
    }

    private void Login() throws IOException {
        try {
            System.out.println("thats ma boy");
//            try {
//                CashierDashBoardFormController.cashier_ID = queryDAO.getCashierID(txtUserName.getText());


//            } catch (SQLException | ClassNotFoundException exception) {
//                exception.printStackTrace();
//            }
//            boolean isValidated = ;
//            System.out.println(isValidated);
            if (txtUserName.getText().isEmpty() | txtPassword.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Enter Your Login Details!");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            } else {
                UsersDTO usersDTO = loginBO.getValidated(txtUserName.getText());
                if (txtUserName.getText().equals(usersDTO.getUserName()) && txtPassword.getText().equals(usersDTO.getUserPassword())) {
                    System.out.println("true");
                    Stage stage = (Stage) root.getScene().getWindow();
                    Parent parent;
                    if (usersDTO.getPosition().equalsIgnoreCase("admin")) {
                        parent = FXMLLoader.load(this.getClass().getResource("../view/AdminDashBoardForm.fxml"));
                    } else {
                        System.out.println("working");
//                        parent = FXMLLoader.load(this.getClass().getResource("../view/CashierDashBoardForm.fxml"));
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/CashierDashBoardForm.fxml"));
                        parent =  fxmlLoader.load();
                        CashierDashBoardFormController controller = fxmlLoader.getController();
                        String cashierID = queryDAO.getCashierID(txtUserName.getText());
                        controller.setCashierID(cashierID);
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
        } catch (NullPointerException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please check username and password");
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

}