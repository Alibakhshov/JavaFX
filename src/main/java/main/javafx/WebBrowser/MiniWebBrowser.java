//package main.javafx.WebBrowser;
//
//import javafx.application.Application;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.VPos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Priority;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//import javafx.stage.Stage;
//
//public class MiniWebBrowser extends Application {
//
//    private Scene scene;
//    private TextField addressBar;
//    private WebView webView;
//    private WebEngine webEngine;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Mini Browser");
//
//        // Create the address bar
//        addressBar = new TextField();
//        addressBar.setPromptText("Enter a URL");
//        addressBar.setOnAction(event -> loadWebpage());
//
//        // Create the Go button
//        Button goButton = new Button("Go");
//        goButton.setOnAction(event -> loadWebpage());
//
//        // Create the WebView
//        webView = new WebView();
//        webEngine = webView.getEngine();
//
//        // Add the WebView and address bar to the grid pane
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(5));
//        grid.setHgap(5);
//        grid.setVgap(5);
//
//        ColumnConstraints column1 = new ColumnConstraints();
//        column1.setHgrow(Priority.ALWAYS);
//        grid.getColumnConstraints().add(column1);
//
//        GridPane.setConstraints(addressBar, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.SOMETIMES);
//        GridPane.setConstraints(goButton, 1, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.SOMETIMES);
//        GridPane.setConstraints(webView, 0, 1, 2, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
//
//        grid.getChildren().addAll(addressBar, goButton, webView);
//
//        // Create the Scene
//        scene = new Scene(grid, 800, 600);
//
//        // Add the scene to the Stage
//        primaryStage.setScene(scene);
//
//        // Show the Stage
//        primaryStage.show();
//    }
//
//    private void loadWebpage() {
//        String url = addressBar.getText();
//        if (!url.startsWith("http://") && !url.startsWith("https://")) {
//            url = "http://" + url;
//        }
//        webEngine.load(url + "/index.html");
//    }
//}
//
//
