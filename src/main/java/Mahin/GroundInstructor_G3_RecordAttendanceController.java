package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;

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

        String attendanceDate = "";

        if (attendanceDatePicker.getValue() != null) {
            attendanceDate = attendanceDatePicker.getValue().toString();
        }

        String status = statusComboBox.getValue();

        AttendanceRecord attendance = new AttendanceRecord(
                studentId,
                studentName,
                attendanceDate,
                status
        );

        BinaryFileUtil.appendObject(
                "attendance_records.dat",
                attendance
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Attendance saved successfully!");
        alert.showAndWait();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("GroundInstructor_Dashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }
}