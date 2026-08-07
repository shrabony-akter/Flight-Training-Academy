package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class FlightInstructor_G7_CreateAnnouncementController {

    @FXML
    private TextArea announcementDetailsTextArea;

    @FXML
    private TextField announcementTitleTextfield;

    @FXML
    public void initialize() {

    }

    @FXML
    public void publishButton(ActionEvent actionEvent) {

        if (announcementTitleTextfield.getText().trim().isEmpty()
                || announcementDetailsTextArea.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Please fill in all fields.");
            return;
        }

        Announcement announcement = new Announcement(
                "ANN" + System.currentTimeMillis(),
                announcementTitleTextfield.getText().trim(),
                announcementDetailsTextArea.getText().trim(),
                LocalDate.now().toString()
        );

        BinaryFileUtil.appendObject(
                "data/announcement.bin",
                announcement
        );

        showAlert(Alert.AlertType.INFORMATION,
                "Announcement published successfully.");

        announcementTitleTextfield.clear();
        announcementDetailsTextArea.clear();
    }

    @FXML
    public void backToDashboardbutton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/FlightInstructor_Dashboard.fxml",
                "Flight Instructor Dashboard"
        );
    }

    private void showAlert(Alert.AlertType type, String message) {

        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}