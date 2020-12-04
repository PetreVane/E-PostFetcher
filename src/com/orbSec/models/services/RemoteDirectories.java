package com.orbSec.models.services;

import com.orbSec.models.CustomTreeItem;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

/**
 * @author Created by Petre Vane on 01/12/2020
 * @project EmailClient
 */

// Responsible for fetching remote directories
public class RemoteDirectories extends Service<Void> {

    private Store store;
    private CustomTreeItem<String> rootDirectory;

    public RemoteDirectories(Store store, CustomTreeItem<String> rootDirectory) {
        this.store = store;
        this.rootDirectory = rootDirectory;
    }

    private void fetchRemoteDirectories() throws MessagingException {
        Folder[] directories = store.getDefaultFolder().list();
        presentDirectories(directories, rootDirectory);
    }

    private void presentDirectories(Folder[] directories, CustomTreeItem<String> rootDirectory) throws MessagingException {
        for (Folder directory: directories) {
            CustomTreeItem<String> remoteDirTree = new CustomTreeItem<String>(directory.getName());
            rootDirectory.getChildren().add(remoteDirTree);
            rootDirectory.setExpanded(true);
            fetchEmailsForDirectory(directory, remoteDirTree);
            // check if a given directory contains sub-directories
            if (directory.getType() == Folder.HOLDS_FOLDERS) {
                // declare a placeholder for subdirectories
                Folder[] subDirectories = directory.list();
                // call the same procedure on subdirectories -> recursion
                presentDirectories(subDirectories, remoteDirTree);
            }
        }
    }

    // responsible for fetching messages from a given remote directory
    private void fetchEmailsForDirectory(Folder directory, CustomTreeItem<String> directoryTree) {
        Service fetchEmailsService = new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        // makes sure this is not a directory which has nested subdirectories
                        if(directory.getType() != Folder.HOLDS_FOLDERS) {
                            // folder.read_Write returns an int 🤨
                          directory.open(Folder.READ_WRITE);
                          int messagesCount = directory.getMessageCount();
                          for (int messageIndex = messagesCount; messageIndex > 0; messageIndex --) {
                              System.out.println(directory.getMessage(messageIndex).getSubject());
                          }
                        }
                        return null;
                    }
                };
            }
        };
        fetchEmailsService.start();
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                fetchRemoteDirectories();
                return null;
            }
        };
    }
}
