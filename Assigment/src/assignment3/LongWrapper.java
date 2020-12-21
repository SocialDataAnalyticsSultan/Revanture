package assignment3;

public class LongWrapper {

	public static void main(String[] args) {
		Long number1 = 123L;
		int i = 123;
		System.out.println("number.equals(123) = " + number1.equals(123));  // false (types are different)
		System.out.println("number.equals(123) = " + number1.equals(i));  // false (types are different)
		
		
		System.out.println("number.equals(123) = " + number1.equals(123L));
		
		Long number2 = 123L;  //Auto-boxing
		@SuppressWarnings("deprecation")
		Long number3 = new Long(123);
		
		System.out.println("number1 == number2 : " + (number1 == number2));
		System.out.println("number1 == number3 : " + (number1 == number3));  //new operator creates new object and == compares addresses
		
		System.out.println("number1.equals(number2) : " + number1.equals(number2)); // equals compares objects values
		System.out.println("number1.equals(number3) : " + number1.equals(number3));
		
		//int i2 = number1; // Cannot convert Long to int
		long i2 = number1;  // Auto-unboxing
		System.out.println(i2);
		
		System.out.println("Max Long Value: " + Long.MAX_VALUE);
		System.out.println("Min Long Value: " + Long.MIN_VALUE);
		
		String s = "123";
		Long number4 = Long.parseLong(s);
		System.out.println("String to Long with parseLong: " + number4);
		
		System.out.println("Long.toBinaryString(number3): " + Long.toBinaryString(number3));
		System.out.println("Long.toHexString(number3): " + Long.toHexString(number3));
		System.out.println("Long.toOctalString(number3): " + Long.toOctalString(number3));
		
		Double d=12.55;
		Long number5 = d.longValue();
		System.out.println("Double to Long with longValue method: " + number5);

	}

}
