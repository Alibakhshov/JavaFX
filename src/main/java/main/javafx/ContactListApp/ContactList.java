package main.javafx.ContactListApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContactList extends Application {

    // ObservableList to store the list of contacts
    private ObservableList<String> contacts = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Contact List Modification App");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        // create a label for the contact list
        Label contactListLabel = new Label("Contact List");
        contactListLabel.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                        "-fx-alignment: center;"
//
        );

        // create a ListView to display the list of contacts
        ListView<String> contactListView = new ListView<>(contacts);

        // create a TextField for the user to enter a new contact
        TextField newContactField = new TextField();
        newContactField.setStyle(
                        "-fx-font: 24 arial;" +
                        "-fx-base: #b6e7c9;" +
                        "-fx-text-fill: #0a0a0a;" +
                        "-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);" +
                        "-fx-background-radius: 5em; " +
                        "-fx-background-insets: 0, 1, 2, 3, 0;"

        );
        newContactField.setPromptText("Enter a new contact");

        // create a Button to add a new contact to the list
        Button addButton = new Button("Add");
        addButton.setStyle(
                        "-fx-font: 24 arial;" +
                        "-fx-base: #b6e7c9;" +
                        "-fx-text-fill: #faf7f7;" +
                        "-fx-background-radius: 2em; " +
                        "-fx-background-insets: 0, 1, 2, 3, 0;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-border-radius: 5em; " +
                        "-fx-border-width: 2px; " +
                        "-fx-border-color: #fdf9f9;" +
                        "-fx-border-insets: 0, 1, 2, 3, 0;" +
                        "-fx-background-color: linear-gradient(#2acc6a, #67a474), " +
                        "radial-gradient(center 50% -40%, radius 200%, #82b747 45%, #6eb93b 50%), " +
                        "radial-gradient(center 50% -40%, radius 200%, #06e75d 45%, #379827 50%);"

        );
        addButton.setOnAction(event -> {
            String newContact = newContactField.getText();
            if (!newContact.isEmpty()) {
                // add the new contact to the list
                contacts.add(newContact);
                // clear the TextField
                newContactField.clear();
            }
        });

        // create a Button to remove a selected contact from the list
        Button removeButton = new Button("Remove");
        removeButton.setStyle(
                        "-fx-font: 24 arial;" +
                        "-fx-base: #b6e7c9;" +
                        "-fx-text-fill: #faf7f7;" +
                        "-fx-background-radius: 2em; " +
                        "-fx-background-insets: 0, 1, 2, 3, 0;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-border-radius: 5em; " +
                        "-fx-border-width: 2px; " +
                        "-fx-border-color: #fdf9f9;" +
                        "-fx-border-insets: 0, 1, 2, 3, 0;" +
                        "-fx-background-color: linear-gradient(#2acc6a, #67a474), " +
                        "radial-gradient(center 50% -40%, radius 200%, #82b747 45%, #6eb93b 50%), " +
                        "radial-gradient(center 50% -40%, radius 200%, #06e75d 45%, #379827 50%);"

        );
        removeButton.setOnAction(event -> {
            String selectedContact = contactListView.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                // remove the selected contact from the list
                contacts.remove(selectedContact);
            }
        });

        // create an HBox to hold the add and remove buttons
        HBox buttonBox = new HBox(10, addButton, removeButton);

        // create a VBox to hold the contact list and the button box
        VBox vBox = new VBox(10, contactListLabel, contactListView, newContactField, buttonBox);
        vBox.setPadding(new Insets(10));

        // create a BorderPane to hold the VBox
        BorderPane root = new BorderPane(vBox);
        root.setStyle(
                "-fx-background-color: #e4f6eb;"
        );

        // create and show the scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
