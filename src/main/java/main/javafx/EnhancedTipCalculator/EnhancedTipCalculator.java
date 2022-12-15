package main.javafx.EnhancedTipCalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EnhancedTipCalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the window title
        primaryStage.setTitle("Enhanced Tip Calculator");

        // Create a grid pane to hold the user interface components
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        // Create a label and text field for the bill amount
        Label billAmountLabel = new Label("Bill amount:");
        TextField billAmountField = new TextField();
        pane.add(billAmountLabel, 0, 0);
        pane.add(billAmountField, 1, 0);

        // Create a label and text field for the tip percentage
        Label tipPercentageLabel = new Label("Tip percentage:");
        TextField tipPercentageField = new TextField();
        pane.add(tipPercentageLabel, 0, 1);
        pane.add(tipPercentageField, 1, 1);

        // Create a button to calculate the tip and total amount
        Button calculateButton = new Button("Calculate");
        pane.add(calculateButton, 1, 2);

        // Create labels to display the tip and total amount
        Label tipAmountLabel = new Label("Tip amount:");
        Label tipAmountValueLabel = new Label();
        pane.add(tipAmountLabel, 0, 3);
        pane.add(tipAmountValueLabel, 1, 3);

        Label totalAmountLabel = new Label("Total amount:");
        Label totalAmountValueLabel = new Label();
        pane.add(totalAmountLabel, 0, 4);
        pane.add(totalAmountValueLabel, 1, 4);

        // When the user clicks the calculate button, calculate and display the tip and total amount
        calculateButton.setOnAction(event -> {
            // Get the bill amount and tip percentage from the text fields
            double billAmount = Double.parseDouble(billAmountField.getText());
            double tipPercentage = Double.parseDouble(tipPercentageField.getText()) / 100;

            // Calculate the tip and total amount
            double tipAmount = billAmount * tipPercentage;
            double totalAmount = billAmount + tipAmount;

            // Display the tip and total amount
            tipAmountValueLabel.setText(String.format("$%.2f", tipAmount));
            totalAmountValueLabel.setText(String.format("$%.2f", totalAmount));
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
