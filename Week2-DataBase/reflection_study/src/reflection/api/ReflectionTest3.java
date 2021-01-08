package reflection.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import reflection.model.Welcome;

public class ReflectionTest3 {
	
	public static void main(String[] args) {
		
		Class<?> cls;
		try {
			cls = Class.forName("reflection.model.Welcome");
			Method method = cls.getDeclaredMethod("greet", String.class);
			method.setAccessible(true);
			
			Object object = method.invoke(new Welcome(), "Sultan");
			String result = (String)object;
			System.out.println(result);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
