package tp.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter  @Setter @ToString
public class Address {
	private String number;
	private String street;
	private String zip;
	private String town;
	//...
	
	public Address() {
		super();
	}
	
	
	public Address(String number, String street, String zip, String town) {
		super();
		this.number = number;
		this.street = street;
		this.zip = zip;
		this.town = town;
	}



	@Override
	public String toString() {
		return "Address [number=" + number + ", street=" + street + ", zip=" + zip + ", town=" + town + "]";
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getTown() {
		return town;
	}


	public void setTown(String town) {
		this.town = town;
	}

}
