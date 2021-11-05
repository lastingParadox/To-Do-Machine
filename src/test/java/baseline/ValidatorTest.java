/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator test = new Validator();

    @Test
    void verifyDescriptionTest() {
        //258 Character String
        String testString = "123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111213";
        //256 Character String
        String expected = "1234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112";
        String actual = test.verifyDescription(testString);

        assertEquals(expected, actual);
    }

    @Test
    void verifyDescriptionTestNull() {
        String testString = "";
        String expected = "";
        String actual = test.verifyDescription(testString);

        assertEquals(expected, actual);
    }

    @Test
    void verifyDueDateTestNull() {
        String expected = "";
        String actual = test.verifyDueDate("");

        assertEquals(expected, actual);
    }

    @Test
    void verifyDueDateTestSuccess() {
        String expected = "2021-12-10";
        String actual = test.verifyDueDate("2021-12-10");

        assertEquals(expected, actual);
    }

    @Test
    void verifyDueDateTestError() {
        String expected = "error";
        String actual = test.verifyDueDate("bruh");

        assertEquals(expected, actual);
    }

    @Test
    void editDescriptionTestSuccess() {
        Item testItem = new Item("Do Something", "2021-10-31");
        test.editDescription(testItem, "Verify editDescription");

        String expected = "Verify editDescription";
        String actual = testItem.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void editDescriptionTestNull() {
        Item testItem = new Item("Do Something", "2021-10-31");
        test.editDescription(testItem, "");

        String expected = "Do Something";
        String actual = testItem.getDescription();

        assertEquals(expected, actual);
    }

}