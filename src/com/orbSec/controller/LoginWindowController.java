package com.orbSec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {


    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private Label errorLabel;

    @FXML
    void loginButtonPressed() {
        System.out.println("Button pressed, yeeei");
        System.out.println("Email textField: " + emailTextField.getText());
        System.out.println("Pass: " + passTextField.getText());
    }

    private void setEmailTextField() {
        emailTextField.setPromptText("This is a prompt");
    }

}
