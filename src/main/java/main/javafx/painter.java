package main.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



public class painter extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private ColorPicker colorPicker;
    private Slider penSizeSlider;
    private Button saveButton;
    private Pane drawingPane;
    private List<Line> lines;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Painter");

        // Set up the color picker
        colorPicker = new ColorPicker(Color.BLACK);

        // Set up the pen size slider
        penSizeSlider = new Slider(1, 10, 1);

        // Set up the save button
        saveButton = new Button("Save");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveDrawing();
            }
        });

        // Set up the drawing pane
        drawingPane = new Pane();
        drawingPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMousePressed(event);
            }
        });
        drawingPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMouseDragged(event);
            }
        });

        // Set up the lines list
        lines = new ArrayList<>();

        // Set up the top toolbar
        HBox toolbar = new HBox();
        toolbar.getChildren().addAll(colorPicker, penSizeSlider, saveButton);

        // Set up the root pane
        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setCenter(drawingPane);

        // Set up the scene and show the stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void handleMousePressed(MouseEvent event) {
        // Create a new line
        Line line = new Line();
        line.setStartX(event.getX());
        line.setStartY(event.getY());
        line.setEndX(event.getX());
        line.setEndY(event.getY());
        line.setStroke(colorPicker.getValue());
        line.setStrokeWidth(penSizeSlider.getValue());

        // Add the line to the drawing pane and the lines list
        drawingPane.getChildren().add(line);
        lines.add(line);
    }

    private void handleMouseDragged(MouseEvent event) {
        // Get the most recently added line
        Line line = lines.get(lines.size() - 1);

        // Update the end coordinates of the line
        line.setEndX(event.getX());
        line.setEndY(event.getY());
    }

    private void saveDrawing() {
        // Create a file chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Drawing");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG", "*.png"));

        // Show the file chooser
        File file = fileChooser.showSaveDialog(null);


        }
    }

