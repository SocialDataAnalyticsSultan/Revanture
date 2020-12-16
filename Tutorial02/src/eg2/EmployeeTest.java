package eg2;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(100, "Dinesh");
		System.out.println("Printing e1");
		e1.printEmployee();
		
		Employee e2 = new Employee(101, "Manesh");
		System.out.println("Printing e2");
		e2.printEmployee();
		
		Employee e3 = new Employee(103, "Sam", 123456, "Boston");
		System.out.println("Printing e3");
		e3.printEmployee();

	}

}
