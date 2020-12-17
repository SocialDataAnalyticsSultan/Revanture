package assignment2;

public class ArrayReverseOrder {

	public static void main(String[] args) {
		int arr[] = {12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int arrLength = arr.length;
		System.out.println("Array:");
		for (int index=0; index<arrLength; index++) {
			System.out.print(arr[index] + "   ");
		}
		System.out.println();
		System.out.println("Array in reverse order:");
		for (int index=arrLength-1; index >= 0; index--) {
			System.out.print(arr[index] + "   ");
		}
		System.out.println();

	}

}
