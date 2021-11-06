/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Objects;

public class AboutSceneController {

    @FXML private ListView<Guide> guideList;

    @FXML private WebView guideView;

    private WebEngine engine;

    private final ObservableList<Guide> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        list.addAll(new Guide("Adding Items", "addItems.html"),
                    new Guide("Removing Items", "removeItems.html"),
                    new Guide("Editing Items", "editItems.html"),
                    new Guide("Importing and Exporting", "importExport.html"));
        guideList.setItems(list);
        engine = guideView.getEngine();

        guideList.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> loadPage(newValue.getLocalHtml())));
    }

    public void loadPage(String html) {
        URL url = this.getClass().getResource("guides/" + html);
        engine.load(Objects.requireNonNull(url).toString());
    }

}
