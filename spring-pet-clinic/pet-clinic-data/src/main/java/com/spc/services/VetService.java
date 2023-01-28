package com.spc.services;

import java.util.Set;

import com.spc.models.Vet;

public interface VetService {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();

}
