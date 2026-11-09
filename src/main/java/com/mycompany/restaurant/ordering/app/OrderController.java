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
    
    public Button getClearOrderBtn() {
        return clearOrderBtn;
    }
    
    public Button getPlaceOrderBtn() {
        return placeOrderBtn;
    }
    
    public RadioButton getCoffeeBtn() {
        return coffeeBtn;
    }
    
    public ToggleGroup getToggleGroup() {
        return drinkSelection;
    }
    
    public ListView<String> getEntreeLv() {
        return entreeLv;
    }
    
    public RadioButton getJuiceBtn() {
        return juiceBtn;
    }
    
    public RadioButton getSodaBtn() {
        return sodaBtn;
    }
    
    public TextField getSpecialRequestTf() {
        return specialRequestTf;
    }
    
    public RadioButton getTeaBtn() {
        return teaBtn;
    }
    
    public Label getTotalLbl() {
        return totalLbl;
    }
    
    public CheckBox getWaterCb() {
        return waterCb;
    }
}
