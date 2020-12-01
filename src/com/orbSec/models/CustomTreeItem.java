package com.orbSec.models;

import javafx.scene.control.TreeItem;

/**
 * @author Created by Petre Vane on 01/12/2020
 * @project EmailClient
 */
public class CustomTreeItem<String> extends TreeItem<String> {

    private String name;

    public CustomTreeItem(String name) {
        super(name);
        this.name = name;
    }

}
