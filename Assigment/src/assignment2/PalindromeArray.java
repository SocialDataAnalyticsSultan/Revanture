package assignment2;

public class PalindromeArray {

	public static void main(String[] args) {
		int arr[] = {11, 12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int arrLength = arr.length;
		
		for(int index=0; index<arrLength; index++) {
			if(palindrome(arr[index])) {
				System.out.println(arr[index] + " is palindrome number.");
			}
		}

	}
	
	public static boolean palindrome(int num) {
		String number = String.valueOf(num);
		StringBuilder sb = new StringBuilder(number);
		sb.reverse();
		if (number.equals(sb.toString())) {
			return true;
		}
		return false;
	}

}
