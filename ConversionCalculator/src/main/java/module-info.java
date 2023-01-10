module com.example.converterupdated {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.converterupdated to javafx.fxml;
    exports com.example.converterupdated;
}