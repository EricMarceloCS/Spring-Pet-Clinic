package com.spc.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String frstName) {
		this.firstName = frstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
