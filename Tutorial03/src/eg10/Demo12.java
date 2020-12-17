package eg10;
import java.util.Scanner;

public class Demo12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter you id");
		int id = sc.nextInt();
		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		System.out.println("Enter contact number: ");
		long contact = sc.nextLong();
		System.out.println("Enter your gender: ");
		char gender = sc.next().charAt(0);
		
		sc.close();
		
		Employee emp1 = new Employee(name, id, age, contact, gender);
		System.out.println(emp1.toString());

	}

}
