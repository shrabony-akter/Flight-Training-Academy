package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;

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
        String description = descriptionArea.getText();

        String lessonDate = "";

        if (lessonDatePicker.getValue() != null) {
            lessonDate = lessonDatePicker.getValue().toString();
        }

        GroundTheoryLesson lesson = new GroundTheoryLesson(
                title,
                topic,
                description,
                lessonDate
        );

        BinaryFileUtil.appendObject(
                "ground_theory_lessons.dat",
                lesson
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Lesson created and saved successfully!");
        alert.showAndWait();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("GroundInstructor_Dashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }
}