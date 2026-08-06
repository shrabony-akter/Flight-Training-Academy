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

public class IssueCertificateController
{
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn<IssueCertificateM1,String> StudentCol;
    @javafx.fxml.FXML
    private TableColumn<IssueCertificateM1,String> StatusCol;
    @javafx.fxml.FXML
    private TextField Program;
    @javafx.fxml.FXML
    private TableView<IssueCertificateM1> Table;
    @javafx.fxml.FXML
    private TextField Cert_No;
    @javafx.fxml.FXML
    private TextField Student;
    @javafx.fxml.FXML
    private TableColumn<IssueCertificateM1,Integer> CertNoCol;
    @javafx.fxml.FXML
    private TableColumn<IssueCertificateM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn<IssueCertificateM1,String> ProgramCol;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {

        Status.getItems().addAll("Issued","Not Issued","Pending");
        CertNoCol.setCellValueFactory(new PropertyValueFactory<>("cert_no"));
        StudentCol.setCellValueFactory(new PropertyValueFactory<>("student"));
        ProgramCol.setCellValueFactory(new PropertyValueFactory<>("program"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void Proceed(ActionEvent actionEvent) {
        //int cert_no, String student, String program, String status, LocalDate date
        IssueCertificateM1 i=new IssueCertificateM1(Integer.parseInt(Cert_No.getText()),
                Student.getText(),
                Program.getText(),
                Status.getValue(),
                Date.getValue());
        File f=new File("Issue_Certificate.bin");
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
            oos.writeObject(i);
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
        File f=new File("Issue_Certificate.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    IssueCertificateM1 st=(IssueCertificateM1) ois.readObject();
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