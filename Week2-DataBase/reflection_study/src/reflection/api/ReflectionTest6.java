package reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import reflection.model.TestClass;

public class ReflectionTest6 {

	public static void main(String[] args) {
		
		Class<?> cls;
		
		try {
			cls = Class.forName("reflection.model.TestClass");
			Constructor<?>[] cons = cls.getDeclaredConstructors();
			
			for(Constructor<?> con:cons) {
				System.out.println("Constructor: " + con.getName());
				
				TestClass testClass;
				if(Modifier.toString(con.getModifiers()).equals("private")) {
					con.setAccessible(true);
					testClass = (TestClass) con.newInstance();
				}else {
					testClass = (TestClass) con.newInstance(200, "Constructor");
				}
				
				testClass.showValue();
				
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}