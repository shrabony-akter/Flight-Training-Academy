package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A2_AssignRunwayController {


    @FXML
    private TextField flightIdField;

    @FXML
    private ComboBox<String> runwayComboBox;


    @FXML
    public void initialize() {

        runwayComboBox.getItems().addAll(
                "Runway 01",
                "Runway 02",
                "Runway 03"
        );

    }


    @FXML
    public void assignRunway(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Runway assigned successfully!");
        alert.showAndWait();


    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}