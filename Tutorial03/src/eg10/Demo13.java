package eg10;
import java.util.Arrays;
import java.util.Scanner;

public class Demo13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements");
		int number = sc.nextInt();
		
		System.out.println("Enter " + number + " Elements");
		int arr[] = new int[number];
		
		for(int index=0; index<number; index++) {
			arr[index] = sc.nextInt();
		}
		
		System.out.println("Array Before Sorting...");
		System.out.println(Arrays.toString(arr));
		System.out.println("Array After Sorting...");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		

	}

}
