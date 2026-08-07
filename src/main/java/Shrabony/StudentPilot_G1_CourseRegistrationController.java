package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StudentPilot_G1_CourseRegistrationController {

    @FXML
    private ComboBox<String> flightCourseComboBox;
    @FXML
    private TextField studentIdTextField;

    @FXML
    public void initialize() {

        flightCourseComboBox.getItems().addAll(
                "Private Pilot License (PPL)",
                "Commercial Pilot License (CPL)",
                "Instrument Rating (IR)",
                "Multi-Engine Rating (MER)"
        );

        if (BinaryFileUtil.readObjects("data/courses.bin").isEmpty()) {

            BinaryFileUtil.appendObject("data/courses.bin",
                    new Course("Private Pilot License (PPL)"));

            BinaryFileUtil.appendObject("data/courses.bin",
                    new Course("Commercial Pilot License (CPL)"));

            BinaryFileUtil.appendObject("data/courses.bin",
                    new Course("Instrument Rating (IR)"));

            BinaryFileUtil.appendObject("data/courses.bin",
                    new Course("Multi-Engine Rating (MER)"));
        }
    }

    @FXML
    public void courseregisterButton(ActionEvent actionEvent) {

        String studentId = studentIdTextField.getText();
        String course = flightCourseComboBox.getValue();

        if (studentId.isEmpty() || course == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter Student ID and select a course.");
            alert.showAndWait();
            return;
        }

        RegisteredCourse registeredCourse = new RegisteredCourse(studentId, course);

        BinaryFileUtil.appendObject(
                "data/regesteredCourses.bin",
                registeredCourse
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Course registration completed successfully.");
        alert.showAndWait();

        studentIdTextField.clear();
        flightCourseComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }
}