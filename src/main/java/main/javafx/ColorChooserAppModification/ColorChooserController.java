package main.javafx.ColorChooserAppModification;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.text.NumberFormat;

public class ColorChooserController {

    @FXML    private Slider redSlider;
    @FXML    private Slider greenSlider;
    @FXML    private Slider blueSlider;
    @FXML    private TextField redTextField;
    @FXML    private TextField greenTextField;
    @FXML    private TextField blueTextField;
    @FXML    private Circle colorCircle;
    @FXML    private Rectangle colorRectangle;

    private int red = 0;
    private int green = 0;
    private int blue = 0 ;


    public void initialize(){


        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getNumberInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getNumberInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getNumberInstance());


        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        if(newValue.intValue()>=0 && newValue.intValue()<=255){
                            blue = newValue.intValue();
                        }
                        colorRectangle.setFill(Color.rgb(red, green, blue));

                    }
                }
        );

        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        if(newValue.intValue()>=0 && newValue.intValue()<=255){
                            green = newValue.intValue();
                        }
                        colorRectangle.setFill(Color.rgb(red, green, blue));

                    }
                }
        );


        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        if(newValue.intValue()>=0 && newValue.intValue()<=255){
                            red = newValue.intValue();
                        }
                        colorRectangle.setFill(Color.rgb(red, green, blue));
                    }
                }
        );


    }

}