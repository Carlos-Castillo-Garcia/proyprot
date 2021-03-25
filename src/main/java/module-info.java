module com.mycompany.proyprot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyprot to javafx.fxml;
    exports com.mycompany.proyprot;
}
