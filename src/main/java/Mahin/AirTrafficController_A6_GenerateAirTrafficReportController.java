package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;
import java.time.LocalDate;

public class AirTrafficController_A6_GenerateAirTrafficReportController {

    @FXML
    private TextField reportTitleField;

    @FXML
    private TextArea reportDetailsArea;

    @FXML
    public void generateReport(ActionEvent event) {

        String reportTitle = reportTitleField.getText();
        String reportDetails = reportDetailsArea.getText();
        String reportDate = LocalDate.now().toString();

        AirTrafficReport report = new AirTrafficReport(
                reportTitle,
                reportDate,
                reportDetails
        );

        BinaryFileUtil.appendObject(
                "air_traffic_reports.dat",
                report
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report Generated");
        alert.setHeaderText(null);
        alert.setContentText(
                "Air traffic report generated successfully!"
        );
        alert.showAndWait();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("AirTrafficController_Dashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }
}