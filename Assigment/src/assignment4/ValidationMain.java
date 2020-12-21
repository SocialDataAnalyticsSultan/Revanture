package assignment4;

public class ValidationMain {

	public static void main(String[] args) {
		DriverLicencePassportNumberValidation valid = new DriverLicencePassportNumberValidation();

		try {
			if (valid.isValidDriverLicence("S001122334")) {
				System.out.println("Valid Driver Licence");
			}
		} catch (InvalidDriverLicenceException e) {
			System.out.println(e.getMessage());
		}

		try {
			if (valid.isValidPassportNumber("C112233445")) {
				System.out.println("Valid Passport Number");
			}
		} catch (InvalidPassoportNumberException e) {
			System.out.println(e.getMessage());
		}

	}
}
