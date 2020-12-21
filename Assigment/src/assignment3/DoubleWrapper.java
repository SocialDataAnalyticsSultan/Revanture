package assignment3;

public class DoubleWrapper {

	public static void main(String[] args) {
		Double number1 = 1230.5;   //Auto-boxing
		Double number2 = 1230.5;
		@SuppressWarnings("deprecation")
		Double number3 = new Double(number1);
		Double number4 = number1;
		
		System.out.println("number1 == number2: " + (number1 == number2));
		System.out.println("number1 == number3: " + (number1 == number3));
		System.out.println("number1 == number4: " + (number1 == number4));
		
		System.out.println("number1.equals(number2): " + number1.equals(number2));
		System.out.println("number1.equals(number3): " + number1.equals(number3));
		System.out.println("number1.equals(number4): " + number1.equals(number4));
		
		double i = number1; //Auto-unboxing
		System.out.println("double i: " + i);
		
		Integer i2 = number1.intValue();
		System.out.println("number1.intValue(): " + i2);
		
		System.out.println("number1.hashCode(): " + number1.hashCode());
		System.out.println("number2.hashCode(): " + number2.hashCode());
		System.out.println("number3.hashCode(): " + number3.hashCode());
		System.out.println("number4.hashCode(): " + number4.hashCode());
		
		Double number5 = i2.doubleValue();
		System.out.println("i2.doubleValue(): " + number5);
		
		System.out.println("number5.compareTo(10000.0): " + number5.compareTo(10000.0));
		System.out.println("number5.compareTo(10.0): " + number5.compareTo(10.0));
		System.out.println("number5.compareTo(1230.0): " + number5.compareTo(1230.0));
		
		Double number6 = (double)123.46f;  // Cannot convert float to Double
	}

}
