module main.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens main.javafx to javafx.fxml;
    exports main.javafx;
}