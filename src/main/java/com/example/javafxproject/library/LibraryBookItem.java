package com.example.javafxproject.library;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class LibraryBookItem {
    private SubScene bookItem;
    private String imagePath;
    private Image image;
    private Button button;
    private String bookName;
    private String bookAuthor;
    private int numOfPages;
    private Group bookItemGroup;

    public LibraryBookItem(){
        this.bookItemGroup = new Group();
        bookItem = new SubScene(this.bookItemGroup, 75, 100);
    }

    public void loadBookThumbnail(){
        File fileOne = new File(imagePath);
        image = new Image(fileOne.toURI().toString());
    }

    public void setAttributes(String name, String author, String path, int pages){
        this.bookName = name;
        this.bookAuthor = author;
        this.imagePath = path;
        this.numOfPages = pages;
    }

    public SubScene loadItem(){
        loadBookThumbnail();
        bookItemGroup.getChildren().add(new ImageView(this.image));
        return this.bookItem;
    }
}
