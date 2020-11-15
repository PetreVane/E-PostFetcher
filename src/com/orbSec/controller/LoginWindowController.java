package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.view.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController extends BaseController {


    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, Coordinator coordinator, String fxmlName) {
        super(emailManager, coordinator, fxmlName);
    }

    @FXML
    void loginButtonPressed() {
        System.out.println("Button pressed, yeeei");
        String userName = emailTextField.getText();
        String password = passTextField.getText();
        errorLabel.setText(" ");

        if (userName.isEmpty() ) {
            errorLabel.setText("Email address is missing !");
            return;
        } else if (password.isEmpty()) {
            errorLabel.setText("Password is missing !");
            return;
        }

        coordinator.presentMainScreen();


    }

    private void setEmailTextField() {
        emailTextField.setPromptText("This is a prompt");
    }


}
