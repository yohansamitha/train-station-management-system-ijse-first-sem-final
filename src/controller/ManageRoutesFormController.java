package controller;

import animatefx.animation.FadeIn;
import bo.BOFactory;
import bo.custom.ManageRouteBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageRoutesFormController implements Initializable {
    public JFXTextArea txt;
    public JFXButton btnAddStation;
    public TableColumn colRouteID;
    public TableColumn colRouteRank;
    public TableColumn colStart;
    public TableColumn colDestination;
    public TableColumn colEstimatedTime;
    public TableColumn colStationID;
    public TableColumn colStationName;
    public TableColumn colDistance;
    public TableColumn colDuration;
    public TableView tblSchedule;
    public JFXTextField txtRouteID;
    public JFXTextField txtRouteRank;
    public JFXTextField txtStart;
    public JFXTextField txtDestination;
    public JFXTextField txtEstimatedTime;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public Label lblError1;
    public Label lblError2;
    public JFXButton btnDeleteEmp;
    ManageRouteBO manageRouteBO = (ManageRouteBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageRouteBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllRoute();
    }

    private void loadAllRoute() {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(this.getClass().getResource("../view/AddStationForm.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.showAndWait();
            new FadeIn(parent).play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clear();
    }

    private void clear() {
        txtRouteID.setText(null);
        txtRouteRank.setText(null);
        txtStart.setText(null);
        txtDestination.setText(null);
        txtEstimatedTime.setText(null);
    }

    public void btnAddStationOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("../view/AddStationForm.fxml")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.showAndWait();

    }

    public void btnDeleteEmpOnAction(ActionEvent actionEvent) {

    }

    public void tblScheduleOnKeyReleased(KeyEvent keyEvent) {

    }


}
