package reflection.model;

public class Welcome {
	
	private String greet(String name) {
		if(name==null || name.isEmpty()) {
			return "Hello, stranger";
		}
		return "Hello, "+name;
	}

}
