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

public class StudentFeeRecordsController
{
    @javafx.fxml.FXML
    private TableView<StudentFeeRecordsM1> Table;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,String> StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,Float> DueCol;
    @javafx.fxml.FXML
    private TextField Fee;
    @javafx.fxml.FXML
    private TextField Paid;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,Float> FeeCol;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TextField Due;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,String> CourseCol;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TableColumn<StudentFeeRecordsM1,Float> PaidCol;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private AnchorPane manpane;

    @javafx.fxml.FXML
    public void initialize() {
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        FeeCol.setCellValueFactory(new PropertyValueFactory<>("fee"));
        PaidCol.setCellValueFactory(new PropertyValueFactory<>("paid"));
        DueCol.setCellValueFactory(new PropertyValueFactory<>("due"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void Proceed(ActionEvent actionEvent) {
        //String student_id, String name, String course, float fee, float paid, float due, LocalDate date)
        StudentFeeRecordsM1 s=new StudentFeeRecordsM1(Student_Id.getText(),
                Name.getText(),
                Course.getText(),
                Float.parseFloat(Fee.getText()),
                Float.parseFloat(Paid.getText()),
                Float.parseFloat(Due.getText()),
                Date.getValue());
        File f=new File("StudentInfo.bin");
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
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        manpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void ShowOnTable(ActionEvent actionEvent) {
        File f=new File("StudentInfo.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    StudentFeeRecordsM1 st=(StudentFeeRecordsM1) ois.readObject();
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