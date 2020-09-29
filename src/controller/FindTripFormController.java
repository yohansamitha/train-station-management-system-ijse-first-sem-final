package controller;

import animatefx.animation.FadeIn;
import bo.BOFactory;
import bo.custom.FindTripBO;
import com.jfoenix.controls.*;
import dto.StationDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public JFXTextField txt1ClassSeatCount;
    public JFXTextField txt2ClassSeatCount;
    public JFXTextField txt3ClassSeatCount;
    public Spinner<Integer> spn1Class;
    public Spinner<Integer> spn2Class;
    public Spinner<Integer> spn3Class;
    public TableView tblSchedule;
    public TableView<StationDTO> tblStation;
    public TableView tblTicketPrice;
    public JFXComboBox<String> txtCustomerSearch;
    public JFXComboBox<String> cblRouteFilter;
    public JFXTextField txtStationSearch;
    public JFXTextField txtStationTableSearch;
    public JFXButton btnPlaceBooking;
    public JFXButton btnCancel;
    public JFXTextField txtTotal;
    public JFXRadioButton rdbCard;
    public JFXRadioButton rdbCash;
    FindTripBO findTripBO = (FindTripBO) BOFactory.getInstance().getBO(BOFactory.BoType.FindTripBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmScheduleID.setCellValueFactory(new PropertyValueFactory<>("schedule_ID"));
        clmEngineNumber.setCellValueFactory(new PropertyValueFactory<>("engine_number"));
        clmEngineName.setCellValueFactory(new PropertyValueFactory<>("engine_name"));
        clmPrimaryDriver.setCellValueFactory(new PropertyValueFactory<>("primary_driver_ID"));
        clmAssistantDriver.setCellValueFactory(new PropertyValueFactory<>("assistant_driver_ID"));
        clmRouteID.setCellValueFactory(new PropertyValueFactory<>("route_ID"));
        clmDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        clmTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        clmStationID.setCellValueFactory(new PropertyValueFactory<>("station_ID"));
        clmRouteId.setCellValueFactory(new PropertyValueFactory<>("route_ID"));
        clmStationName.setCellValueFactory(new PropertyValueFactory<>("station_name"));
        clmDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        clmDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        clmRouteid.setCellValueFactory(new PropertyValueFactory<>("ticket_price_ID"));
        clmStaID.setCellValueFactory(new PropertyValueFactory<>("station_ID"));
        clm1rdClass.setCellValueFactory(new PropertyValueFactory<>("st_class_seat_price1"));
        clm2rdClass.setCellValueFactory(new PropertyValueFactory<>("st_class_seat_price2"));
        clm3rdClass.setCellValueFactory(new PropertyValueFactory<>("st_class_seat_price3"));
        spn1Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        loadAllCustomer();
        loadAllStations();
    }

    private void loadAllStations() {
        try {
            ArrayList<StationDTO> allStation = findTripBO.getAllStation();
            tblStation.setItems(FXCollections.observableArrayList(allStation));
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void loadAllCustomer() {
        try {
            ArrayList<String> allCustomerID = findTripBO.getAllCustomerName();
            txtCustomerSearch.setItems(FXCollections.observableArrayList(allCustomerID));
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void txtCustomerSearchOnAction(ActionEvent actionEvent) {
    }

    public void cblRouteFilterOnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceBookingOnAction(ActionEvent actionEvent) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("../view/AddCustomerForm.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.showAndWait();
            new FadeIn(parent).play();
            loadAllCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rdbCardOnAction(ActionEvent actionEvent) {
        rdbCash.setSelected(false);
    }

    public void rdbCashOnAction(ActionEvent actionEvent) {
        rdbCard.setSelected(false);
    }
}
