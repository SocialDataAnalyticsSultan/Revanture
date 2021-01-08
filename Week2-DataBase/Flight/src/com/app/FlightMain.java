package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightMain {

	public static void main(String[] args) {
		
		List<Flight> flightList = new ArrayList<Flight>();
		
		flightList.add(new Flight(101, "Boston", "A1", 140.5, 7.8f, true));
		flightList.add(new Flight(102, "NewYork", "A2", 240.5, 8.1f, true));
		flightList.add(new Flight(103, "Alabama", "A3", 80.5, 5.3f, false));
		flightList.add(new Flight(104, "California", "A4", 180.5, 6.8f, true));
		flightList.add(new Flight(105, "Boston", "A2", 130.5, 6.8f, true));
		flightList.add(new Flight(106, "NewYork", "A3", 280.5, 8.9f, false));
		flightList.add(new Flight(107, "Alabama", "A4", 150.5, 8.8f, true));
		flightList.add(new Flight(108, "California", "A1", 190.5, 6.8f, true));
		flightList.add(new Flight(109, "Boston", "A3", 160.5, 9.2f, false));
		flightList.add(new Flight(110, "NewYork", "A4", 200.5, 8.5f, true));
		flightList.add(new Flight(111, "Alabama", "A1", 110.5, 8.5f, true));
		flightList.add(new Flight(111, "California", "A2", 150.5, 6.2f, false));
		
		System.out.println("\nFlight List Before Sorting");
		printFlightList(flightList);
		
		System.out.println("\n\nFlight List using Member Function CompareTo Sort by Cost");
		Collections.sort(flightList);
		printFlightList(flightList);

		System.out.println("\n\nFlight List using Comparator Function CompareTo Sort by Cost");
		Collections.sort(flightList, new FlightOfCostComparator());
		printFlightList(flightList);
		
		System.out.println("\n\nFlight List using Lambda Function by Rating");
		Collections.sort(flightList, (Flight flight1, Flight flight2) -> {
			Float f1 = flight1.getRating();
			Float f2 = flight2.getRating();
			return f1.compareTo(f2);
		});
		printFlightList(flightList);
		
		System.out.println("\n\nFlight List using Lambda Function by Name");
		Collections.sort(flightList, (Flight flight1, Flight flight2) -> {
			String s1 = flight1.getName();
			String s2 = flight2.getName();
			return s1.compareTo(s2);
		});
		printFlightList(flightList);
		
		System.out.println("\n\nFlight List using Lambda Function by Name and Manufacturer");
		Collections.sort(flightList, (Flight flight1, Flight flight2) -> {
			int result = 0;
			String s1Name = flight1.getName();
			String s2Name = flight2.getName();
			result = s1Name.compareTo(s2Name);
			
			if(result == 0) {
				String s1Manufacturer = flight1.getManufactureName();
				String s2Manufacturer = flight2.getManufactureName();
				result = s1Manufacturer.compareTo(s2Manufacturer);
			}
			return result;
		});
		printFlightList(flightList);
		
		System.out.println("\n\nFlight List using Lambda Function by Avalibility and Rating");
		Collections.sort(flightList, (Flight flight1, Flight flight2) ->{
			int result = 0;
			Boolean b1 = flight1.isAvailibity();
			Boolean b2 = flight2.isAvailibity();
			result = b2.compareTo(b1);
			
			if(result == 0) {
				Float f1 = flight1.getRating();
				Float f2 = flight2.getRating();
				result = f1.compareTo(f2);
			}
			
			return result;
		});
		printFlightList(flightList);
		
	}
	
	public static void printFlightList(List<Flight> flightList) {
		for(Flight f:flightList) {
			System.out.println(f);
		}
	}

}
