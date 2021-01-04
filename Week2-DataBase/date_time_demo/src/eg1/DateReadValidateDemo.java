package eg1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateReadValidateDemo {
	public static void main(String[] args) {
		//dd.MM.yyyy
		String s = "32.02.2000";  
	
	
		if(s.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")) {
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			sdf.setLenient(false);
			
			Date dob = null;
			try {
				dob = sdf.parse(s); // takes String and returns date object
				System.out.println("dob validated: " + dob);
				}catch(ParseException e) {
					System.out.println(e);
				}
		}else {
			System.out.println("Invalid Date");
		}
		
		}
	}

