package eg10;

public class Employee {
	private String name;
	private int id;
	private int age;
	private long contact;
	private char gender;
	
	public Employee(){
		
	}
	public Employee(String name, int id, int age, long contact, char gender) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.contact = contact;
		this.gender = gender;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", contact=" + contact + ", gender=" + gender
				+ "]";
	}
	
	
	

}
