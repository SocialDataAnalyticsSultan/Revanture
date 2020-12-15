package eg1;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println(sumOfNumbers(10, 2, 1, 3, 4, 45));
		System.out.println(sumOfNumbers(10, 2, 1));
		System.out.println(sumOfNumbers());

	}
	
	public static int sumOfNumbers(int...a) {
		int sum = 0;
		for (int i:a) {
			sum = sum + i;
		}
		return sum;
	}
}