package com.orbSec.models;

import javax.mail.Store;
import java.util.Properties;

/**
 * @author Created by Petre Vane on 25/11/2020
 * @project EmailClient
 */


// Responsible for configuring email Accounts
public class EmailAccount {

    private String emailAddress;
    private String password;
    private Properties properties;
    private Store store;


    public EmailAccount( String emailAddress, String password ) {
        this.emailAddress = emailAddress;
        this.password = password;
        configureProperties();
    }


    private void configureProperties() {
        properties = new Properties();
        properties.put("incomingHost", "imap.gmail.com");
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("outgoingHost", "smtp.gmail.com");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
