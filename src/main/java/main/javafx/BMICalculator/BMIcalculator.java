package main.javafx.BMICalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BMIcalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        // Create a grid pane to hold the input fields and labels
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Add weight input field and label
        Label weightLabel = new Label("Weight (kg): ");
        GridPane.setConstraints(weightLabel, 0, 0);

        TextField weightInput = new TextField();
        weightInput.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #000000;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"

        );
        GridPane.setConstraints(weightInput, 1, 0);

        // Add height input field and label
        Label heightLabel = new Label("Height (cm): ");
        heightLabel.setStyle(
                    "-fx-font-size: 20px;" +
                    "-fx-text-fill: #15151a;"
        );
        GridPane.setConstraints(heightLabel, 0, 1);
        TextField heightInput = new TextField();
        heightInput.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #000000;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"

        );
        GridPane.setConstraints(heightInput, 1, 1);

        // Add BMI output label
        Label bmiLabel = new Label("BMI: ");
        GridPane.setConstraints(bmiLabel, 0, 2);
        Label bmiOutput = new Label();
        GridPane.setConstraints(bmiOutput, 1, 2);

        // Add calculate button
        Button calculateButton = new Button("Calculate");
        GridPane.setConstraints(calculateButton, 1, 3);

        // Add clear button
        Button clearButton = new Button("Clear");
        clearButton.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #000000;" +
                "-fx-background-color: #00ff00;" +
                "-fx-border-color: #000000;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 5px;"
        );;
        GridPane.setConstraints(clearButton, 0, 4);

        // Add exit button
        Button exitButton = new Button("Exit");
        GridPane.setConstraints(exitButton, 1, 4);


        // Add all nodes to the grid pane
        grid.getChildren().addAll(weightLabel, weightInput, heightLabel, heightInput, bmiLabel, bmiOutput, calculateButton, clearButton, exitButton);

        // Calculate BMI when the calculate button is clicked
        calculateButton.setOnAction(e -> {
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            double bmi = weight / (height * height / 10000);
            bmiOutput.setText(String.format("%.2f", bmi));
        });

        // Clear the input fields and output
        clearButton.setOnAction(e -> {
            weightInput.clear();
            heightInput.clear();
            bmiOutput.setText("");
        });

        // Exit the program

        exitButton.setOnAction(e -> {
            System.exit(0);
        });


        // Set the grid pane to the center of the scene

        grid.setAlignment(Pos.CENTER);

        // Create a scene and place it in the stage

        Scene scene = new Scene(grid, 400, 300);

        // Set the scene to the stage

        primaryStage.setScene(scene);

        // Display the stage

        primaryStage.show();
    }
}


