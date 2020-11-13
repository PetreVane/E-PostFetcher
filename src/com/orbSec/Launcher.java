package com.orbSec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

//        FXMLLoader fXMLLoader;
        Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));

        // add panel to scene
        Scene scene = new Scene(parent); // 966, 786);

        // add scene to stage
        stage.setScene(scene);
        stage.setTitle("E-PostFetcher");

        // show the stage
        stage.show();

    }
}
