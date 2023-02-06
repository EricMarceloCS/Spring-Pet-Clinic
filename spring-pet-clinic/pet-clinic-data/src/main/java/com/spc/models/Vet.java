package com.spc.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
@Entity
@Table(name="vets")
public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="vet_specialties", joinColumns=@JoinColumn(name="vet_id"),
	inverseJoinColumns=@JoinColumn(name="specialty_id"))
	private Set<Specialty> specialties = new HashSet<>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	
	

}
