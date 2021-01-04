package lamda_demo;

public class HelloInterfaceFunctionalByNameMain {

	public static void main(String[] args) {
		
		HelloInterfaceFunctionalByName hello = (n)-> {
			System.out.println("Hellooooo " + n);
		};
		
		hello.sayHello("Vinay");
		hello.sayHello("Emma");
		

	}

}
