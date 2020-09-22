package controller;

import animatefx.animation.FadeOut;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class AddCustomerFormController {
    public AnchorPane root;

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
}
