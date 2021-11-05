/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class ItemList {

    private final ObservableList<Item> items = FXCollections.observableArrayList();

    public void createAndAddItem(String descriptionField, String dueDateField) {
        Item item = new Item(descriptionField);
        if (!dueDateField.equals("")) {
            item.setDueDate(dueDateField);
        }
        items.add(item);
    }

    public void createAndAddItem(String descriptionField, LocalDate dueDateField) {
        Item item = new Item(descriptionField);
        if (dueDateField != null) {
            item.setDueDate(dueDateField);
        }
        items.add(item);
    }

    public void removeSelectedItems(List<Item> removedItems) {
        items.removeAll(removedItems);
    }

    public void clear() {
        items.clear();
    }

    public void sortByDate() {
        items.sort((o1, o2) -> {
            if (o1.getDueDate() == null) {
                return (o2.getDueDate() == null) ? 0 : 1;
            }
            if (o2.getDueDate() == null) {
                return -1;
            }
            return o1.getDueDate().compareTo(o2.getDueDate());
        });
    }

    public ObservableList<Item> getList() {
        return items;
    }

    public void setItemList(List<Item> newItemList) {
        items.clear();
        items.addAll(newItemList);
    }
}
