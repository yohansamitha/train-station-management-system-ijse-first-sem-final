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
import dto.cashierDTO;
import dto.primary_driverDTO;
import entity.customEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
    public JFXButton btnCancel;
    public Label lblHint;
    public JFXButton btnDeleteEmp;
    ManageEmployeeBO manageEmployeeBO = (ManageEmployeeBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageEmployeeBOImpl);
    private boolean cashierUser;

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
        loadAllEmployee();
        txtRegisterDate.setText(LocalDate.now().toString());
    }

    private void loadAllEmployee() {
        try {
            ObservableList<AllEmployeeTM> allEmployeeTMS = FXCollections.observableArrayList();
            ArrayList<customEntity> allEmployee = manageEmployeeBO.getAllEmployee();
            tblEmployee.setItems(FXCollections.observableArrayList(allEmployee));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
//        save function
        if (btnSave.getText().equalsIgnoreCase("save")) {
            if (txtID.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please Select Employee Role").showAndWait();
            } else {
                switch (cblEmployeeRole.getValue().toString()) {
                    case "Cashier":
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateUserForm.fxml"));
                        Parent parent = fxmlLoader.load();
                        CreateUserFormController createUserFormController = fxmlLoader.getController();
                        createUserFormController.setCashierDetails(new cashierDTO(
                                txtID.getText(),
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                dtpDOB.getValue(),
                                txtAddress.getText(),
                                txtEmailAddress.getText(),
                                txtRegisterDate.getText(),
                                cblEmployeeRole.getValue().toString())
                        );
                        Stage stage = new Stage();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                        System.out.println("1");
                        loadAllEmployee();
//                        boolean isCashierAdded = cashierAdd(false);
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
                }
            }
        } else {
//            update Function
            if (txtID.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please Select Employee Role").showAndWait();
            } else {
                switch (cblEmployeeRole.getValue().toString()) {
                    case "Cashier":
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CreateUserForm.fxml"));
                        Parent parent = fxmlLoader.load();
                        CreateUserFormController createUserFormController = fxmlLoader.getController();
                        createUserFormController.setCashierDetails(new cashierDTO(
                                txtID.getText(),
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                dtpDOB.getValue(),
                                txtAddress.getText(),
                                txtEmailAddress.getText(),
                                txtRegisterDate.getText(),
                                cblEmployeeRole.getValue().toString()));
                        Stage stage = new Stage();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                        break;
                    case "Primary Driver":
                        try {
                            boolean isUpdate = manageEmployeeBO.updatePrimaryDriver(new primary_driverDTO(
                                    txtID.getText(),
                                    txtFirstName.getText(),
                                    txtLastName.getText(),
                                    dtpDOB.getValue().toString(),
                                    txtAddress.getText(),
                                    txtEmailAddress.getText(),
                                    txtRegisterDate.getText(),
                                    cblEmployeeRole.getValue().toString()
                            ));
                            if (isUpdate) {
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
                            boolean isUpdated = manageEmployeeBO.updateAssistantDriver(new AssistantDriverDTO(
                                    txtID.getText(),
                                    txtFirstName.getText(),
                                    txtLastName.getText(),
                                    dtpDOB.getValue().toString(),
                                    txtAddress.getText(),
                                    txtEmailAddress.getText(),
                                    txtRegisterDate.getText(),
                                    cblEmployeeRole.getValue().toString()
                            ));
                            if (isUpdated) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Assistant Driver Added Successfully!").showAndWait();
                                loadAllEmployee();
                            } else {
                                new Alert(Alert.AlertType.ERROR, "Something went Wrong").show();
                            }
                        } catch (SQLException | ClassNotFoundException throwables) {
                            throwables.printStackTrace();
                        }
                        break;
                }
            }
        }
    }

    public void cblEmployeeRoleOnAction(ActionEvent actionEvent) {
        try {
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
            }
        } catch (NullPointerException ex) {
            System.out.println("null");
        }
    }


    public void btnCancelOnAction(ActionEvent actionEvent) {
        txtID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtEmailAddress.setText("");
        txtRegisterDate.setText("");
//        cblEmployeeRole.getItems().get(0);
//        cblEmployeeRole.getSelectionModel().clearSelection();
        cblEmployeeRole.setValue(null);
        dtpDOB.setValue(null);
//        dtpDOB.setValue(LocalDate.parse(""));
        btnSave.setText("Save");
        lblHint.requestFocus();
    }

    public LocalDate NOW_LOCAL_DATE() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void getAssistantDriverID() {
        try {
            int rowCount = manageEmployeeBO.getAssistantDriverRowCount();
            System.out.println("assistant Driver row count" + rowCount);
            if (rowCount < 9) {
                txtID.setText("A00" + (rowCount + 1));
            } else if (rowCount < 99) {
                txtID.setText("A0" + (rowCount + 1));
            } else {
                txtID.setText("A" + (rowCount + 1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchOnKeyReleased(KeyEvent keyEvent) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String search = txtSearch.getText();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cashier where cashier_ID like ? '%' or first_name like ? '%';");
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "select cashier_ID,first_name,last_name,DOB,address,email_address,reg_date,position from cashier where cashier_ID like ? '%' or first_name like ? '%' union " +
//                            "select primary_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from primary_driver where primary_driver_ID like ? '%' or first_name like ? '%'; union " +
//                            "select assistant_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from assistant_driver where assistant_driver_ID like ? '%' or first_name like ? '%';"
//            );
            preparedStatement.setObject(1, search);
            preparedStatement.setObject(2, search);
//            preparedStatement.setObject(3, search);
//            preparedStatement.setObject(4, search);
//            preparedStatement.setObject(5, search);
//            preparedStatement.setObject(6, search);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<customEntity> searchResult = new ArrayList<>();
            while (resultSet.next()) {
                customEntity customEntity = new customEntity(
                        resultSet.getString(1),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getDate(8),
                        resultSet.getString(9)
                );
                searchResult.add(customEntity);
                System.out.println(
                        resultSet.getString(1) + " " +
                                resultSet.getString(3) + " " +
                                resultSet.getString(4) + " " +
                                resultSet.getString(5) + " " +
                                resultSet.getString(6) + " " +
                                resultSet.getString(7) + " " +
                                resultSet.getString(8) + " " +
                                resultSet.getString(9)
                );
                tblEmployee.setItems(FXCollections.observableArrayList(searchResult));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void tblEmployeeSelection(MouseEvent mouseEvent) {
        customEntity s = (customEntity) tblEmployee.getSelectionModel().getSelectedItem();
        System.out.println(s.toString());
        txtID.setText(s.getID());
        txtFirstName.setText(s.getFirst_name());
        txtLastName.setText(s.getLast_name());
        txtAddress.setText(s.getAddress());
        txtEmailAddress.setText(s.getEmail_address());
        txtRegisterDate.setText(String.valueOf(s.getReg_date()));
        dtpDOB.setValue(LocalDate.parse(s.getDOB()));
        cblEmployeeRole.setValue(s.getPosition());
        lblHint.requestFocus();
        btnSave.setText("Update");
    }

    public void btnDeleteEmpOnAction(ActionEvent actionEvent) {

    }
}
