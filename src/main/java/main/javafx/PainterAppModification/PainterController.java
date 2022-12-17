package main.javafx.PainterAppModification;// Fig. 13.6: PainterController.java



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

   public Button undoButton;
   public Button clearButton;

   private enum PenSize {
      SMALL(2),
      MEDIUM(4),
      LARGE(6);

      private final int radius;

      PenSize(int radius) {
         this.radius = radius;
      }

      public int getRadius() {
         return radius;
      }
   }

   private int red = 0;
   private int green = 0;
   private int blue = 0;

   @FXML
   private Slider redSlider;

   @FXML
   private Slider greenSlider;

   @FXML
   private Slider blueSlider;

   @FXML
   private TextField redTextField;

   @FXML
   private TextField greenTextField;

   @FXML
   private TextField blueTextField;

   @FXML
   private Rectangle colorRectangle;

   @FXML
   private RadioButton smallRadioButton;
   @FXML
   private RadioButton mediumRadioButton;
   @FXML
   private RadioButton largeRadioButton;
   @FXML
   private Pane drawingAreaPane;
   @FXML
   private ToggleGroup colorToggleGroup;
   @FXML
   private ToggleGroup sizeToggleGroup;


   private PenSize radius = PenSize.MEDIUM;
   private Paint brushColor = Color.BLACK;


   public void initialize() {
      smallRadioButton.setUserData(PenSize.SMALL);
      mediumRadioButton.setUserData(PenSize.MEDIUM);
      largeRadioButton.setUserData(PenSize.LARGE);

      redTextField.textProperty().bind(
              redSlider.valueProperty().asString("%.0f"));
      greenTextField.textProperty().bind(
              greenSlider.valueProperty().asString("%.0f"));
      blueTextField.textProperty().bind(
              blueSlider.valueProperty().asString("%.0f"));


      redSlider.valueProperty().addListener(
              new ChangeListener<Number>() {
                 @Override
                 public void changed(ObservableValue<? extends Number> ov,
                                     Number oldValue, Number newValue) {
                    red = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue));
                    brushColor = Color.rgb(red, green, blue);
                 }
              }
      );
      greenSlider.valueProperty().addListener(
              new ChangeListener<Number>() {
                 @Override
                 public void changed(ObservableValue<? extends Number> ov,
                                     Number oldValue, Number newValue) {
                    green = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue));
                    brushColor = Color.rgb(red, green, blue);
                 }
              }
      );
      blueSlider.valueProperty().addListener(
              new ChangeListener<Number>() {
                 @Override
                 public void changed(ObservableValue<? extends Number> ov,
                                     Number oldValue, Number newValue) {
                    blue = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue));
                    brushColor = Color.rgb(red, green, blue);
                 }
              }
      );
   }

   @FXML
   private void drawingAreaMouseDragged(MouseEvent e) {
      Circle newCircle = new Circle(e.getX(), e.getY(),
              radius.getRadius(), brushColor);
      drawingAreaPane.getChildren().add(newCircle);
   }


   @FXML
   private void sizeRadioButtonSelected(ActionEvent e) {
      radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
   }

   @FXML
   private void undoButtonPressed(ActionEvent event) {
      int count = drawingAreaPane.getChildren().size();

      if (count > 0) {
         drawingAreaPane.getChildren().remove(count - 1);
      }
   }

   @FXML
   private void clearButtonPressed(ActionEvent event) {
      drawingAreaPane.getChildren().clear();
   }
}