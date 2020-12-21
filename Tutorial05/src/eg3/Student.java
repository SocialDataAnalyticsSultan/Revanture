package eg3;

public class Student extends People {
	
	private int studentID;
	private double gpa;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int studentID, double gpa) {
		super(name, age);
		this.studentID = studentID;
		this.gpa = gpa;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", gpa=" + gpa + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void activity() {
		System.out.println("Learning...");
		
	}

}
