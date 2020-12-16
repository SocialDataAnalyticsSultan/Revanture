package eg2;

public class Calculator_Main {

	public static void main(String[] args) {
		Calculator cal1 = new Calculator("Hi hi");
		Calculator cal2 = new Calculator(100);
		Calculator cal3 = new Calculator(10, 5);
		System.out.println(cal3.add());
	}

}
