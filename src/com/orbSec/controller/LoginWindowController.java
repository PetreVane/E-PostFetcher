package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.models.EmailAccount;
import com.orbSec.models.services.AuthenticationService;
import com.orbSec.view.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * @author Created by Petre Vane
 * @project EmailClient
 */

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
        setDefaultCredentials();
        System.out.println(" Login button pressed");
        String userEmailAddress = emailTextField.getText();
        String userPassword = passTextField.getText();

        authenticateWithCredentials(userEmailAddress, userPassword);
        errorLabel.setText(" ");
    }

    private boolean userInputIsValid(String userName, String password) {

        if (userName.isEmpty() ) {
            errorLabel.setText("Email address is missing !");
            return false;
        } else if (password.isEmpty()) {
            errorLabel.setText("Password is missing !");
            return false;
        }
        return true;
    }

    private void authenticateWithCredentials(String userEmailAddress, String userPassword) {

        if (userInputIsValid(userEmailAddress, userPassword)) {

            AuthenticationService authService = new AuthenticationService(new EmailAccount(userEmailAddress, userPassword), emailManager);
            /* multi threaded authentication */
            authService.start();
            authService.setOnSucceeded(event -> {

                switch (authService.getValue()) {

                    case SUCCESS:
                        System.out.println("User logged in successfully with email " + userEmailAddress);
                        System.out.println(AutenticationResult.SUCCESS.getDescription());
                        coordinator.presentMainScreen();
                        break;

                    case UNEXPECTED_ERROR:
                        System.out.println("Unexpected error " + AutenticationResult.UNEXPECTED_ERROR.getDescription());
                        break;

                    case WRONG_CREDENTIALS:
                        System.out.println("Wrong credentials " + AutenticationResult.WRONG_CREDENTIALS.getDescription());
                        break;

                    case NO_NETWORK_RESPONSE:
                        System.out.println("No network response " + AutenticationResult.NO_NETWORK_RESPONSE.getDescription());
                        break;
                }
            });
        }
    }

  
}
