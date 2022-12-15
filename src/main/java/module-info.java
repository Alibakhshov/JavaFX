module main.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens main.javafx to javafx.fxml;
    exports main.javafx;
    exports main.javafx.tipCalculator;
    opens main.javafx.tipCalculator to javafx.fxml;
    exports main.javafx.EnhancedTipCalculator;
    opens main.javafx.EnhancedTipCalculator to javafx.fxml;
}