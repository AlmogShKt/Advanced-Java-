module Advanced.Java {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens mmn11.mmn11q2 to javafx.fxml;
    exports mmn11.mmn11q2;
}