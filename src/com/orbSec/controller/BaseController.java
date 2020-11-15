package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.view.Coordinator;

public abstract class BaseController {

    protected EmailManager emailManager;
    protected Coordinator coordinator;
    private String fxmlName;


    public BaseController(EmailManager emailManager, Coordinator coordinator, String fxmlName) {
        this.emailManager = emailManager;
        this.coordinator = coordinator;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
