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
import java.util.ArrayList;

public class Coordinator {

    EmailManager emailManager;
    private String loginFxmlPath = "LoginWindow.fxml";
    private String mainFxmlPath = "MainWindow.fxml";
    private ArrayList<Stage> activeStages = new ArrayList<>();

    public Coordinator(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void presentLoginScreen() {
        System.out.println("Login screen presented");
        BaseController loginController = new LoginWindowController(emailManager, this, loginFxmlPath);
        setStageFor(loginController);
        System.out.println("Your array contains " + activeStages.size() + " stage");
    }

    public void presentMainScreen() {
        System.out.println("presetMainScreen method called");
        BaseController mainController = new MainWindowViewController(emailManager, this, mainFxmlPath);
        setStageFor(mainController);
        System.out.println("Your array now contains " + activeStages.size() + " stages");
        closeStage(activeStages.get(0));
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
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToBeClosed) {
        if (activeStages.contains(stageToBeClosed)) {
            activeStages.remove(stageToBeClosed);
            System.out.println("Stage has been removed from list");
            stageToBeClosed.close();
            System.out.println("Stage has been closed");

        } else {
            System.out.println("Your array does not contain this stage");
            System.out.println("Stages so far: " + activeStages.size());
        }
    }
}
