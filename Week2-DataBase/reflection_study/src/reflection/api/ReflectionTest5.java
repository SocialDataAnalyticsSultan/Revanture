package reflection.api;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ReflectionTest5 {

	public static void main(String[] args) {
		
		try {
			
			Class<?> cls = Class.forName("reflection.model.TestClass");
			
			//Constructor with two argument
			Constructor<?> constructor = cls.getConstructor(int.class, String.class);
			System.out.println("Constructor: " + constructor.toString());
			
			//All constructors
			Constructor<?>[] constructors = cls.getConstructors();
			System.out.println("Constructors: " + Arrays.toString(constructors));
			
			//Private constructor
			constructor = cls.getDeclaredConstructor();
			System.out.println("Constructor: " + constructor.toString());
			
			//All constructor
			constructors = cls.getDeclaredConstructors();
			System.out.println("Constructors: " + Arrays.toString(constructors));
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

}
