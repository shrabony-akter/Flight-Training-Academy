package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;

public class GroundInstructor_G2_UploadStudyMaterialsController {

    @FXML
    private TextField materialTitleField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label fileNameLabel;


    private File selectedFile;


    @FXML
    public void chooseFile(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            fileNameLabel.setText(selectedFile.getName());
        }
    }


    @FXML
    public void uploadMaterial(ActionEvent event) {

        String title = materialTitleField.getText();
        String subject = subjectField.getText();

        System.out.println("Study Material Uploaded");
        System.out.println("Title: " + title);
        System.out.println("Subject: " + subject);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Study material uploaded successfully!");
        alert.showAndWait();
    }


    @FXML
    public void goBack(ActionEvent event) {

        System.out.println("Returning to Ground Instructor Dashboard");

        // Scene switching will be added later
    }

}