package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;

public class AddStationFormController {
    public JFXButton btnSave;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        System.out.println(btnSave.getText());
    }

    public void testOnAction(ActionEvent actionEvent) {
        btnSave.setText("Success");
    }
}
