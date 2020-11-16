package com.orbSec.view;

import com.orbSec.EmailManager;
import com.orbSec.constants.ColorThemes;
import com.orbSec.constants.FontSize;
import com.orbSec.controller.BaseController;
import com.orbSec.controller.LoginWindowController;
import com.orbSec.controller.MainWindowViewController;
import com.orbSec.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Coordinator {

    EmailManager emailManager;

    private String loginFxml = "LoginWindow.fxml";
    private String mainFxml = "MainWindow.fxml";
    private String optionsFxml = "OptionsWindow.fxml";
    private HashMap<String, Stage> activeStages = new HashMap<>();

    private ColorThemes colorThemes = ColorThemes.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public Coordinator(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    ///MARK: - Screen instantiation

    // Presents the login screen. This is called when the app starts
    public void presentLoginScreen() {
        System.out.println("Login screen presented");
        BaseController loginController = new LoginWindowController(emailManager, this, loginFxml);
        setStageFor(loginController);
    }

    // Presents the main window. This is called when authentication is successful
    public void presentMainScreen() {
        System.out.println("presetMainScreen method called");
        BaseController mainController = new MainWindowViewController(emailManager, this, mainFxml);
        setStageFor(mainController);
        removeStageForController(loginFxml);
    }

    // Presets option Screen
    public void presentOptionsScreen() {
        System.out.println("present options screen called");
        BaseController optionsController = new OptionsWindowController(emailManager, this, optionsFxml);
        setStageFor(optionsController);
    }

    // Dismisses the Options screen when user closes the window
    public void dismissOptionsScreen() {
        removeStageForController(optionsFxml);
    }


    ///MARK: - Stage configuration

    // Prepares the stage for the controller that calls this method
    private void setStageFor(BaseController controller) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        String controllerName = controller.getFxmlName();

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
        activeStages.put(controllerName, stage);
    }


    private void removeStageForController(String objectForKey) {

        // ensures there is an object for this key
        Stage stageToBeClosed = activeStages.get(objectForKey);
        if (stageToBeClosed != null) {
            activeStages.remove(objectForKey);
            stageToBeClosed.close();
            System.out.println("Stage removed and closed");
        }
    }

    ///MARK: -  Getters & Setters

    public ColorThemes getColorTheme() {
        return colorThemes;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

}
