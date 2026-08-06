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

public class ManageOutstandingDuesController
{
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1,String> StatusCol;
    @javafx.fxml.FXML
    private TableView<ManageOutstandingM1> Table;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1,Integer> StudentIdCol;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1, LocalDate> LastPayCol;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1,String> NameCol;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1,Float> ToalDuecol;
    @javafx.fxml.FXML
    private TextField Total_Due;
    @javafx.fxml.FXML
    private TableColumn<ManageOutstandingM1,String> CourseCol;
    @javafx.fxml.FXML
    private TextField Student_Id;
    @javafx.fxml.FXML
    private TextField Course;
    @javafx.fxml.FXML
    private DatePicker Last_Pay;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Paid","Not paid");
        StudentIdCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        CourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        ToalDuecol.setCellValueFactory(new PropertyValueFactory<>("total_due"));
        LastPayCol.setCellValueFactory(new PropertyValueFactory<>("last_pay"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
        File f=new File("Manage_Outstanding.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ManageOutstandingM1 st=(ManageOutstandingM1) ois.readObject();
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
        //int student_id, String name, String course, String status, float total_due, LocalDate last_pay
        ManageOutstandingM1 m=new ManageOutstandingM1(Integer.parseInt(Student_Id.getText()),
                Name.getText(),
                Course.getText(),
                Status.getValue(),
                Float.parseFloat(Total_Due.getText()),
                Last_Pay.getValue());
        File f=new File("Manage_Outstanding.bin");
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
            oos.writeObject(m);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}