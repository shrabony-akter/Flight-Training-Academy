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

public class ApproveStudentPaymentRequestCnt
{
    @javafx.fxml.FXML
    private TableColumn<ApproveStudentPaymentRequestM1,String> StudentCol;
    @javafx.fxml.FXML
    private TextField Request_Id;
    @javafx.fxml.FXML
    private TableColumn<ApproveStudentPaymentRequestM1,String> CourseCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveStudentPaymentRequestM1,Float> AmountCol;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TextField Student;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private TableColumn<ApproveStudentPaymentRequestM1,Integer> RequestIdCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveStudentPaymentRequestM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableView<ApproveStudentPaymentRequestM1> Table;

    @javafx.fxml.FXML
    public void initialize() {
        RequestIdCol.setCellValueFactory(new PropertyValueFactory<>("request_id"));
        StudentCol.setCellValueFactory(new PropertyValueFactory<>("student"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
        File f=new File("ApprovePaymentRequest.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try {
                    ApproveStudentPaymentRequestM1 a=(ApproveStudentPaymentRequestM1) ois.readObject();
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
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void SaveInfo(ActionEvent actionEvent) {
        //int request_id, String student, String course, float amount, LocalDate date)
        ApproveStudentPaymentRequestM1 a=new ApproveStudentPaymentRequestM1(Integer.parseInt(Request_Id.getText()),
                Student.getText(),
                Course.getText(),
                Float.parseFloat(Amount.getText()),
                Date.getValue());





        File f=new File("ApprovePaymentRequest.bin");
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