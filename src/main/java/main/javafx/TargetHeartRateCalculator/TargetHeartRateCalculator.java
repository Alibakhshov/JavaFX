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
        titleLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: 'Segoe UI';" +
                        "-fx-padding: 10px 0px 10px 0px;" +
                        "-fx-background-color: #e6e6e6;" +
                        "-fx-border-color: #d9d9d9;" +
                        "-fx-border-width: 0px 0px 1px 0px;" +
                        "-fx-border-style: solid;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 400px;" +
                        "-fx-max-width: 400px;" +
                        "-fx-min-height: 50px;" +
                        "-fx-max-height: 50px;" +
                        "-fx-background-radius: 0px 0px 0px 0px;" +
                        "-fx-border-radius: 0px 0px 0px 0px;" +
                        "-fx-background-insets: 0px 0px 0px 0px;" +
                        "-fx-border-insets: 0px 0px 0px 0px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 0, 0);"
        );
        layout.setTop(titleLabel);

        // Add a grid pane to the center of the layout
        GridPane gridPane = new GridPane();
        gridPane.setStyle(
                        "-fx-background-color: #f2f2f2;" +
                        "-fx-padding: 10px 10px 10px 10px;" +
                        "-fx-hgap: 10px;" +
                        "-fx-vgap: 10px;" +
                        "-fx-background-radius: 1px 0px 0px 1px;" +
                        "-fx-border-radius: 0px 0px 0px 0px;" +
                        "-fx-background-insets: 0px 0px 0px 0px;" +
                        "-fx-border-insets: 0px 0px 0px 0px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 0, 0);"
        );
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Add a label and text field for the user's age
        Label ageLabel = new Label("Age:");
        ageLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;"
        );
        TextField ageField = new TextField();
        ageField.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #000000;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"
        );
        gridPane.add(ageLabel, 0, 0);
        gridPane.add(ageField, 1, 0);

        // Add a label and text field for the user's resting heart rate
        Label restingHeartRateLabel = new Label("Resting Heart Rate:");
        restingHeartRateLabel.setStyle(
                        "-fx-font-size: 20px;" +
                        "-fx-text-fill: #15151a;"
        );
        TextField restingHeartRateField = new TextField();
        restingHeartRateField.setStyle(
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #000000;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;"
        );
        gridPane.add(restingHeartRateLabel, 0, 1);
        gridPane.add(restingHeartRateField, 1, 1);

        // Add the grid pane to the center of the layout
        layout.setCenter(gridPane);

        // Add a button to the bottom of the layout
        Button calculateButton = new Button("Calculate");
        calculateButton.setStyle(
                "-fx-font-size: 18pt;" +
                        "-fx-font-family: 'Verdana';" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: linear-gradient(to bottom, #67a474, #379827);" +
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
                            "-fx-background-color: linear-gradient(to bottom, #b7cc83, #4e6518);" +
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
                            "-fx-background-color: linear-gradient(to bottom, #3f4346, #3f5365);" +
                            "-fx-border-color: #0072C6;" +
                            "-fx-border-radius: 5;" +
                            "-fx-padding: 10;" +
                            "-fx-cursor: hand;" +
                            "fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 1);");
        });
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
            targetHeartRateLabel.setStyle(
                            "-fx-font-size: 20px;" +
                            "-fx-text-fill: #15151a;"
            );
            layout.setBottom(targetHeartRateLabel);
        });

        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


