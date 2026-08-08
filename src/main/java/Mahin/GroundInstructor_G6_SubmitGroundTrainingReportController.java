package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;

public class GroundInstructor_G6_SubmitGroundTrainingReportController {

    @FXML
    private TextField instructorNameField;

    @FXML
    private TextField reportTitleField;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private TextArea trainingSummaryArea;

    @FXML
    private TextArea studentProgressArea;

    @FXML
    private TextArea remarksArea;

    @FXML
    public void submitReport(ActionEvent event) {

        String instructorName = instructorNameField.getText();
        String reportTitle = reportTitleField.getText();

        String reportDate = "";

        if (reportDatePicker.getValue() != null) {
            reportDate = reportDatePicker.getValue().toString();
        }

        String trainingSummary = trainingSummaryArea.getText();
        String studentProgress = studentProgressArea.getText();
        String remarks = remarksArea.getText();

        GroundTrainingReport report = new GroundTrainingReport(
                instructorName,
                reportTitle,
                reportDate,
                trainingSummary,
                studentProgress,
                remarks
        );

        BinaryFileUtil.appendObject(
                "ground_training_reports.dat",
                report
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(
                "Ground training report submitted successfully!"
        );
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