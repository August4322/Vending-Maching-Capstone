package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineCLI {

	//Instance Variables
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };
	private Menu menu;

	//Constructor
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	VendingMachine vendiMatic800= new VendingMachine();

	//Methods
	public void run() {
		vendiMatic800.inventoryRestock();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			//DISPLAY VENDING MACHINE ITEMS
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (int i = 0; i < vendiMatic800.getProducts().size(); i++) {
					System.out.println(vendiMatic800.getProducts().get(i).toString());
				}

			//DISPLAY PURCHASE OPTIONS
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Current Money Provided: $" + vendiMatic800.totalMoneyInserted);

				String choicePurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				//FEED MONEY
				if (choicePurchase.equals(PURCHASE_MENU_FEED_MONEY)) {
					boolean isFeedingMoreMoney = true;

					//While user is inputting more money
					while (isFeedingMoreMoney) {
						vendiMatic800.feedMoney();
						//See if the user would like to continue inserting money
						System.out.println("Would you like to insert more money? (Y/N)");
						Scanner userInput = new Scanner(System.in);
						String continueYN = userInput.nextLine();

						if (continueYN.equalsIgnoreCase("N")) {
							isFeedingMoreMoney = false;
						} else if (continueYN.equalsIgnoreCase("Y")) {
							isFeedingMoreMoney = true;
						} else if (!(continueYN.equalsIgnoreCase("Y") || continueYN.equalsIgnoreCase("N"))) {
							System.out.println("Please enter a valid response.");
						}
					}

				//SELECT PRODUCT
				} else if (choicePurchase.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
					boolean isSelectingMoreProduct = true;

					// display vending machine items
					for (int i = 0; i < vendiMatic800.getProducts().size(); i++) {
						System.out.println(vendiMatic800.getProducts().get(i).toString());
					}
					//While user is making more selections
					while (isSelectingMoreProduct) {
						vendiMatic800.selectProduct();
						//See if the user would like to continue making selections
						System.out.println("Would you like to select another product? (Y/N)");
						Scanner userInput = new Scanner(System.in);
						String continueYN = userInput.nextLine();

						if (continueYN.equalsIgnoreCase("N")) {
							isSelectingMoreProduct = false;
						} else if (continueYN.equalsIgnoreCase("Y")) {
							isSelectingMoreProduct = true;
						} else if (!(continueYN.equalsIgnoreCase("Y") || continueYN.equalsIgnoreCase("N"))) {
							System.out.println("Please enter a valid response.");
						}
					}

				//FINISH TRANSACTION
				} else if (choicePurchase.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
					//Dispense change


					//Finish Transaction
					continue;
				}

			//EXIT
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	//Main method
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
