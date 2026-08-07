package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class StudentPilot_G2_FlightSchedule_ViewController {
    @FXML
    private TableColumn<FlightSchedule, String> flightDateTableColumn;

    @FXML
    private TableColumn<FlightSchedule, String> flightTimeTableColumn;

    @FXML
    private TableView<FlightSchedule> flightScheduleTableView;

    @FXML
    private ComboBox<String> airCraftTypeComboBox;

    @FXML
    private TableColumn<FlightSchedule, String> instructorNameTableColumn;

    @FXML
    private TableColumn<FlightSchedule, String> flightIdTableColumn;

    @FXML
    private TableColumn<FlightSchedule, String> aircraftTypeTableColumn;

    @FXML
    public void initialize() {

        airCraftTypeComboBox.getItems().addAll(
                "Cessna 172",
                "Piper PA-28",
                "Diamond DA40"
        );

        flightIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));

        flightDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("flightDate"));

        flightTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("flightTime"));

        aircraftTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("aircraftType"));

        instructorNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));


        if (BinaryFileUtil.readObjects("data/flightSchedules.bin").isEmpty()) {

            BinaryFileUtil.appendObject("data/flightSchedules.bin",
                    new FlightSchedule(
                            "F101",
                            "10-Aug-2026",
                            "09:00 AM",
                            "Cessna 172",
                            "Captain Hasan"));

            BinaryFileUtil.appendObject("data/flightSchedules.bin",
                    new FlightSchedule(
                            "F102",
                            "11-Aug-2026",
                            "11:00 AM",
                            "Piper PA-28",
                            "Captain Rahman"));

            BinaryFileUtil.appendObject("data/flightSchedules.bin",
                    new FlightSchedule(
                            "F103",
                            "12-Aug-2026",
                            "02:00 PM",
                            "Diamond DA40",
                            "Captain Karim"));

            BinaryFileUtil.appendObject("data/flightSchedules.bin",
                    new FlightSchedule(
                            "F104",
                            "13-Aug-2026",
                            "10:30 AM",
                            "Cessna 172",
                            "Captain Ahmed"));
        }

        loadTable();
    }

    private void loadTable() {

        ObservableList<FlightSchedule> list =
                FXCollections.observableArrayList();

        ArrayList<FlightSchedule> schedules =
                BinaryFileUtil.readObjects("data/flightSchedules.bin");

        list.addAll(schedules);

        flightScheduleTableView.setItems(list);
    }

    @FXML
    public void refreshfilterButton(ActionEvent actionEvent) {

        String aircraft = airCraftTypeComboBox.getValue();

        ObservableList<FlightSchedule> list =
                FXCollections.observableArrayList();

        ArrayList<FlightSchedule> schedules =
                BinaryFileUtil.readObjects("data/flightSchedules.bin");

        for (FlightSchedule schedule : schedules) {

            if (schedule.getAircraftType().equals(aircraft)) {
                list.add(schedule);
            }
        }

        flightScheduleTableView.setItems(list);
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }

    @FXML
    public void searchfilterButton(ActionEvent actionEvent) {

        loadTable();
    }
}