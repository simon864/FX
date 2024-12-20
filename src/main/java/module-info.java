module org.example.javalab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javalab5 to javafx.fxml;
    exports org.example.javalab5;
}