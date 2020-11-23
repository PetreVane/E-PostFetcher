package com.orbSec;

import com.orbSec.view.Coordinator;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Coordinator coordinator = new Coordinator(new EmailManager());
//        coordinator.presentOptionsScreen();
//        coordinator.updateStageStyle();
        coordinator.presentLoginScreen();
    }
}
