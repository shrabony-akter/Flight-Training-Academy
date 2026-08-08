package com.example.flighttrainingacademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController
{
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextField  userNameTextField;
    @javafx.fxml.FXML
    private ComboBox <String> userTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Student Pilot", "Flight Instructor" , "Finance Officer" , "Exam Evaluator");

    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) throws IOException {
        if (userTypeComboBox.getValue().equals("Flight Instructor") && userNameTextField.getText().equals("Masuda") && passwordPasswordField.getText().equals("Masuda1234")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/FlightInstructor_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Flight Instructor Dashboard");
            nextStage.setScene(scene);
            nextStage.show();
        }

        else if (userTypeComboBox.getValue().equals("Student Pilot") && userNameTextField.getText().equals("Shrabony") && passwordPasswordField.getText().equals("Shrabony1234")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Shrabony/StudentPilot_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            nextStage.setTitle("Student Pilot Dashboard");
            nextStage.setScene(scene);
            nextStage.show();
        }


        else if (userTypeComboBox.getValue().equals("Finance Officer")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Nadim_Hasan_Khan/FinanceOfficerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            //nextStage.setTitle("Student pilot Dashboard");
            nextStage.setScene(scene);
            nextStage.show();
        }

        else if (userTypeComboBox.getValue().equals("Exam Evaluator")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Nadim_Hasan_Khan/ExamEvaluatorDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            //nextStage.setTitle("Student pilot Dashboard");
            nextStage.setScene(scene);
            nextStage.show();
        }

    }
}