package Nadim_Hasan_Khan;

import com.example.flighttrainingacademy.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.time.LocalDate;
import java.util.jar.Attributes;

public class GeneratePaymentReceiptController
{
    @javafx.fxml.FXML
    private TextField Receipt_Id;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextField Student_Name;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private ComboBox<String> Student_Label;
    @javafx.fxml.FXML
    private DatePicker Date;

    @javafx.fxml.FXML
    public void initialize() {
        Student_Label.getItems().addAll("Label-A","Label-B","Label-C");
    }

    @Deprecated
    public void Print(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("GeneratePaymentReceipt2.fxml"));
        Node node= fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @Deprecated
    public void Save(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void ShowReceiptOnTable(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void SaveAndVerification(ActionEvent actionEvent) {
        if (Integer.parseInt(Receipt_Id.getText())==0){
            ErrorAlert("Receipt id cannot be Zero");
            return;
        }
        if (Integer.parseInt(Student_Id.getText())==0){
            ErrorAlert("Student id cannot be Zero.");
        }
        if (Student_Name.getText().equals(null)){
            ErrorAlert("Student name cannot be null.");
            return;
        }
        if (Date.getValue().isBefore(LocalDate.now())){
            ErrorAlert("Date must be latest");
            return;
        }
        //int receipt_id, int student_id, String student_name, String student_label, LocalDate date
        GeneratePaymentReceiptM1 g=new GeneratePaymentReceiptM1(
                Integer.parseInt(Receipt_Id.getText()),
                Integer.parseInt(Student_Id.getText()),
                Student_Name.getText(),
                Student_Label.getValue(),
                Date.getValue());

        File f=new File("GeneratePaymentReceipt.bin");
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

    public void ErrorAlert(String e){
        Alert a=new Alert(Alert.AlertType.ERROR);
        a.setContentText(e);
        a.showAndWait();
    }
}