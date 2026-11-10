package com.mycompany.restaurant.ordering.app;

/**
 *
 * @author 6375071
 */
public class Order {
    
    private final double chickenSaladPrice = 6.50;
    private final double turkeySandwichPrice = 6.75;
    private final double vegetableWrapPrice = 6.00;
    private final double grilledCheesePrice = 5.00;
    
    private final double coffeePrice = 1.50;
    private final double teaPrice = 1.50;
    private final double sodaPrice = 2.00;
    private final double juicePrice = 1.75;
    
    private String entree = "";
    private String drink = "";
    private String specialRequests = "";
    private boolean water = false;

//    private double calculate() {
//        
//    }
    
    public void setEntree(String entree) {
        this.entree = entree;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public String getEntree() {
        return entree;
    }

    public String getDrink() {
        return drink;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public boolean isWater() {
        return water;
    }

    public boolean hasEntree() {
        return !entree.equals("");
    }

    public boolean hasDrink() {
        return !drink.equals("");
    }
}
