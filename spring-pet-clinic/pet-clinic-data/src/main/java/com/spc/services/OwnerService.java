package com.spc.services;


import java.util.List;

import com.spc.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
