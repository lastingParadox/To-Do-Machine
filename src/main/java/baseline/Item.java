/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDate;

public class Item {

    //Create new private String description
    //Create new private String dueDate
    //Create new private SimpleBooleanProperty completed

    //Item Constructor for the GUI:
    Item(String description, LocalDate dueDate) {
        //this description is equal to description
        //this dueDate is equal to the string value of dueDate
    }

    //Item Constructor for FileImport:
    Item(String description, String dueDate) {
        //this description is equal to description
        //this dueDate is equal to dueDate
    }

    //Item Constructor for only a description being provided:
    Item(String description) {
        //this description is equal to description
    }

    //Getters
    public String getDescription() {
        //return description
        return null;
    }

    public String getDueDate() {
        //return dueDate
        return null;
    }

    //Used in changing the value of completed through the completed tableColumn
    public SimpleBooleanProperty getCompleted() {
        //returns completed
        return null;
    }

    public boolean getCompletedValue() {
        //returns the boolean value of completed
        return false;
    }

    //Setters
    public void setDescription(String description) {
        //this description is equal to description
    }

    public void setDueDate(String dueDate) {
        //this dueDate is equal to dueDate
    }

    //Used to change dueDate through a LocalDate format
    public void setDueDate(LocalDate dueDate) {
        //this dueDate is equal to the string value of dueDate
    }

    public void setCompleted(SimpleBooleanProperty completed) {
        //this completed is equal to completed
    }
}
