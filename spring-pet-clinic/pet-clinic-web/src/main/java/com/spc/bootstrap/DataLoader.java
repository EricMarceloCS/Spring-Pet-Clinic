package com.spc.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spc.models.*;
import com.spc.services.*;
import com.spc.services.map.*;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerSerivce;
	private final VetService vetService;
	
	@Autowired
	public DataLoader(OwnerService ownerSerivce, VetService vetService) {
		super();
		this.ownerSerivce = ownerSerivce;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		
		this.ownerSerivce.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		
		this.ownerSerivce.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		this.vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		this.vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		

	}

}
