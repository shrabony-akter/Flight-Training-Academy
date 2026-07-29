package Shrabony;

import com.example.flighttrainingacademy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentPilot_DashboardController
{
    @javafx.fxml.FXML
    private BorderPane studentPilotDashboard;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void leaveRequestButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G7_LeaveRequest.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void courseRegistrationButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G1_CourseRegistration.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void simulatorBookingButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G3_SimulatorBooking.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void viewFeedbackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G5_ViewFeedback_View.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void trainingProgressButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G4_TrainingProgress_View.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void updateProfileButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G6_UpdateProfile.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void additionalSimulatorRequestButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G8_AdditionalSimulatorRequest.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void flightScheduleButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_G2_FlightSchedule_View.fxml"));
        studentPilotDashboard.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void signOutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setTitle("Flight Training Academy");
        nextStage.setScene(scene);
        nextStage.show();
    }
}