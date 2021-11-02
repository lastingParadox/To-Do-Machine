/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validator {

    public String verifyDescription(String description) {
        if (description.length() > 256) {
            description = description.substring(0, 256);
        }
        return description;
    }

    public String verifyDueDate(String dueDate) {
        if (dueDate.equals("")) {
            return dueDate;
        }
        try {
            LocalDate.parse(dueDate);
            return dueDate;
        } catch (DateTimeParseException e) {
            return "error";
        }
    }

    public void editDescription(Item item, String newDescription) {
        if (newDescription.equals(""))
            return;

        item.setDescription(verifyDescription(newDescription));
    }
}
