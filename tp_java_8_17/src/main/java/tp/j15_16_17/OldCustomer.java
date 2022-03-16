package tp.j15_16_17;

import java.util.Objects;

public class OldCustomer{
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	
	public OldCustomer() {
		super();
	}


	public OldCustomer(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "OldCustomer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OldCustomer other = (OldCustomer) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
	
	
	
}
