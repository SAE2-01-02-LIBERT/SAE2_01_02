module com.example.terrariafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.terrariafx to javafx.fxml;
    exports com.example.terrariafx;
}