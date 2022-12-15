package main.javafx.ContactsList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContactsApp extends Application {
    // Create a list of contacts
    ObservableList<String> contacts = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        // Create a ListView to display the contacts
        ListView<String> listView = new ListView<>(contacts);

        // Create a text field for the user to enter a new contact
        TextField textField = new TextField();

        // Create buttons for adding, updating, and deleting contacts
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        // Handle the add button click
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the text from the text field
                String contact = textField.getText();

                // Add the contact to the list
                contacts.add(contact);

                // Clear the text field
                textField.clear();
            }
        });

        // Handle the update button click
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the selected contact from the ListView
                String selectedContact = listView.getSelectionModel().getSelectedItem();

                // Check if a contact was selected
                if (selectedContact != null) {
                    // Get the index of the selected contact
                    int index = contacts.indexOf(selectedContact);

                    // Update the contact in the list
                    contacts.set(index, textField.getText());

                    // Clear the text field
                    textField.clear();
                }
            }
        });

        // Handle the delete button click
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the selected contact from the ListView
                String selectedContact = listView.getSelectionModel().getSelectedItem();

                // Check if a contact was selected
                if (selectedContact != null) {
                    // Remove the contact from the list
                    contacts.remove(selectedContact);

                    // Clear the text field
                    textField.clear();
                }
            }
        });

        // Create a horizontal box for the buttons
        HBox buttonBox = new HBox(10, addButton, updateButton, deleteButton);

        // Create a vertical box for the ListView and text field
        VBox root = new VBox(10, listView, textField, buttonBox);
        root.setPadding(new Insets(10));

        // Create a scene and set it as the stage's scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Contact List");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
