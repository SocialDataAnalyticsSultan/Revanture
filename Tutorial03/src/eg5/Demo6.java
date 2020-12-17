package eg5;

import java.util.Arrays;

public class Demo6 {
	public static void main(String[] args) {
		String s1 = "Hello";
		System.out.println("s1 = " + s1);
		System.out.println("s1.toUpperCase() = " + s1.toUpperCase());
		System.out.println("s1 = " + s1);
		s1 = s1.toUpperCase();
		System.out.println("s1 = " + s1);
		
		System.out.println("s1.length() = " + s1.length());
		System.out.println("s1.charAt(0) = " + s1.charAt(0));
		
		System.out.println("s1.equals(\"HELLO\")" + s1.equals("HELLO"));
		System.out.println("s1.equals(\"Hello\")" + s1.equals("Hello"));
		
		System.out.println("s1.equalsIgnoreCase(\"HELLO\") =  " + s1.equalsIgnoreCase("HELLO"));
		System.out.println("s1.equalsIgnoreCase(\"Hello\") =  " + s1.equalsIgnoreCase("Hello"));
		
		System.out.println("s1.contains(\"L\") = " + s1.contains("L"));
		System.out.println("s1.contains(\"LL\") = " + s1.contains("LL"));
		System.out.println("s1.contains(\"LOL\") = " + s1.contains("LOL"));
		
		char c[] = s1.toCharArray();
		System.out.println(Arrays.toString(c));
		
		System.out.println("s1.substring(2) = " + s1.substring(2));
		System.out.println("s1.substring(2, 4) = " + s1.substring(2, 4));
		
		System.out.println("s1.toLowerCase() = " + s1.toLowerCase());
		String s2 = "Hello hi good afternoon and it is lunch time";
		String ar[] = s2.split(" ");
		for(int i = 0; i<ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		String s3 = "      heyyyy.     ";
		System.out.println(s3);
		s3 = s3.trim();
		System.out.println(s3);
		
		System.out.println(s2.replace(" ", "-"));
		
	}

}
