package reflection.model;

public class TestClass {
	
	private int value;
	private String name;
	
	private TestClass() {
	}
	
	public TestClass(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public void showValue() {
		System.out.println("Name: " + name +"\tValue: " + value);
	}
	
	

}
