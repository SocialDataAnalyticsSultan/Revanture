package eg4;

public class Validation  {
	public boolean isValidAge(int age)throws InvalidAgeException {
		
		if(age<=0) {
			throw new InvalidAgeException("Age cannot be zero or negative");
		}
		
		if (age<18 || age>40) {
			throw new InvalidAgeException("Only users between 18 and 40 can register");
		}
		return true;
	}
	
	public boolean isValidMobile(String mobileNumber)throws BusinessException {
		
		if(!mobileNumber.matches("\\+1-[0-9]{10}")) {
			throw new BusinessException("Entered mobile number " + mobileNumber + " is not valid");
		}
		return true;
		
	}
	
	

}
