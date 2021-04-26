package controller;

import bo.BOFactory;
import bo.custom.ManageCustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageCustomerFormController implements Initializable {
    public TableView<CustomerDTO> tblCustomer;
    public TableColumn clmID;
    public TableColumn clmFirstName;
    public TableColumn clmLastName;
    public TableColumn clmDateOfBirth;
    public TableColumn clmAddress;
    public TableColumn clmEmailAddress;
    public TableColumn clmDelete;
    public JFXButton btnSearch;
    public JFXTextField txtID;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXDatePicker dtpDOB;
    public JFXTextField txtAddress;
    public JFXTextField txtEmailAddress;
    public JFXButton btnSave;
    public JFXButton btnDeleteCustomer;
    public JFXButton btnCancel;
    public JFXTextField txtCustomerSearch;

    ManageCustomerBO manageCustomerBO = (ManageCustomerBO) BOFactory.getInstance().getBO(BOFactory.BoType.ManageCustomerBOImpl);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmID.setCellValueFactory(new PropertyValueFactory<>("customer_ID"));
        clmFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        clmLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        clmDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmEmailAddress.setCellValueFactory(new PropertyValueFactory<>("email_address"));

        try {
            loadAllCustomer();
            setNewCustomerID();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void loadAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomer = manageCustomerBO.getAllCustomer();
        tblCustomer.setItems(FXCollections.observableArrayList(allCustomer));
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        System.out.println("customer delete button clicked");
        try {
            String id = txtID.getText();
            boolean isCustomerDelete = manageCustomerBO.deleteCustomer(id);
            if (isCustomerDelete) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Customer Delete SuccessFully!");
                cleanAll();
                setNewCustomerID();
                loadAllCustomer();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Something went Wrong!");
                alert.showAndWait();

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void tblCustomerOnMouseReleased(MouseEvent mouseEvent) {
        CustomerDTO selectedItem = tblCustomer.getSelectionModel().getSelectedItem();
        txtID.setText(selectedItem.getCustomer_ID());
        txtFirstName.setText(selectedItem.getFirst_name());
        txtLastName.setText(selectedItem.getLast_name());
        dtpDOB.setValue(LocalDate.parse(selectedItem.getDOB()));
        txtAddress.setText(selectedItem.getAddress());
        txtEmailAddress.setText(selectedItem.getEmail_address());
        btnDeleteCustomer.setDisable(false);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        CustomerDTO customerDTO = new CustomerDTO(
                txtID.getText(),
                txtFirstName.getText(),
                txtLastName.getText(),
                dtpDOB.getValue().toString(),
                txtAddress.getText(),
                txtEmailAddress.getText()
        );
        try {
            boolean isCustomerAdded = manageCustomerBO.addCustomer(customerDTO);
            if (isCustomerAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Customer Saved SuccessFully!");
                Optional<ButtonType> res = alert.showAndWait();
                if (res.isPresent()) {
                    if (res.get().equals(ButtonType.CANCEL)) {
                        System.out.println("schedule added");
                        cleanAll();
                        setNewCustomerID();
                        loadAllCustomer();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Something went Wrong!");
                alert.showAndWait();

            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void cleanAll() {
        txtID.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        dtpDOB.setValue(null);
        txtAddress.setText(null);
        txtEmailAddress.setText(null);
        txtCustomerSearch.setText(null);
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        try {
            cleanAll();
            setNewCustomerID();
            loadAllCustomer();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void txtCustomerSearchOnAction(ActionEvent actionEvent) {

    }

    private void setNewCustomerID() {
        try {
            txtID.setText(manageCustomerBO.getNewCustomerID());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void getDataInRealTime(String description) throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> customerDTOS = manageCustomerBO.CustomerSearch(txtCustomerSearch.getText());
        tblCustomer.setItems(FXCollections.observableArrayList(customerDTOS));
    }

    public void txtCustomerSearchOnKeyRelesed(KeyEvent keyEvent) {
        try {
            getDataInRealTime(txtCustomerSearch.getText());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
