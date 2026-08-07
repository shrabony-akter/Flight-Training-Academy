package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FlightInstructor_G3_RecordAssessmentMarksController {

    @FXML
    private ComboBox<String> studentIdComboBox;

    @FXML
    private TextField assessmentMarksTextField;

    @FXML
    public void initialize() {

        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        for (StudentPilotProfile student : students) {
            studentIdComboBox.getItems().add(student.getStudentId());
        }
    }

    @FXML
    public void saveMarksButton(ActionEvent actionEvent) {

        if (studentIdComboBox.getValue() == null ||
                assessmentMarksTextField.getText().isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Please select a student and enter marks.");
            return;
        }

        double marks;

        try {
            marks = Double.parseDouble(assessmentMarksTextField.getText());

            if (marks < 0 || marks > 100) {
                showAlert(Alert.AlertType.ERROR,
                        "Marks must be between 0 and 100.");
                return;
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR,
                    "Please enter a valid numeric mark.");
            return;
        }

        AssessmentMarks assessment = new AssessmentMarks(
                studentIdComboBox.getValue(),
                marks
        );

        BinaryFileUtil.appendObject(
                "data/assessmentMarks.bin",
                assessment
        );

        showAlert(Alert.AlertType.INFORMATION,
                "Assessment marks saved successfully.");

        studentIdComboBox.setValue(null);
        assessmentMarksTextField.clear();
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