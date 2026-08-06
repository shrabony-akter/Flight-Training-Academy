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

public class ConductExamsController
{
    @javafx.fxml.FXML
    private TextField Exam_Id;
    @javafx.fxml.FXML
    private TextArea Time;
    @javafx.fxml.FXML
    private ComboBox<String> Course;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableView<ConductExamsM1> table;
    @javafx.fxml.FXML
    private TableColumn<ConductExamsM1,String> TimeCol;
    @javafx.fxml.FXML
    private TableColumn<ConductExamsM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn<ConductExamsM1,String> CourseCol;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TableColumn<ConductExamsM1,Integer> ExamIdCol;
    @javafx.fxml.FXML
    private TableColumn<ConductExamsM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Course.getItems().addAll("TakeOff","Flying","Landing");
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        ExamIdCol.setCellValueFactory(new PropertyValueFactory<>("exam_id"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
    }



    @javafx.fxml.FXML
    public void Attendance(ActionEvent actionEvent) {
        //int student_id, int exam_id, LocalDate date, String course, String time)
        ConductExamsM1 c=new ConductExamsM1(Integer.parseInt(Student_Id.getText()),
                Integer.parseInt(Exam_Id.getText()),
                Date.getValue(),
                Course.getValue(),
                Time.getText());


        File f=new File("Conduc_Exams.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try{
            if (f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(c);
            oos.close();

        }
        catch (Exception e){
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
    public void Load_To_Table(ActionEvent actionEvent) {
        File f=new File("StudentInfo.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ConductExamsM1 st=(ConductExamsM1) ois.readObject();
                    table.getItems().add(st);
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