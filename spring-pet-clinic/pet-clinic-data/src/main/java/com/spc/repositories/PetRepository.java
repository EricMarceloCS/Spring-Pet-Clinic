package com.spc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spc.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
