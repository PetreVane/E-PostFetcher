package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.view.Coordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowViewController  extends BaseController {

    @FXML
    private TreeView<?> messagesTreeView;

    @FXML
    private TableView<?> messagesTableView;

    @FXML
    private WebView messageWebView;

    private String fxmlName;

    public MainWindowViewController(EmailManager emailManager, Coordinator coordinator, String fxmlName) {
        super(emailManager, coordinator, fxmlName);
    }


    @FXML
    void optionButtonPressed(ActionEvent event) {
        System.out.println("Option button pressed");
        coordinator.presentOptionsScreen();
    }
}
