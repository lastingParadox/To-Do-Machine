package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator test = new Validator();

    @Test
    void verifyDescriptionTest() {
        String testString = "123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111213";
        String expected = "1234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112123456789010111212345678901011121234567890101112";
        String actual = test.verifyDescription(testString);

        assertEquals(expected, actual);
    }

    @Test
    void verifyDueDateTestNull() {
        //String expected = ""
        //String actual = test.verifyDueDate("")

        //AssertEquals(expected, actual)
    }

    @Test
    void verifyDueDateTestSuccess() {
        //String expected = "2021-12-10"
        //String actual = test.verifyDueDate("2021-12-10")

        //AssertEquals(expected, actual)
    }

    @Test
    void verifyDueDateTestError() {
        //String expected = "error"
        //String actual = test.verifyDueDate("bruh")

        //AssertEquals(expected, actual)
    }

    @Test
    void editDescriptionTestSuccess() {
        //Item testItem is a new item with constructors "Do Something", "2021-10-31"
        //test.editDescription(testItem, "verify editDescription")

        //String expected = "verify editDescription"
        //String actual = testItem.getDescription()

        //AssertEquals(expected, actual)
    }

    @Test
    void editDescriptionTestNull() {
        //Item testItem is a new item with constructors "Do Something", "2021-10-31"
        //test.editDescription(testItem, "")

        //String expected = "Do Something"
        //String actual = testItem.getDescription()

        //AssertEquals(expected, actual)
    }

}