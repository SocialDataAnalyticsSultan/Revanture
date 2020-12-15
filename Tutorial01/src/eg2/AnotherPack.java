package eg2;

public class AnotherPack {
	public static void iAmStaticAnotherPack() {
		System.out.println("Demo1 static from AnotherPack");
	}
	
	public static void iAmStaticAnotherPack(String name) {
		System.out.println("Demo1 static from Another by name and name = " + name);
	}
	
	public void iAmNonStaticAnotherPack(){
		System.out.println("Demo1 non-static from AnotherPack");
	}

}
