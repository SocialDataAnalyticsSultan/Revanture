package assignment2;
import java.util.Arrays;

public class MaxMinArray {

	public static void main(String[] args) {
		int arr[] = {11, 12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int arrLength = arr.length;
		int minNumber = arr[0];
		int maxNumber = arr[0];
		
		System.out.println("Array: " + Arrays.toString(arr));
		for(int index=1; index<arrLength; index++) {
			if (arr[index]<minNumber) {
				minNumber = arr[index];
			}
			if (arr[index]>maxNumber) {
				maxNumber = arr[index];
			}
		}
		
		System.out.println("Minimum number in array: " + minNumber);
		System.out.println("Maximum number in array: " + maxNumber);

	}

}
