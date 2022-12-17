package main.javafx.TipCalculatorModification;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TipCalculatorModification extends Application {
    private TextField amountField;
    private TextField tipPercentField;
    private Label tipAmountLabel;
    private Label totalAmountLabel;
    private Button calculateButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI controls
        amountField = new TextField();
        tipPercentField = new TextField();
        tipAmountLabel = new Label();
        totalAmountLabel = new Label();
        calculateButton = new Button("Calculate");

        // Set up layout
        GridPane grid = new GridPane();
        grid.setStyle(
                        "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: #645e5e;" +
                        "-fx-background-color: #f6f1f1;"
        );
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add controls to layout
        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(new Label("Tip %:"), 0, 1);
        grid.add(tipPercentField, 1, 1);
        grid.add(new Label("Tip Amount:"), 0, 2);
        grid.add(tipAmountLabel, 1, 2);
        grid.add(new Label("Total Amount:"), 0, 3);
        grid.add(totalAmountLabel, 1, 3);
        grid.add(calculateButton, 1, 4);

        // Set up button event handler
        calculateButton.setOnAction(event -> calculate());

        // Set up scene and stage
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tip Calculator Modification");
        primaryStage.show();
    }

    private void calculate() {
        // Get input values
        double amount = Double.parseDouble(amountField.getText());
        double tipPercent = Double.parseDouble(tipPercentField.getText());

        // Calculate tip and total amount
        double tipAmount = amount * (tipPercent / 100);
        double totalAmount = amount + tipAmount;

        // Update labels with calculated values
        tipAmountLabel.setText(String.format("$%.2f", tipAmount));
        totalAmountLabel.setText(String.format("$%.2f", totalAmount));
    }
}
