package com.orbSec.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.mail.Message;
import java.util.Date;

/**
 * @author Created by Petre Vane on 04/12/2020
 * @project EmailClient
 */

// Resembles a message object received from the remote email server
public class RemoteMessage {

    private SimpleStringProperty subject;
    private SimpleStringProperty sender;
    private SimpleStringProperty recipient;
    private SimpleIntegerProperty size;
    private SimpleObjectProperty<Date> date;
    private boolean isSeen;
    private Message message;

    public RemoteMessage(String subject, String sender, String recipient, int size, Date date, boolean isSeen, Message message) {
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.recipient = new SimpleStringProperty(recipient);
        this.size = new SimpleIntegerProperty(size);
        this.date = new SimpleObjectProperty(date);
        this.isSeen = isSeen;
        this.message = message;
    }


    public String getSubject() {
        return subject.get();
    }

    public String getSender() {
        return sender.get();
    }

    public String getRecipient() {
        return recipient.get();
    }

    public Integer getSize() {
        return size.get();
    }

    public Date getDate() {
        return date.get();
    }

    public boolean isSeen() {
        return isSeen;
    }
    public void setIsSeen(boolean seen) {
        isSeen = seen;
    }

    public Message getMessage() {
        return message;
    }

}
