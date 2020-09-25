package controller;

import TM.AllEmployeeTM;
import bo.BOFactory;
import bo.custom.ManageEmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entity.customEntity;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageEmployeeFormController implements Initializable {
    public JFXButton btnSave;
    public TableColumn clmID;
    public TableColumn clmFirstName;
    public TableColumn clmLastName;
    public TableColumn clmDateOfBirth;
    public TableColumn clmAddress;
    public TableColumn clmEmailAddress;
    public TableColumn clmRegisterDate;
    public TableColumn clmPosition;
    public TableColumn clmDelete;
    public TableView tblEmployee;
    public JFXTextField txtSearch;
    public JFXButton btnSearch;
    public JFXTextField txtID;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXDatePicker dtpDOB;
    public JFXTextField txtAddress;
    public JFXTextField txtEmailAddress;
    public JFXTextField txtRegisterDate;
    public JFXComboBox cblEmployeeRole;
    ManageEmployeeBO manageEmployeeBO = (ManageEmployeeBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageEmployeeBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        clmFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clmLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        clmDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmEmailAddress.setCellValueFactory(new PropertyValueFactory<>("email_address"));
        clmRegisterDate.setCellValueFactory(new PropertyValueFactory<>("reg_date"));
        clmPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        clmDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        loadAllEmployee();
    }

    private void loadAllEmployee() {
        try {
            ObservableList<AllEmployeeTM> allEmployeeTMS = FXCollections.observableArrayList();
            ArrayList<customEntity> allEmployee = manageEmployeeBO.getAllEmployee();
            int x = 0;
            for (int i = 0; i < allEmployee.size(); i++) {
                x++;
                Button button = new JFXButton("Delete");
                button.setId(String.valueOf(i));
                System.out.println(allEmployee.get(i).toString());
                allEmployeeTMS.add(new AllEmployeeTM(
                        allEmployee.get(i).getID(),
                        allEmployee.get(i).getFirst_name(),
                        allEmployee.get(i).getLast_name(),
                        allEmployee.get(i).getDOB(),
                        allEmployee.get(i).getAddress(),
                        allEmployee.get(i).getEmail_address(),
                        allEmployee.get(i).getReg_date(),
                        allEmployee.get(i).getPosition(),
                        button
                ));
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("button id");
                    }
                });
                System.out.println(x);
            }
            tblEmployee.setItems(allEmployeeTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        if ("Cashier".equals(cblEmployeeRole.getValue().toString())) {
//            txtID.setText("cashier");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateUserForm.fxml"));
            Parent parent = fxmlLoader.load();
            CreateUserFormController createUserFormController = fxmlLoader.<CreateUserFormController>getController();
            createUserFormController.setUserID(txtID.getText());
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            txtID.setText("working");
        }
    }

    public void cblEmployeeRoleOnAction(ActionEvent actionEvent) {
        switch (cblEmployeeRole.getValue().toString()) {
            case "Cashier":
                txtID.setText("cashier");
                break;
            case "Primary Driver":
                txtID.setText("primary Driver");
                break;
            case "Assistant Driver":
                txtID.setText("Assistant Driver");
                break;
            default:
                txtID.setText("working");

        }
    }
}
