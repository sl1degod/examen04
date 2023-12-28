package com.example.demo1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo1.Loader;
import com.example.demo1.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label error;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button reg;

    @FXML
    private AnchorPane root;

    DataBase dataBase = new DataBase();


    @FXML
    void initialize() {

        reg.setOnAction(e -> {
            validation();
        });
    }

    private void validation() {
        String name = firstName.getText();
        String lastname = lastName.getText();
        String login_ = login.getText();
        String password_ = password.getText();
        if (dataBase.check_login(login_) == 0) {
            error.setText("Пользователь с таким логином уже существует");
        } else {
            dataBase.createUser(name, lastname, login_, password_);
            new Loader().openNewScene(root, "/com/example/demo1/main.fxml", "Главный экран");
        }

    }

}
