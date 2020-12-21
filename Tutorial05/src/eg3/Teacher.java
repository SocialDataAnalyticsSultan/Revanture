package eg3;

public class Teacher extends People{

	private String schoolClass;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, int age, String schoolClass) {
		super(name, age);
		this.schoolClass = schoolClass;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	@Override
	public void activity() {
		System.out.println("Teaching...");
		
	}

	@Override
	public String toString() {
		return "Teacher [schoolClass=" + schoolClass + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
