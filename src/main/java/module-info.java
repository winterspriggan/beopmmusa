module com.example.beopmmufx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.beopmmufx to javafx.fxml;
    exports com.example.beopmmufx;
}