package com.app;

import java.util.Comparator;

public class FlightOfCostComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Flight obj1 = (Flight)o1;
		Flight obj2 = (Flight)o2;
		
		Double d1 = obj1.getCost();
		Double d2 = obj2.getCost();
		return d1.compareTo(d2);
	}
	
	

}
