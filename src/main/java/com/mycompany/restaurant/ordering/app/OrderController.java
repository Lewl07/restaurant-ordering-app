package com.mycompany.restaurant.ordering.app;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class OrderController {
    
    private Order order = new Order();

    @FXML
    private Button clearOrderBtn;

    @FXML
    private Button placeOrderBtn;
    
    @FXML
    private RadioButton coffeeBtn;

    @FXML
    private ToggleGroup drinkSelection;

    @FXML
    private ListView<String> entreeLv;

    @FXML
    private RadioButton juiceBtn;

    @FXML
    private RadioButton sodaBtn;

    @FXML
    private TextField specialRequestTf;

    @FXML
    private RadioButton teaBtn;

    @FXML
    private Label totalLbl;

    @FXML
    private CheckBox waterCb;
    
    @FXML
    void clearOrder(ActionEvent event) {
        order.clear();
        totalLbl.setText("Total: $0.00");
    }

    @FXML
    void placeOrder(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
    public void initialize() {
        entreeLv.getItems().addAll(
                "Chicken Salad",
                "Turkey Sandwich",
                "Vegetable Wrap",
                "Grilled Cheese");
    }
}
