package eg1;

public class Exercise02 {

	public static void main(String[] args) {
		fibonacciNumbers(100);

	}

	public static void fibonacciNumbers(int m) {
		int first = 0;
		int second = 1;
		int temp = 0;
		System.out.print(first + "    ");
		System.out.print(second + "    ");
		do {
			temp = first + second;
			first = second;
			second = temp;
			System.out.print(second + "    ");
		}while(second<m);
	}
}
