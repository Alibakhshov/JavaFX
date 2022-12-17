package main.javafx.ColorChooser;// Fig. 13.8: Colorchooser.java
// Main application class that loads and displays the ColorChooser's GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorChooser extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("ColorChooser.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("Color Chooser");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}

