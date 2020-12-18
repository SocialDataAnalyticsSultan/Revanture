package eg5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DemoList {

	public static void main(String[] args) {
		
		List li1 = new LinkedList();
		li1.add("hello");
		li1.add(2222);
		li1.add(true);
		li1.add(1212121222);
		li1.add(2222.233);
		li1.add(2222222222222222L);
		
		System.out.println("li1 = " + li1);
		
		List<Integer> li2 = new LinkedList<>();
		li2.add(22);
		li2.add(22);
		li2.add(122);
		li2.add(null);
		li2.add(null);
		li2.add(220);
		li2.add(221);
		li2.add(22);
		li2.add(null);
		li2.add(42);
		li2.add(22);
		li2.add(null);
		System.out.println("li2 = " + li2);
		
		li2.add(0, 333);
		System.out.println("li2 = " + li2);
		
		li2.set(0, 444);
		System.out.println("li2 = " + li2);
		System.out.println("li2.size() = " + li2.size());
		
		li2.remove(3); // look for index
		System.out.println("li2 after li2.remove(3) = " + li2);
		
		Integer i = 22;
		li2.remove(i);
		System.out.println("li2 after li2.remove(i) = " + li2); // only first occurance is removed
		
		// To remove all elements
		while(li2.remove(i)) {
		}
		System.out.println("li2 after all li2.remove(i) = " + li2);
		
		System.out.println("li2.contains(100): "+ li2.contains(100));
		System.out.println("li2.contains(42): "+ li2.contains(42));
		
		System.out.println("\nTraversing using for loop: ");
		for (int index=0; index<li2.size(); index++) {
			System.out.print(li2.get(index) + "  ");
		}
		
		System.out.println("\nTraversing using for-each loop: ");
		for (Integer item:li2) {
			System.out.print(item + "  ");
		}
		
		Collections.reverse(li2);
		System.out.println("li2 after reverse: ");
		System.out.println(li2);
		
		Collections.shuffle(li2);
		System.out.println("li2 after shuffle: ");
		System.out.println(li2);
		
		Collections.replaceAll(li2, null, -1);
		System.out.println("li2 after replacement of null with -1: ");
		System.out.println(li2);
		
		Collections.sort(li2); // ascending order, sort does not accept null value
		System.out.println("li2 after sorting(Ascending order): ");
		System.out.println(li2);
		
		Collections.sort(li2, Collections.reverseOrder());
		System.out.println("li2 after sorting(Descending order): ");
		System.out.println(li2);
		
		// For binary search list should be sorted
		Collections.sort(li2);
		System.out.println("li2 after sorting(Ascending order): ");
		System.out.println(li2);
		System.out.println("Binary search of 100: " + Collections.binarySearch(li2, 100));
		System.out.println("Binary search of 42: " + Collections.binarySearch(li2, 42));
		
		List<Integer> li3 = new ArrayList<> (li2);
		System.out.println("li3 = " + li3);
		li3.addAll(li2);
		System.out.println("li3 = " + li3);
		
		li3.add(100);
		li3.add(300);
		li3.add(600);
		li3.add(99);
		System.out.println("li3 = " + li3);
		System.out.println("li2 = " + li2);
		
		//li3.retainAll(li2);
		//System.out.println("li3 after retainAll = " + li3);
		
		li3.removeAll(li2);
		System.out.println("li3 after removeAll = " + li3);

	}

}
