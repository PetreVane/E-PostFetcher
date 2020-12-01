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

    private void presentDirectories(Folder[] directories, CustomTreeItem<String> rootDirectory) {
        for (Folder directory: directories) {
            CustomTreeItem<String> remoteDirTree = new CustomTreeItem<String>(directory.getName());
            rootDirectory.getChildren().add(remoteDirTree);
        }
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
