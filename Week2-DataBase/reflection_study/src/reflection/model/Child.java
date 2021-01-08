package reflection.model;

@Deprecated
public class Child extends Person{
	
	private Integer value;

	public Child() {
		super();
	}

	public Child(String name, Integer age, Integer value) {
		super(name, age);
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Child [toString()=" + super.toString() + ", value=" + value + "]";
	}
	
	
	

}
