package eg1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormating {

	public static void main(String[] args) {

		Date d = new Date(); //Capture current date
		System.out.println("Default date object: " + d);
		
		/*
		 *  dd - date in 2 digit
		 *  MM - month in 2 digit
		 *  MMM - short name of month
		 *  MMMM - full name of month
		 *  yy - last 2 digit of year
		 *  yyyy - full name of year
		 *  EEE - day in short name
		 *  EEEE - full day name
		 *  mm - minutes
		 *  ss - seconds
		 *  hh - hours
		 *  z/Z - time zone
		 *  a - am/pm
		 *  
		 *  */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy EEEE  zZ hh:mm:ss  a");
		System.out.println("formated date: " + sdf.format(d));  //format takes date and gives formatted date as String
		
	}

}
