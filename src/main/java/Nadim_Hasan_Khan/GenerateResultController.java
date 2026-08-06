package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class GenerateResultController
{
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,String> StatusCol;
    @javafx.fxml.FXML
    private TableView<GenerateResultM1> Table;
    @javafx.fxml.FXML
    private TextField Position;
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TextField Grade;
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,Integer> TotalCol;
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,String> PositionCol;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TextField Total;
    @javafx.fxml.FXML
    private TableColumn<GenerateResultM1,String> GradeCol;
    @javafx.fxml.FXML
    private Label Output;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private ComboBox<String> Status;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Passed","Failed");
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        GradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        PositionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void Download_Pdf(ActionEvent actionEvent) {
        File f=new File("Generate_Result.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    GenerateResultM1 st=(GenerateResultM1) ois.readObject();
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
    public void Generate_Result(ActionEvent actionEvent) {
        //int student_id, int total, String name, String grade, String position, String status)
        GenerateResultM1 g=new GenerateResultM1(Integer.parseInt(Student_Id.getText()),
                Integer.parseInt(Total.getText()),
                Name.getText(),
                Grade.getText(),
                Position.getText(),
                Status.getValue());

        File f=new File("Generate_Result.bin");
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
            oos.writeObject(g);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void EmailToStudent(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ExamEvaluatorDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }
}