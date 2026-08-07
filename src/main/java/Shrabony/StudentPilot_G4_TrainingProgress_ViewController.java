package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class StudentPilot_G4_TrainingProgress_ViewController {
    @FXML
    private TableColumn<TrainingProgress, String> lessonNameTableColumn;
    @FXML
    private TableColumn<TrainingProgress, String> trainingDateTableColumn;
    @FXML
    private TableColumn<TrainingProgress, String> instructorNameTableColumn;
    @FXML
    private TableColumn<TrainingProgress, Double> marksTableColumn;
    @FXML
    private TableColumn<TrainingProgress, String> completionStatusTableColumn;
    @FXML
    private TableView<TrainingProgress> trainingProgressTableView;

    @FXML
    public void initialize() {

        lessonNameTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("lessonName"));

        trainingDateTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("trainingDate"));

        instructorNameTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("instructorName"));

        marksTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("marks"));

        completionStatusTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("completionStatus"));

        if (BinaryFileUtil.readObjects("data/trainingProgress.bin").isEmpty()) {

            BinaryFileUtil.appendObject(
                    "data/trainingProgress.bin",
                    new TrainingProgress(
                            "Basic Flight Controls",
                            "05-Aug-2026",
                            "Captain Hasan",
                            88,
                            "Completed"));

            BinaryFileUtil.appendObject(
                    "data/trainingProgress.bin",
                    new TrainingProgress(
                            "Take-off Practice",
                            "08-Aug-2026",
                            "Captain Rahman",
                            92,
                            "Completed"));

            BinaryFileUtil.appendObject(
                    "data/trainingProgress.bin",
                    new TrainingProgress(
                            "Landing Practice",
                            "10-Aug-2026",
                            "Captain Ahmed",
                            85,
                            "Completed"));

            BinaryFileUtil.appendObject(
                    "data/trainingProgress.bin",
                    new TrainingProgress(
                            "Emergency Procedures",
                            "15-Aug-2026",
                            "Captain Karim",
                            0,
                            "Pending"));
        }

        loadTable();
    }

    private void loadTable() {

        ObservableList<TrainingProgress> list =
                FXCollections.observableArrayList();

        ArrayList<TrainingProgress> progressList =
                BinaryFileUtil.readObjects("data/trainingProgress.bin");

        list.addAll(progressList);

        trainingProgressTableView.setItems(list);
    }

    @FXML
    public void refreshButton(ActionEvent actionEvent) {

        loadTable();
    }

    @FXML
    public void backToDashboardbutton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }
}