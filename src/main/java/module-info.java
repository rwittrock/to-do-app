module com.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.example.todoapp to javafx.fxml;
    exports com.example.todoapp;
}