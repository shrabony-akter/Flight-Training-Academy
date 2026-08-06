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

public class PrepareFinancialReportsController
{
    @javafx.fxml.FXML
    private ComboBox<String> Type;
    @javafx.fxml.FXML
    private TextField Description;
    @javafx.fxml.FXML
    private TableView<PrepareFinancialReportsM1> Table;
    @javafx.fxml.FXML
    private TableColumn<PrepareFinancialReportsM1,String> DescriptionCol;
    @javafx.fxml.FXML
    private TableColumn<PrepareFinancialReportsM1,Float> AmountCol;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TableColumn<PrepareFinancialReportsM1,String> TypeCol;
    @javafx.fxml.FXML
    private TableColumn<PrepareFinancialReportsM1,Float> BalanceCol;
    @javafx.fxml.FXML
    private TextField Balance;
    @javafx.fxml.FXML
    private TableColumn<PrepareFinancialReportsM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Type.getItems().addAll("Monthly","Yearly");
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        DescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        BalanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
    }

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void Save(ActionEvent actionEvent) {
        //LocalDate date, String description, String type, float amount, float balance)
        PrepareFinancialReportsM1 p=new PrepareFinancialReportsM1(Date.getValue(),
                Description.getText(),
                Type.getValue(),
                Float.parseFloat(Amount.getText()),
                Float.parseFloat(Balance.getText()));

        File f=new File("PrepareFinancialReports.bin");
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

    @javafx.fxml.FXML
    public void AddToTable(ActionEvent actionEvent) {
        File f=new File("StudentInfo.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    PrepareFinancialReportsM1 st=(PrepareFinancialReportsM1) ois.readObject();
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