package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends VendingMachineProduct{

    //Instance Variables

    //Constructors
    public Beverages(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    //Getters

    //Setters

    //Methods

    public void drinkCatchphrase() {
        System.out.println("Cheers Glug, Glug!");
    }

}

//Never actually used these, made them for possible future functionality