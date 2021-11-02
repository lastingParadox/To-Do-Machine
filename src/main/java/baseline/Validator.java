/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class Validator {

    public String verifyDescription(String description) {
        if (description.length() > 256) {
            description = description.substring(0, 256);
        }
        return description;
    }

    public String verifyDueDate(String dueDate) {
        //If dueDate equals "":
            //return dueDate
        //tTry to parse dueDate as a LocalDate
            //If successful:
                //return dueDate
            //Else:
                //Create a new alert of type error
                //Set the text of alert to "Due date must be a valid fate in the format "YYYY-MM-DD"".
                //Show alert
                //return "error"
        return null;
    }

    public void editDescription(Item item, String newDescription) {
        //If newDescription equals "":
            //Create a new alert of type ERROR
            //Set content text of alert to "An item's description must be between 1 and 256 characters."
            //Show alert
            //Return
        //Set item's description to verifyDescription(newDescription)
    }
}
