package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineProduct{

    //Instance Variables

    //Constructors
    public Chips(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    //Getters

    //Setters

    //Methods
    public void chipCatchphrase() {
        System.out.println("Crunch Crunch, Crunch!");
    }
}

//Never actually used these, made them for possible future functionality