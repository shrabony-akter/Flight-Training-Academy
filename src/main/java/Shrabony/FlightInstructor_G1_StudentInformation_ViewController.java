package Shrabony;

import Utility.BinaryFileUtil;
import Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FlightInstructor_G1_StudentInformation_ViewController {

    @FXML
    private TableColumn<StudentPilotProfile, String> studentidTableColoum;

    @FXML
    private TableColumn<StudentPilotProfile, String> enrollrdCourseTableColoum;

    @FXML
    private ComboBox<String> trainingStatusComboBox;

    @FXML
    private TableColumn<StudentPilotProfile, String> trainingStatusTablecoloum;

    @FXML
    private TableColumn<StudentPilotProfile, String> studentNameTableColoum;

    @FXML
    private TableView<StudentPilotProfile> studentInformationTableView;

    @FXML
    private TableColumn<StudentPilotProfile, String> contactNumberTableColoum;

    private ObservableList<StudentPilotProfile> studentList;

    @FXML
    public void initialize() {

        trainingStatusComboBox.getItems().addAll(
                "All",
                "Completed",
                "Ongoing",
                "Pending"
        );
        trainingStatusComboBox.setValue("All");

        studentNameTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("fullName"));

        contactNumberTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber"));

        studentidTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("studentId"));

        enrollrdCourseTableColoum.setCellValueFactory(
                new PropertyValueFactory<>("enrolledCourse"));

        trainingStatusTablecoloum.setCellValueFactory(
                new PropertyValueFactory<>("trainingStatus"));

        loadData();
    }

    private void loadData() {

        ArrayList<StudentPilotProfile> list =
                BinaryFileUtil.readObjects("data/studentPilotProfile.bin");

        studentList = FXCollections.observableArrayList(list);

        studentInformationTableView.setItems(studentList);
    }

    @FXML
    public void searchButton(ActionEvent actionEvent) {

        String status = trainingStatusComboBox.getValue();

        if (status == null || status.equals("All")) {
            studentInformationTableView.setItems(studentList);
            return;
        }

        ObservableList<StudentPilotProfile> filtered =
                FXCollections.observableArrayList();

        for (StudentPilotProfile student : studentList) {

            if (student.getTrainingStatus().equalsIgnoreCase(status)) {
                filtered.add(student);
            }
        }

        studentInformationTableView.setItems(filtered);
    }

    @FXML
    public void backToDashboardButton(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/Shrabony/FlightInstructor_Dashboard.fxml",
                "Flight Instructor Dashboard"
        );
    }
}