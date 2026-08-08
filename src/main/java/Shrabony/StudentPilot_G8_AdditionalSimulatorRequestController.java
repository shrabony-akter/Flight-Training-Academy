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

        LocalDate preferredDate =
                preferredDateDatePicker.getValue();

        String preferredTimeSlot =
                preferredTimeSlotTextField.getText().trim();

        String reason =
                reasonTextField.getText().trim();

        // Validate fields
        if (preferredDate == null
                || preferredTimeSlot.isEmpty()
                || reason.isEmpty()) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Please fill in all fields."
            );

            return;
        }

        // Get current student
        String studentId = getStudentId();

        if (studentId == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Student profile could not be found."
            );

            return;
        }

        // Check booked simulator sessions
        ArrayList<BookedSimulatorTraining> bookedSessions =
                BinaryFileUtil.readObjects(
                        "data/bookedSimulatorTrainings.bin"
                );

        for (BookedSimulatorTraining booking : bookedSessions) {

            if (booking.getSessionDate().equals(
                    preferredDate.toString())
                    && booking.getTimeSlot().equalsIgnoreCase(
                    preferredTimeSlot)) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "The selected time slot is not available."
                );

                return;
            }
        }

        // Create request ID
        String requestId =
                "REQ" + System.currentTimeMillis();

        // Create request
        AdditionalSimulatorRequest request =
                new AdditionalSimulatorRequest(
                        requestId,
                        studentId,
                        preferredDate.toString(),
                        preferredTimeSlot,
                        reason,
                        "Pending"
                );

        // Save request
        BinaryFileUtil.appendObject(
                "data/additionalSimulatorRequests.bin",
                request
        );

        showAlert(
                Alert.AlertType.INFORMATION,
                "Simulator request submitted successfully."
        );

        // Clear form
        preferredDateDatePicker.setValue(null);
        preferredTimeSlotTextField.clear();
        reasonTextField.clear();
    }

    /**
     * Gets the student ID from the stored student profile.
     *
     * This assumes the profile file contains the current
     * student's profile.
     */
    private String getStudentId() {

        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects(
                        "data/studentPilotProfile.bin"
                );

        if (students.isEmpty()) {
            return null;
        }

        return students.get(0).getStudentId();
    }

    @FXML
    public void backToDashboardbutton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }

    private void showAlert(
            Alert.AlertType type,
            String message) {

        Alert alert = new Alert(type);

        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}