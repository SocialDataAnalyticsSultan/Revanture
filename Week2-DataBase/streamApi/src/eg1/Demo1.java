package eg1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Demo1 {

	public static void main(String[] args) {
		
		List<Integer> li = Arrays.asList(12, 33, 33, 23, 22, 11);
		List<Integer> lievenStream = li.stream().filter(i -> (i%2==0)).collect(Collectors.toList());
		System.out.println("Even List Stream: " + lievenStream);

		lievenStream = li.stream().filter(i -> (i%2==0)).distinct().collect(Collectors.toList());
		System.out.println("Even List Stream: " + lievenStream);
		
		lievenStream = li.stream().filter(i -> (i%2==0)).distinct().sorted().collect(Collectors.toList());
		System.out.println("Even List Stream: " + lievenStream);
		
		lievenStream = li.stream().filter(i -> (i%2==0)).distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("Even List Stream: " + lievenStream);

	}

}
