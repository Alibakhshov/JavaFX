package main.javafx.ContactsListAppModification;

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

public class ContactsListAppModification extends Application {
    // Create a list of contacts
    ObservableList<String> contacts = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        // Create a ListView to display the contacts
        ListView<String> listView = new ListView<>(contacts);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        // Create a text field for the user to enter a new contact
        TextField textField = new TextField();
        textField.setPromptText("Enter a new contact");
        textField.setPrefColumnCount(20);
        textField.setStyle(
                        "-fx-font: 24 arial;" +
                        "-fx-base: #b6e7c9;" +
                        "-fx-text-fill: #0a0a0a;" +
                        "-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);" +
                        "-fx-background-radius: 5em; " +
                        "-fx-background-insets: 0, 1, 2, 3, 0;"

        );

        // Create buttons for adding, updating, and deleting contacts
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
        Button updateButton = new Button("Update");
        updateButton.setStyle(
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
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle(
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
        buttonBox.setStyle(
                        "-fx-background-color: #b6e7c9;" +
                        "-fx-padding: 10;" +
                        "-fx-spacing: 10;" +
                        "-fx-border-radius: 50em; " +
                        "-fx-border-width: 2px; "
        );

        // Create a vertical box for the ListView and text field
        VBox root = new VBox(10, listView, textField, buttonBox);
        root.setStyle(
                        "-fx-background-color: #b6e7c9;" +
                        "-fx-padding: 10;" +
                        "-fx-spacing: 10;" +
                        "-fx-border-radius: 50em; " +
                        "-fx-border-width: 2px; "
        );
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
