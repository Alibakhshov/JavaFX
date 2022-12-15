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
        // Create a grid pane to hold the input fields and labels
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Create the input fields and labels
        TextField weightField = new TextField();
        TextField heightField = new TextField();
        Label bmiLabel = new Label();

        grid.add(new Label("Weight (kg):"), 0, 0);
        grid.add(weightField, 1, 0);
        grid.add(new Label("Height (cm):"), 0, 1);
        grid.add(heightField, 1, 1);
        grid.add(new Label("BMI:"), 0, 2);
        grid.add(bmiLabel, 1, 2);

        // Create the calculate button and set its action
        Button calcButton = new Button("Calculate BMI");
        calcButton.setOnAction(event -> {
            // Get the weight and height from the input fields
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            // Calculate the BMI
            double bmi = weight / (height / 100.0 * height / 100.0);

            // Display the BMI in the label
            bmiLabel.setText(String.format("%.1f", bmi));
        });
        grid.add(calcButton, 1, 3);

        // Create the scene and set the CSS stylesheet
        Scene scene = new Scene(grid, 350, 200);
//        scene.getStylesheets().add("bmi-calculator.css");

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.show();
    }
}
