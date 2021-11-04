/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Objects;

public class TodoListApplicationController {

    @FXML private TableColumn<Item, Boolean> completedColumn;

    @FXML private TableColumn<Item, String> descriptionColumn;

    @FXML private Label descriptionCharCounter;

    @FXML private TableColumn<Item, String> dueDateColumn;

    @FXML private Button exportButton;

    @FXML private Button importButton;

    @FXML private TableView<Item> itemTable;

    @FXML private TextField newDescriptionField;

    @FXML private DatePicker newDueDateField;

    @FXML private Label selectedItemCounter;

    private final ObservableList<Item> items = FXCollections.observableArrayList();

    private final StringConverter<LocalDate> converter = new StringConverter<>() {
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
    void onAboutButtonClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }

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

        createAndAddItem(newDescriptionField.getText(), newDueDateField.getValue());

        newDescriptionField.setText("");
        newDueDateField.getEditor().setText("");
        newDueDateField.setValue(null);
    }

    @FXML
    void onAllItemsButtonClicked() {
        itemTable.setItems(items);
    }

    @FXML
    void onClearButtonClicked() {
        //Creates a prompt box, if user accepts, clears all items.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Clear all items");
        alert.setContentText("Are you sure you want to delete all items?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yes, no);
        alert.showAndWait().ifPresent(type -> {
            if (type == yes)
                clear();
        });
    }

    @FXML
    void onCompleteItemsButtonClicked() {
        FilteredList<Item> completeItems = new FilteredList<>(items, Item::getCompletedValue);
        itemTable.setItems(completeItems);
    }

    @FXML
    void onDateSortButtonClicked() {
        sortByDate();
    }

    @FXML
    void onDescriptionColumnEdit(TableColumn.CellEditEvent<Item, String> cell) {
        //Creates alerts if description is over 256 characters or is empty
        //If not empty, sets the description to a provided description less than 256 characters.
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
        //If the dueDate given is a valid date, sets the date, otherwise creates an alert and does not commit.
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
        Stage stage = (Stage) importButton.getScene().getWindow();
        FileChooser fileExport = new FileChooser();
        fileExport.setTitle("Export To Do List File");
        fileExport.setInitialDirectory(new File("./TodoLists"));
        fileExport.setInitialFileName("NewList.txt");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text files", "*.txt");
        fileExport.getExtensionFilters().add(filter);

        File path = fileExport.showSaveDialog(stage);
        if (path == null)
            return;

        FileHandler fileHandler = new FileHandler(path, items);
        fileHandler.fileExport();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Todo List successfully exported!");
        alert.show();
    }

    @FXML
    void onImportButtonClicked() {
        Stage stage = (Stage) exportButton.getScene().getWindow();
        FileChooser fileImport = new FileChooser();
        fileImport.setTitle("Select To Do List File");
        fileImport.setInitialDirectory(new File("./TodoLists"));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text files", "*.txt");
        fileImport.getExtensionFilters().add(filter);

        File path = fileImport.showOpenDialog(stage);
        if (path == null)
            return;

        FileHandler fileHandler = new FileHandler(path);
        setItemList(fileHandler.fileImport());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Todo List successfully imported!");
        alert.show();
    }

    @FXML
    void onIncompleteItemsButtonClicked() {
        FilteredList<Item> incompleteItems = new FilteredList<>(items, t -> ! t.getCompletedValue());
        itemTable.setItems(incompleteItems);
    }

    @FXML
    void onRemoveButtonClicked() {
        //Items to be removed are the currently selected items in the table.
        removeSelectedItems(itemTable.getSelectionModel().getSelectedItems());
    }

    @FXML
    public void initialize() {
        //Initializing table elements and number of selected items counter
        itemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        itemTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            int count = itemTable.getSelectionModel().getSelectedItems().size();
            selectedItemCounter.setText(String.format("Number of Selected Items: %d", count));
        }));
        itemTable.setItems(items);

        //Initializes the columns and what each column contains
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

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> newItemList) {
        items.clear();
        items.addAll(newItemList);
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
}
