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

public class ManageBudgetController
{
    @javafx.fxml.FXML
    private ComboBox<String> Department;
    @javafx.fxml.FXML
    private TableColumn<ManageBudgetM1,String> DepartmentCol;
    @javafx.fxml.FXML
    private TableColumn<ManageBudgetM1,Float> RemainingCol;
    @javafx.fxml.FXML
    private TableColumn<ManageBudgetM1,Float> AllocatedCol;
    @javafx.fxml.FXML
    private TextField Spent;
    @javafx.fxml.FXML
    private TableColumn<ManageBudgetM1,Float> SpentCol;
    @javafx.fxml.FXML
    private TextField Remaining;
    @javafx.fxml.FXML
    private TextField Allocated;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableView<ManageBudgetM1> Table;

    @javafx.fxml.FXML
    public void initialize() {
        Department.getItems().addAll("Academic","Ground","Traffic","Register");
        DepartmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        AllocatedCol.setCellValueFactory(new PropertyValueFactory<>("allocated"));
        SpentCol.setCellValueFactory(new PropertyValueFactory<>("spent"));
        RemainingCol.setCellValueFactory(new PropertyValueFactory<>("remaining"));
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
        File f=new File("StudentInfo.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try{
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try{
                    ManageBudgetM1 st=(ManageBudgetM1) ois.readObject();
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
        //String department, float allocated, float spent, float remaining
        ManageBudgetM1 m=new ManageBudgetM1(Department.getValue(),
                Float.parseFloat(Allocated.getText()),
                Float.parseFloat(Spent.getText()),
                Float.parseFloat(Remaining.getText()));



        File f=new File("Manage_Budget.bin");
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