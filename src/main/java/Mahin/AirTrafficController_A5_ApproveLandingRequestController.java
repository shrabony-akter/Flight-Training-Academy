package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;
import java.time.LocalDate;

public class AirTrafficController_A5_ApproveLandingRequestController {

    @FXML
    private TextField flightIdField;

    @FXML
    public void approveLanding(ActionEvent event) {

        String flightId = flightIdField.getText();
        String requestDate = LocalDate.now().toString();

        LandingRequest request = new LandingRequest(
                flightId,
                requestDate,
                "Approved"
        );

        BinaryFileUtil.appendObject(
                "landing_requests.dat",
                request
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Landing Approved");
        alert.setHeaderText(null);
        alert.setContentText(
                "Landing request approved successfully!"
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