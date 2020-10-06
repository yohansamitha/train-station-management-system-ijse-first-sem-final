package controller;

import animatefx.animation.FadeOut;
import bo.BOFactory;
import bo.custom.ManageTrainBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.TrainDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageTrainFormController implements Initializable {
    public JFXButton btnSave;
    public JFXTextField txtEngineNumber;
    public JFXComboBox<String> cmbEngineType;
    public JFXComboBox<String> cmbStationID;
    public JFXTextField txtFuelCapacity;
    public JFXButton btnDeleteEmp;
    public TableColumn colEngineNumber;
    public TableColumn colEngineName;
    public TableColumn colEngineType;
    public TableColumn colFuelCapacity;
    public TableColumn colStationID;
    public TableView<TrainDTO> tblTrain;
    public JFXTextField txtEngineName;
    ManageTrainBO manageTrainBO = (ManageTrainBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageTrainBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEngineNumber.setCellValueFactory(new PropertyValueFactory<>("engine_number"));
        colEngineName.setCellValueFactory(new PropertyValueFactory<>("train_name"));
        colEngineType.setCellValueFactory(new PropertyValueFactory<>("engine_type"));
        colFuelCapacity.setCellValueFactory(new PropertyValueFactory<>("fuel_capacity"));
        colStationID.setCellValueFactory(new PropertyValueFactory<>("station_ID"));
        loadAllTrains();
        loadAllStation();
        loadNewTrainID();
    }

    private void loadNewTrainID() {
        try {
            int trainRowCount = manageTrainBO.getTrainRowCount();
            if (trainRowCount < 9) {
                txtEngineNumber.setText("Eng00" + (trainRowCount + 1));
            } else if (trainRowCount < 99) {
                txtEngineNumber.setText("Eng0" + (trainRowCount + 1));
            } else {
                txtEngineNumber.setText("Eng" + (trainRowCount + 1));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void loadAllStation() {
        try {
            ArrayList<String> allStationID = manageTrainBO.getAllStationID();
            cmbStationID.setItems(FXCollections.observableArrayList(allStationID));
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void loadAllTrains() {
        try {
            ArrayList<TrainDTO> allTrain = manageTrainBO.getAllTrain();
            tblTrain.setItems(FXCollections.observableArrayList(allTrain));
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void btnDeleteEmpOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        try {
            boolean b = manageTrainBO.addTrain(new TrainDTO(txtEngineNumber.getText(), txtEngineName.getText(), cmbEngineType.getValue(), Integer.parseInt(txtFuelCapacity.getText()), cmbStationID.getValue()));
            if (b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Train Saved SuccessFully!");
                Optional<ButtonType> res = alert.showAndWait();
                if (res.isPresent()) {
                    if (res.get().equals(ButtonType.OK)) {
                        clean();

                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void clean() {
        txtEngineNumber.setText(null);
        txtEngineName.  setText(null);
        txtFuelCapacity.setText(null);
        cmbEngineType.  setValue(null);
        cmbStationID.   setValue(null);
        loadAllTrains();
        loadNewTrainID();
    }

    public void tblTrainOnKeyReleased(MouseEvent keyEvent) {
        TrainDTO selectedItem = tblTrain.getSelectionModel().getSelectedItem();
        txtEngineNumber.setText(selectedItem.getEngine_number());
        txtEngineName.setText(selectedItem.getTrain_name());
        txtFuelCapacity.setText(String.valueOf(selectedItem.getFuel_capacity()));
        System.out.println(selectedItem.getEngine_type()+" engine type");
//        cmbEngineType.setValue(selectedItem.getEngine_type());
        cmbEngineType.setValue("asdd");
        cmbStationID.setValue(selectedItem.getStation_ID());
    }

}
