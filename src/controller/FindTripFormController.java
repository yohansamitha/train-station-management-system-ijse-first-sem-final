package controller;

import animatefx.animation.FadeIn;
import bo.BOFactory;
import bo.custom.FindTripBO;
import com.jfoenix.controls.*;
import dto.*;
import entity.customEntity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class FindTripFormController implements Initializable {
    public JFXDatePicker dtpTripDate;
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
    public TableView<customEntity> tblSchedule;
    public TableView<StationDTO> tblStation;
    public TableView<TicketPriceDTO> tblTicketPrice;
    public JFXComboBox<String> cmbCustomerSearch;
    public JFXComboBox<String> cblRouteFilter;
    public JFXTextField txtStationSearch;
    public JFXTextField txtStationTableSearch;
    public JFXButton btnPlaceBooking;
    public JFXButton btnCancel;
    public JFXTextField txtTotal;
    public JFXRadioButton rdbCard;
    public JFXRadioButton rdbCash;
    public JFXButton btnSearchCustomer;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXButton btnScheduleSearch;
    public Label lblFindTrip;
    public JFXButton btnTotal;
    FindTripBO findTripBO = (FindTripBO) BOFactory.getInstance().getBO(BOFactory.BoType.FindTripBOImpl);
    ArrayList<String> allStationNames = new ArrayList<>();
    private String scheduleID;
    private String cashier_ID;
    private String ticket_price_ID;
    private int st_class_seat_price1;
    private int st_class_seat_price2;
    private int st_class_seat_price3;

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
        loadAllCustomer();
        loadAllStations();
//        loadSpiners();
        stateChanged();
    }

    private void loadSpiners(String schedule_id, String engine_number) throws SQLException, ClassNotFoundException {
        int[] remainingSeatCount = findTripBO.getRemainingSeatCount(schedule_id,engine_number);
        int spn1MaxValue = remainingSeatCount[0];
        int spn2MaxValue = remainingSeatCount[1];
        int spn3MaxValue = remainingSeatCount[2];
        spn1Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, spn1MaxValue, 0, 1));
        txt1ClassSeatCount.setText(String.valueOf(remainingSeatCount[0]));
        spn2Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, spn2MaxValue, 0, 1));
        txt2ClassSeatCount.setText(String.valueOf(remainingSeatCount[1]));
        spn3Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, spn3MaxValue, 0, 1));
        txt3ClassSeatCount.setText(String.valueOf(remainingSeatCount[2]));

    }

    public void stateChanged() {
        spn1Class.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("working");

        });
    }

    private void loadAllStations() {
        try {
            ArrayList<StationDTO> allStation = findTripBO.getAllStation();
            tblStation.setItems(FXCollections.observableArrayList(allStation));
            for (StationDTO stationDTO : allStation) {
                allStationNames.add(stationDTO.getRoute_ID() + " " + stationDTO.getStation_name());
            }
            TextFields.bindAutoCompletion(txtStationSearch, allStationNames);
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void loadAllCustomer() {
        try {
            ArrayList<String> allCustomerID = findTripBO.getAllCustomerName();
            cmbCustomerSearch.setItems(FXCollections.observableArrayList(allCustomerID));
            TextFields.bindAutoCompletion(cmbCustomerSearch.getEditor(), allCustomerID);
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public void cmbCustomerSearchOnAction(ActionEvent actionEvent) {
        btnSearchCustomer.setDisable(false);
    }

    public void cblRouteFilterOnAction(ActionEvent actionEvent) {
    }


    public void btnPlaceBookingOnAction(ActionEvent actionEvent) {
        try {
            getTotal();
            System.out.println(spn1Class.getValue() + " spinner value 1");
            String paymentMethod = "Cash";
            System.out.println("place booking on start");
            System.out.println(scheduleID + " schedule id");
            String[] customerID = cmbCustomerSearch.getValue().split("\\s+");
            System.out.println(customerID[0] + " customer id");
            System.out.println(ticket_price_ID + " ticket Price id");
            System.out.println(cashier_ID + " cashier id from find trip \n");
            System.out.println(spn2Class.getValue() + " spinner value 2");
            System.out.println(spn3Class.getValue() + " spinner value 3 \n");
            if (rdbCash.isSelected()) {
                paymentMethod = "Cash";
                System.out.println("cash selected");
            } else if (rdbCard.isSelected()) {
                paymentMethod = "Card";
                System.out.println("card selected");
            }
            System.out.println(txtTotal.getText());
            ArrayList<BookingDetailsDTO> bookingDetailsDTOS = new ArrayList<>();
            bookingDetailsDTOS.add(new BookingDetailsDTO("CLS001", spn1Class.getValue(), st_class_seat_price1));
            bookingDetailsDTOS.add(new BookingDetailsDTO("CLS002", spn2Class.getValue(), st_class_seat_price2));
            bookingDetailsDTOS.add(new BookingDetailsDTO("CLS003", spn3Class.getValue(), st_class_seat_price3));
            BookingDTO bookingDTO = new BookingDTO(scheduleID, customerID[0], ticket_price_ID, cashier_ID, bookingDetailsDTOS, Double.parseDouble(txtTotal.getText()), paymentMethod);
            boolean bookingAdded = findTripBO.createBooking(bookingDTO);
            System.out.println(bookingAdded + " booking added Successfully");

            if (bookingAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Booking Placed SuccessFully!");
                Optional<ButtonType> res = alert.showAndWait();
                if (res.isPresent()) {
                    if (res.get().equals(ButtonType.OK)) {
                        cleanAll();

                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }

    private void cleanAll() {
        cmbCustomerSearch.setValue("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        dtpTripDate.setValue(LocalDate.now());
        txtStationSearch.setText("");
        txtStationTableSearch.setText("");
        tblSchedule.setItems(FXCollections.observableArrayList());
        tblTicketPrice.setItems(FXCollections.observableArrayList());
        lblFindTrip.requestFocus();
        txtTotal.setText("");
        txt1ClassSeatCount.setText(null);
        txt2ClassSeatCount.setText(null);
        txt3ClassSeatCount.setText(null);
        spn1Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0));
        spn1Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0, 0));
        spn2Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0));
        spn2Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0, 0));
        spn3Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0));
        spn3Class.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0, 0, 0));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        cleanAll();
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


    public void btnSearchCustomerOnAction(ActionEvent actionEvent) {
        if (cmbCustomerSearch.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please insert or select customer!");
            alert.showAndWait();
        } else {
            try {
                String value = cmbCustomerSearch.getValue() + "";
                System.out.println(value);
                String[] a = value.split("\\s+");
                System.out.println(a[0] + " splited");
                CustomerDTO customerDTO = findTripBO.getCustomerDetails(a[0]);
                txtCustomerName.setText(customerDTO.getFirst_name());
                txtCustomerAddress.setText(customerDTO.getAddress());
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong Customer Details!");
                alert.showAndWait();
            } catch (SQLException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void txtStationSearch(ActionEvent actionEvent) {
        System.out.println("txtStationSearch On Action");
        scheduleSearch();
    }

    public void btnSearchScheduleOnAction(ActionEvent actionEvent) {
        scheduleSearch();
//        getTicketPrice();
    }

    private void getTicketPrice() {
        try {
            String station = txtStationSearch.getText();
            String[] routeID = station.split("\\s+");
            System.out.println(routeID[0] + " getTickPrice " + routeID[1]);
            TicketPriceDTO ticketPrice = findTripBO.getTicketPrice(routeID[0], routeID[1]);
            ticket_price_ID = ticketPrice.getTicket_price_ID();
            st_class_seat_price1 = ticketPrice.getSt_class_seat_price1();
            st_class_seat_price2 = ticketPrice.getSt_class_seat_price2();
            st_class_seat_price3 = ticketPrice.getSt_class_seat_price3();
            tblTicketPrice.setItems(FXCollections.observableArrayList(ticketPrice));
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void scheduleSearch() {
        if (txtStationSearch.getText().isEmpty() | dtpTripDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill date and station!");
            alert.showAndWait();
        } else {
            try {
                String date = String.valueOf(dtpTripDate.getValue());
                String station = txtStationSearch.getText();
                String[] routeID = station.split("\\s+");
                ArrayList<customEntity> schedule = findTripBO.findSchedule(date, routeID[0]);
                tblSchedule.setItems(FXCollections.observableArrayList(schedule));
                System.out.println(schedule.toString());

            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Please Check Your Entered Details!");
                alert.showAndWait();
            } catch (SQLException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void tblScheduleOnMouseReleased(MouseEvent mouseEvent) {
        try {
            customEntity selectedItem = tblSchedule.getSelectionModel().getSelectedItem();
//        loading schedule od to class field
            scheduleID = selectedItem.getSchedule_ID();
            System.out.println(selectedItem + "schedule table mouse release on Action");
            String stationAndRouteID = txtStationSearch.getText();
            String[] routeID = stationAndRouteID.split("\\s+");
            getTicketPrice();
            loadSpiners(selectedItem.getSchedule_ID(),selectedItem.getEngine_number());
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }

    public void setCashierID(String cashier_id) {
        this.cashier_ID = cashier_id;
    }

    public void btnTotalOnAction(ActionEvent actionEvent) {
        getTotal();
    }

    private void getTotal() {
        int total = 0;
        if (!spn1Class.getValue().equals(0)) {
            System.out.println("spn 1 total");
            total += st_class_seat_price1 * spn1Class.getValue();
        }
        if (!spn2Class.getValue().equals(0)) {
            System.out.println("spn 2 total");
            total += st_class_seat_price2 * spn2Class.getValue();
        }
        if (!spn3Class.getValue().equals(0)) {
            System.out.println("spn 3 total");
            total += st_class_seat_price3 * spn3Class.getValue();
        }
        txtTotal.setText(String.valueOf(total));
    }
}
