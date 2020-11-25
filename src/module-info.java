module EmailClient {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.fxml;
    requires activation;
    requires java.mail;

    opens com.orbSec;
    opens com.orbSec.view;
    opens com.orbSec.controller;
}