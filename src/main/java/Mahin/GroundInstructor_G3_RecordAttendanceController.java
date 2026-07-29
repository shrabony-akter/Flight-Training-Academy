package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GroundInstructor_G3_RecordAttendanceController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField studentNameField;

    @FXML
    private DatePicker attendanceDatePicker;

    @FXML
    private ComboBox<String> statusComboBox;


    @FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "Present",
                "Absent",
                "Late"
        );

    }


    @FXML
    public void saveAttendance(ActionEvent event) {

        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String status = statusComboBox.getValue();

        System.out.println("Attendance Recorded");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Status: " + status);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Attendance saved successfully!");
        alert.showAndWait();

    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added later
    }

}