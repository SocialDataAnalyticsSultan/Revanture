package assignment2;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println("Palindrome Numbers between 1000 and 9999");
		for (int number=1000; number<=9999; number++) {
			StringBuffer sb=new StringBuffer(String.valueOf(number));
			if (sb.reverse().toString().equals(String.valueOf(number))) {
				System.out.println(number);
			}
		}
	}

}
