package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListApplicationControllerTest {

    TodoListApplicationController test = new TodoListApplicationController();

    @Test
    void createAndAddItemTest() {
        test.createAndAddItem("Test Description", "");

        List<Item> actualList = test.getItemList();

        String expected = "Test Description";
        String actual = actualList.get(0).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void createAndAddItemTestDate() {
        test.createAndAddItem("Test Description", "2021-10-31");

        List<Item> actualList = test.getItemList();

        String expected = "2021-10-31";
        String actual = actualList.get(0).getDueDate();

        assertEquals(expected, actual);
    }

    @Test
    void setItemListTest() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Test Description", "2021-10-31"));
        expected.add(new Item("Test Description 2", "2021-10-31"));

        test.setItemList(expected);

        List<Item> actual = test.getItemList();

        assertEquals(actual, expected);
    }

    @Test
    void removeSelectedItemsTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Description", "2021-10-31"));
        items.add(new Item("Test Description 2", "2021-10-31"));

        test.setItemList(items);

        List<Item> expected = new ArrayList<>();
        expected.add(items.get(1));

        items.remove(1);
        test.removeSelectedItems(items);

        List<Item> actual = test.getItemList();

        assertEquals(expected, actual);
    }

    @Test
    void clearTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Description", "2021-10-31"));
        items.add(new Item("Test Description 2", "2021-10-31"));

        test.setItemList(items);

        test.clear();

        List<Item> expected = new ArrayList<>();

        List<Item> actual = test.getItemList();

        assertEquals(expected, actual);
    }
}