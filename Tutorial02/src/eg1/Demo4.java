package eg1;

public class Demo4 {
	public static void main(String[] args) {
		for(int i = 0; i<10; i++) {
			System.out.println(i);
		}
		
		for (int i = 0, j = 10; i<10; i++, j--) {
			System.out.println("i = " + i + " j = " + j);
		}
		
		System.out.println("Printing all even numbers");
		for(int i = 0; i<=50; i++) {
			if (i%2==0)
				System.out.println(i);
		}
		
		System.out.println();
		int x=0;
		while(x!=10) {
			System.out.println("x = " + x);
			x++;
		}
		
		System.out.println("Value of x before do while = " + x);
		do {
			System.out.println("I will be executed once for sure... I am exist controlled");
		}while(x!=10);

	}
}
