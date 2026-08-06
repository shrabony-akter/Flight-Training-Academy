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

public class ScheduleExaminationsController
{
    @javafx.fxml.FXML
    private TextField Total_Marks;
    @javafx.fxml.FXML
    private DatePicker Exam_Date;
    @javafx.fxml.FXML
    private TextField Duration;
    @javafx.fxml.FXML
    private TextField Time;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private ComboBox<String> Exam_Type;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1, LocalDate> TimeCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1,String> CourseCol;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1,String> DurationCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1,LocalDate> ExamDateCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1,Float> TotalMarksCol;
    @javafx.fxml.FXML
    private TableColumn<ScheduleExaminationsM1,String> ExamTypeCol;
    @javafx.fxml.FXML
    private TableView<ScheduleExaminationsM1> table;

    @javafx.fxml.FXML
    public void initialize() {
        Exam_Type.getItems().addAll("Written","Practical");
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        ExamDateCol.setCellValueFactory(new PropertyValueFactory<>("exam_date"));
        ExamTypeCol.setCellValueFactory(new PropertyValueFactory<>("exam_type"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        DurationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        TotalMarksCol.setCellValueFactory(new PropertyValueFactory<>("total_marks"));

    }

    @javafx.fxml.FXML
    public void Cancel(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Update(ActionEvent actionEvent) {
        File f=new File("StudentInfo.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ScheduleExaminationsM1 st=(ScheduleExaminationsM1) ois.readObject();
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

    @javafx.fxml.FXML
    public void Schedule_Exam(ActionEvent actionEvent) {
        //String course, String exam_type, String time, String duration, LocalDate exam_date, int total_marks
        ScheduleExaminationsM1 s=new ScheduleExaminationsM1(Course.getText(),
                Exam_Type.getValue(),
                Time.getText(),
                Duration.getText(),
                Exam_Date.getValue(),
                Integer.parseInt(Total_Marks.getText()));

        File f=new File("Schedule_Exam.bin");
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
}