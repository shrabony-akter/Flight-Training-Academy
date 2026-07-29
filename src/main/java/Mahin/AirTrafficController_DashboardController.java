package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AirTrafficController_DashboardController {


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
    public void viewFlightScheduleButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A1_ViewFlightSchedule.fxml");

    }


    @FXML
    public void assignRunwayButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A2_AssignRunway.fxml");

    }


    @FXML
    public void monitorActiveFlightStatusButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A3_MonitorActiveFlightStatus.fxml");

    }


    @FXML
    public void approveTakeoffRequestButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A4_ApproveTakeoffRequest.fxml");

    }


    @FXML
    public void approveLandingRequestButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A5_ApproveLandingRequest.fxml");

    }


    @FXML
    public void generateAirTrafficReportButton(ActionEvent event) throws IOException {

        openPage("AirTrafficController_A6_GenerateAirTrafficReport.fxml");

    }


    @FXML
    public void logoutButton(ActionEvent event) {

        System.out.println("Logout clicked");

    }

}