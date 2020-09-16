package controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;

public class ManageSchedulesFormController {
    public JFXDatePicker cblSelectDate;
    public JFXTimePicker cblSelectDepTime;

    public void btnTesting(ActionEvent actionEvent) {
        System.out.println(cblSelectDate.getValue());
        System.out.println(cblSelectDepTime.getValue());
    }
}
