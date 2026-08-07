package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class FlightInstructor_G2_AssignLessonController {

    @FXML
    private ComboBox<String> lessonComboBox;

    @FXML
    private ComboBox<String> studentIdComboBox;

    @FXML
    public void initialize() {

        lessonComboBox.getItems().addAll(
                "Lesson 1",
                "Lesson 2",
                "Lesson 3",
                "Lesson 4",
                "Lesson 5"
        );

        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        for (StudentPilotProfile student : students) {
            studentIdComboBox.getItems().add(student.getStudentId());
        }
    }

    @FXML
    public void assignlessonButton(ActionEvent actionEvent) {

        if (studentIdComboBox.getValue() == null ||
                lessonComboBox.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select both Student ID and Lesson.");
            alert.showAndWait();
            return;
        }

        AssignedLesson assignedLesson = new AssignedLesson(
                studentIdComboBox.getValue(),
                lessonComboBox.getValue()
        );

        BinaryFileUtil.appendObject(
                "data/assignedLesson.bin",
                assignedLesson
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Lesson assigned successfully.");
        alert.showAndWait();

        studentIdComboBox.setValue(null);
        lessonComboBox.setValue(null);
    }

    @FXML
    public void backToDashBoardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/FlightInstructor_Dashboard.fxml",
                "Flight Instructor Dashboard"
        );
    }
}