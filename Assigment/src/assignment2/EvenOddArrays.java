package assignment2;
import java.util.Arrays;

public class EvenOddArrays {

	public static void main(String[] args) {
		int arr[] = {11, 12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int evenCount = 0;
		int oddCount = 0;
		int arrLength = arr.length;
		
		System.out.println("Array: " + Arrays.toString(arr));
		for(int index=0; index<arrLength; index++) {
			if(arr[index]%2 == 0) {
				evenCount++;
			}else {
				oddCount++;
			}
		}
		
		if (evenCount>0) {
			int arrEven[] = new int[evenCount];
			int count = 0;
			for(int index=0; index<arrLength; index++) {
				if(arr[index]%2 == 0) {
					arrEven[count] = arr[index];
					count++;
				}
			}
			System.out.println("Even Array: " + Arrays.toString(arrEven));
		}
		
		
		if (oddCount>0) {
			int arrOdd[] = new int[oddCount];
			int count = 0;
			for(int index=0; index<arrLength; index++) {
				if(arr[index]%2 == 1) {
					arrOdd[count] = arr[index];
					count++;
				}
			}
			System.out.println("Odd Array: " + Arrays.toString(arrOdd));
		}

	}

}
