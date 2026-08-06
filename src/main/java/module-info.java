module com.example.flighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires com.example.flighttrainingacademy;


    opens com.example.flighttrainingacademy to javafx.fxml;
    exports com.example.flighttrainingacademy;
    opens Shrabony ;
    exports Shrabony;
    opens Nadim_Hasan_Khan to javafx.fxml;
    exports Nadim_Hasan_Khan;
    opens Mahin to javafx.fxml;
    exports Mahin;

}