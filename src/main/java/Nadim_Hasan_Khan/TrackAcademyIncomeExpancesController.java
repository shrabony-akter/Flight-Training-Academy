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

public class TrackAcademyIncomeExpancesController
{
    @javafx.fxml.FXML
    private ComboBox<String> Type;
    @javafx.fxml.FXML
    private TableView<TrackAcademyIncomeExpancesM1> Table;
    @javafx.fxml.FXML
    private TextField Remarks;
    @javafx.fxml.FXML
    private TableColumn<TrackAcademyIncomeExpancesM1,Float> AmountCol;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TableColumn<TrackAcademyIncomeExpancesM1,String> TypeCol;
    @javafx.fxml.FXML
    private TableColumn<TrackAcademyIncomeExpancesM1,String> RemarksCol;
    @javafx.fxml.FXML
    private TableColumn<TrackAcademyIncomeExpancesM1, LocalDate> DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Type.getItems().addAll("Tution-fee","Donation");
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        RemarksCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
        File f=new File("TrackAcademyIncomeExpances.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    TrackAcademyIncomeExpancesM1 st=(TrackAcademyIncomeExpancesM1) ois.readObject();
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
    public void MakeReport(ActionEvent actionEvent) {
        //LocalDate date, float amount, String type, String remarks)
        TrackAcademyIncomeExpancesM1 tr=new TrackAcademyIncomeExpancesM1(Date.getValue(),
                Float.parseFloat(Amount.getText()),
                Type.getValue(),
                Remarks.getText());
        File f=new File("TrackAcademyIncomeExpances.bin");
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
            oos.writeObject(tr);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}