package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;

public class ManageRoutesFormController {
    public JFXTextArea txt;
    public JFXButton btnAddStation;

    public void test(ActionEvent actionEvent) {
        System.out.println(txt.getText());
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        btnAddStation.setVisible(true);
    }
}
