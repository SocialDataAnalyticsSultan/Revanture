package assigment1;

public class PalindromeString {

	public static void main(String[] args) {
		boolean palin = palindrome("sas");
		System.out.println("The palindrome string " + palin);

	}
	
public static boolean palindrome(String s) {
		
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
