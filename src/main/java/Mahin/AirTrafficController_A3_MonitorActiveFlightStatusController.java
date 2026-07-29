package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A3_MonitorActiveFlightStatusController {


    @FXML
    private TextField flightIdField;

    @FXML
    private TextArea statusArea;


    @FXML
    public void monitorFlight(ActionEvent event) {

        statusArea.setText(
                "Flight Status: Active\nAltitude: 5000 ft\nSpeed: Normal"
        );

    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}