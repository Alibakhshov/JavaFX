package main.javafx.TargetHeartRateCalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TargetHeartRateCalculator extends Application {

    public void start(Stage primaryStage) {
        // Create a Scene and set it as the stage's scene
        Scene scene = new Scene(createLayout());
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    private BorderPane createLayout() {
        // Create a BorderPane layout
        BorderPane layout = new BorderPane();

        // Add a title label to the top of the layout
        Label titleLabel = new Label("Heart Rate Calculator");
        layout.setTop(titleLabel);

        // Add a grid pane to the center of the layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add a label and text field for the user's age
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        gridPane.add(ageLabel, 0, 0);
        gridPane.add(ageField, 1, 0);

        // Add a label and text field for the user's resting heart rate
        Label restingHeartRateLabel = new Label("Resting Heart Rate:");
        TextField restingHeartRateField = new TextField();
        gridPane.add(restingHeartRateLabel, 0, 1);
        gridPane.add(restingHeartRateField, 1, 1);

        // Add the grid pane to the center of the layout
        layout.setCenter(gridPane);

        // Add a button to the bottom of the layout
        Button calculateButton = new Button("Calculate");
        layout.setBottom(calculateButton);



        // When the user clicks the calculate button, calculate and display the target heart rate
        calculateButton.setOnAction(event -> {
            // Get the user's age and resting heart rate from the text fields
            int age = Integer.parseInt(ageField.getText());
            int restingHeartRate = Integer.parseInt(restingHeartRateField.getText());

            // Calculate the target heart rate
            double targetHeartRate = (((220 - age) - restingHeartRate) * 0.85) + restingHeartRate;

            // Display the target heart rate
            Label targetHeartRateLabel = new Label("Target Heart Rate: " + targetHeartRate);
            layout.setBottom(targetHeartRateLabel);
        });

        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }



}


