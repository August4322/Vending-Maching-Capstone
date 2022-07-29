package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineProduct{

    //Instance Variables

    //Constructors
    public Candy(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    //Getters

    //Setters

    //Methods
    public void candyCatchphrase() {
        System.out.println("Munch Munch, Mmm-Good!");
    }

}

//Never actually used these, made them for possible future functionality