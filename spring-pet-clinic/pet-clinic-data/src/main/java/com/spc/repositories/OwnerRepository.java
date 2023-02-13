package com.spc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spc.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	public Owner findByLastName(String lastName);
	
	public List<Owner> findAllByLastNameLike(String lastName);
}
