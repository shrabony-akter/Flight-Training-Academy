package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ManageOutstandingDuesController
{
    @javafx.fxml.FXML
    private ComboBox Status;
    @javafx.fxml.FXML
    private TableColumn StatusCol;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TableColumn StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn LastPayCol;
    @javafx.fxml.FXML
    private TableColumn NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TableColumn ToalDuecol;
    @javafx.fxml.FXML
    private TextField Total_Due;
    @javafx.fxml.FXML
    private TableColumn CourseCol;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private DatePicker Last_Pay;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
    }
}