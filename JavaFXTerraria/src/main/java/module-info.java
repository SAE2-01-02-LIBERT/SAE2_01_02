module com.example.javafxterraria {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxterraria to javafx.fxml;
    exports com.example.javafxterraria;
}