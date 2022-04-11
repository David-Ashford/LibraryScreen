package com.example.javafxproject.library;

import javafx.scene.image.Image;

import java.io.File;

public class LibraryBookItem {
    private String imagePath;
    private Image image;

    public LibraryBookItem(){
    }

    public void loadBookThumbnail(){
        File fileOne = new File(imagePath);
        image = new Image(fileOne.toURI().toString());
    }
}
