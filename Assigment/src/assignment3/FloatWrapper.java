package assignment3;

public class FloatWrapper {

	public static void main(String[] args) {
		Float number1 = 1230.5f;   //Auto-boxing
		Float number2 = 1230.5f;
		@SuppressWarnings("deprecation")
		Float number3 = new Float(number1);
		Float number4 = number1;
		
		System.out.println("number1 == number2: " + (number1 == number2));
		System.out.println("number1 == number3: " + (number1 == number3));
		System.out.println("number1 == number4: " + (number1 == number4));
		
		System.out.println("number1.equals(number2): " + number1.equals(number2));
		System.out.println("number1.equals(number3): " + number1.equals(number3));
		System.out.println("number1.equals(number4): " + number1.equals(number4));
		
		float i = number1; //Auto-unboxing
		System.out.println("float i: " + i);
		
		Integer i2 = number1.intValue();
		double d2 = number1.doubleValue();
		System.out.println("number1.intValue(): " + i2);
		System.out.println("number1.doubleValue(): " + d2);
		
		System.out.println("number1.hashCode(): " + number1.hashCode());
		System.out.println("number2.hashCode(): " + number2.hashCode());
		System.out.println("number3.hashCode(): " + number3.hashCode());
		System.out.println("number4.hashCode(): " + number4.hashCode());
		
		Float number5 = i2.floatValue();
		System.out.println("i2.doubleValue(): " + number5);
		
		System.out.println("number5.compareTo(10000.0f): " + number5.compareTo(10000.0f));
		System.out.println("number5.compareTo(10.0f): " + number5.compareTo(10.0f));
		System.out.println("number5.compareTo(1230.0f): " + number5.compareTo(1230.0f));
		
		Double d3 = 1234.56;
		Float number6 = d3.floatValue();
		System.out.println("d3.doubleValue(): " + number6);
		
	}

}
