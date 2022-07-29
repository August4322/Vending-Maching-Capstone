package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    //Instance Variables
    List<VendingMachineProduct> products = new ArrayList<>();
    BigDecimal totalMoneyInserted = new BigDecimal("0.00");
    BigDecimal currentMoneyInserted = new BigDecimal("0.00");

    //Getter
    public List<VendingMachineProduct> getProducts() {
        return products;
    }

    public BigDecimal getTotalMoneyInserted() {
        return totalMoneyInserted;
    }

    public BigDecimal getCurrentMoneyInserted() {
        return currentMoneyInserted;
    }

    //Methods
    public void inventoryRestock() {
        //Initialize scanner to open file (try/catch)
        try (Scanner fileScanner = new Scanner(new File("vendingmachine.csv"))) {
            //Separate the different variables and put them into a new list
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                String[] productDetails = currentLine.split("\\|");
                String slotIdentifier = productDetails[0];
                String name = productDetails[1];
                BigDecimal price = new BigDecimal(productDetails[2]);
                String type = productDetails[3];
                products.add(new VendingMachineProduct(slotIdentifier, name, price, type));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist");
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }

    public void feedMoney() {
        //Prompt user for input
        System.out.println("Current Money Provided: $" + totalMoneyInserted);
        System.out.println("Please enter a valid currency in whole dollar amounts");

        //Get user input
        Scanner userInput = new Scanner(System.in);

        //try/catch to keep Christopher from breaking the code
        try {
            int addMoney = Integer.parseInt(userInput.nextLine());
            BigDecimal maxMoney = new BigDecimal("50.00"); //max is $50 because that's a lot of snackage

            //loop through to see that user has not put more than $50
            while (totalMoneyInserted.compareTo(maxMoney) < 0) {
                //Turn user input into BigDecimal and return current money provided
                if (addMoney == 1) {
                    totalMoneyInserted = currentMoneyInserted.add(new BigDecimal("1.00"));
                    System.out.println("Current Money Provided: $" + totalMoneyInserted);
                } else if (addMoney == 2) {
                    totalMoneyInserted = currentMoneyInserted.add(new BigDecimal("2.00"));
                    System.out.println("Current Money Provided: $" + totalMoneyInserted);
                } else if (addMoney == 5) {
                    totalMoneyInserted = currentMoneyInserted.add(new BigDecimal("5.00"));
                    System.out.println("Current Money Provided: $" + totalMoneyInserted);
                } else if (addMoney == 10) {
                    totalMoneyInserted = currentMoneyInserted.add(new BigDecimal("10.00"));
                    System.out.println("Current Money Provided: $" + totalMoneyInserted);
                } else if (addMoney == 20) {
                    totalMoneyInserted = currentMoneyInserted.add(new BigDecimal("20.00"));
                    System.out.println("Current Money Provided: $" + totalMoneyInserted);
                } else {
                    System.out.println("Please insert valid currency.");
                }

                currentMoneyInserted = totalMoneyInserted;
                break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please insert a valid currency.");
        } catch (Exception ex) {
            System.out.println("Something went wrong.");
        }
    }

    public void selectProduct() {
        //Prompt user for input
        System.out.println("Please enter a valid selection: ");
        Scanner userSelection = new Scanner(System.in);
        String userChoice = userSelection.nextLine();
        List<VendingMachineProduct> purchaseList = new ArrayList<>();


        //try/catch to keep Christopher from breaking the code
        try {
            //Loop through the products
            for (int i = 0; i < products.size(); i++) {
                //get the index of the product
                VendingMachineProduct lookForSnack = this.products.get(i);
                //if the user chooses something
                if (userChoice.equalsIgnoreCase(lookForSnack.getSlotIdentifier())) {
                    //if the user doesn't have enough money
                    if (this.getTotalMoneyInserted().compareTo(lookForSnack.getPrice()) < 0) {
                        System.out.println("Please insert more money.");
                    //if the product is sold out
                    } else if (lookForSnack.getAmountRemaining() == 0) {
                        System.out.println("Sorry, this selection is sold out. Please select a valid product.");
                    //if they finally choose a correct solution and have enough money
                    } else {
                        //Subtract price from total money inserted
                        BigDecimal remainingMoney = totalMoneyInserted.subtract(lookForSnack.getPrice());
                        //Print the name, cost, and money remaining
                        System.out.println(lookForSnack.getName() + "- Cost of product: " + lookForSnack.getPrice() + " - Money remaining: " + remainingMoney);
                        //Print out the type catchphrase
                        if (lookForSnack.getType().equals("Drink")) {
                            System.out.println("Cheers Glug, Glug!");
                        } else if (lookForSnack.getType().equals("Candy")) {
                            System.out.println("Munch Munch, Mmm-Good!");
                        } else if (lookForSnack.getType().equals("Chip")) {
                            System.out.println("Crunch Crunch, Crunch!");
                        } else {
                            System.out.println("Chew Chew, Pop!");
                        }
                        //Decrease amount remaining
                        lookForSnack.inventoryDecrement();
                        //Add selected item to purchase list
                        purchaseList.add(this.products.get(i));
                        //Store the money remaining
                        totalMoneyInserted = remainingMoney;
                    }
                }
            }
        } catch (
                Exception e) {
            System.out.println("Something went wrong.");
        }

    }

    //TODO Finish transaction
    public void finishTransaction() {

    }

}


