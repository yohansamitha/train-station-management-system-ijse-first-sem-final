package controller;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FindTripFormController implements Initializable {
    public JFXDatePicker DtpTrip;
    public JFXButton btnNewCustomer;
    public TableColumn clmScheduleID;
    public TableColumn clmEngineNumber;
    public TableColumn clmEngineName;
    public TableColumn clmPrimaryDriver;
    public TableColumn clmAssistantDriver;
    public TableColumn clmRouteID;
    public TableColumn clmDate;
    public TableColumn clmTime;
    public TableColumn clmStationID;
    public TableColumn clmRouteId;
    public TableColumn clmStationName;
    public TableColumn clmDistance;
    public TableColumn clmDuration;
    public TableColumn clmRouteid;
    public TableColumn clmStaID;
    public TableColumn clm1rdClass;
    public TableColumn clm2rdClass;
    public TableColumn clm3rdClass;
    public Spinner<Integer> spn1Class;
    public Spinner<Integer> spn2Class;
    public Spinner<Integer> spn3Class;
    public JFXTextField txt1ClassSeatCount;
    public JFXTextField txt2ClassSeatCount;
    public JFXTextField txt3ClassSeatCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

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
