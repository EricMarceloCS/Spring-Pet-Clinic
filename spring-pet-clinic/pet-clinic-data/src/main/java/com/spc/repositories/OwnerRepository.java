package com.spc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spc.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
