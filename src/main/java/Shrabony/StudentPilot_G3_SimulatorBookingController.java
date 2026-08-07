package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentPilot_G3_SimulatorBookingController {

    @FXML
    private DatePicker sessionDateDatePicker;

    @FXML
    private ComboBox<String> timeSlotCombobox;

    @FXML
    public void initialize() {

        timeSlotCombobox.getItems().addAll(
                "09:00 AM - 10:00 AM",
                "11:00 AM - 12:00 PM",
                "02:00 PM - 03:00 PM",
                "04:00 PM - 05:00 PM"
        );

        if (BinaryFileUtil.readObjects("data/simulatorTrainings.bin").isEmpty()) {

            BinaryFileUtil.appendObject(
                    "data/simulatorTrainings.bin",
                    new SimulatorTraining("09:00 AM - 10:00 AM"));

            BinaryFileUtil.appendObject(
                    "data/simulatorTrainings.bin",
                    new SimulatorTraining("11:00 AM - 12:00 PM"));

            BinaryFileUtil.appendObject(
                    "data/simulatorTrainings.bin",
                    new SimulatorTraining("02:00 PM - 03:00 PM"));

            BinaryFileUtil.appendObject(
                    "data/simulatorTrainings.bin",
                    new SimulatorTraining("04:00 PM - 05:00 PM"));
        }
    }

    @FXML
    public void bookSessionbutton(ActionEvent actionEvent) {

        LocalDate sessionDate = sessionDateDatePicker.getValue();
        String timeSlot = timeSlotCombobox.getValue();

        if (sessionDate == null || timeSlot == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a session date and time slot.");
            alert.showAndWait();
            return;
        }

        ArrayList<BookedSimulatorTraining> bookings =
                BinaryFileUtil.readObjects("data/bookedSimulatorTrainings.bin");

        for (BookedSimulatorTraining booking : bookings) {

            if (booking.getSessionDate().equals(sessionDate.toString())
                    && booking.getTimeSlot().equals(timeSlot)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Selected time slot is already booked.");
                alert.showAndWait();
                return;
            }
        }

        BookedSimulatorTraining bookedTraining =
                new BookedSimulatorTraining(
                        sessionDate.toString(),
                        timeSlot
                );

        BinaryFileUtil.appendObject(
                "data/bookedSimulatorTrainings.bin",
                bookedTraining
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Simulator session booked successfully.");
        alert.showAndWait();

        sessionDateDatePicker.setValue(null);
        timeSlotCombobox.getSelectionModel().clearSelection();
    }

    @FXML
    public void backTodashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }
}