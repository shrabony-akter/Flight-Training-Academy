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

public class ProcessFeePaymentsController
{
    @javafx.fxml.FXML
    private TextField Payment_Id;
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1,String> StudentCol;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1,String> StatusCol;
    @javafx.fxml.FXML
    private TableView<ProcessFeePaymentsM1> Table;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TextField Student;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1,Integer> PaymentIdCol;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1,String> CourseCol;
    @javafx.fxml.FXML
    private TableColumn<ProcessFeePaymentsM1,Float> AmountCol;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Paid","Pending","Unpaid");
        PaymentIdCol.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        StudentCol.setCellValueFactory(new PropertyValueFactory<>("student"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void AddToReport(ActionEvent actionEvent) {
        File f=new File("ProcessFeePayment.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ProcessFeePaymentsM1 st=(ProcessFeePaymentsM1) ois.readObject();
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
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void Save(ActionEvent actionEvent) {

        //int payment_id, String student, String course, String status, float amount, LocalDate date)
        ProcessFeePaymentsM1 p=new ProcessFeePaymentsM1(Integer.parseInt(Payment_Id.getText()),
                Student.getText(),
                Course.getText(),
                Status.getValue(),
                Float.parseFloat(Amount.getText()),
                Date.getValue());

        File f=new File("ProcessFeePayment.bin");
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
            oos.writeObject(p);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}