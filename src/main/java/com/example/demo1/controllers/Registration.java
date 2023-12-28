package com.example.demo1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo1.Loader;
import com.example.demo1.database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    private TextField secondName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;


    @FXML
    private TextField email;

    @FXML
    private Button reg;

    @FXML
    private AnchorPane root;

    DataBase dataBase = new DataBase();


    @FXML
    void initialize() {
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z0-9]*")) {
                password.setText(newValue.replaceAll("[^a-zA-Z0-9]", ""));
            }
        });

        reg.setOnAction(e -> {
            validation();
        });
    }

    private void validation() {
        String name = firstName.getText();
        String secondname = secondName.getText();
        String lastname = lastName.getText();
        String email_ = email.getText();
        String login_ = login.getText();
        String password_ = password.getText();


        if (dataBase.check_login(login_) == 0) {
            error.setText("Пользователь с таким логином уже существует");
        } else if (password.getLength() < 8) {
            error.setText("Пароль должен быть не менее 8 символов");
        }
        else {
            dataBase.createUser(name, secondname, lastname, email_, login_, password_);
            new Loader().openNewScene(root, "/com/example/demo1/authorization.fxml", "Главный экран");
        }
    }

}
