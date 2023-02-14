package com.spc.models;

import java.util.HashSet;


import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vets")
public class Vet extends Person {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="vet_specialties", joinColumns=@JoinColumn(name="vet_id"),
	inverseJoinColumns=@JoinColumn(name="specialty_id"))
	@Builder.Default
	private Set<Specialty> specialities = new HashSet<>();


}
