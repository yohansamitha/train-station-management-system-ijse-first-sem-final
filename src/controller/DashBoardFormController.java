package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class DashBoardFormController {
    public AnchorPane context;
    public AnchorPane root;

    public void btnManageTrain(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageTrainForm.fxml")));
    }

    public void banManageEmployee(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageEmployeeForm.fxml")));
    }

    public void btnManageRoute(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageRoutesForm.fxml")));
    }

    public void btnReports(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ReportsForm.fxml")));
    }

    public void btnManageSchedule(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageSchedulesForm.fxml")));
    }

    public void btnLogout(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> decision = alert.showAndWait();
        if (decision.get() == ButtonType.OK) {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/LoginFrom.fxml"))));
            stage.centerOnScreen();
            stage.show();
        } else {
            alert.close();
        }

    }
}
