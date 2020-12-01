package com.orbSec.models.services;

import com.orbSec.EmailManager;
import com.orbSec.controller.AutenticationResult;
import com.orbSec.models.EmailAccount;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.*;

/**
 * @author Created by Petre Vane on 25/11/2020
 * @project EmailClient
 */
public class AuthenticationService extends Service<AutenticationResult> {

    EmailAccount emailAccount;
    EmailManager emailManager;

    public AuthenticationService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    private AutenticationResult logUserIn() {

        // Anonymous authenticator object from java mail
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount.getEmailAddress(), emailAccount.getPassword());
            }
        };

        try {
            // 1. declare a new session
            Session session = Session.getInstance(emailAccount.getProperties(), authenticator);

            // 2. get a new store from session
            Store store = session.getStore("imap");

            // 3. initialise a new connection using the store
            store.connect(emailAccount.getProperties().getProperty("incomingHost"), emailAccount.getEmailAddress(), emailAccount.getPassword());

            // 4. pass this store to your emailAccount object.
            // Remember to add a catch clause which handles the case where typed in credentials are wrong.
            emailAccount.setStore(store);


        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return AutenticationResult.NO_NETWORK_RESPONSE;

        } catch (AuthenticationFailedException e) {
            e.printStackTrace();
            return AutenticationResult.WRONG_CREDENTIALS;

        } catch (MessagingException e) {
            e.printStackTrace();
            return AutenticationResult.UNEXPECTED_ERROR;

        } catch (Exception e) {
            e.printStackTrace();
            return AutenticationResult.UNEXPECTED_ERROR;
        }

        return AutenticationResult.SUCCESS;
    }

    @Override
    protected Task<AutenticationResult> createTask() {
        return new Task<AutenticationResult>() {
            @Override
            protected AutenticationResult call() throws Exception {
                return logUserIn();
            }
        };
    }
}
