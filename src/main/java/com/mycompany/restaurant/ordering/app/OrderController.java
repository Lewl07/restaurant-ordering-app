package com.mycompany.restaurant.ordering.app;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        entreeLv.getSelectionModel().clearSelection();
        drinkSelection.selectToggle(null);
        waterCb.setSelected(false);
        specialRequestTf.clear();
        updateOrder();
}

    public void initialize() {
        entreeLv.getItems().addAll(
                "Chicken Salad",
                "Turkey Sandwich",
                "Vegetable Wrap",
                "Grilled Cheese");
        
        entreeLv.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
            updateOrder();
        });
        
        drinkSelection.selectedToggleProperty().addListener(
        (observable, oldValue, newValue) -> {
            updateOrder();
        });
    }
    
    @FXML
    void updateOrder() {
        String entree = entreeLv.getSelectionModel().getSelectedItem();
        if (entree == null) {
            order.setEntree("");
        } else {
            order.setEntree(entree);
        }

        RadioButton drinkButton = (RadioButton) drinkSelection.getSelectedToggle();
        if (drinkButton == null) {
            order.setDrink("");
        } else {
            order.setDrink(drinkButton.getText());
        }

        order.setWater(waterCb.isSelected());
        order.setSpecialRequests(specialRequestTf.getText());

        totalLbl.setText(String.format("Total: $%.2f", order.calcTotal()));
    }
    
    @FXML
    void placeOrder() {
        updateOrder();

        if (!order.hasEntree() || !order.hasDrink()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Order");
            alert.setHeaderText(null);
            alert.setContentText("Please select one entrée and one drink before placing your order.");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderSummary.fxml"));
            Parent root = loader.load();

            OrderSummaryController summaryController = loader.getController();
            summaryController.setOrder(order);

            Stage summaryStage = new Stage();
            summaryStage.setTitle("Order Summary");
            summaryStage.setScene(new Scene(root));
            summaryStage.initModality(Modality.APPLICATION_MODAL);
            summaryStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void exitApp() {
        Platform.exit();
    }
    
    @FXML
    void clearEntree() {
        entreeLv.getSelectionModel().clearSelection();
        updateOrder();
    }

    @FXML
    void clearDrink() {
        drinkSelection.selectToggle(null);
        updateOrder();
    }

    @FXML
    void clearSpecialRequest() {
        specialRequestTf.clear();
        updateOrder();
    }

    @FXML
    void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Restaurant Ordering Application");
        alert.setContentText("Version: 1.0\nDeveloper: Leo");
        alert.showAndWait();
    }
}
