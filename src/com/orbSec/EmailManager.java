package com.orbSec;


import com.orbSec.models.CustomTreeItem;
import com.orbSec.models.EmailAccount;
import com.orbSec.models.services.RemoteDirectories;


/**
 * @author Created by Petre Vane on 25/11/2020
 * @project EmailClient
 */


// Class responsible with presenting email directories
public class EmailManager {

   private CustomTreeItem<String> rootDirectory = new CustomTreeItem<String>("");

   public CustomTreeItem<String> getRootItem() {
       return rootDirectory;
   }

   public void presentEmailAccountDirectories(EmailAccount account) {
       CustomTreeItem<String> inboxDirectory = new CustomTreeItem<String>(account.getEmailAddress());
       RemoteDirectories loader = new RemoteDirectories(account.getStore(), inboxDirectory);
       loader.start();
       rootDirectory.getChildren().add(inboxDirectory);
   }
}
