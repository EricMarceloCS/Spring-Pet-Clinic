package com.spc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name="types")
public class PetType extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
