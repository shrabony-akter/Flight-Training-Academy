package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A5_ApproveLandingRequestController {


    @FXML
    private TextField flightIdField;


    @FXML
    public void approveLanding(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Landing Approved");
        alert.setHeaderText(null);
        alert.setContentText("Landing request approved!");
        alert.showAndWait();


    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}