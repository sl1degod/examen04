module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires java.sql;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.controllers;
    opens com.example.demo1.controllers to javafx.fxml;
    exports com.example.demo1.models;
    opens com.example.demo1.models to java.base;
}