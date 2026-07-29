package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GroundInstructor_G4_ConductGroundTheoryAssessmentController {

    @FXML
    private TextField assessmentTitleField;

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField marksField;

    @FXML
    private TextArea feedbackArea;


    @FXML
    public void submitAssessment(ActionEvent event) {

        String title = assessmentTitleField.getText();
        String studentId = studentIdField.getText();
        String marks = marksField.getText();

        System.out.println("Assessment Submitted");
        System.out.println("Title: " + title);
        System.out.println("Student ID: " + studentId);
        System.out.println("Marks: " + marks);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Assessment submitted successfully!");
        alert.showAndWait();

    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added later
    }

}