package com.orbSec.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowViewController {

    @FXML
    private TreeView<?> messagesTreeView;

    @FXML
    private TableView<?> messagesTableView;

    @FXML
    private WebView messageWebView;

    @FXML
    void optionButtonPressed(ActionEvent event) {
        System.out.println("Option button pressed");
    }
}
