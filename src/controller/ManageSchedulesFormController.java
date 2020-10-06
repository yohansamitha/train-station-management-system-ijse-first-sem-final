package controller;

import bo.BOFactory;
import bo.custom.ManageScheduleBO;
import com.jfoenix.controls.*;
import dto.ScheduleDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageSchedulesFormController implements Initializable {
    public JFXDatePicker dtpSelectDate;
    public JFXTimePicker tpSelectDepTime;
    public TableView tblSchedule;
    public TableColumn clmScheduleID;
    public TableColumn clmEngineNumber;
    public TableColumn clmEngineName;
    public TableColumn clmPrimaryDriver;
    public TableColumn clmAssistantDriver;
    public TableColumn clmRouteID;
    public TableColumn clmDate;
    public TableColumn clmTime;
    public JFXComboBox<String> cblSelectEngineNumber;
    public JFXComboBox<String> cblSelectPrimaryDriver;
    public JFXComboBox<String> cblAssistantDriver;
    public JFXComboBox<String> cblSelectRoute;
    public JFXComboBox<String> cblFilterMood;
    public JFXTextField txtScheduleSearch;
    public JFXTextField txtScheduleID;
    public JFXButton btnSearchOnAction;
    public JFXButton btnSave;
    ManageScheduleBO manageScheduleBO = (ManageScheduleBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageScheduleBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            LoadEngineNumber();
            loadPrimaryDriver();
            loadAssistantDriver();
            loadRoute();
            getNewScheduleID();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void getNewScheduleID() throws SQLException, ClassNotFoundException {
        int scheduleRowCount = manageScheduleBO.getScheduleRowCount();
        if (scheduleRowCount < 9) {
            txtScheduleID.setText("S00" + (scheduleRowCount + 1));
        } else if (scheduleRowCount < 99) {
            txtScheduleID.setText("S0" + (scheduleRowCount + 1));
        } else {
            txtScheduleID.setText("S" + (scheduleRowCount + 1));
        }
    }

    private void LoadEngineNumber() throws SQLException, ClassNotFoundException {
        ArrayList<String> allEngineNumbers = manageScheduleBO.getAllEngineNumbers();
        cblSelectEngineNumber.setItems(FXCollections.observableArrayList(allEngineNumbers));
    }

    private void loadPrimaryDriver() throws SQLException, ClassNotFoundException {
        ArrayList<String> allPrimaryDrivers = manageScheduleBO.getAllPrimaryDrivers();
        cblSelectPrimaryDriver.setItems(FXCollections.observableArrayList(allPrimaryDrivers));
    }

    private void loadAssistantDriver() throws SQLException, ClassNotFoundException {
        ArrayList<String> allAssistantDrivers = manageScheduleBO.getAllAssistantDrivers();
        cblAssistantDriver.setItems(FXCollections.observableArrayList(allAssistantDrivers));
    }

    private void loadRoute() throws SQLException, ClassNotFoundException {
        ArrayList<String> allRoute = manageScheduleBO.getAllRoute();
        cblSelectRoute.setItems(FXCollections.observableArrayList(allRoute));;
    }


    public void btnSaveSchedule(ActionEvent actionEvent) {
        System.out.println(dtpSelectDate.getValue());
        System.out.println(tpSelectDepTime.getValue());

        try {
            boolean isScheduleAdded = manageScheduleBO.createSchedule(new ScheduleDTO(
                    txtScheduleID.getText(),
                    cblSelectEngineNumber.getValue(),
                    cblSelectPrimaryDriver.getValue(),
                    cblAssistantDriver.getValue(),
                    cblSelectRoute.getValue(),
                    dtpSelectDate.getValue().toString(),
                    tpSelectDepTime.getValue().toString()
            ));
            if (isScheduleAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Schedule Placed SuccessFully!");
                Optional<ButtonType> res = alert.showAndWait();
                if (res.isPresent()) {
                    if (res.get().equals(ButtonType.CANCEL)) {
                        System.out.println("schedule added");
                        cleanAll();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Something Went Wrong!");
                alert.showAndWait();
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }

    private void cleanAll() {

    }

    public void tblScheduleOMouseReleased(MouseEvent mouseEvent) {

    }

    public void btnDeleteScheduleOnAction(ActionEvent actionEvent) {

    }
}
