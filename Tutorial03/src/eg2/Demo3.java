package eg2;

public class Demo3 {

	public static void main(String[] args) {
		int ar[] = {12, 33, 11, 344, 11, 12, 11, 11, 23, 11, 44, 11, 22, 11};
		System.out.println("Array elements are:");
		
		for(int i = 0; i<ar.length; i++) {
			System.out.print(ar[i] + "   ");
		}
		
		System.out.println("\nPrime numbers in array elements are:");
		for(int i = 0; i<ar.length; i++) {
			if (isPrime(ar[i])) {
				System.out.print(ar[i] + "  ");
			}
			
		}

	}
	
	public static boolean isPrime(int n) {
		boolean b = false;
		int c = 0;
		for (int i = 1; i<=n; i++) {
			if (n%i == 0) {
				c++;
			}
		}
		if (c>=2) {
			b = true;
		}
		return b;
	}

}
