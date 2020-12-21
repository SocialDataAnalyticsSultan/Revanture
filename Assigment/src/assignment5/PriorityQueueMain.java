package assignment5;

import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); 
		
		pq1.add(23);
		pq1.add(89);
		pq1.add(56);
		pq1.add(6);
		
		System.out.println("pq1.isEmpty(): " + pq1.isEmpty());
		System.out.println("pq1.size(): " + pq1.size());
		System.out.println("pq1 elements are: ");
		for(Integer i: pq1) {
			System.out.print(i + "    ");
		}
		
		pq1.offer(10);
		pq1.offer(1);
		pq1.offer(0);
		System.out.println("\npq1 elements are: " + pq1.toString());
		
		
		System.out.println("pq1.poll(): " + pq1.poll());
		System.out.println("pq1.poll(): " + pq1.poll());
		System.out.println("pq1.poll(): " + pq1.poll());
		System.out.println("pq1.poll(): " + pq1.poll());
		
		System.out.println("\npq1 elements are: " + pq1.toString());
		
		System.out.println("pq1.peek(): " + pq1.peek());
		System.out.println("pq1.contains(23): " + pq1.contains(23));
		System.out.println("pq1.contains(123): " + pq1.contains(123));
		

	}

}
