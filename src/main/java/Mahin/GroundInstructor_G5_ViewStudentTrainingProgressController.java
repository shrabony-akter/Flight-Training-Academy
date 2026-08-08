package Mahin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Utility.BinaryFileUtil;

import java.io.IOException;
import java.util.List;

public class GroundInstructor_G5_ViewStudentTrainingProgressController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TableView<StudentTrainingProgress> progressTable;

    @FXML
    private TableColumn<StudentTrainingProgress, String> lessonColumn;

    @FXML
    private TableColumn<StudentTrainingProgress, String> statusColumn;

    @FXML
    private TableColumn<StudentTrainingProgress, String> scoreColumn;

    @FXML
    public void initialize() {

        lessonColumn.setCellValueFactory(
                new PropertyValueFactory<>("lesson")
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        scoreColumn.setCellValueFactory(
                new PropertyValueFactory<>("score")
        );
    }

    @FXML
    public void searchStudent(ActionEvent event) {

        String studentId = studentIdField.getText();

        ObservableList<StudentTrainingProgress> progressList =
                FXCollections.observableArrayList();

        List<Object> records = BinaryFileUtil.readObjects(
                "student_training_progress.dat"
        );

        for (Object record : records) {

            if (record instanceof StudentTrainingProgress) {

                StudentTrainingProgress progress =
                        (StudentTrainingProgress) record;

                if (progress.getStudentId().equals(studentId)) {
                    progressList.add(progress);
                }
            }
        }

        progressTable.setItems(progressList);

        if (progressList.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Records");
            alert.setHeaderText(null);
            alert.setContentText(
                    "No training progress found for this student."
            );
            alert.showAndWait();
        }
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