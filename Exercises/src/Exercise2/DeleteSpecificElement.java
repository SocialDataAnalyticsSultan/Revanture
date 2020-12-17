package Exercise2;
import java.util.Arrays;

public class DeleteSpecificElement {

	public static void main(String[] args) {
		int arr[] = {11, 12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		int arrLength = arr.length;
		
		int elementDelete = 11;
		for(int index=0; index<arrLength; index++) {
			if (arr[index] == elementDelete) {
				System.out.println("Deleting element " + arr[index] + " at position " + (index+1));
				for (int index2 = index; index2<arrLength-1; index2++) {
					arr[index2]=arr[index2+1];
				}
				
				index--;
				arr[arrLength-1]=0;
				arrLength = arrLength-1;
				System.out.println(Arrays.toString(arr));
			}
			
		}
	}

}
