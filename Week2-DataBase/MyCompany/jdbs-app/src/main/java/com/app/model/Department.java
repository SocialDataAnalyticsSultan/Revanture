package com.app.model;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private String city;
	private String state;
	private String country;
	private int managerId;
	
	public Department() {
		super();
	}
	
	public Department(int departmentId, String departmentName, String city, String state, String country,
			int managerId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", managerId=" + managerId + "]";
	}
	
	
	
	
	

}
