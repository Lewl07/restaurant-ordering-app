package com.mycompany.restaurant.ordering.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OrderSummaryController {

    @FXML
    private Button closeBtn;

    @FXML
    private Label drinkSummaryLbl;

    @FXML
    private Label entreeSummaryLbl;

    @FXML
    private Label requestSummaryLbl;

    @FXML
    private Label totalSummaryLbl;

    @FXML
    private Label waterSummaryLbl;
    
    @FXML
    private Label entreePriceLbl;
    
    @FXML
    private Label drinkPriceLbl;
    
    public void setOrder(Order order) {
        entreeSummaryLbl.setText(order.getEntree());
        entreePriceLbl.setText("$" + String.format("%.2f", order.getEntreePrice()));

        drinkSummaryLbl.setText(order.getDrink());
        drinkPriceLbl.setText("$" + String.format("%.2f", order.getDrinkPrice()));

        if (order.isWater()) {
            waterSummaryLbl.setText("Yes");
        } else {
            waterSummaryLbl.setText("No");
        }

        if (order.getSpecialRequests().trim().equals("")) {
            requestSummaryLbl.setText("None");
        } else {
            requestSummaryLbl.setText(order.getSpecialRequests());
        }

        totalSummaryLbl.setText("$" + String.format("%.2f", order.calcTotal()));
    }
    
    @FXML
    void closeSummary() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
    
}
