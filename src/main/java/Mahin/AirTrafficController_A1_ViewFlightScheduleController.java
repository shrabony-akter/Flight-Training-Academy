        package Mahin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;
import java.util.ArrayList;

public class AirTrafficController_A1_ViewFlightScheduleController {

    @FXML
    private TableView<Flight> flightTable;

    @FXML
    private TableColumn<Flight, String> flightIdColumn;

    @FXML
    private TableColumn<Flight, String> timeColumn;

    @FXML
    private TableColumn<Flight, String> destinationColumn;

    @FXML
    private TableColumn<Flight, String> statusColumn;

    @FXML
    public void initialize() {

        flightIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("flightId")
        );

        timeColumn.setCellValueFactory(
                new PropertyValueFactory<>("flightTime")
        );

        destinationColumn.setCellValueFactory(
                new PropertyValueFactory<>("destination")
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        Flight.initializeSampleFlights();

        loadFlights();
    }

    private void loadFlights() {

        ArrayList<Flight> flights =
                BinaryFileUtil.readObjects("flights.dat");

        ObservableList<Flight> flightList =
                FXCollections.observableArrayList(flights);

        flightTable.setItems(flightList);
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
