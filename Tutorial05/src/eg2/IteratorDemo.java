package eg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class IteratorDemo {

	public static void main(String[] args) {
		//Remove all key value pairs whose value is null or whose key divisable by ten
		Map<Integer, String> hm = new HashMap<>();
		hm.put(100, "Java");  
		hm.put(100, "openjdk"); 
		hm.put(199, "Java");
		hm.put(300, "Java");
		hm.put(900, null);
		hm.put(1000, null);
		//hm.put(null, "driver");
		hm.put(45, null);
		hm.put(800, "Jee");
		hm.put(500, "Jse");
		hm.put(400, "Jee");
		
		System.out.println("Map Before Deletion");
		System.out.println("hm = " + hm);
		
		/*
		for(Entry<Integer, String> e: hm.entrySet()) {
			if(e.getValue() == null || e.getKey()%10==0) {
				hm.remove(e.getKey());
			}
		}
		*/
		
		Iterator<Entry<Integer, String>> i = hm.entrySet().iterator();
		
		while(i.hasNext()) {
			Entry<Integer, String> e = i.next();
			if(e.getValue() == null || e.getKey()%10==0) {
				i.remove();
				
			}
		}
		
		
		System.out.println("Map After Deletion");
		System.out.println("hm = " + hm);
		
		/*
		 * Enumerator - read operation from top to bottom
		 * Iterator - read and remove operation from top to bottom (any collection)
		 * ListIterator - read, remove, add from any direction it is only used with List Interface.
		 * 
		 */
		List<Integer> li3 = new ArrayList<> ();
		li3.add(100);
		li3.add(300);
		li3.add(600);
		li3.add(99);
		
		System.out.println("\nIterating li3 using Iterator");
		Iterator<Integer> it = li3.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
