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

public class PrimaryController {

    @FXML
    private Button clearOrderBtn;

    @FXML
    private RadioButton coffeeBtn;

    @FXML
    private ToggleGroup drinkSelection;

    @FXML
    private ListView<String> entreeLv;

    @FXML
    private RadioButton juiceBtn;

    @FXML
    private Button placeOrderBtn;

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
    
    private final double chickenSaladPrice = 6.50;
    private final double turkeySandwichPrice = 6.75;
    private final double vegetableWrapPrice = 6.00;
    private final double grilledCheesePrice = 5.00;
    
    private final double coffeePrice = 1.50;
    private final double teaPrice = 1.50;
    private final double sodaPrice = 2.00;
    private final double juicePrice = 1.75;
    
    @FXML
    void clearOrder(ActionEvent event) {
        entreeLv.getSelectionModel().clearSelection();
        drinkSelection.selectToggle(null);
        waterCb.setSelected(false);
        specialRequestTf.setText("");
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
