package com.spc.services.map;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spc.models.Owner;
import com.spc.models.Pet;
import com.spc.services.OwnerService;
import com.spc.services.PetService;
import com.spc.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	@Autowired
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
	public Owner save(Owner type) {
		// TODO Auto-generated method stub
		if(type != null) {
			if(type.getPets() != null) {
				type.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else {
						throw new RuntimeException("PetType is required");
					}
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
		}else {
			return null;
		}
		return super.save(type);
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
		Optional<Owner> owner = owners.stream().filter(o -> o.getLastName().equals(lastName)).findAny();
		return owner.orElse(null);
	}



}
