package assigment1;

public class FibonacciNumbers {

	public static void main(String[] args) {
		fibonacci(100);

	}
	
	public static void fibonacci(int m) {
		int first = 0;
		int second = 1;
		int temp = 0;
		System.out.print(first + "    ");
		System.out.print(second + "    ");
		while(second<m) {
			temp = first + second;
			first = second;
			second = temp;
			System.out.print(second + "    ");
		}
	}
}
