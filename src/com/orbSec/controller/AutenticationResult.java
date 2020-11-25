package com.orbSec.controller;

/**
 * @author Created by Petre Vane on 25/11/2020
 * @project EmailClient
 */
public enum AutenticationResult {
    SUCCESS,
    NO_NETWORK_RESPONSE,
    UNEXPECTED_ERROR,
    WRONG_CREDENTIALS;

    public String getDescription() {

        switch (this) {
            case SUCCESS: return "Logged in successfully";
            case WRONG_CREDENTIALS: return "Wrong user name or password";
            case NO_NETWORK_RESPONSE: return "No internet connection";
            case UNEXPECTED_ERROR: return "An unexpected error has occurred";
            default: return null;
        }

    }
}
