package com.spc.models;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	private Set<Specialty> specialties = new HashSet<>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	
	

}
