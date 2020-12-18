package eg4;

public class CustomMain {

	public static void main(String[] args) {
		Validation v = new Validation(); 
		try {
			if(v.isValidAge(41)) {
				System.out.println("Age is valid");
			}
			
		}catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if (v.isValidMobile("+1-187650983122")) {
				System.out.println("Mobile Number Validated");
			}
		}catch (BusinessException e) {
				System.out.println(e.getMessage());
			}
		}
	}
