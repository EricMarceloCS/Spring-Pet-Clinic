package com.spc.models;

import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="owners")
public class Owner extends Person {

	private static final long serialVersionUID = 1L;
	
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	private Set<Pet> pets = new HashSet<>();
	
	@Builder
	public Owner(Long id, String firstName, String lastName,
			String address, String city, String telephone,
			Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets == null ? new HashSet<>() : pets;
	}
	
	/**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                if (compName.equalsIgnoreCase(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
	
}
