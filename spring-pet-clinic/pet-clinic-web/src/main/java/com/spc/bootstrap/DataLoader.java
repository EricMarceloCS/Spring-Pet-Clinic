package com.spc.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	private final PetTypeService petTypeService;

	@Autowired //included for clarity
	public DataLoader(OwnerService ownerSerivce, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerSerivce = ownerSerivce;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PetType dog = new PetType();
		dog.setName("Dog");
		
		PetType savedDogPetType = this.petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		
		PetType savedCatType = this.petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231234567");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Roscoe");
		
		owner1.getPets().add(mikesPet);
		this.ownerSerivce.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231234567");
		
		Pet fionasCat = new Pet();
		fionasCat.setPetType(savedCatType);
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setName("Just Cat");
		owner2.getPets().add(fionasCat);
		
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
