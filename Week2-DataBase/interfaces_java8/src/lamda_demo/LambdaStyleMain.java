package lamda_demo;

public class LambdaStyleMain {

	public static void main(String[] args) {
		
		HelloFunctional h1 = () -> System.out.println("Hello Lambda");
		h1.hello();
		
		HelloFunctional h2 = () -> {
			System.out.println("Hey again");
			System.out.println("Hey again and again");
		};
		h2.hello();
	}

}
