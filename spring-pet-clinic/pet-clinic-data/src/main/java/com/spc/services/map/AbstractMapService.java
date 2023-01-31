package com.spc.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.spc.models.BaseEntity;

public abstract class AbstractMapService<Type extends BaseEntity, ID extends Long>{

	protected Map<Long, Type> map = new HashMap<>();
	
	Set<Type> findAll() {
		return new HashSet<>(map.values());
	}
	
	Type findById(ID id) {
		return map.get(id);
	}
	
	Type save(Type type) {

		if (type != null) {
			if(type.getId() == null) {
				type.setId(this.getNextId());
			}
			map.put(type.getId(), type);
		} else {
			throw new RuntimeException("Object is null");
		}
		
		return type;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(Type type) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(type));
	}
	
	private Long getNextId() {
		return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1L;
	}
}
