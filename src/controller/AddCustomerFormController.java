package controller;

import animatefx.animation.FadeOut;
import bo.BOFactory;
import bo.custom.ManageCustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {
    public AnchorPane root;
    public JFXTextField txtID;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmailAddress;
    public JFXDatePicker dtpDOB;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    ManageCustomerBO manageCustomerBO = (ManageCustomerBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageCustomerBOImpl);

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to exit!");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.isPresent()) {
            if (res.get().equals(ButtonType.OK))
                stage.close();
            new FadeOut(root).play();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            boolean isCustomerAdded = manageCustomerBO.addCustomer(new CustomerDTO(
                    txtID.getText(),
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    dtpDOB.getValue().toString(),
                    txtAddress.getText(),
                    txtEmailAddress.getText()
            ));
            if (isCustomerAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Customer Added SuccessFully!");
                Optional<ButtonType> res = alert.showAndWait();
                if (res.isPresent()) {
                    if (res.get().equals(ButtonType.OK))
                        stage.close();
                    new FadeOut(root).play();
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            txtID.setText(manageCustomerBO.getNewCustomerID());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
