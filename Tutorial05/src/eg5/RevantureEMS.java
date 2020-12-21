package eg5;

public class RevantureEMS extends EMS {

	@Override
	public void addEmmployee() {
		System.out.println("Revanture Employee added to Oracle DB");
		
	}

	@Override
	public void updateEmployee() {
		System.out.println("Revanture Employee UPDATED to Oracle DB");
		
	}

	@Override
	public void calculateEmployeeLeaves() {
		System.out.println("Revanture Employee total leaves were calculated");
		
	}

	@Override
	public void searchEmployee() {
		System.out.println("Revanture Employee was searched in Oracle DB");
		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Revanture Employee removed to Oracle DB");
		
	}

}
