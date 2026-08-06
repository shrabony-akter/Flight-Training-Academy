package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class AssignGradesController
{
    @javafx.fxml.FXML
    private TableView<AssignGradesM1> Table;
    @javafx.fxml.FXML
    private TextField Theory;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> TotalCol;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> VivaCol;
    @javafx.fxml.FXML
    private TextField Viva;
    @javafx.fxml.FXML
    private TextField Student_ID;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> TheoryCol;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> GradeCol;
    @javafx.fxml.FXML
    private TextField Practical;
    @javafx.fxml.FXML
    private TableColumn<AssignGradesM1,Integer> PracticalCol;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextField Grade;
    @javafx.fxml.FXML
    private TextField Total;

    @javafx.fxml.FXML
    public void initialize() {
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TheoryCol.setCellValueFactory(new PropertyValueFactory<>("theory"));
        PracticalCol.setCellValueFactory(new PropertyValueFactory<>("practical"));
        VivaCol.setCellValueFactory(new PropertyValueFactory<>("viva"));
        TotalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        GradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
    }

    @Deprecated
    public void Save_Report(ActionEvent actionEvent) {
        //int student_id, int theory, int practical, int viva, int total, String name, String grade
        AssignGradesM1 a=new AssignGradesM1(Integer.parseInt(Student_ID.getText()),
                Integer.parseInt(Theory.getText()),
                Integer.parseInt(Practical.getText()),
                Integer.parseInt(Viva.getText()),
                Integer.parseInt(Total.getText()),
                Name.getText(),
                Grade.getText());

        File f=new File("AssignGrades.bin");
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
            oos.writeObject(a);
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
    public void Submit_Grade(ActionEvent actionEvent) {
        File f=new File("AssignGrades.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    AssignGradesM1 a=(AssignGradesM1) ois.readObject();
                    Table.getItems().add(a);
                }
                catch (Exception e){
                    break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}