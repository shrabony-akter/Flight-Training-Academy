package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;

public class StudentAssesmentRecordCotroller
{
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1,String> StatusCol;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private ComboBox<String> Exam_Type;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1,Integer> ScoreCol;
    @javafx.fxml.FXML
    private TextField Grade;
    @javafx.fxml.FXML
    private TextField ScoreOfStudent;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1,String> CourseCol;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1,String> ExamTypeCol;
    @javafx.fxml.FXML
    private TableColumn<StudentAssesmentRecordM1,String> GradeCol;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Passed","Failed");
        Exam_Type.getItems().addAll("Written","Practical");
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        ExamTypeCol.setCellValueFactory(new PropertyValueFactory<>("exam_type"));
        ScoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        GradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void Proceed_Record(ActionEvent actionEvent) {
        //LocalDate date, int score, String course, String exam_type, String grade, String status)
        StudentAssesmentRecordM1 s=new StudentAssesmentRecordM1(Date.getValue(),
                Integer.parseInt(ScoreOfStudent.getText()),
                Course.getText(),
                Exam_Type.getValue(),
                Grade.getText(),
                Status.getValue());
        File f=new File("StudentAssesmentRecord.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try{
            if (f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);

            }
            oos.writeObject(s);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ExamEvaluatorDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void ShowOnTable(ActionEvent actionEvent) {
        File f=new File("Student_Assesment_Record.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    StudentAssesmentRecordM1 st=(StudentAssesmentRecordM1) ois.readObject();
                    Table.getItems().add(st);
                }
                catch (Exception e){
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}