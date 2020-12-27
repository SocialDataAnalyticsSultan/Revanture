package com.app.model;

public class Client extends Person{
	
	private int clientId;
	private String companyName;
	
	public Client() {
		super();
	}

	public Client(String firstName, String lastName, String gender, String phoneNumber, String email, int clientId, String companyName) {
		super(firstName, lastName, gender, phoneNumber, email);
		this.clientId = clientId;
		this.companyName = companyName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", companyName=" + companyName + ", firstName=" + firstName +", \n\t"
				+ "lastName=" + lastName + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", email=" + email+ "]";
	}

}
