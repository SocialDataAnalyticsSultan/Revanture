package eg3;

public class SchoolDemo {

	public static void main(String[] args) {
		Student tom = new Student("Tom", 14, 1234, 3.0);
		Student alex = new Student("Alex", 14, 2356, 2.8);
		
		Teacher andy = new Teacher("Andy", 35, "Math");
		
		System.out.println(tom.toString());
		System.out.println(alex.toString());
		System.out.println(andy.toString());
		
		tom.activity();
		alex.activity();
		andy.activity();
	}

}
