package assignment2;
import java.util.Scanner;

public class SSNCheck {

	public static void main(String[] args) {
		
		System.out.println("Enter your social security number (SSN): ");
		Scanner sc = new Scanner(System.in);
		String ssn = sc.nextLine();
		
		if (ssn.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}")) {
			System.out.println("Valid SSN Number");
		}else {
			System.out.println("Not Valid SSN Number");
		}
		sc.close();

	}

}
