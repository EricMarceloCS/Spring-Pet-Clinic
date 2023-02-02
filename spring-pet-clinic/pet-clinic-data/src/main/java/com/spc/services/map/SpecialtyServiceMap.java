package com.spc.services.map;


import java.util.Set;

import org.springframework.stereotype.Service;

import com.spc.models.Specialty;
import com.spc.services.SpecialtyService;
@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Set<Specialty> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Specialty findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Specialty save(Specialty type) {
		// TODO Auto-generated method stub
		return super.save(type);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Specialty type) {
		// TODO Auto-generated method stub
		super.delete(type);
	}

	
}
