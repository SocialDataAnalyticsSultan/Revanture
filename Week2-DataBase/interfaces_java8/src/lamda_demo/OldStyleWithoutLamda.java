package lamda_demo;

public class OldStyleWithoutLamda implements HelloFunctional{

	public static void main(String[] args) {
		
		HelloFunctional h = new OldStyleWithoutLamda();
		h.hello();
		
		HelloFunctional h1 = new HelloFunctional() {
			
			@Override
			public void hello() {
				System.out.println("Hello old style inner");
			}
		};
		h1.hello();
		
		HelloFunctional h2 = new HelloFunctional() {
			
			@Override
			public void hello() {
				System.out.println("Hello again old style inner");
			}
		};
		h2.hello();
		
	}

	@Override
	public void hello() {
		System.out.println("Hello old style");
		
	}

}
