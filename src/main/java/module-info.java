module com.example.beopmmufx {
    exports com.example.beopmmufx.controller;
    opens com.example.beopmmufx.controller to javafx.fxml; // 이 줄을 추가합니다.
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.beopmmufx to javafx.fxml;
    exports com.example.beopmmufx;
}