package com.spc.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spc.models.Specialty;
import com.spc.repositories.SpecialtyRepository;
import com.spc.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;
	
	
	@Autowired
	public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}


	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}


	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}


	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}


	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
		
	}


	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
		
	}


}
