package com.spc.services.springdatajpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spc.models.Specialty;
import com.spc.repositories.SpecialtyRepository;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyRepository {

	private final SpecialtyRepository specialtyRepository;
	
	
	@Autowired
	public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public <S extends Specialty> S save(S entity) {
		return specialtyRepository.save(entity);
	}

	@Override
	public <S extends Specialty> Iterable<S> saveAll(Iterable<S> entities) {
		return specialtyRepository.saveAll(entities);
	}

	@Override
	public Optional<Specialty> findById(Long id) {
		return specialtyRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return specialtyRepository.existsById(id);
	}

	@Override
	public Iterable<Specialty> findAll() {
		return specialtyRepository.findAll();
	}

	@Override
	public Iterable<Specialty> findAllById(Iterable<Long> ids) {
		return specialtyRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return specialtyRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);

	}

	@Override
	public void delete(Specialty entity) {
		specialtyRepository.delete(entity);

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		specialtyRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Specialty> entities) {
		specialtyRepository.deleteAll(entities);

	}

	@Override
	public void deleteAll() {
		specialtyRepository.deleteAll();

	}

}
