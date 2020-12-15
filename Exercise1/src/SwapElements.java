
public class SwapElements {

	public static void main(String[] args) {
		int[] elements = {1, 2, 3, 4, 5};
	    
	    /*Put your code here to swap the first element with the last*/
		int temp;
		temp = elements[0];
		elements[0] = elements[elements.length-1];
		elements[elements.length-1] = temp;
		
		System.out.println(elements[0]);
		System.out.println(elements[elements.length-1]);

	}

}
