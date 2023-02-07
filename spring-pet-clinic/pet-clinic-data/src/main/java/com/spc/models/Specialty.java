package com.spc.models;

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
@Table(name="specialties")
public class Specialty extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="description")
	private String description;

}
