package controller;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FindTripFormController {
    public JFXDatePicker tripDatePicker;


    public JFXButton btnNewCustomer;

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("../view/AddCustomerForm.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
            new FadeIn(parent).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
