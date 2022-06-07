module com.example.terrariafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.junit.jupiter.api;

    opens com.example.terrariafx to javafx.fxml;
    exports com.example.terrariafx;
}