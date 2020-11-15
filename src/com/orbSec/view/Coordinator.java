package com.orbSec.view;

import com.orbSec.EmailManager;
import com.orbSec.controller.BaseController;
import com.orbSec.controller.LoginWindowController;
import com.orbSec.controller.MainWindowViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    EmailManager emailManager;
    private String loginFxmlPath = "LoginWindow.fxml";
    private String mainFxmlPath = "MainWindow.fxml";

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void presentLoginScreen() {
        System.out.println("Login screen presented");
        BaseController loginController = new LoginWindowController(emailManager, this, loginFxmlPath);
        setStageFor(loginController);

    }

    public void presentMainScreen() {
        System.out.println("presetMainScreen method called");
        BaseController mainController = new MainWindowViewController(emailManager, this, mainFxmlPath);
        setStageFor(mainController);

    }

    private void setStageFor(BaseController controller) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

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
    }
}
