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

        // Creating a grid pane to hold the input fields and labels
        GridPane grid = new GridPane();
        grid.setStyle(
                        "-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: black;" +
                        "-fx-background-color: lightgray;"
        );
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Add weight input field and label
        Label weightLabel = new Label("Weight(kg): ");
        weightLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;"
        );
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
        Label heightLabel = new Label("Height(cm): ");
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
        bmiLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;"
        );
        GridPane.setConstraints(bmiLabel, 0, 2);
        Label bmiOutput = new Label();
        bmiOutput.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;"
        );
        GridPane.setConstraints(bmiOutput, 1, 2);

        // Add calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setStyle(
                        "-fx-font-size: 18pt;" +
                        "-fx-font-family: 'Verdana';" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #0072C6, #0054A6);" +
                        "-fx-border-color: #0072C6;" +
                        "-fx-border-radius: 5;" +
                        "-fx-padding: 10;" +
                        "-fx-cursor: hand;" +
                        "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);" +
                        "-fx-background-radius: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-style: solid;"
        );

        calculateButton.setOnMouseEntered(event -> {
            calculateButton.setStyle(
                    "-fx-font-size: 18pt;" +
                            "-fx-font-family: 'Verdana';" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #0054A6, #0072C6);" +
                            "-fx-border-color: #0054A6;" +
                            "-fx-border-radius: 5;" +
                            "-fx-padding: 10;" +
                            "-fx-cursor: hand;" +
                            "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });

        calculateButton.setOnMouseExited(event -> {
            calculateButton.setStyle(
                            "-fx-font-size: 18pt;" +
                            "-fx-font-family: 'Verdana';" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #81b6de, #3f5365);" +
                            "-fx-border-color: #0072C6;" +
                            "-fx-border-radius: 5;" +
                            "-fx-padding: 10;" +
                            "-fx-cursor: hand;" +
                            "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });
        GridPane.setConstraints(calculateButton, 1, 3);

        // Add clear button
        Button clearButton = new Button("Clear");
        clearButton.setStyle(
                "-fx-font-size: 18pt;" +
                "-fx-font-family: 'Verdana';" +
                "-fx-text-fill: white;" +
                "-fx-background-color: linear-gradient(to bottom, #0072C6, #0054A6);" +
                "-fx-border-color: #0072C6;" +
                "-fx-border-radius: 5;" +
                "-fx-padding: 10;" +
                "-fx-cursor: hand;" +
                "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);"
        );

        clearButton.setOnMouseEntered(event -> {
            clearButton.setStyle(
                    "-fx-font-size: 18pt;" +
                    "-fx-font-family: 'Verdana';" +
                    "-fx-text-fill: white;" +
                    "-fx-background-color: linear-gradient(to bottom, #0054A6, #0072C6);" +
                    "-fx-border-color: #0054A6;" +
                    "-fx-border-radius: 5;" +
                    "-fx-padding: 10;" +
                    "-fx-cursor: hand;" +
                    "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });

        clearButton.setOnMouseExited(event -> {
            clearButton.setStyle(
                    "-fx-font-size: 18pt;" +
                    "-fx-font-family: 'Verdana';" +
                    "-fx-text-fill: white;" +
                    "-fx-background-color: linear-gradient(to bottom, #81b6de, #3f5365);" +
                    "-fx-border-color: #0072C6;" +
                    "-fx-border-radius: 5;" +
                    "-fx-padding: 10;" +
                    "-fx-cursor: hand;" +
                    "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });
        GridPane.setConstraints(clearButton, 0, 3);

        // Add exit button
        Button exitButton = new Button("Exit");
        exitButton.setStyle(
                        "-fx-font-size: 18pt;" +
                        "-fx-font-family: 'Verdana';" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #0072C6, #0054A6);" +
                        "-fx-border-color: #0072C6;" +
                        "-fx-border-radius: 5;" +
                        "-fx-padding: 10;" +
                        "-fx-cursor: hand;" +
                        "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);"
        );

        exitButton.setOnMouseEntered(event -> {
            exitButton.setStyle(
                    "-fx-font-size: 18pt;" +
                            "-fx-font-family: 'Verdana';" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #0054A6, #0072C6);" +
                            "-fx-border-color: #0054A6;" +
                            "-fx-border-radius: 5;" +
                            "-fx-padding: 10;" +
                            "-fx-cursor: hand;" +
                            "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });

        exitButton.setOnMouseExited(event -> {
            exitButton.setStyle(
                    "-fx-font-size: 18pt;" +
                            "-fx-font-family: 'Verdana';" +
                            "-fx-text-fill: white;" +
                            "-fx-background-color: linear-gradient(to bottom, #81b6de, #3f5365);" +
                            "-fx-border-color: #0072C6;" +
                            "-fx-border-radius: 5;" +
                            "-fx-padding: 10;" +
                            "-fx-cursor: hand;" +
                            "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });
        GridPane.setConstraints(exitButton, 2, 3);


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

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


