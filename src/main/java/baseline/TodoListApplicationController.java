/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoListApplicationController {

    @FXML private Button addItemButton;

    @FXML private Button clearItemButton;

    @FXML private TableColumn<Item, Boolean> completedColumn;

    @FXML private TableColumn<Item, String> descriptionColumn;

    @FXML private Label descriptionCharCounter;

    @FXML private TableColumn<Item, String> dueDateColumn;

    @FXML private Button exportButton;

    @FXML private MenuItem exportMenu;

    @FXML private Button importButton;

    @FXML private MenuItem importMenu;

    @FXML private TableView<Item> itemTable;

    @FXML private TextField newDescriptionField;

    @FXML private DatePicker newDueDateField;

    @FXML private Button removeItemButton;

    @FXML private Label selectedItemCounter;

    @FXML private Button showAllItemsButton;

    @FXML private Button showCompleteItemsButton;

    @FXML private Button showIncompleteItemsButton;

    private final ObservableList<Item> items = FXCollections.observableArrayList();

    private final StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        @Override
        public String toString(LocalDate date) {
            if(date != null)
                return dateFormatter.format(date);
            return null;
        }
        @Override
        public LocalDate fromString(String string) {
            if (string != null && !string.isEmpty()) {
                return LocalDate.parse(string, dateFormatter);
            } else {
                return null;
            }
        }
    };

    private final Validator validator = new Validator();

    @FXML
    void onAddItemButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        //If there isn't a description provided, then shows an error and does not add the item.
        if(newDescriptionField.getText().equals("")) {
            alert.setContentText("An item's description must be between 1 and 256 characters.");
            alert.show();
            return;
        }
        //Scenario occurs if the user is somehow able to type past 256 characters in the field.
        //Shortens the description for the user and continues adding the item.
        else if (newDescriptionField.getText().length() > 256) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText(String.format(
                    "An item's description must be between 1 and 256 characters.%nThe description provided has been shortened."));
            alert.show();
        }

        Item newItem = new Item(newDescriptionField.getText());

        //As a DatePicker doesn't allow you to commit a non-date value, there's no need to validate what's entered here.
        if(newDueDateField.getValue() != null)
            newItem.setDueDate(newDueDateField.getValue());

        items.add(newItem);

        newDescriptionField.setText("");
        newDueDateField.getEditor().setText("");
        newDueDateField.setValue(null);
    }

    @FXML
    void onAllItemsButtonClicked() {
        //Set itemTable's elements to items
    }

    @FXML
    void onClearButtonClicked() {
        //Create a new alert of type CONFIRMATION
        //Set the title of alert to "Clear all items"
        //Set the content text of alert to "Are you sure you want to delete all items?"
        //Create yes button
        //Create no button
        //Add buttons to alert
        //Show alert and wait for a button to be clicked:
            //If yes:
               //clear(items)
    }

    @FXML
    void onCompleteItemsButtonClicked() {
        //FilteredList of Items "completeItems" is a new FilteredList of "items" with filter getCompletedValue
        //Set itemTable's elements to completeItems
    }

    @FXML
    void onDescriptionColumnEdit(TableColumn.CellEditEvent<Item, String> cell) {
        Item item = itemTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        if(cell.getNewValue().equals("")) {
            alert.setContentText("An item's description must be between 1 and 256 characters.");
            alert.show();
            itemTable.refresh();
            return;
        }
        else if (cell.getNewValue().length() > 256) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText(String.format(
                    "An item's description must be between 1 and 256 characters.%nThe description provided has been shortened."));
            alert.show();
        }
        validator.editDescription(item, cell.getNewValue());
    }

    @FXML
    void onDescriptionFieldFill() {
        //If the user commits the field before adding an item, verifies the field.
        newDescriptionField.setText(validator.verifyDescription(newDescriptionField.getText()));
    }

    @FXML
    void onDueDateColumnEdit(TableColumn.CellEditEvent<Item, String> cell) {
        Item item = itemTable.getSelectionModel().getSelectedItem();
        if(!validator.verifyDueDate(cell.getNewValue()).equals("error"))
            item.setDueDate(cell.getNewValue());
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Due Date must be a valid date in the format \"YYYY-MM-DD\".");
            alert.show();
            itemTable.refresh();
        }

    }

    @FXML
    void onExportButtonClicked() {
        //New Stage "stage" = (Stage) scene of importButton ((Stage) importButton.getScene().getWindow())
        //New FileChooser fileExport
        //Set fileImport's title to "Export To Do List File"
        //New File "path" is equal to fileExport save dialog (fileExport.showSaveDialog(stage))
        //New FileHandler "fileHandler" is made with constructors "path" and "items"
        //fileHandler.fileExport()
    }

    @FXML
    void onImportButtonClicked() {
        //New Stage "stage" = (Stage) scene of importButton ((Stage) importButton.getScene().getWindow())
        //New FileChooser fileImport
        //Set fileImport's title to "Select To Do List File"
        //New File "path" is equal to fileImport dialog (fileImport.showOpenDialog(stage))
        //New FileHandler "fileHandler" is made with constructor "path"
        //setItemList(fileHandler.fileImport())
    }

    @FXML
    void onIncompleteItemsButtonClicked() {
        //FilteredList of Items "imcompleteItems" is a new FilteredList of "items" with filter NOT getCompletedValue
        //Set itemTable's elements to incompleteItems
    }

    @FXML
    void onRemoveButtonClicked() {
        //removeSelectedItems(the currently selected items in the table)
            //(itemTable.getSelectionModel().getSelectedItems())
    }

    @FXML
    public void initialize() {
        itemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        itemTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            int count = itemTable.getSelectionModel().getSelectedItems().size();
            selectedItemCounter.setText(String.format("Number of Selected Items: %d", count));
        }));
        itemTable.setItems(items);

        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        completedColumn.setCellValueFactory(param -> param.getValue().getCompleted());
        completedColumn.setCellFactory(column -> new CheckBoxTableCell<>());

        //Sets the character counter and refuses the user the ability to type past 256 characters in the field
        newDescriptionField.textProperty().addListener((observable, oldValue, newValue) -> {
            descriptionCharCounter.setText(
                    String.format("Current: %d characters", newDescriptionField.getText().length()));
            if (newDescriptionField.getText().length() >= 256) {
                newDescriptionField.setText(newDescriptionField.getText().substring(0, 256));
            }
        });
        newDueDateField.setConverter(converter);
    }

    public void createAndAddItem(String descriptionField, String dueDateField) {
        Item item = new Item(descriptionField);
        if (dueDateField != null) {
            item.setDueDate(dueDateField);
        }
        items.add(item);
    }

    public void removeSelectedItems(List<Item> removedItems) {
        //Remove removedItems from items
    }

    public void clear() {
        //clear items
    }

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> newItemList) {
        //Clear items
        //Add newItemList to items
    }
}
