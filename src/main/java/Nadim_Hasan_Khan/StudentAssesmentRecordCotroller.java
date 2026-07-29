package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class StudentAssesmentRecordCotroller
{
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn StatusCol;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private ComboBox<String> Exam_Type;
    @javafx.fxml.FXML
    private TableColumn ScoreCol;
    @javafx.fxml.FXML
    private TextField Grade;
    @javafx.fxml.FXML
    private TextField ScoreOfStudent;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn CourseCol;
    @javafx.fxml.FXML
    private TableColumn ExamTypeCol;
    @javafx.fxml.FXML
    private TableColumn GradeCol;
    @javafx.fxml.FXML
    private TextField Course;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Passed","Failed");
        Exam_Type.getItems().addAll("Written","Practical");
    }

    @javafx.fxml.FXML
    public void Proceed_Record(ActionEvent actionEvent) {
    }
}