package eg5;

public class AbstractionMain {

	public static void main(String[] args) {
		System.out.println("Accessing EMS via RevantureESM");
		EMS revEms = new RevantureEMS();
		revEms.addEmmployee();
		revEms.searchEmployee();
		revEms.updateEmployee();
		revEms.calculateEmployeeLeaves();
		revEms.removeEmployee();
		
		System.out.println("Accessing EMS via  XyzEMS");
		EMS  xyzEMS = new  XyzEMS();
		xyzEMS.addEmmployee();
		xyzEMS.searchEmployee();
		xyzEMS.updateEmployee();
		xyzEMS.calculateEmployeeLeaves();
		xyzEMS.removeEmployee();
	}

}
