package eg5;

public class Demo7 {

	public static void main(String[] args) {
		String s = "hbu  oy76vh.k^*(9fyigl";
		int alphas = 0, upper = 0, lower = 0,digit = 0, alphanum= 0, space =0, special=0;
		for (int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c)){
				alphas++;
			}
			if (Character.isUpperCase(c)) {
				upper++;
			}
			if (Character.isLowerCase(c)) {
				lower++;
			}
			if (Character.isDigit(c)) {
				digit++;
			}
			if (Character.isLetterOrDigit(c)) {
				alphanum++;
			}
			if (Character.isWhitespace(c)) {
				space++;
			}
			if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
				special++;
			}
		}
		
		System.out.println("Alphabetic = " + alphas);
		System.out.println("UpperCase = " + upper);
		System.out.println("LowerCase = " + lower);
		System.out.println("Digit = " + digit);
		System.out.println("LetterOrDigit = " + alphanum);
		System.out.println("Whitespace = " + space);
		System.out.println("Special = " + special);

	}

}
