package com.techelevator;

import java.math.BigDecimal;

public class VendingMachineProduct {

    //Instance Variables
    private String slotIdentifier;
    private String name;
    private BigDecimal price;
    private String type;
    private static int amountRemaining;

    //Constructor
    public VendingMachineProduct(String slotIdentifier, String name, BigDecimal price, String type) {
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.type = type;
        this.amountRemaining = 5;
    }

    //Getters
    public String getSlotIdentifier() {
        return slotIdentifier;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public int getAmountRemaining() {
        return amountRemaining;
    }

    //Methods

    //Need to overide toString because it already exists in the Java background
    @Override
    public String toString(){
        if (amountRemaining < 1) {
            return slotIdentifier + ": " + name + "SOLD OUT";
        }
        return slotIdentifier + ": " + name + " - " + getPrice() + " - " + amountRemaining + " remaining";
    }

    public void inventoryDecrement() {
        amountRemaining --;
    }


}
