package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane context;
    public AnchorPane root;

    public void btnManageTrain(ActionEvent actionEvent) {
    }

    public void banManageEmployee(ActionEvent actionEvent) {
    }

    public void btnManageRoute(ActionEvent actionEvent) {
    }

    public void btnReports(ActionEvent actionEvent) {
    }

    public void btnManageSchedule(ActionEvent actionEvent) {
    }

    public void btnLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/LoginFrom.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}
