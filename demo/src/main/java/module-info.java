module app.java {
    requires javafx.controls;
    requires javafx.fxml;

    opens app.java to javafx.fxml;
    exports app.java;
}
