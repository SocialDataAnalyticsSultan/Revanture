package reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest1 {
	
	public static void main(String[] args) {
		
		try {
			Class<?> c = Class.forName("reflection.model.Person");
			
			//Getting constructor of the class
			Constructor<?>[] constructors = c.getConstructors();
			System.out.println("Constructors: " + Arrays.toString(constructors));
			
			//Getting all methods of the class included inherited ones
			Method [] methods = c.getMethods();
			System.out.println("Methods: " + Arrays.toString(methods));
			
			//Getting methods of the class
			Method [] declaredMethods = c.getDeclaredMethods();
			System.out.println("Declared Methods: " + Arrays.toString(declaredMethods));
			
			//Getting fields of the class
			Field[] declaredField = c.getDeclaredFields();
			System.out.println("Declared Fields: " + Arrays.toString(declaredField));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
	}
}