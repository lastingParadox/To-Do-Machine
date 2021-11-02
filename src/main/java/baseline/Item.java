/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDate;

public class Item {

    private String description;
    private String dueDate;
    private SimpleBooleanProperty completed = new SimpleBooleanProperty(false);

    //Item Constructor for the GUI:
    Item(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate.toString();
    }

    //Item Constructor for FileImport:
    Item(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    //Item Constructor for only a description being provided:
    Item(String description) {
        this.description = description;
    }

    //Getters
    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    //Used in changing the value of completed through the completed tableColumn
    public SimpleBooleanProperty getCompleted() {
        return completed;
    }

    public boolean getCompletedValue() {
        return completed.getValue();
    }

    //Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    //Used to change dueDate through a LocalDate format
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate.toString();
    }

    public void setCompleted(SimpleBooleanProperty completed) {
        this.completed = completed;
    }
}
