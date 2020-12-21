package assignment4;

public class DriverLicencePassportNumberValidation {
	
	public boolean isValidDriverLicence(String driverLicence) throws InvalidDriverLicenceException{
		
		if (!driverLicence.matches("S[0-9]{8}")) {
			throw new InvalidDriverLicenceException("Invalid Driver Licence");
		}
		return true;
	}
	
	public boolean isValidPassportNumber(String passportNumber) throws InvalidPassoportNumberException{
		
		if(!passportNumber.matches("C[0-9]{8}")) {
			throw new InvalidPassoportNumberException("Invalid Passport Number");
		}
		return true;
	}

}
