package assignment2;
import java.util.Arrays;

public class EvenOddArraySum {

	public static void main(String[] args) {
		int arr[] = {11, 12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int arrLength = arr.length;
		int evenSum = 0;
		int oddSum = 0;
		
		System.out.println("Array: " + Arrays.toString(arr));
		for(int index=0; index<arrLength; index++) {
			if (arr[index]%2 == 0) {
				evenSum += arr[index];
			}else {
				oddSum += arr[index];
			}
		}
		
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of even numbers: " + oddSum);
		
		if(evenSum > oddSum) {
			System.out.println("Even numbers sum is greater than odd numbers sum");
		}else {
			System.out.println("Odd numbers sum is greater than Even numbers sum");
		}

	}

}
