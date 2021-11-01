package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoListApplicationControllerTest {

    //Create new TodoListApplicationController test

    @Test
    void createAndAddItemTest() {
        //test.createAndAddItemTest("Test Description", "")

        //List of items expected contains a new Item with constructor "Test Description"
        //List of items actual equals test.getItemList()

        //AssertEquals(expected, actual)
    }

    @Test
    void createAndAddItemTestDate() {
        //test.createAndAddItemTest("Test Description", "2021-10-31")

        //List of items expected contains a new Item with constructors "Test Description", "2021-10-31"
        //List of items actual equals test.getItemList()

        //AssertEquals(expected, actual)
    }

    @Test
    void setItemListTest() {
        //List of items expected contains two items:
            //A new Item with constructors "Test Description", "2021-10-31"
            //A new Item with constructors "Test Description 2", "2021-10-31"

        //test.setItemList(expected)
        //List of items actual equals test.getItemList()

        //AssertEquals(expected, actual)
    }

    @Test
    void removeSelectedItemsTest() {
        //List of items "items" contains two items:
            //A new Item with constructors "Test Description", "2021-10-31"
            //A new Item with constructors "Test Description 2", "2021-10-31"
        //test.setItemList(items)

        //List of items "expected" contains items.get(1)

        //items.remove(1)
        //test.removeSelectedItems(items)

        //List of items "actual" equals test.getItemList()

        //AssertEquals(expected, actual)
    }

    @Test
    void clearTest() {
        //List of items "items" contains two items:
            //A new Item with constructors "Test Description", "2021-10-31"
            //A new Item with constructors "Test Description 2", "2021-10-31"
        //test.setItemList(items)

        //test.clear()

        //List of items "expected" is empty
        //List of items "actual" equals test.getItemList()

        //AssertEquals(expected, actual)
    }
}