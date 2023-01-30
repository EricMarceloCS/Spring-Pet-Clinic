package com.spc.services;

import java.util.Set;

public interface CrudService<Type, ID> {
	
	Set<Type> findAll();
	
	Type findById(ID id);
	
	Type save(ID id, Type object);
	
	void delete(Type object);
	
	void deleteById(ID id);

}
