package controller;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDashBoardFormController implements Initializable {
    public AnchorPane context;
    public AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            context.getChildren().clear();
            Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManageSchedulesForm.fxml"));
            context.getChildren().add(parent);
            new FadeIn(parent).play();
//            context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageSchedulesForm.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnManageTrain(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
//        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageTrainForm.fxml")));
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManageTrainForm.fxml"));
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void banManageEmployee(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
//        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageEmployeeForm.fxml")));
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManageEmployeeForm.fxml"));
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void btnManageRoute(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
//        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageRoutesForm.fxml")));
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManageRoutesForm.fxml"));
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void btnReports(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
//        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ReportsForm.fxml")));
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ReportsForm.fxml"));
        context.getChildren().add(parent);
        new FadeIn(parent).play();
    }

    public void btnManageSchedule(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
//        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageSchedulesForm.fxml")));
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManageSchedulesForm.fxml"));
        context.getChildren().add(parent);
        new FadeIn(parent).play();
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
