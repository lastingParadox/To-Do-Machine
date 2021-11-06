/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.converter.DefaultStringConverter;

import java.util.Objects;

public class WrappedTextFieldTableCell<S> extends TextFieldTableCell<S, String> {
    //Only exists for the sake of having a TextFieldTableCell with wrapped text.
    //As this extends a TextFieldTableCell, this class has many parents.

    private final Text description;

    public WrappedTextFieldTableCell() {
        super(new DefaultStringConverter());
        this.description = wrappedText();
        description.setTextAlignment(TextAlignment.CENTER);
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        getStyleClass().add("wrapped-text-field-table-cell");
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setGraphic(description);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!isEmpty() && !isEditing()) {
            setGraphic(description);
        }
    }

    private Text wrappedText() {
        Text text = new Text();
        text.wrappingWidthProperty().bind(widthProperty());
        text.textProperty().bind(itemProperty());
        return text;
    }
}
