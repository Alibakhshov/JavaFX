//package main.javafx;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//import javafx.stage.Stage;
//
//public class Browser extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//        WebView webView = new WebView();
//        WebEngine webEngine = webView.getEngine();
//
//        StackPane root = new StackPane();
//        root.getChildren().add(webView);
//
//        Scene scene = new Scene(root, 800, 600);
//
//        primaryStage.setTitle("JavaFX Browser");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        // Load a web page
//        webEngine.load("https://www.google.com");
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
