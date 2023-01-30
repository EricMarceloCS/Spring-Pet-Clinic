package com.spc.services.map;

import java.util.Set;

import com.spc.models.Vet;
import com.spc.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Vet save(Long id, Vet type) {
		// TODO Auto-generated method stub
		return super.save(id, type);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Vet type) {
		// TODO Auto-generated method stub
		super.delete(type);
	}

	


}
