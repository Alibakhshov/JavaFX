package main.javafx.ContactListModification;

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

public class ContactListModification extends Application {

    // ObservableList to store the list of contacts
    private ObservableList<String> contacts = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Contact List Modification App");

        // create a label for the contact list
        Label contactListLabel = new Label("Contact List");

        // create a ListView to display the list of contacts
        ListView<String> contactListView = new ListView<>(contacts);

        // create a TextField for the user to enter a new contact
        TextField newContactField = new TextField();
        newContactField.setPromptText("Enter a new contact");

        // create a Button to add a new contact to the list
        Button addButton = new Button("Add");
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

        // create and show the scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
