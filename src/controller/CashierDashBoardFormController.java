package controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class CashierDashBoardFormController {
    public AnchorPane root;
    public AnchorPane context;
    String cashier_ID;

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

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageCustomerForm.fxml")));
    }

    public void btnFindTripOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/FindTripForm.fxml"));
        Parent parent = fxmlLoader.load();
        FindTripFormController controller = fxmlLoader.getController();
        controller.setCashierID(cashier_ID);
        context.getChildren().clear();
        context.getChildren().add(parent);
    }

    public void btnTrainScheduleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/TrainSchedulesForm.fxml"));
        Parent parent = fxmlLoader.load();
        context.getChildren().clear();
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void btnTrainDetailsOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/TrainDetailsForm.fxml"));
        Parent parent = fxmlLoader.load();
        context.getChildren().clear();
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/AboutForm.fxml"));
        Parent parent = fxmlLoader.load();
        context.getChildren().clear();
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void setCashierID(String cashierID) {
        this.cashier_ID = cashierID;
    }
}
