package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;

public class EvaluatePerformanceController
{
    @javafx.fxml.FXML
    private TextField Score;
    @javafx.fxml.FXML
    private TableView<EvaluatePerformanceM1> Table;
    @javafx.fxml.FXML
    private TableColumn<EvaluatePerformanceM1,String> CourseCol;
    @javafx.fxml.FXML
    private TableColumn<EvaluatePerformanceM1,Integer> IdCol;
    @javafx.fxml.FXML
    private TableColumn<EvaluatePerformanceM1,Integer> ScoreCol;
    @javafx.fxml.FXML
    private DatePicker Exam_Date;
    @javafx.fxml.FXML
    private TextField Id;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private TableColumn<EvaluatePerformanceM1, LocalDate> ExamDateCol;
    @javafx.fxml.FXML
    private TableColumn<EvaluatePerformanceM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        ScoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        ExamDateCol.setCellValueFactory(new PropertyValueFactory<>("exam_date"));
    }

    @javafx.fxml.FXML
    public void Send_To_Student(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Save_Evaluation(ActionEvent actionEvent) {
        //String name, String course, int id, int score, LocalDate exam_date)
        EvaluatePerformanceM1 e=new EvaluatePerformanceM1(Name.getText(),
                Course.getText(),
                Integer.parseInt(Id.getText()),
                Integer.parseInt(Score.getText()),
                Exam_Date.getValue());
        File f=new File("Evaluate_performance.bin");
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
            oos.writeObject(e);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void Print_Report(ActionEvent actionEvent) {
        File f=new File("Evaluate_Performance.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    EvaluatePerformanceM1 st=(EvaluatePerformanceM1) ois.readObject();
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

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ExamEvaluatorDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }
}