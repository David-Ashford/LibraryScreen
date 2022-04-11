package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EntropyLibraryController {

    @FXML protected ScrollPane scrollPane;
    @FXML protected AnchorPane anchorPane1;

    @FXML protected TextField searchBar;
    @FXML protected ListView<String> listView;

    @FXML void search(ActionEvent event) {

        listView.getItems().clear();
    }
}
