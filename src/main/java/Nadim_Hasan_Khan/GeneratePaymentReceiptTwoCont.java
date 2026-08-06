package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class GeneratePaymentReceiptTwoCont
{

    @javafx.fxml.FXML
    private ComboBox<String> StudentLabelFilter;
    @javafx.fxml.FXML
    private TableColumn<GeneratePaymentReceiptM1,String> StudentLabelCol;
    @javafx.fxml.FXML
    private TableView<GeneratePaymentReceiptM1> Table;
    @javafx.fxml.FXML
    private TableColumn<GeneratePaymentReceiptM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TextField StudentIdFiter;
    @javafx.fxml.FXML
    private TableColumn<GeneratePaymentReceiptM1,String> StudentNameCol;
    @javafx.fxml.FXML
    private TableColumn<GeneratePaymentReceiptM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private TableColumn<GeneratePaymentReceiptM1,Integer> ReceiptIdCol;

    @javafx.fxml.FXML
    public void initialize() {
        StudentLabelFilter.getItems().addAll("Label-A","Label-B","Label-C");
        ReceiptIdCol.setCellValueFactory(new PropertyValueFactory<>("receipt_id"));
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        StudentNameCol.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        StudentLabelCol.setCellValueFactory(new PropertyValueFactory<>("student_label"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void LoadTheTable(ActionEvent actionEvent) {

        File f=new File("GeneratePaymentReceipt2.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    GeneratePaymentReceiptM1 st=(GeneratePaymentReceiptM1) ois.readObject();
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