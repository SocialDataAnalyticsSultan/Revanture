package eg5;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class DemoSet {

	public static void main(String[] args) {

		Set<String> hs = new HashSet<>();
		hs.add("hello");
		hs.add("hello");
		hs.add(null);
		hs.add(null);
		hs.add("hey");
		hs.add("hi");
		hs.add("java");
		hs.add(null);
		hs.add("jee");
		hs.add("jme");
		hs.add("spring");
		hs.add("alpha");
		hs.add("hibernate");
		hs.add("java");
		hs.add(null);
		System.out.println("hs: " + hs);
		
		Set<String> lhs = new LinkedHashSet<>();
		lhs.add("hello");
		lhs.add("hello");
		lhs.add(null);
		lhs.add(null);
		lhs.add("hey");
		lhs.add("hi");
		lhs.add("java");
		lhs.add(null);
		lhs.add("jee");
		lhs.add("jme");
		lhs.add("spring");
		lhs.add("alpha");
		lhs.add("hibernate");
		lhs.add("java");
		lhs.add(null);
		System.out.println("lhs: " + lhs);// Entry Order is preserved
		
		//TreeSet does not accept null values
		Set<String> ts = new TreeSet<>(); //Ascending Order
		//Set<String> ts = new TreeSet<>(Colletions.reverseOrder()); //Descending Order
		ts.add("hello");
		ts.add("hello");
		ts.add("hey");
		ts.add("hi");
		ts.add("java");
		ts.add("jee");
		ts.add("jme");
		ts.add("spring");
		ts.add("alpha");
		ts.add("hibernate");
		ts.add("java");
		System.out.println("ts: " + ts);
		
		System.out.println(ts.size());
		System.out.println(ts.contains("hi"));
		System.out.println(ts.contains("java8"));
		System.out.println(ts.remove("jme"));
		System.out.println("ts: " + ts);
		
		Set<String> ts2 = new TreeSet<>();
		ts2.add("temp");
		ts2.add("try");
		ts2.add("apple");
		ts2.add("orange");
		ts2.add("java");
		System.out.println("ts2: " + ts2);
		
		//ts.addAll(ts2);
		//System.out.println("ts: " + ts);
		
		//ts.removeAll(ts2);
		//System.out.println("ts: " + ts);
		
		//ts.retainAll(ts2);
		//System.out.println("ts: " + ts);
		
		System.out.println("Traversing using for-each loop: ");  // for loop cannot be used
		for(String element:ts) {
			System.out.print(element + "   ");
		}

	}

}
