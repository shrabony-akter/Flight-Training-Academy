package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class TrackAcademyIncomeExpancesController
{
    @javafx.fxml.FXML
    private ComboBox Type;
    @javafx.fxml.FXML
    private ComboBox Category;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TableColumn CategoryCol;
    @javafx.fxml.FXML
    private TextField Remarks;
    @javafx.fxml.FXML
    private TableColumn AmountCol;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TableColumn TypeCol;
    @javafx.fxml.FXML
    private TableColumn RemarksCol;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void Add_To_Table(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Go_Back(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FinanceOfficerDashboard.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }
}