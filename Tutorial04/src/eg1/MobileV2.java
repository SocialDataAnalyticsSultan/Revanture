package eg1;

public class MobileV2 extends MobileV1{
	
	public MobileV2() {
		System.out.println("V2");
	}
	
	public void browsing() {
		System.out.println("Browsing from V2");
	}
	
	public void gaming() {
		System.out.println("Gaming from V2");
	}
	
	public void displayMenu(){  // public final displayMenu() ==> cannot be overwritten
		System.out.println("Menu in v2 gets displayed in LIST Style");
	}
}
