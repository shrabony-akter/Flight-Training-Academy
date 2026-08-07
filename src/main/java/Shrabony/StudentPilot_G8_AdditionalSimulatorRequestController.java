package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentPilot_G8_AdditionalSimulatorRequestController {

    @FXML
    private DatePicker preferredDateDatePicker;

    @FXML
    private TextField preferredTimeSlotTextField;

    @FXML
    private TextField reasonTextField;

    @FXML
    public void initialize() {

    }

    @FXML
    public void submitRequestButton(ActionEvent actionEvent) {

        LocalDate preferredDate = preferredDateDatePicker.getValue();
        String preferredTimeSlot = preferredTimeSlotTextField.getText().trim();
        String reason = reasonTextField.getText().trim();

        if (preferredDate == null ||
                preferredTimeSlot.isEmpty() ||
                reason.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        ArrayList<BookedSimulatorTraining> bookedSessions =
                BinaryFileUtil.readObjects("data/bookedSimulatorTrainings.bin");

        for (BookedSimulatorTraining booking : bookedSessions) {

            if (booking.getSessionDate().equals(preferredDate.toString())
                    && booking.getTimeSlot().equalsIgnoreCase(preferredTimeSlot)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("The selected time slot is not available.");
                alert.showAndWait();
                return;
            }
        }

        AdditionalSimulatorRequest request =
                new AdditionalSimulatorRequest(
                        preferredDate.toString(),
                        preferredTimeSlot,
                        reason,
                        "Pending"
                );

        BinaryFileUtil.appendObject(
                "data/additionalSimulatorRequests.bin",
                request
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Simulator request submitted successfully.");
        alert.showAndWait();

        preferredDateDatePicker.setValue(null);
        preferredTimeSlotTextField.clear();
        reasonTextField.clear();
    }

    @FXML
    public void backToDashboardbutton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }
}