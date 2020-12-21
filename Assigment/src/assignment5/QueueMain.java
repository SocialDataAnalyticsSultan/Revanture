package assignment5;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

	public static void main(String[] args) {
		Queue q1 = new LinkedList();
		q1.add(23);
		q1.add("Navin");
		q1.add(22.3);
		q1.add(34.8f);
		q1.add(12345L);
		q1.add(23);
		
		System.out.println("Size of q1: " + q1.size());
		System.out.println("q1 elements are: ");
		
		Iterator<Object> it = q1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Peek of q1: " + q1.peek());
		System.out.println("Poll of q1: " + q1.poll());
		
		Queue<Integer> q2 = new LinkedList<>();
		System.out.println("q2.isEmpty(): " + q2.isEmpty());
		q2.add(23);
		q2.add(56);
		q2.add(98);
		q2.add(17);
		q2.add(16);
		q2.add(40);
		q2.add(69);
		q2.add(92);
		q2.add(21);
		System.out.println("q2.contains(40): " + q2.contains(40));
		
		//Object arr = q2.toArray();
	

	}

}
