package assigment1;

public class PalindromeNumber {

	public static void main(String[] args) {
		boolean palin = palindrome(2332);
		System.out.println("The palindrome number " + palin);

	}
	
	public static boolean palindrome(int num) {
		boolean palindrome = true;
		String number = String.valueOf (num);
		int numberLength = number.length();
		
		for(int location =0; location< numberLength/2; location++) {
			if (number.charAt(location) != number.charAt(numberLength-1-location)) {
				palindrome = false;
				return palindrome;
			}
		}
		return palindrome;
	}

}
