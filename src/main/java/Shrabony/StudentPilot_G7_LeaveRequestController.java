package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

public class StudentPilot_G7_LeaveRequestController {

    @FXML
    private TextArea leaveReasonTextArea;

    @FXML
    private DatePicker leaveDatedatePicker;

    @FXML
    public void initialize() {

    }

    @FXML
    public void submitRequestButton(ActionEvent actionEvent) {

        LocalDate leaveDate = leaveDatedatePicker.getValue();
        String reason = leaveReasonTextArea.getText().trim();

        if (leaveDate == null || reason.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a leave date and enter the reason.");
            alert.showAndWait();
            return;
        }

        LeaveRequest request = new LeaveRequest(
                leaveDate.toString(),
                reason,
                "Pending"
        );

        BinaryFileUtil.appendObject(
                "data/leaveRequests.bin",
                request
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Leave request submitted successfully.");
        alert.showAndWait();

        leaveDatedatePicker.setValue(null);
        leaveReasonTextArea.clear();
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