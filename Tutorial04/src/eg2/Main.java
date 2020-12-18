package eg2;

public class Main {

	public static void main(String[] args) {
		Project p1 = new Project(9000, "Abc Corp", "Abc Corp Some Client");
		Address add = new Address(12, "Fault St.", "Boston", 12345);
		Employee e1 = new Employee(100, "Sachin", "Manager", 23333.4, p1, add);
		System.out.println(e1);
		
		

	}

}
