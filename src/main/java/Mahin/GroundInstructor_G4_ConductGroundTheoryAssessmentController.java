package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;

public class GroundInstructor_G4_ConductGroundTheoryAssessmentController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField assessmentTitleField;

    @FXML
    private DatePicker assessmentDatePicker;

    @FXML
    private TextField totalMarksField;

    @FXML
    private TextField obtainedMarksField;

    @FXML
    private TextArea remarksArea;

    @FXML
    public void saveAssessment(ActionEvent event) {

        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String assessmentTitle = assessmentTitleField.getText();

        String assessmentDate = "";

        if (assessmentDatePicker.getValue() != null) {
            assessmentDate = assessmentDatePicker.getValue().toString();
        }

        String totalMarks = totalMarksField.getText();
        String obtainedMarks = obtainedMarksField.getText();
        String remarks = remarksArea.getText();

        GroundTheoryAssessment assessment = new GroundTheoryAssessment(
                studentId,
                studentName,
                assessmentTitle,
                assessmentDate,
                totalMarks,
                obtainedMarks,
                remarks
        );

        BinaryFileUtil.appendObject(
                "ground_theory_assessments.dat",
                assessment
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Assessment saved successfully!");
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