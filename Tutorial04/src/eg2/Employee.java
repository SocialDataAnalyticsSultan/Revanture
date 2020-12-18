package eg2;

public class Employee extends Person{
	
	private String designation;
	private double salary;
	private Project project;
	private Address add;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String designation, double salary, Project project, Address add) {
		super(id, name);
		this.designation=designation;
		this.salary=salary;
		this.project = project;
		this.add = add;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return super.toString() + "Employee [designation=" + designation + ", salary=" + salary + ", project=" + project + ", add=" + add + "]" + project.toString();
	}



}
