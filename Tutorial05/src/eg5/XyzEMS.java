package eg5;

public class XyzEMS extends EMS {
	
	@Override
	public void addEmmployee() {
		System.out.println("XyzEMS Employee added to Oracle DB");
		
	}

	@Override
	public void updateEmployee() {
		System.out.println("XyzEMS Employee UPDATED to Oracle DB");
		
	}

	@Override
	public void calculateEmployeeLeaves() {
		System.out.println("XyzEMS Employee total leaves were calculated");
		
	}

	@Override
	public void searchEmployee() {
		System.out.println("Revanture Employee was searched in Oracle DB");
		
	}

	@Override
	public void removeEmployee() {
		System.out.println("XyzEMS Employee removed to Oracle DB");
		
	}

}
