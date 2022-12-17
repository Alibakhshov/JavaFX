package main.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Colorchooser extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Create a color picker
        ColorPicker colorPicker = new ColorPicker();


        // Create a text label
        Text label = new Text("Choose a color:");
        label.setFont(new Font(20));

        // Create a button
        Button button = new Button("OK");
        button.setOnAction(event -> {
            Color color = colorPicker.getValue();
            label.setFill(color);
        });

        // Create a vertical layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(label, colorPicker, button);

        // Set the scene and show the stage
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Color Chooser");
        stage.show();
    }
}



