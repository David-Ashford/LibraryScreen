package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EntropyDesignLibraryController {

    @FXML protected Button bookOne;
    @FXML protected Button bookTwo;
    @FXML protected Button bookThree;
    @FXML protected Button bookFour;
    @FXML protected Button bookFive;
    @FXML protected Button bookSix;

    @FXML protected Label bookOneAuthorLabel;
    @FXML protected Label bookTwoAuthorLabel;
    @FXML protected Label bookThreeAuthorLabel;
    @FXML protected Label bookFourAuthorLabel;
    @FXML protected Label bookFiveAuthorLabel;
    @FXML protected Label bookSixAuthorLabel;

    @FXML protected ImageView bookOneImage;
    @FXML protected ImageView bookTwoImage;
    @FXML protected ImageView bookThreeImage;
    @FXML protected ImageView bookFourImage;
    @FXML protected ImageView bookFiveImage;
    @FXML protected ImageView bookSixImage;

    @FXML protected ProgressBar progressBar1;
    @FXML protected ProgressBar progressBar2;
    @FXML protected ProgressBar progressBar3;
    @FXML protected ProgressBar progressBar4;
    @FXML protected ProgressBar progressBar5;
    @FXML protected ProgressBar progressBar6;

    @FXML protected ScrollPane scrollPane;
    @FXML protected AnchorPane anchorPane1;

    @FXML protected TextField searchBar;
    @FXML protected ListView<String> listView;


    //Height will be the same for all the progress bars however the width will change
    //This needs to be added into an array of values

    public static double[] PROGRESS_BAR_VALUE = {0,0,0,0,0,0};

    public static int MAX_NUM_BOOKS = 6;
    public static String[] bookAuthor = {"", "", "", "", "", ""};

    ArrayList<String> bookTitle = new ArrayList<>(
            Arrays.asList("","","","","","")
    );

    //Used for the search button, what it does is clear the listView and then add the contents back
    //which have been searched through the searchList method
    @FXML void search(ActionEvent event) {

        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),bookTitle));
    }

    //Initialization function - loads in the images, authors names, book titles and progress bar values to the FXML file
    public void initialize() throws FileNotFoundException {
        loadImages();
        scanBookTitles();
        scanBookAuthors();
        progressBar();
        listView.getItems().addAll(bookTitle);
    }

    //This method loads in 6 images that are stored in the project to be shown in each individual imageview
    // to represent the cover of the book
    public void loadImages() throws FileNotFoundException{

        File fileOne = null;
        fileOne = new File("./resources/Holes.jpg");
        Image imageOne = new Image(fileOne.toURI().toString());
        bookOneImage.setImage(imageOne);

        File fileTwo = new File("./resources/HP_PS.jpg");
        Image imageTwo = new Image(fileTwo.toURI().toString());
        bookTwoImage.setImage(imageTwo);

        File fileThree = new File("./resources/CharlieandtheChocolateFactory.jpg");
        Image imageThree = new Image(fileThree.toURI().toString());
        bookThreeImage.setImage(imageThree);

        File fileFour = new File("./resources/LionWitchWardrobe.jpg");
        Image imageFour = new Image(fileFour.toURI().toString());
        bookFourImage.setImage(imageFour);

        File fileFive = new File("./resources/Hobbit.jpg");
        Image imageFive = new Image(fileFive.toURI().toString());
        bookFiveImage.setImage(imageFive);

        File fileSix = new File("./resources/CW.jpg");
        Image imageSix = new Image(fileSix.toURI().toString());
        bookSixImage.setImage(imageSix);

    }

    //This method scans in the title of each book and adds it to the book buttons
    public void scanBookTitles() throws FileNotFoundException {

        File text = new File("./resources/ChildrenBooks.txt");
        Scanner scnr = new Scanner(text);

        for(int i = 0; i<MAX_NUM_BOOKS; i++) {

            String line = scnr.nextLine();
            bookTitle.set(i, line);
            System.out.println("Book " + (i+1) + ": " + line);
        }

        bookOne.setText(bookTitle.get(0));
        bookTwo.setText(bookTitle.get(1));
        bookThree.setText(bookTitle.get(2));
        bookFour.setText(bookTitle.get(3));
        bookFive.setText(bookTitle.get(4));
        bookSix.setText(bookTitle.get(5));
    }



    //This method scans the text folder called "ChildrenBooksAuthors.txt" and assigns them to the string array, which
    //is connected to the FXML file
    public void scanBookAuthors() throws FileNotFoundException{
        File text = new File("./resources/ChildrenBooksAuthors.txt");
        Scanner scnr = new Scanner(text);

        for(int i = 0; i<MAX_NUM_BOOKS; i++) {

            String line = scnr.nextLine();
            bookAuthor[i]  = line;
            System.out.println("Author " + (i+1) + ": " + line);
        }

        bookOneAuthorLabel.setText(bookAuthor[0]);
        bookTwoAuthorLabel.setText(bookAuthor[1]);
        bookThreeAuthorLabel.setText(bookAuthor[2]);
        bookFourAuthorLabel.setText(bookAuthor[3]);
        bookFiveAuthorLabel.setText(bookAuthor[4]);
        bookSixAuthorLabel.setText(bookAuthor[5]);
    }

    //Loads in the completion status of all books from a text file
    public void scanProgressBarCompletion() throws FileNotFoundException {

        File text = new File("./resources/ProgressValues.txt");
        Scanner scnr = new Scanner(text);

        for(int i = 0; i<MAX_NUM_BOOKS; i++) {
            String line = scnr.nextLine();
            PROGRESS_BAR_VALUE[i]  = Double.parseDouble(line);
        }
    }


    //Sets the progress bar values to the data set in the "ProgressValues.txt" file.
    //Sets the bar to red
    public void progressBar() throws FileNotFoundException {

        scanProgressBarCompletion();

        progressBar1.setProgress(PROGRESS_BAR_VALUE[0]);
        progressBar2.setProgress(PROGRESS_BAR_VALUE[1]);
        progressBar3.setProgress(PROGRESS_BAR_VALUE[2]);
        progressBar4.setProgress(PROGRESS_BAR_VALUE[3]);
        progressBar5.setProgress(PROGRESS_BAR_VALUE[4]);
        progressBar6.setProgress(PROGRESS_BAR_VALUE[5]);

        progressBar1.setStyle("-fx-accent: red;");
        progressBar2.setStyle("-fx-accent: red;");
        progressBar3.setStyle("-fx-accent: red;");
        progressBar4.setStyle("-fx-accent: red;");
        progressBar5.setStyle("-fx-accent: red;");
        progressBar6.setStyle("-fx-accent: red;");

    }

    //Started to create the search bar, used the YouTube clip below to do so.
    //https://www.youtube.com/watch?v=VUVqamT8Npc&t=119s
    public List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(""));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
