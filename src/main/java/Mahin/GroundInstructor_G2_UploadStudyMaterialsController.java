package Mahin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.File;
import java.io.IOException;

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
        String description = descriptionArea.getText();

        String fileName = "";

        if (selectedFile != null) {
            fileName = selectedFile.getName();
        }

        StudyMaterial material = new StudyMaterial(
                title,
                subject,
                description,
                fileName
        );

        BinaryFileUtil.appendObject(
                "study_materials.dat",
                material
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(
                "Study material uploaded and saved successfully!"
        );
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