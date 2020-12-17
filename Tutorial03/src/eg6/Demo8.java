package eg6;

public class Demo8 {

	public static void main(String[] args) {
		// Reg-Ex - Regular Expression
		// writing using some wild cards to match pattern
		
		// [] - to write an expression
		// {} represent length
		// ^ represent not
		// [0-9]{5} - any digit length 5
		// [a-zA-Z] {6} any word of length 6
		// [a-zA-Z0-9]{2,6} any alphanumeric length between 2 and 6
		// [A-Z]{1,} min 1 uppercase character, max can be any
		// [^a-z] - apart from letter anything can expected
		
		String s = "vcjdegfjedb  97409uhgb ^*)*^R$ jkj";
		System.out.println(s.replaceAll("[^a-zA-Z]", ""));
		System.out.println(s.replaceAll("[^a-zA-Z]", "").length());
		
		System.out.println(s.replaceAll("[^0-9]", ""));
		System.out.println(s.replaceAll("[^a-zA-Z0-9]", ""));
		
		String ex = "ABIDM1234U";
		if(ex.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			System.out.println("Matched");
		}else {
			System.out.println("Not Matched");
		}
		
		String phone = "+1-1234567890";
		if(phone.matches("\\+1-[0-9]{10}")) {
			System.out.println("Valid Mobile Number");
		}else {
			System.out.println("Not Valid Mobile Number");
		}
	}

}
