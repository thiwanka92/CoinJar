package com.usdcoinjar.application;

import java.util.Scanner;

import com.usdcoinjar.service.impl.ScreenPrinterServiceImpl;
import com.usdcoinjar.service.impl.USDCoinJarServiceImpl;

public class MainApp{
	static USDCoinJarServiceImpl USDimpl = new USDCoinJarServiceImpl();
	static ScreenPrinterServiceImpl printerServiceImpl =new ScreenPrinterServiceImpl(true);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String userInput;
        boolean quit = false;
        System.out.println("Welcome to USD Coin Jar.");
        do {
        	  printerServiceImpl.printOptionMenu(printerServiceImpl.getDefaultMap());
        	  userInput = in.next();
			  
			  switch (validateInput(userInput)) {
			  case 1:
			        System.out.print("Plase enter coin value : ");
			        userInput = in.next();
			        USDimpl.depositCoin(validateInput(userInput));
			        break;
			  case 2:
				  	USDimpl.printJarBalance();
			        break;
			  case 3:
				  	System.out.println(printerServiceImpl.getWarningDataLostMsg());
				  	System.out.print(printerServiceImpl.getConfirmMsg());
				  	Scanner resetScanner = new Scanner(System.in);
			        String  confirm = resetScanner.next();
			        
			        if(confirm.equals("y")) {
			        	USDimpl.resetJar();
			        }
			        break;
			  case 99:
			        quit = true;
			        break;
			  case 0:
				  	System.out.println("\nInvalid input. \n");
			        break;
			  default:
				  	System.out.println(printerServiceImpl.getStartResultMsg());
			        System.out.println("Wrong choice.");
			        System.out.println(printerServiceImpl.getEndResultMsg());
			        break;
			  }
        } while (!quit);
        	System.out.println(printerServiceImpl.getQuitMsg());
        
	}
	
	private static int validateInput(String choice) {
		try {
			return Integer.valueOf(choice);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
