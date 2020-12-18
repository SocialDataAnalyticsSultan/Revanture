package eg1;

public class MobileV3 extends MobileV2 {
	
	public MobileV3() {
		System.out.println("V3");
	}
	
	public void socialApps() {
		System.out.println("Social apps from V3");
	}
	
	@Override
	public void displayMenu() {
		System.out.println("Menu in V3 updated to GRID view");
	}
	
	// final int number = 99 ==> Cannot be changed

}
