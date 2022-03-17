package tp.data;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tp.annotations.CsvIgnore;
import tp.annotations.MyMinimum;

public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	
	@CsvIgnore
	@JsonIgnore
	private Address address; //may be null (optional)
	
	@CsvIgnore
	private Person bestFriend; //may be null (optional)
	
	@CsvIgnore
	@JsonIgnore
	private String email; //may be null (optional)
	//...
	

	@MyMinimum(0)
	private Integer age;
	
	
	@MyMinimum(25) //25cm
	private Integer taille;

	
	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getTaille() {
		return taille;
	}


	public void setTaille(Integer taille) {
		this.taille = taille;
	}


	
	public Person() {
		super();
	}
	
	
	public Person(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

    

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public Optional<Address> getOptionalAddress() {
		return Optional.ofNullable(address);
	}
	
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}

	public Optional<String> getOptionalEmail() {
		return Optional.ofNullable(email);
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Person getBestFriend() {
		return bestFriend;
	}
	

	public Optional<Person> getOptionalBestFriend() {
		return Optional.ofNullable(bestFriend);
	}


	public void setBestFriend(Person bestFriend) {
		this.bestFriend = bestFriend;
	}
	
	
	
}

