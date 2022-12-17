package main.javafx.ColorChooserAppModification;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorChooser extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("ColorChooser.fxml"));

      Scene scene = new Scene(root);
      stage.setTitle("Color Chooser App Modification");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}