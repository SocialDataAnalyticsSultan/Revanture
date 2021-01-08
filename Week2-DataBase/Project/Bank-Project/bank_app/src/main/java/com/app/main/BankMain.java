package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankMain {
	
	private static Logger log=Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO ASYA BANK");
		System.out.println("====================");
		
		int choice = 0;
		do {
			System.out.println("BANK MAIN MENU");
			System.out.println("====================");
			System.out.println("Please enter:");
			System.out.println("1) If you are customer");
			System.out.println("2) If you are emplooye");
			System.out.println("3) If you a newcomer");
			System.out.println("4)EXIT");
			System.out.println("Please enter appropriate choice between 1-4\n");
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.error(e.getMessage());
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("Please enter the following information to open an account");
				break;
			
			case 4:
				System.out.println("Thank you for using Asya Bank App");
				boolean applicationConfirmation = false;
				
				break;
			
			default:
				System.out.println("Invalid Input");
				System.out.println("Please enter appropriate choice between 1-4\n");
			}
			
		}while(choice!=4);

	}

}
