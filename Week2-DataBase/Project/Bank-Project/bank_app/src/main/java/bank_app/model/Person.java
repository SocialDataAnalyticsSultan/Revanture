package bank_app.model;

import java.util.Date;

public abstract class Person {
	
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected String gender;
	protected String maritalStatus;
	protected String nationality;
	protected String socialSecurityNumber;
	protected String addressStreet;
	protected String addressCity;
	protected String addressState;
	protected String addressZipcode;
	protected String addressCountry;
	protected String contactEmail;
	protected String contactPhone;
	protected String contactMobilePhone;
	
	public Person() {
		super();
	}
	
	
	public Person(String firstName, String lastName, Date dateOfBirth, String gender, String nationality,
			String addressStreet, String addressCity, String addressState, String addressZipcode, String addressCountry,
			String contactEmail, String contactPhone, String contactMobilePhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZipcode = addressZipcode;
		this.addressCountry = addressCountry;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.contactMobilePhone = contactMobilePhone;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactMobilePhone() {
		return contactMobilePhone;
	}
	public void setContactMobilePhone(String contactMobilePhone) {
		this.contactMobilePhone = contactMobilePhone;
	}
	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", nationality=" + nationality + ", addressStreet=" + addressStreet
				+ ", addressCity=" + addressCity + ", addressState=" + addressState + ", addressZipcode="
				+ addressZipcode + ", addressCountry=" + addressCountry + ", contactEmail=" + contactEmail
				+ ", contactPhone=" + contactPhone + ", contactMobilePhone=" + contactMobilePhone + "]";
	}
	
	
}
