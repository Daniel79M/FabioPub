module com.example.fabiopub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.fabiopub to javafx.fxml;
    exports com.example.fabiopub;
    opens com.example.fabiopub.controllers to javafx.fxml;
    exports com.example.fabiopub.controllers;
    opens com.example.fabiopub.Entity to javafx.fxml;
    exports com.example.fabiopub.Entity;
}