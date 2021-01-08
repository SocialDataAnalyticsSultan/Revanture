package reflection.api;

import java.lang.reflect.Field;

import reflection.model.Welcome2;

public class ReflectionTest4 {

	public static void main(String[] args) {
		
		try {
			Class<?> cls = Class.forName("reflection.model.Welcome2");
			Field field = cls.getDeclaredField("message");
			field.setAccessible(true);
			Object obj = field.get(new Welcome2());
			String result = (String)obj;
			System.out.println(result);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
