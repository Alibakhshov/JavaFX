package main.javafx.tipCalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class tipCalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane to hold the user interface elements
        GridPane gridPane = new GridPane();
        gridPane.setStyle(
                        "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: #f6f1f1;" +
                        "-fx-background-color: #39393f;"
        );
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Create labels and text fields for the bill amount, tip percentage, and tip amount
        Label billAmountLabel = new Label("Bill Amount:");
        billAmountLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #ffffff;"
        );
        TextField billAmountField = new TextField();
        billAmountField.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #faf4f4;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"
        );
        Label tipPercentageLabel = new Label("Tip Percentage:");
        tipPercentageLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #ffffff;"
        );
        TextField tipPercentageField = new TextField();
        tipPercentageField.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #f6eded;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"
        );
        Label tipAmountLabel = new Label("Tip Amount:");
        tipAmountLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #f6f1f1;"
        );
        TextField tipAmountField = new TextField();
        tipAmountField.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #f3eeee;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"
        );
        tipAmountField.setEditable(false);

        // Add the labels and text fields to the grid pane
        gridPane.add(billAmountLabel, 0, 0);
        gridPane.add(billAmountField, 1, 0);
        gridPane.add(tipPercentageLabel, 0, 1);
        gridPane.add(tipPercentageField, 1, 1);
        gridPane.add(tipAmountLabel, 0, 2);
        gridPane.add(tipAmountField, 1, 2);

        // When the user enters a bill amount and tip percentage, calculate the tip amount
        billAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double billAmount = Double.parseDouble(newValue);
                double tipPercentage = Double.parseDouble(tipPercentageField.getText());
                double tipAmount = billAmount * tipPercentage / 100;
                tipAmountField.setText(String.format("%.2f", tipAmount));
            } catch (NumberFormatException e) {
                tipAmountField.setText("");
            }
        });
        tipPercentageField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double billAmount = Double.parseDouble(billAmountField.getText());
                double tipPercentage = Double.parseDouble(newValue);
                double tipAmount = billAmount * tipPercentage / 100;
                tipAmountField.setText(String.format("%.2f", tipAmount));
            } catch (NumberFormatException e) {
                tipAmountField.setText("");
            }
        });

//        gridPane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Show the user interface
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Sample tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
