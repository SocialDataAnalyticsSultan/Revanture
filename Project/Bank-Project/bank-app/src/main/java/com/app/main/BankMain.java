package com.app.main;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.service.CustomerApplicationService;
import com.app.service.CustomerService;
import com.app.service.EmployeeService;
import com.app.service.impl.CustomerApplicationServiceImpl;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.EmployeeServiceImpl;

public class BankMain {
	
	private static Logger logBank =Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		
		System.out.println("Wellcome to Asya Bank");
		System.out.println("------------------------------");
		
		int choice = 0;
		int attempt = 0;
		boolean validChoice = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("Please enter ");
			System.out.println("1 if you are a custumer.");
			System.out.println("2 if you are a employee.");
			System.out.println("3 if you want to be a customer.");
			System.out.println();
			
			try {
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
			}catch(NumberFormatException e) {
				logBank.error(e.getMessage());
			}
			attempt++;
			
			switch(choice) {
			case 1:
				validChoice = true;
				CustomerService customerService = new CustomerServiceImpl();
				
				try {
					boolean logIn = customerService.customerLogIn();
					
					if (logIn) {
						
						boolean validCustomerServiceChoice = false;
						int customerServiceChoice = 0;
						int customerServiceAttempt = 0;
						
						do {
							customerServiceAttempt++;
							
							System.out.println();
							System.out.println("Please enter ");
							System.out.println("1 if you would like see your account information.");
							System.out.println("2 if you would like make a deposit in your account.");
							System.out.println("3 if you would like withdraw from your account.");
							System.out.println("4 if you would like make transaction to another account.");
							System.out.println("5 if you would like see your transaction history.");
							System.out.println("6 if you would like apply for a loan.");
							System.out.println("7 if you would like pay for your loan.");
							System.out.println("8 if you would like to see loan payment history.");
							
							try {
								customerServiceChoice = Integer.parseInt(sc.nextLine());
								System.out.println();
								
								switch (customerServiceChoice) {
								case 1:
									validCustomerServiceChoice = true;
									
									break;
								case 2:
									validCustomerServiceChoice = true;
									break;
								case 3:
									validCustomerServiceChoice = true;
									break;
								case 4:
									validCustomerServiceChoice = true;
									break;
								case 5:
									validCustomerServiceChoice = true;
									break;
								case 6:
									validCustomerServiceChoice = true;
									break;
								case 7:
									validCustomerServiceChoice = true;
									break;
								case 8:
									validCustomerServiceChoice = true;
									break;
								default:
									System.out.println("Choice you entered is not valid");
									System.out.println(attempt + " outof 3 attempt");
									break;
								}
							}catch(NumberFormatException e) {
								logBank.error(e.getMessage());
								}
							
							}while(customerServiceAttempt<3 && !validCustomerServiceChoice);
						} 
				}catch (BankException e) {
					e.printStackTrace();
					}
				break;
				
			case 2:
				validChoice = true;
				EmployeeService employeeService = new EmployeeServiceImpl();
				boolean logIn;
				try {
					logIn = employeeService.employeeLogIn();
					if (logIn) {
						boolean validEmployeeServiceChoice = false;
						int employeeServiceChoice = 0;
						int employeeServiceAttempt = 0;
						
						do {
							employeeServiceAttempt++;
							
							System.out.println();
							System.out.println("Please enter ");
							
							System.out.println("1 if you would like search customer account information.");
							System.out.println("2 if you would like search customer loan information.");
							System.out.println("3 if you would like search customer transaction information.");
							
							try {
								employeeServiceChoice = Integer.parseInt(sc.nextLine());
								System.out.println();
							}catch(NumberFormatException e) {
								logBank.error(e.getMessage());
							}
							
							switch(employeeServiceChoice) {
							case 1:
								validEmployeeServiceChoice = true;
								break;
							case 2:
								validEmployeeServiceChoice = true;
								break;
							case 3:
								validEmployeeServiceChoice = true;
								break;
							default: 
								System.out.println("Choice you entered is not valid");
								System.out.println(attempt + " outof 3 attempt");
								break;	
							}
							
						}while(employeeServiceAttempt<3 && !validEmployeeServiceChoice);	
					}
				} catch (BankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			
			case 3:
				validChoice = true;
				CustomerApplicationService newCustomerApplicationService = new CustomerApplicationServiceImpl();
				try {
					Customer newCustomer = newCustomerApplicationService.customerApplication();
				} catch (ClassNotFoundException | BankException | ParseException | SQLException e) {
					e.printStackTrace();
				}
				
				break;
			default:
				System.out.println("Choice you entered is not valid");
				System.out.println(attempt + " outof 3 attempt");
				break;
			}
			
		}while(attempt < 3 && !validChoice);
		
		if(attempt == 3 && !validChoice) {
			System.out.println();
			System.out.println("Please try to enter the system later...");
			System.out.println("HAVE NICE DAY!!!!");
		}
		
		sc.close();
	}

}
