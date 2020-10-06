package controller;

import bo.BOFactory;
import bo.custom.TrainDetailBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.SuperDAO;
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

public class TrainDetailsFormController implements Initializable {
    public JFXTextField txtSearch;
    public TableColumn lblEngineNumber;
    public TableColumn lblTrainName;
    public TableColumn lblEngineType;
    public TableColumn lblFuelCapacity;
    public TableColumn lblStationID;
    public TableColumn lbl1stClassSeatCount;
    public TableColumn lbl2stClassSeatCount;
    public TableColumn lbl3stClassSeatCount;
    public TableView<customEntity> tblTrainDetails;
    public JFXButton btnSearch;
    TrainDetailBO trainDetailBO = (TrainDetailBO) BOFactory.getInstance().getBO(BOFactory.BoType.TrainDetailBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblEngineNumber.setCellValueFactory(new PropertyValueFactory<>("engine_number"));
        lblTrainName.setCellValueFactory(new PropertyValueFactory<>("train_name"));
        lblEngineType.setCellValueFactory(new PropertyValueFactory<>("engine_type"));
        lblFuelCapacity.setCellValueFactory(new PropertyValueFactory<>("fuel_capacity"));
        lblStationID.setCellValueFactory(new PropertyValueFactory<>("station_ID"));
        lbl1stClassSeatCount.setCellValueFactory(new PropertyValueFactory<>("clas_seat_count1"));
        lbl2stClassSeatCount.setCellValueFactory(new PropertyValueFactory<>("clas_seat_count2"));
        lbl3stClassSeatCount.setCellValueFactory(new PropertyValueFactory<>("clas_seat_count3"));
        trainSearch(txtSearch.getText());

    }

    public void txtSearchOnKeyRelease(KeyEvent keyEvent) {
        trainSearch(txtSearch.getText());
    }

    private void trainSearch(String value) {
        try {
            ArrayList<customEntity> allTrain = trainDetailBO.getAllTrain(value);
            tblTrainDetails.setItems(FXCollections.observableArrayList(allTrain));
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        trainSearch(txtSearch.getText());
    }
}
