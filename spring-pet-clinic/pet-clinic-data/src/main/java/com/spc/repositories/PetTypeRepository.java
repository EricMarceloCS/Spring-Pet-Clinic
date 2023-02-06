package com.spc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spc.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
