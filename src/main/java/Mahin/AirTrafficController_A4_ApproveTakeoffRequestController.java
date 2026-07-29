package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A4_ApproveTakeoffRequestController {


    @FXML
    private TextField flightIdField;


    @FXML
    public void approveTakeoff(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Takeoff Approved");
        alert.setHeaderText(null);
        alert.setContentText("Takeoff request approved!");
        alert.showAndWait();


    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}