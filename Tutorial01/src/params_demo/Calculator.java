package params_demo;

public class Calculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		int res = c.add(100, 22);
		System.out.println("Addition: " + res);
		
		c.multiply(5, 3);
		
		System.out.println(c.isEvenNumber(14));
		
	}
	
	public int add(int a, int b) {
		return (a+b);
	}
	
	public void multiply(int x, int y) {
		System.out.println("Result of multiply: " + (x*y));
	}
	
	public boolean isEvenNumber(int num) {
		boolean b = false;
		if (num%2 == 0) {
			b = true;
		}
		return b;
	}

}


