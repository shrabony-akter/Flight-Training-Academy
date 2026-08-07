package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StudentPilot_G6_UpdateProfileController {

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField emailaddressTextField;

    @FXML
    public void initialize() {

        ArrayList<StudentPilotProfile> profileList = BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        if (!profileList.isEmpty()) {

            StudentPilotProfile profile = profileList.get(0);

            fullNameTextField.setText(profile.getFullName());
            phoneNumberTextField.setText(profile.getPhoneNumber());
            emailaddressTextField.setText(profile.getEmailAddress());
        }
    }

    @FXML
    public void updateProfileButton(ActionEvent actionEvent) {

        String fullName = fullNameTextField.getText().trim();
        String phone = phoneNumberTextField.getText().trim();
        String email = emailaddressTextField.getText().trim();

        if (fullName.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        StudentPilotProfile profile = new StudentPilotProfile(fullName, phone, email);

        ArrayList<StudentPilotProfile> profileList = new ArrayList<>();

        profileList.add(profile);

        BinaryFileUtil.saveList(
                "data/studentPilotProfile.bin",
                profileList
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Profile updated successfully.");
        alert.showAndWait();
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