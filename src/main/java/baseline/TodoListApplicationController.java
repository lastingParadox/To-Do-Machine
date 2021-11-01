/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    //Create new ObservableList "items" equal to FXCollections observableArrayList

    //Create new StringConverter of LocalDates "converter"
        //Final DateTimeFormatter "dateFormatter" is the pattern "yyyy-MM-dd"
        //Override toString with LocalDate "date"
            //If "date" is not null:
                //Return formatted date
            //Return null
        //Override fromString with String "string"
            //If string is not null and is not empty:
                //Return parsed string as LocalDate
            //Else
                //Return null

    //Create new Validator "validator"

    @FXML
    void onAddItemButtonClicked() {
        //If validator.verifyDescription(newDescriptionField's text) equals "":
            //Return

        //getItemList(newDescriptionField.getText(), newDueDateField.getText())

        //newDescriptionField is set to ""
        //newDueDateField is set to null
        //newDueDateField's text is set to ""
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
        //Item "item" is the currently selected item (itemTable.getSelectionModel().getSelectedItem)
        //validator.editDescription(item, cell.getNewValue())
        //Refresh itemTable()
    }

    @FXML
    void onDescriptionFieldFill() {
        //Set newDescriptionField's text to validator.verifyDescription(newDescriptionField's text)
    }

    @FXML
    void onDueDateColumnEdit(TableColumn.CellEditEvent<Item, String> cell) {
        //Item "item" is the currently selected item
        //If validator.verifyDueDate(cell.getNewValue()) does not equal "error":
            //Set item's dueDate to cell.getNewValue()
        //Else
            //Refresh the itemTable
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
        //Make itemTable's selectionMode MULTIPLE
        //Add a listener for the currently selected items in the table:
            //Int count is the number of currently selected items
            //Set selectedItemCounter to "Number of Selected Items: 'count'"
        //Set itemTable's items to "items"

        //Set descriptionColumn's cellValueFactory to a propertyValueFactory "description"
        //Set descriptionColumn's cellFactory to a TextFieldCell for the entire column

        //Set descriptionColumn's cellValueFactory to a propertyValueFactory "dueDate"
        //Set dueDateColumn's cellFactory to a TextFieldCell for the entire column

        //Set completedColumn's cellValueFactory to (lambda) item.getCompleted()
        //Set completedColumn's cellFactory to a column of CheckBoxTableCells

        //Add a listener for newDescriptionField's text:
            //Set descriptionCharCounter's text to "Current: 'newDescriptionField's text length' characters"
        //If newDescriptionField's text length is greater than or equal to 256:
            //Set newDescriptionField's text to a substring of newDescriptionField's text from index 0 to 256

        //Set newDueDateField's converter to "converter"
    }

    public void createAndAddItem(String descriptionField, String dueDateField) {
        //Item item is a new Item with constructor descriptionField
        //If dueDateField is not null:
            //item.setDueDate(dueDateField)
        //items.add(item)
    }

    public void removeSelectedItems(List<Item> removedItems) {
        //Remove removedItems from items
    }

    public void clear() {
        //clear items
    }

    public List<Item> getItemList() {
        //Return items.getItems()
        return null;
    }

    public void setItemList(List<Item> newItemList) {
        //Clear items
        //Add newItemList to items
    }
}
