package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class FlightInstructor_G4_ProvideFeedbackController {

    @FXML
    private ComboBox<String> studentIdComboBox;

    @FXML
    private TextField feedbackSummaryTextField;

    @FXML
    private TextField feedbackDetailsTextField;

    @FXML
    public void initialize() {

        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        for (StudentPilotProfile student : students) {
            studentIdComboBox.getItems().add(student.getStudentId());
        }
    }

    @FXML
    public void submitFeedbackButton(ActionEvent actionEvent) {

        if (studentIdComboBox.getValue() == null
                || feedbackSummaryTextField.getText().isEmpty()
                || feedbackDetailsTextField.getText().isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Please fill in all fields.");
            return;
        }

        String feedbackId = "FB" + System.currentTimeMillis();

        Feedback feedback = new Feedback(
                feedbackId,
                studentIdComboBox.getValue(),
                "Flight Instructor",
                LocalDate.now().toString(),
                feedbackSummaryTextField.getText(),
                feedbackDetailsTextField.getText()
        );

        BinaryFileUtil.appendObject(
                "data/feedback.bin",
                feedback
        );

        showAlert(Alert.AlertType.INFORMATION,
                "Feedback submitted successfully.");

        studentIdComboBox.setValue(null);
        feedbackSummaryTextField.clear();
        feedbackDetailsTextField.clear();
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/FlightInstructor_Dashboard.fxml",
                "Flight Instructor Dashboard"
        );
    }

    private void showAlert(Alert.AlertType type, String message) {

        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}