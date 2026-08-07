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

public class FlightInstructor_G6_FinalExamRecommendationController {

    @FXML
    private ComboBox<String> studentIdComboBox;

    @FXML
    private TextField recommendationNoteTextField;

    @FXML
    private ComboBox<String> recommendationStatusComboBox;

    @FXML
    public void initialize() {

        // Recommendation status
        recommendationStatusComboBox.getItems().addAll(
                "Recommended",
                "Not Recommended"
        );

        // Load Student IDs
        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        for (StudentPilotProfile student : students) {
            studentIdComboBox.getItems().add(student.getStudentId());
        }
    }

    @FXML
    public void submitRecommendationButton(ActionEvent actionEvent) {

        if (studentIdComboBox.getValue() == null
                || recommendationStatusComboBox.getValue() == null
                || recommendationNoteTextField.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Please complete all fields.");
            return;
        }

        FinalExamRecommendation recommendation =
                new FinalExamRecommendation(
                        studentIdComboBox.getValue(),
                        recommendationStatusComboBox.getValue(),
                        recommendationNoteTextField.getText().trim(),
                        LocalDate.now().toString()
                );

        BinaryFileUtil.appendObject(
                "data/finalExamRecommendation.bin",
                recommendation
        );

        showAlert(Alert.AlertType.INFORMATION,
                "Recommendation submitted successfully.");

        studentIdComboBox.setValue(null);
        recommendationStatusComboBox.setValue(null);
        recommendationNoteTextField.clear();
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