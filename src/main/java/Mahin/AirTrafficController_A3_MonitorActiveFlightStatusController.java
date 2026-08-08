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
import java.util.ArrayList;

public class AirTrafficController_A3_MonitorActiveFlightStatusController {

    @FXML
    private TextField flightIdField;

    @FXML
    private TextArea statusArea;

    @FXML
    public void monitorFlight(ActionEvent event) {

        String flightId = flightIdField.getText();

        ArrayList<FlightStatus> statuses =
                BinaryFileUtil.readObjects("flight_statuses.dat");

        FlightStatus selectedStatus = null;

        for (FlightStatus status : statuses) {

            if (status.getFlightId().equals(flightId)) {
                selectedStatus = status;
                break;
            }
        }

        if (selectedStatus != null) {

            statusArea.setText(
                    "Flight Status: " + selectedStatus.getStatus()
                            + "\nAltitude: " + selectedStatus.getAltitude()
                            + "\nSpeed: " + selectedStatus.getSpeed()
            );

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Flight status not found!");
            alert.showAndWait();
        }
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
