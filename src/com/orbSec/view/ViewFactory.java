package com.orbSec.view;

import com.orbSec.EmailManager;
import com.orbSec.controller.BaseController;
import com.orbSec.controller.LoginWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    EmailManager emailManager;
    private String fxmlPath = "LoginWindow.fxml";

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void presentLoginScreen() {
        System.out.println("Login screen presented");
        BaseController loginController = new LoginWindowController(emailManager, this, fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(loginController.getFxmlName()));
        fxmlLoader.setController(loginController);

        Parent parent;

        try {
            parent = fxmlLoader.load();

        } catch (IOException exception) {
            System.out.println("Exeption thrown: " + exception.getMessage());
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        // <!--        fx:controller="com.orbSec.controller.LoginWindowController"-->
    }
}
