package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GroundInstructor_DashboardController {


    private void openPage(String fileName) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(fileName)
        );

        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void createGroundTheoryLessonButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G1_CreateGroundTheoryLesson.fxml");
    }


    @FXML
    public void uploadStudyMaterialsButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G2_UploadStudyMaterials.fxml");
    }


    @FXML
    public void recordAttendanceButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G3_RecordAttendance.fxml");
    }


    @FXML
    public void conductGroundTheoryAssessmentButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G4_ConductGroundTheoryAssessment.fxml");
    }


    @FXML
    public void viewStudentTrainingProgressButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G5_ViewStudentTrainingProgress.fxml");
    }


    @FXML
    public void submitGroundTrainingReportButton(ActionEvent event) throws IOException {
        openPage("GroundInstructor_G6_SubmitGroundTrainingReport.fxml");
    }


    @FXML
    public void logoutButton(ActionEvent event) {

        System.out.println("Logout clicked");

    }

}