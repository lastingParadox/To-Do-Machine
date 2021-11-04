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
    private final SimpleBooleanProperty completed = new SimpleBooleanProperty(false);

    //Item Constructor for the Import:
    Item(String description, String dueDate, boolean completed) {
        this.description = description;
        if (dueDate.equals("null"))
            this.dueDate = "";
        else
            this.dueDate = dueDate;
        this.completed.setValue(completed);
    }

    //ItemConstructor for the GUI:
    Item(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = String.valueOf(dueDate);
    }

    //Item Constructor for testing:
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

    public void setCompleted(boolean completed) {
        this.completed.setValue(completed);
    }

}
