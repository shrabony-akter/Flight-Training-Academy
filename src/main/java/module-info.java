module com.example.flighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.flighttrainingacademy to javafx.fxml;
    exports com.example.flighttrainingacademy;
    /*exports com.example.flighttrainingacademy.Shrabony_Akter;
    opens ShrabonyAkterStudentPilot to javafx.fxml;*/
}