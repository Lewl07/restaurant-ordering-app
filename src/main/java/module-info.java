module com.mycompany.restaurant.ordering.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.restaurant.ordering.app to javafx.fxml;
    exports com.mycompany.restaurant.ordering.app;
}
