package eg1;

public class Exercise03 {
	
	public static void main(String[] args) {
	
		boolean palin = palindromeNumber(2332);
		System.out.println("The palindrome number " + palin);

	}

	public static boolean palindromeNumber(int num) {
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
