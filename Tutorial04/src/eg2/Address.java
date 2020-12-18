package eg2;

public class Address {
	private int aid;
	private String streetname;
	private String city;
	private int zip;
	
	public Address() {
	}
	
	public Address(int aid, String streetname, String city, int zip) {
		super();
		this.aid = aid;
		this.streetname = streetname;
		this.city = city;
		this.zip = zip;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", streetname=" + streetname + ", city=" + city + ", zip=" + zip + "]";
	}

}
