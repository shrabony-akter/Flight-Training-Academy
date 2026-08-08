package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightInstructor_G5_ApproveAdditionalSimulatorRequestsController {

    @FXML
    private TableView<AdditionalSimulatorRequest> additionalSimulatorRequestsTableView;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> requestIdTableColoum;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> studentIdTableColoum;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> requestedDateTAblecoloum;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> studentNameTableColoum;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> requestReasonTableColoum;

    @FXML
    private TableColumn<AdditionalSimulatorRequest, String> preferredTimeSlotTableColoum;

    private ObservableList<AdditionalSimulatorRequest> requestList;

    // Used to find student name from student ID
    private Map<String, String> studentNameMap = new HashMap<>();

    @FXML
    public void initialize() {

        setupTableColumns();
        loadStudentNames();
        loadRequests();
    }

    private void setupTableColumns() {

        requestIdTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("requestId")
        );

        studentIdTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("studentId")
        );

        requestedDateTAblecoloum.setCellValueFactory(
                new PropertyValueFactory<>("preferredDate")
        );

        requestReasonTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("reason")
        );

        preferredTimeSlotTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("preferredTimeSlot")
        );

        /*
         * Student name is not directly stored inside
         * AdditionalSimulatorRequest.
         *
         * Therefore, we use a custom cell value factory
         * to find the name using studentId.
         */
        studentNameTableColoum.setCellValueFactory(cellData -> {

            String studentId = cellData.getValue().getStudentId();

            String studentName = studentNameMap.get(studentId);

            if (studentName == null) {
                studentName = "Unknown";
            }

            return new javafx.beans.property.SimpleStringProperty(studentName);
        });
    }

    private void loadStudentNames() {

        ArrayList<StudentPilotProfile> students =
                BinaryFileUtil.readObjects(
                        "data/studentPilotProfile.bin"
                );

        for (StudentPilotProfile student : students) {

            studentNameMap.put(
                    student.getStudentId(),
                    student.getFullName()
            );
        }
    }

    private void loadRequests() {

        ArrayList<AdditionalSimulatorRequest> requests =
                BinaryFileUtil.readObjects(
                        "data/additionalSimulatorRequests.bin"
                );

        requestList =
                FXCollections.observableArrayList(requests);

        additionalSimulatorRequestsTableView.setItems(requestList);
    }

    @FXML
    public void approveRequestButton(ActionEvent actionEvent) {

        AdditionalSimulatorRequest selectedRequest =
                additionalSimulatorRequestsTableView
                        .getSelectionModel()
                        .getSelectedItem();

        if (selectedRequest == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Please select a request to approve."
            );

            return;
        }

        if ("Approved".equalsIgnoreCase(
                selectedRequest.getRequestStatus())) {

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "This request is already approved."
            );

            return;
        }

        selectedRequest.setRequestStatus("Approved");

        /*
         * Save the complete updated list.
         * This replaces the old file with the updated list.
         */
        BinaryFileUtil.saveList(
                "data/additionalSimulatorRequests.bin",
                new ArrayList<>(requestList)
        );

        additionalSimulatorRequestsTableView.refresh();

        showAlert(
                Alert.AlertType.INFORMATION,
                "Simulator request approved successfully."
        );
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/FlightInstructor_Dashboard.fxml",
                "Flight Instructor Dashboard"
        );
    }

    private void showAlert(Alert.AlertType type, String message) {

        Alert alert = new Alert(type);

        alert.setTitle(
                type == Alert.AlertType.ERROR
                        ? "Error"
                        : "Success"
        );

        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}