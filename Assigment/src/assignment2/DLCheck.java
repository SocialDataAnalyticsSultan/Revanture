package assignment2;

import java.util.Scanner;

public class DLCheck {

	public static void main(String[] args) {
		System.out.println("Enter your driver licence number (DL): ");
		Scanner sc = new Scanner(System.in);
		String dl = sc.nextLine();
		
		if(dl.matches("S[0-9]{8}")) {
			System.out.println("Valid Driver Licence");
		}else {
			System.out.println("Invalid Driver Licence");
		}
		
		sc.close();

	}

}
