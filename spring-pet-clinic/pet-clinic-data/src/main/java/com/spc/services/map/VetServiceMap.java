package com.spc.services.map;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.models.Specialty;
import com.spc.models.Vet;
import com.spc.services.SpecialtyService;
import com.spc.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;
	
	@Autowired
	public VetServiceMap(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

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
	public Vet save(Vet type) {
		// TODO Auto-generated method stub
		if(type.getSpecialties().size() > 0) {
			type.getSpecialties().forEach(specialty -> {
				if(specialty.getId() == null) {
					Specialty savedSpecialty =this.specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			} );
		}
		return super.save(type);
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
