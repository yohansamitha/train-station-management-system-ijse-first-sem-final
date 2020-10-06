package controller;

import bo.BOFactory;
import bo.custom.TrainScheduleBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import entity.customEntity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TrainScheduleFormController implements Initializable {
    public TableView<customEntity> tblSchedule;
    public TableColumn clmScheduleID;
    public TableColumn clmEngineNumber;
    public TableColumn clmEngineName;
    public TableColumn clmPrimaryDriver;
    public TableColumn clmAssistantDriver;
    public TableColumn clmRouteID;
    public TableColumn clmDate;
    public TableColumn clmTime;
    public JFXTextField txtScheduleSearch;
    public JFXButton btnSchedule;

    TrainScheduleBO trainScheduleBO = (TrainScheduleBO) BOFactory.getInstance().getBO(BOFactory.BoType.TrainScheduleBOImpl);

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
        scheduleSearch(txtScheduleSearch.getText());
    }

    public void txtScheduleSearchOnKeyRelease(KeyEvent keyEvent) {
        scheduleSearch(txtScheduleSearch.getText());
    }

    public void btnScheduleOnAction(ActionEvent actionEvent) {
        scheduleSearch(txtScheduleSearch.getText());
    }

    private void scheduleSearch(String value) {
        try {
            ArrayList<customEntity> allSchedule = trainScheduleBO.getAllSchedule(value);
            tblSchedule.setItems(FXCollections.observableArrayList(allSchedule));
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }


}
