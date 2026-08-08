 package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;
import java.time.LocalDate;

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

        String flightId = flightIdField.getText();
        String runway = runwayComboBox.getValue();
        String assignmentDate = LocalDate.now().toString();

        RunwayAssignment assignment = new RunwayAssignment(
                flightId,
                runway,
                assignmentDate
        );

        BinaryFileUtil.appendObject(
                "runway_assignments.dat",
                assignment
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(
                "Runway assigned successfully!"
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
