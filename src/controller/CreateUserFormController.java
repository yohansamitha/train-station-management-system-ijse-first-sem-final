package controller;

import animatefx.animation.FadeOut;
import bo.BOFactory;
import bo.custom.ManageEmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.UsersDTO;
import dto.cashierDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreateUserFormController implements Initializable {
    public JFXButton btnLogin;
    public JFXButton btnCancel;
    public JFXTextField txtUserName;
    public Label txtCashierID;
    public AnchorPane root;
    public JFXPasswordField txtPassWord;
    public JFXPasswordField txtPassWordReEnter;
    ManageEmployeeBO manageEmployeeBO = (ManageEmployeeBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageEmployeeBOImpl);
    cashierDTO cashierDTO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        setUserID();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        addUser();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        alert.setContentText("cashier will not save if you close this close this!");
        alert.initStyle(StageStyle.UTILITY);
        Optional<ButtonType> res = alert.showAndWait();
        if (res.isPresent()) {
            if (res.get().equals(ButtonType.CANCEL)) {
//                            event.consume();
                System.out.println("hhh");
            }else {
                Stage stage = (Stage) root.getScene().getWindow();
                stage.close();
                new FadeOut(root).play();
            }
        }
    }

    public void setCashierDetails(cashierDTO cashierDTO) {
        this.cashierDTO = cashierDTO;
    }

    private void addUser() {
        try {
            if (txtPassWord.getText().equals(txtPassWordReEnter.getText())) {
                boolean cashier = manageEmployeeBO.addCashier(cashierDTO, new UsersDTO(txtUserName.getText(), txtPassWord.getText(), "cashier"));
                System.out.println(cashier + " cashier from user controller");
                if (cashier) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Cashier Added successfully!");
                    alert.initStyle(StageStyle.UTILITY);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        // ... user chose OK
                        Stage stage = (Stage) root.getScene().getWindow();
                        stage.close();
                        new FadeOut(root).play();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Warning!");
                    alert.setHeaderText(null);
                    alert.setContentText("Something Went Wrong!");
                    alert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void txtPassWordOnAction(ActionEvent actionEvent) {
        txtPassWordReEnter.requestFocus();
    }

    public void txtPassWordReEnterOnAction(ActionEvent actionEvent) {
        addUser();
    }
}
