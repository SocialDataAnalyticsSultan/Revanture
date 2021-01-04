package lamda_demo;

public class AddFunctionalMain {

	public static void main(String[] args) {
		
		AddFunctional add = (x,y,z)-> {
			return x+y+z;
		};
		
		System.out.println("Result is " + add.sum(100, 200, 300));

	}

}
