package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.view.Coordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Created by Petre Vane
 * @project EmailClient
 */

public class MainWindowViewController  extends BaseController implements Initializable {

    @FXML
    private TreeView<String> messagesTreeView;

    @FXML
    private TableView<?> messagesTableView;

    @FXML
    private WebView messageWebView;

    private String fxmlName;

    public MainWindowViewController(EmailManager emailManager, Coordinator coordinator, String fxmlName) {
        super(emailManager, coordinator, fxmlName);
    }


    @FXML
    void addNewAccountPressed(ActionEvent event) {
        System.out.println("New account pressed");
        coordinator.presentLoginScreen();
    }

    @FXML
    void openButtonPressed(ActionEvent event) {
        System.out.println("Open button pressed");

    }

    @FXML
    void optionButtonPressed(ActionEvent event) {
        System.out.println("Options button pressed");
        coordinator.presentOptionsScreen();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureMessagesTreeView();
    }

    private void configureMessagesTreeView() {
        messagesTreeView.setRoot(emailManager.getRootItem());
        // hide root dir because is empty
        messagesTreeView.setShowRoot(false);
    }
}
