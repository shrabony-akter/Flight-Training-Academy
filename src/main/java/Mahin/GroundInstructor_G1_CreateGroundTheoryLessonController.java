package Mahin;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class GroundInstructor_G1_CreateGroundTheoryLessonController {

    @FXML
    private TextField lessonTitleField;

    @FXML
    private TextField topicField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private DatePicker lessonDatePicker;


    @FXML
    public void createLesson(ActionEvent event) {

        String title = lessonTitleField.getText();
        String topic = topicField.getText();

        System.out.println("Ground Theory Lesson Created");
        System.out.println("Title: " + title);
        System.out.println("Topic: " + topic);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Lesson created successfully!");
        alert.showAndWait();
    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added after all controllers are created
    }

}