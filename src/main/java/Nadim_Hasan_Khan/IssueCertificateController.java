package Nadim_Hasan_Khan;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class IssueCertificateController
{
    @javafx.fxml.FXML
    private ComboBox<String> Status;
    @javafx.fxml.FXML
    private TableColumn StudentCol;
    @javafx.fxml.FXML
    private TableColumn StatusCol;
    @javafx.fxml.FXML
    private TextField Program;
    @javafx.fxml.FXML
    private TableView Table;
    @javafx.fxml.FXML
    private TextField Cert_No;
    @javafx.fxml.FXML
    private TextField Student;
    @javafx.fxml.FXML
    private TableColumn CertNoCol;
    @javafx.fxml.FXML
    private TableColumn DateCol;
    @javafx.fxml.FXML
    private DatePicker Date;
    @javafx.fxml.FXML
    private TableColumn ProgramCol;

    @javafx.fxml.FXML
    public void initialize() {
        Status.getItems().addAll("Issued","Not Issued","Pending");
    }

    @javafx.fxml.FXML
    public void Proceed(ActionEvent actionEvent) {
    }
}