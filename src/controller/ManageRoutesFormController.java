package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageRoutesFormController {
    public JFXTextArea txt;
    public JFXButton btnAddStation;

    public void test(ActionEvent actionEvent) {
        System.out.println(txt.getText());
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        btnAddStation.setVisible(true);
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnAddStationOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("../view/AddStationForm.fxml")));
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
