package eg1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Pineapple", "Mango", "Grapes");
		
		List<String> fruitRes = fruits.stream().filter(i -> i.length()>5).map(f -> f.toUpperCase()).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("Fruits: " + fruitRes);

	}

}
