package com.orbSec;

import com.orbSec.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.presentLoginScreen();

        /*
//        FXMLLoader fXMLLoader;
        Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));

        // add panel to scene
        Scene scene = new Scene(parent); // 966, 786);

        // add scene to stage
        stage.setScene(scene);
        stage.setTitle("E-PostFetcher");

        // show the stage
        stage.show();

         */

    }
}
