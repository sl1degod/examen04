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

public class AuthorizationController {

    @FXML
    private Button buttonRegistration;

    @FXML
    private Button buttonSignIn;

    @FXML
    private Label labelError;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private TextField textFieldPassword;
    DataBase dataBase = new DataBase();

    @FXML
    void initialize() {
        buttonSignIn.setOnAction(e -> {
            validation();
        });

        buttonRegistration.setOnAction(e -> {
            new Loader().openNewScene(root, "/com/example/demo1/registration.fxml", "Регистрация");
        });
    }

    private void validation() {
        String login = textFieldLogin.getText();
        String password = textFieldPassword.getText();
        int codeError = dataBase.signIn(login, password);
        if (login.isEmpty()) {
            labelError.setText("Введите логин");
        }
        else if (password.isEmpty()) {
            labelError.setText("Введите пароль");
        } else if (codeError == 0) {
            labelError.setText("Такого пользователя нет");
        } else {
            new Loader().openNewScene(root, "/com/example/demo1/main.fxml", "Главный экран");
        }
    }
}
