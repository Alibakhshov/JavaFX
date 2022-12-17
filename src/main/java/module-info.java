module main.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens main.javafx to javafx.fxml;
    exports main.javafx;
    exports main.javafx.tipCalculator;
    opens main.javafx.tipCalculator to javafx.fxml;
    exports main.javafx.EnhancedTipCalculator;
    opens main.javafx.EnhancedTipCalculator to javafx.fxml;
    exports main.javafx.BMICalculator;
    opens main.javafx.BMICalculator to javafx.fxml;
    exports main.javafx.TargetHeartRateCalculator;
    opens main.javafx.TargetHeartRateCalculator to javafx.fxml;
//    exports main.javafx.PainterAppModification.Painter;
    //opens main.javafx.PainterAppModification.Painter to javafx.fxml;
    exports main.javafx.ContactsList;
    opens main.javafx.ContactsList to javafx.fxml;
    exports main.javafx.ContactListModification;
    opens main.javafx.ContactListModification to javafx.fxml;
    exports main.javafx.TipCalculatorModification;
    opens main.javafx.TipCalculatorModification to javafx.fxml;
    exports main.javafx.ColorChooser;
    opens main.javafx.ColorChooser to javafx.fxml;
    opens main.javafx.PainterAppModification to javafx.fxml;
    exports main.javafx.PainterAppModification;
    //exports main.javafx.PainterAppModification.Painter;
//    exports main.javafx.WebBrowser;
//    opens main.javafx.WebBrowser to javafx.fxml;
}