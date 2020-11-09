package com.orbSec.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ViewOne {


    public Button button;

    public void configureButton() {
        button = new Button();
        button.setText("Log in");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login button pressed");
            }
        });

//         add panel which holds your objects together
        StackPane pane = new StackPane();

        // add button to panel
        pane.getChildren().add(button);
    }

    @FXML
    public void buttonClicked() {
        System.out.println("Button clicked");
    }


    //        Button button = new Button();
//        button.setText("Click me");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Button clicked");
//            }
//        });
//
//        // add panel which holds your objects together
//        StackPane pane = new StackPane();
//
//        // add button to panel
//        pane.getChildren().add(button);
}
