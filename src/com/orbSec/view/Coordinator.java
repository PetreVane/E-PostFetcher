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

/**
 * @author Created by Petre Vane
 * @project EmailClient
 */

public class Coordinator {

    EmailManager emailManager;

    private final String loginFxml = "LoginWindow.fxml";
    private final String mainFxml = "MainWindow.fxml";
    private final String optionsFxml = "OptionsWindow.fxml";
    private HashMap<String, Stage> activeStages = new HashMap<>();

    private ColorThemes colorThemes = ColorThemes.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public Coordinator(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    ///MARK: - Screen instantiation

    // Presents the login screen. This is called when the app starts
    public void presentLoginScreen() {
        BaseController loginController = new LoginWindowController(emailManager, this, loginFxml);
        setStageFor(loginController);
    }

    // Presents the main window. This is called when authentication is successful
    public void presentMainScreen() {
        BaseController mainController = new MainWindowViewController(emailManager, this, mainFxml);
        setStageFor(mainController);
        removeStageForController(loginFxml);
    }

    // Presets option Screen
    public void presentOptionsScreen() {
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
        }
    }

    public void updateStageStyle() {
        for(Stage stage: activeStages.values()) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            var size = getClass().getResource(fontSize.getFilePathFor(fontSize)).toExternalForm();
            var theme = getClass().getResource(colorThemes.getFilePathFor(colorThemes)).toExternalForm();
            scene.getStylesheets().add(size);
            scene.getStylesheets().add(theme);

        }
    }

    ///MARK: -  Getters & Setters

    // choiceBox
    public ColorThemes getColorTheme() {
        return colorThemes;
    }

    public void setColorThemes(ColorThemes value) {
        colorThemes = value;
    }

    // Slider
    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(int size) {
        fontSize = FontSize.values()[size];
    }

}
