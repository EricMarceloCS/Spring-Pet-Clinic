package com.spc.models;

import jakarta.persistence.*;

@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
