package Shrabony;

import com.example.flighttrainingacademy.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightInstructor_DashboardController
{

    @javafx.fxml.FXML
    private BorderPane flightInstructorDashboardBorderpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assessmentMarksButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G3_RecordAssessmentMarks.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void provideFeedBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G4_ProvideFeedback.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());

    }

    @javafx.fxml.FXML
    public void assignLessonButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G2_AssignLesson.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void updateProfileButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G8_UpdateProfile.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void creatAnnouncementButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G7_CreateAnnouncement.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void finalExamRecommendationButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G6_FinalExamRecommendation.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void additionalSimulatorRequestsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G5_ApproveAdditionalSimulatorRequests.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
    }

    @javafx.fxml.FXML
    public void studentInformationButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_G1_StudentInformation_View.fxml"));
        flightInstructorDashboardBorderpane.setCenter(fxmlLoader.load());
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