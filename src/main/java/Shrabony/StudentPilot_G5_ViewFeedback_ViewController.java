package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class StudentPilot_G5_ViewFeedback_ViewController {

    @FXML
    private TableColumn<Feedback, String> feedbackIdTableColumn;
    @FXML
    private TableColumn<Feedback, String> feedbackDateTableColoumn;
    @FXML
    private TextArea feedbackAreaTextArea;
    @FXML
    private TableView<Feedback> viewfeedbackTableView;
    @FXML
    private TableColumn<Feedback, String> instructorNameTableColumn;
    @FXML
    private TableColumn<Feedback, String> feedbackSummaryTableColumn;
    @FXML
    public void initialize() {

        feedbackIdTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("feedbackId"));

        instructorNameTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("instructorName"));

        feedbackDateTableColoumn.setCellValueFactory(
                new PropertyValueFactory<>("feedbackDate"));

        feedbackSummaryTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("feedbackSummary"));

        if (BinaryFileUtil.readObjects("data/feedbacks.bin").isEmpty()) {

            BinaryFileUtil.appendObject(
                    "data/feedbacks.bin",
                    new Feedback(
                            "FB001",
                            "Captain Hasan",
                            "05-Aug-2026",
                            "Good Progress",
                            "You have shown excellent improvement in take-off and landing. Continue practicing crosswind landings."
                    ));

            BinaryFileUtil.appendObject(
                    "data/feedbacks.bin",
                    new Feedback(
                            "FB002",
                            "Captain Rahman",
                            "10-Aug-2026",
                            "Navigation Skills",
                            "Navigation skills are satisfactory. Work more on route planning and communication."
                    ));

            BinaryFileUtil.appendObject(
                    "data/feedbacks.bin",
                    new Feedback(
                            "FB003",
                            "Captain Ahmed",
                            "15-Aug-2026",
                            "Simulator Performance",
                            "Excellent simulator performance. Emergency procedures were completed successfully."
                    ));
        }

        loadTable();
    }

    private void loadTable() {

        ObservableList<Feedback> list =
                FXCollections.observableArrayList();

        ArrayList<Feedback> feedbackList =
                BinaryFileUtil.readObjects("data/feedbacks.bin");

        list.addAll(feedbackList);

        viewfeedbackTableView.setItems(list);
    }

    @FXML
    public void viewButton(ActionEvent actionEvent) {

        Feedback feedback =
                viewfeedbackTableView.getSelectionModel().getSelectedItem();

        if (feedback != null) {
            feedbackAreaTextArea.setText(feedback.getFeedbackDetails());
        }
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/StudentPilotDashboard.fxml",
                "Student Pilot Dashboard"
        );
    }
}