package eg1;

public class Exercise03_2 {
	public static void main(String[] args) {
		
		boolean palin = palindromeString("sas");
		System.out.println("The palindrome string " + palin);

	}


	public static boolean palindromeString(String s) {
		
		s = s.toLowerCase();
		int sLength = s.length();
		boolean palindrome = true;
		for(int location = 0; location< sLength/2; location++) {
			if (s.charAt(location) != s.charAt(sLength-1-location)) {
				palindrome = false;
				return palindrome;
			}
		}
		return palindrome;
	}
}
