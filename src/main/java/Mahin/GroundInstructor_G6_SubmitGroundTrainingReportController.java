package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GroundInstructor_G6_SubmitGroundTrainingReportController {


    @FXML
    private TextField reportTitleField;

    @FXML
    private TextField studentIdField;

    @FXML
    private TextArea reportDetailsArea;

    @FXML
    private DatePicker reportDatePicker;



    @FXML
    public void submitReport(ActionEvent event) {

        String title = reportTitleField.getText();
        String studentId = studentIdField.getText();

        System.out.println("Ground Training Report Submitted");
        System.out.println("Report Title: " + title);
        System.out.println("Student ID: " + studentId);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Training report submitted successfully!");
        alert.showAndWait();

    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added later
    }

}