package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineProduct{

    //Instance Variables

    //Constructors
    public Gum(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    //Getters

    //Setters

    //Methods
    public void gumCatchphrase() {
        System.out.println("Chew Chew, Pop!");
    }
}

//Never actually used these, made them for possible future functionality