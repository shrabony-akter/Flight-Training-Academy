package com.example.flighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private ComboBox userNameComboBox;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_Dashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        nextStage.setTitle("Student pilot Dashboard");
//        nextStage.setScene(scene);
//        nextStage.show();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Nadim_Hasan_Khan/FinanceOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //nextStage.setTitle("Student pilot Dashboard");
        nextStage.setScene(scene);
        nextStage.show();
    }
}