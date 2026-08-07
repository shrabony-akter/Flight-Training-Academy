package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FlightInstructor_G8_UpdateProfileController {

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    public void initialize() {

        ArrayList<FlightInstructorProfile> profiles =
                BinaryFileUtil.readObjects("data/flightInstructorProfile.bin");

        if (!profiles.isEmpty()) {
            FlightInstructorProfile profile = profiles.get(0);

            fullNameTextField.setText(profile.getFullName());
            contactNumberTextField.setText(profile.getContactNumber());
            emailAddressTextField.setText(profile.getEmailAddress());
        }
    }

    @FXML
    public void updateProfileButton(ActionEvent actionEvent) {

        if (fullNameTextField.getText().trim().isEmpty()
                || contactNumberTextField.getText().trim().isEmpty()
                || emailAddressTextField.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.ERROR,
                    "Please fill in all fields.");
            return;
        }

        FlightInstructorProfile profile =
                new FlightInstructorProfile(
                        fullNameTextField.getText().trim(),
                        contactNumberTextField.getText().trim(),
                        emailAddressTextField.getText().trim()
                );

        BinaryFileUtil.saveObject(
                "data/flightInstructorProfile.bin",
                profile
        );

        showAlert(Alert.AlertType.INFORMATION,
                "Profile updated successfully.");
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
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}