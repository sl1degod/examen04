package com.example.demo1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo1.database.DataBase;
import com.example.demo1.models.Courses;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Main {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> firstname;

    @FXML
    private TableColumn<?, ?> lastname;

    @FXML
    private TableColumn<?, ?> login;

    @FXML
    private TableColumn<?, ?> password;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Courses> tabelView;

    DataBase dataBase = new DataBase();

    @FXML
    void initialize() {
        firstname.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("price"));
        login.setCellValueFactory(new PropertyValueFactory<>("period_education"));
        password.setCellValueFactory(new PropertyValueFactory<>("curator"));
        tabelView.setItems(dataBase.getAllCourses());

    }

}
