module com.example.flighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.flighttrainingacademy to javafx.fxml;
    exports com.example.flighttrainingacademy;
    opens Shrabony ;
    exports Shrabony;
    opens Nadim to javafx.fxml;
    exports Nadim;
    opens Mahin to javafx.fxml;
    exports Mahin;

}