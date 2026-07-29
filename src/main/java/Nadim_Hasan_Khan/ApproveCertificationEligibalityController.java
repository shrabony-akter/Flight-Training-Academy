package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ApproveCertificationEligibalityController
{
    @javafx.fxml.FXML
    private TextField Attendance;
    @javafx.fxml.FXML
    private TableColumn ProjectCol;
    @javafx.fxml.FXML
    private ComboBox<String> Action;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TableColumn CGPACol;
    @javafx.fxml.FXML
    private TableColumn StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn ActionCol;
    @javafx.fxml.FXML
    private TextField CGPA;
    @javafx.fxml.FXML
    private ComboBox<String> Eligible;
    @javafx.fxml.FXML
    private TableColumn NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private ComboBox<String> Project;
    @javafx.fxml.FXML
    private TextField Credits;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TableColumn AttendanceCol;
    @javafx.fxml.FXML
    private TableColumn CreditsCol;
    @javafx.fxml.FXML
    private TableColumn EligibleCol;

    @javafx.fxml.FXML
    public void initialize() {
        Project.getItems().addAll("Yes","NO");
        Eligible.getItems().addAll("Yes","No");
        Action.getItems().addAll("Certify","Not Certify");
    }

    @javafx.fxml.FXML
    public void Proceed_Report(ActionEvent actionEvent) {
    }
}