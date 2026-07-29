package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AirTrafficController_A1_ViewFlightScheduleController {


    @FXML
    private TableView<?> flightTable;

    @FXML
    private TableColumn<?, ?> flightIdColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;

    @FXML
    private TableColumn<?, ?> destinationColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Back to ATC Dashboard");

    }

}