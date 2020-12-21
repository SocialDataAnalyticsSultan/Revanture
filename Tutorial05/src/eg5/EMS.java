package eg5;

public abstract class EMS {
	
	public abstract void addEmmployee();
	public abstract void updateEmployee();
	public abstract void calculateEmployeeLeaves();
	public abstract void searchEmployee();
	public abstract void removeEmployee();
	
	public void commonEmployeeBenefits() {
		System.out.println("Common across all the Employee");
	}
	
}
