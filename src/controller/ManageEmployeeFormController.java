package controller;

import TM.AllEmployeeTM;
import bo.BOFactory;
import bo.custom.ManageEmployeeBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.AssistantDriverDTO;
import dto.primary_driverDTO;
import entity.customEntity;
import entity.primary_driver;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.awt.Color.black;

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
    public JFXButton btnCancel;
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
        txtRegisterDate.setText(LocalDate.now().toString());
    }

    private void loadAllEmployee() {
        try {
            ObservableList<AllEmployeeTM> allEmployeeTMS = FXCollections.observableArrayList();
            ArrayList<customEntity> allEmployee = manageEmployeeBO.getAllEmployee();
            int x = 0;
            for (int i = 0; i < allEmployee.size(); i++) {
                x++;
                Button button = new JFXButton("Delete");
                button.setStyle("-fx-border-color: black; -fx-border-insets: 0.5;");
//                button.setPrefHeight(5);
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
        if (txtID.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Employee Role").showAndWait();
        } else {
            switch (cblEmployeeRole.getValue().toString()) {
                case "Cashier":
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateUserForm.fxml"));
                    Parent parent = fxmlLoader.load();
                    CreateUserFormController createUserFormController = fxmlLoader.getController();
                    createUserFormController.setUserID(txtID.getText());
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                    break;
                case "Primary Driver":
                    try {
                        boolean isAdded = manageEmployeeBO.addPrimaryDriver(new primary_driverDTO(
                                txtID.getText(),
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                dtpDOB.getValue().toString(),
                                txtAddress.getText(),
                                txtEmailAddress.getText(),
                                txtRegisterDate.getText(),
                                cblEmployeeRole.getValue().toString()
                        ));
                        if (isAdded) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Primary Driver Added Successfully!").showAndWait();
                            loadAllEmployee();
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Something went Wrong").show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "Assistant Driver":
                    System.out.println("Assistant Driver oubob");
                    try {
                        boolean isAdded = manageEmployeeBO.addAssistantDriver(new AssistantDriverDTO(
                                txtID.getText(),
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                dtpDOB.getValue().toString(),
                                txtAddress.getText(),
                                txtEmailAddress.getText(),
                                txtRegisterDate.getText(),
                                cblEmployeeRole.getValue().toString()
                        ));
                        if (isAdded) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Assistant Driver Added Successfully!").showAndWait();
                            loadAllEmployee();
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Something went Wrong").show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                default:
                    txtID.setText("working");
                    break;
            }
        }
    }

    public void cblEmployeeRoleOnAction(ActionEvent actionEvent) {
        switch (cblEmployeeRole.getValue().toString()) {
            case "Cashier":
                getCashierID();
                break;
            case "Primary Driver":
//                txtID.setText("primary Driver");
                getPrimaryDriverID();
                break;
            case "Assistant Driver":
                getAssistantDriverID();
//                txtID.setText("Assistant Driver");
                break;
            default:
                txtID.setText("working");

        }
    }


    public void btnCancelOnAction(ActionEvent actionEvent) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String search = txtSearch.getText();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cashier where cashier_ID like ? '%' or first_name like ? '%';");
            preparedStatement.setObject(1,search);
            preparedStatement.setObject(2,search);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println(
                        resultSet.getString(1)+
                        resultSet.getString(2)+
                        resultSet.getString(3)+
                        resultSet.getString(4)+
                        resultSet.getString(5)+
                        resultSet.getString(6)+
                        resultSet.getString(7)+
                        resultSet.getString(8)+
                        resultSet.getString(9)+
                        resultSet.getString(10)
                );
            }else{
                System.out.println("fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void txtIDOnAction(ActionEvent actionEvent) {
        txtFirstName.requestFocus();
    }

    public void txtFirstNameOnAction(ActionEvent actionEvent) {
        txtLastName.requestFocus();
    }

    public void txtLastNameOnAction(ActionEvent actionEvent) {
        dtpDOB.requestFocus();
    }

    public void dtpDOB(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddress(ActionEvent actionEvent) {
        txtEmailAddress.requestFocus();
    }

    public void txtEmailAddress(ActionEvent actionEvent) {
        cblEmployeeRole.requestFocus();
    }

    public void getCashierID() {
        try {
            int rowCount = manageEmployeeBO.getCashierRowCount();
            if (rowCount < 9) {
                txtID.setText("E00" + (rowCount + 1));
            } else if (rowCount < 99) {
                txtID.setText("E0" + (rowCount + 1));
            } else {
                txtID.setText("E" + (rowCount + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getPrimaryDriverID() {
        try {
            int rowCount = manageEmployeeBO.getPrimaryDriverRowCount();
            if (rowCount < 9) {
                txtID.setText("P00" + (rowCount + 1));
            } else if (rowCount < 99) {
                txtID.setText("P0" + (rowCount + 1));
            } else {
                txtID.setText("P" + (rowCount + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getAssistantDriverID() {
        try {
            int rowCount = manageEmployeeBO.getAssistantDriverRowCount();
            System.out.println("assistant Driver row count"+rowCount);
            if (rowCount < 9) {
                txtID.setText("A00" + (rowCount + 1));
            } else if (rowCount < 99) {
                txtID.setText("A0" + (rowCount + 1));
            } else {
                txtID.setText("A" + (rowCount + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
