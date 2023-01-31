package com.spc.services.map;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spc.models.Owner;
import com.spc.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Owner save(Long id, Owner type) {
		// TODO Auto-generated method stub
		return super.save(id, type);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Owner type) {
		// TODO Auto-generated method stub
		super.delete(type);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		Set<Owner> owners = this.findAll();
		Optional<Owner> owner = owners.stream().filter(o -> o.getLastname().equals(lastName)).findAny();
		return owner.orElse(null);
	}



}
