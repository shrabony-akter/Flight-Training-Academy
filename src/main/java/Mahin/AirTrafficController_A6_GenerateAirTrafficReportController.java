package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A6_GenerateAirTrafficReportController {


    @FXML
    private TextField reportTitleField;

    @FXML
    private TextArea reportDetailsArea;


    @FXML
    public void generateReport(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report Generated");
        alert.setHeaderText(null);
        alert.setContentText("Air traffic report generated successfully!");
        alert.showAndWait();


    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}