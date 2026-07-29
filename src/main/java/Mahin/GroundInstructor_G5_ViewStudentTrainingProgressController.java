package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GroundInstructor_G5_ViewStudentTrainingProgressController {


    @FXML
    private TextField studentIdField;

    @FXML
    private TableView<?> progressTable;

    @FXML
    private TableColumn<?, ?> lessonColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableColumn<?, ?> scoreColumn;



    @FXML
    public void searchStudent(ActionEvent event) {

        String studentId = studentIdField.getText();

        System.out.println("Searching Student Progress");
        System.out.println("Student ID: " + studentId);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Progress");
        alert.setHeaderText(null);
        alert.setContentText("Student training progress loaded!");
        alert.showAndWait();

    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added later
    }

}