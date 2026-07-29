package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ProcessFeePaymentsController
{
    @javafx.fxml.FXML
    private TextField Payment_Id;
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn StudentCol;
    @javafx.fxml.FXML
    private TableColumn StatusCol;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TextField Amount;
    @javafx.fxml.FXML
    private TextField Student;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn PaymentIdCol;
    @javafx.fxml.FXML
    private TableColumn CourseCol;
    @javafx.fxml.FXML
    private TableColumn AmountCol;
    @javafx.fxml.FXML
    private TextField Course;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Paid","Pending","Unpaid");
    }

    @javafx.fxml.FXML
    public void AddToReport(ActionEvent actionEvent) {
    }
}