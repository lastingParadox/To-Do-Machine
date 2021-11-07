/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.collections.transformation.FilteredList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemListTest {

    ItemList test = new ItemList();

    @Test
    void createAndAddItemTest() {
        test.createAndAddItem("Test Description", "");

        List<Item> actualList = test.getList();

        String expected = "Test Description";
        String actual = actualList.get(0).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void createAndAddItemTestDate() {
        test.createAndAddItem("Test Description", "2021-10-31");

        List<Item> actualList = test.getList();

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

        List<Item> actual = test.getList();

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

        List<Item> actual = test.getList();

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

        List<Item> actual = test.getList();

        assertEquals(expected, actual);
    }

    @Test
    void sortByDateTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Description", "2022-10-31"));
        items.add(new Item("Test Description 2", "2021-10-31"));
        test.setItemList(items);

        test.sortByDate();

        List<Item> actualList = test.getList();
        String actual = actualList.get(0).getDescription() + actualList.get(1).getDescription();
        String expected = items.get(1).getDescription() + items.get(0).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void filterCompleteItemsTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Description", "2022-10-31", false));
        items.add(new Item("Test Description 2", "2021-10-31", true));
        test.setItemList(items);

        FilteredList<Item> actual = test.filterCompleteItems();

        assertEquals("Test Description 2", actual.get(0).getDescription());
    }

    @Test
    void filterIncompleteItemsTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Test Description", "2022-10-31", true));
        items.add(new Item("Test Description 2", "2021-10-31", false));
        test.setItemList(items);

        FilteredList<Item> actual = test.filterIncompleteItems();

        assertEquals("Test Description 2", actual.get(0).getDescription());
    }

}