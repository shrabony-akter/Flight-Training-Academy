package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class ApproveCertificationEligibalityController
{
    @javafx.fxml.FXML
    private TextField Attendance;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,String> ProjectCol;
    @javafx.fxml.FXML
    private ComboBox<String> Action;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,Float> CGPACol;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,String> ActionCol;
    @javafx.fxml.FXML
    private TextField CGPA;
    @javafx.fxml.FXML
    private ComboBox<String> Eligible;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private ComboBox<String> Project;
    @javafx.fxml.FXML
    private TextField Credits;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,Integer> AttendanceCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,Integer> CreditsCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveCertificatonEligibalityM1,String> EligibleCol;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Project.getItems().addAll("Yes","NO");
        Eligible.getItems().addAll("Yes","No");
        Action.getItems().addAll("Certify","Not Certify");
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        CGPACol.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        CreditsCol.setCellValueFactory(new PropertyValueFactory<>("credit"));
        AttendanceCol.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        ProjectCol.setCellValueFactory(new PropertyValueFactory<>("project"));
        EligibleCol.setCellValueFactory(new PropertyValueFactory<>("eligible"));
        ActionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

    }

    @javafx.fxml.FXML
    public void Proceed_Report(ActionEvent actionEvent) {
        File f=new File("ApproveCertificationEligibality.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ApproveCertificatonEligibalityM1 a=(ApproveCertificatonEligibalityM1) ois.readObject();
                    Table.getItems().add(a);
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

    @javafx.fxml.FXML
    public void SaveInfo(ActionEvent actionEvent) {
        //int student_id, int attendance, int credit, String name, String project, String eligible, String action, float cgpa
        ApproveCertificatonEligibalityM1 a=new ApproveCertificatonEligibalityM1(Integer.parseInt(Student_Id.getText()),
                Integer.parseInt(Attendance.getText()),
                Integer.parseInt(Credits.getText()),
                Name.getText(),
                Project.getValue(),
                Eligible.getValue(),
                Action.getValue(),
                Float.parseFloat(CGPA.getText()));







        File f=new File("ApproveCertificationEligibality.bin");
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
}