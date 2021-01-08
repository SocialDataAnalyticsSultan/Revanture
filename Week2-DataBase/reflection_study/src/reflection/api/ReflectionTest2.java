package reflection.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionTest2 {
	
	public static void main(String[] args) {
		Class<?> c1;
		
		//Get the class name
		try {
			c1=Class.forName("reflection.model.Child");
			System.out.println("Class Name: " + c1.getName());
			System.out.println("Class Name: " + c1.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the super class
		Class<?> c2;
		try {
			c2=Class.forName("reflection.model.Child");
			System.out.println("Super Class Name: " + c2.getSuperclass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the interface
		Class<?> c3;
		try {
			c3=Class.forName("reflection.model.Child");
			System.out.println("Interfaces: " + Arrays.toString(c3.getInterfaces()));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the modifiers
		Class<?> c4;
		
		try {
			c4=Class.forName("reflection.model.Child");
			int modifiers = c4.getModifiers();
			System.out.println("Modifiers: " + Modifier.toString(modifiers));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the fields
		Class<?> c5;
		try {
			c5=Class.forName("reflection.model.Child");
			Field[] allFields = c5.getFields();  //only gives public member
			System.out.println("All Fields: " + Arrays.toString(allFields));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the class field
		Class<?> c6;
		try {
			c6=Class.forName("reflection.model.Child");
			Field[] declaredFields = c6.getDeclaredFields();
			System.out.println("All Declared Fields: " + Arrays.toString(declaredFields));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get constructors
		Class<?> c7;
		try {
			c7=Class.forName("reflection.model.Child");
			Constructor<?>[] constructors = c7.getConstructors(); //return only public constructors
			System.out.println("All Constructors: " + Arrays.toString(constructors));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get all defined constructors
		Class<?> c8;
		try {
			c8=Class.forName("reflection.model.Child");
			Constructor<?>[] allConstructors = c8.getDeclaredConstructors(); //return all defined constructors
			System.out.println("All Declerad Constructors: " + Arrays.toString(allConstructors));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get the methods
		Class<?> c9;
		try {
			c9=Class.forName("reflection.model.Child");
			Method[] methods = c9.getMethods(); 
			System.out.println("All Methods: " + Arrays.toString(methods));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get all defined methods
		Class<?> c10;
		try {
			c10=Class.forName("reflection.model.Child");
			Method[] declaredMethods = c10.getDeclaredMethods();
			System.out.println("All Declared Methods: " + Arrays.toString(declaredMethods));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get annotation
		Class<?> c11;
		try {
			c11=Class.forName("reflection.model.Child");
			Annotation[] annotations = c11.getAnnotations(); 
			System.out.println("Annotations: " + Arrays.toString(annotations));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Get annotation
		Class<?> c12;
		try {
			c12=Class.forName("reflection.model.Child");
			Annotation[] declaredAnnotations = c12.getDeclaredAnnotations(); 
			System.out.println("Declared Annotations: " + Arrays.toString(declaredAnnotations));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
