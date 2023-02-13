package com.spc.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spc.models.Owner;
import com.spc.models.Pet;
import com.spc.models.PetType;
import com.spc.services.OwnerService;
import com.spc.services.PetService;
import com.spc.services.PetTypeService;

@Controller
@RequestMapping("owners/{ownerId}/")
public class PetController {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	private final OwnerService ownerService;
	
	
	@Autowired
	public PetController(PetTypeService petTypeService, OwnerService ownerService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.ownerService = ownerService;
	}



	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes(){
		return this.petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return this.ownerService.findById(ownerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("pets/new")
	public String initCreationForm(Owner owner, Model model) {
		Pet pet = new Pet();
		owner.getPets().add(pet);
		pet.setOwner(owner);
		model.addAttribute("pet", pet);
		return "pets/createOrUpdatePetForm";
	}
	
	@PostMapping("pets/new")
    public String processCreationForm(Owner owner, @Validated Pet pet, BindingResult result, ModelMap model) {
        if ((!pet.getName().isEmpty()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        owner.getPets().stream().forEach(p -> System.out.println(p.getName()));
        if (result.hasErrors()) {
            model.put("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }
	
	@PostMapping("pets/{petId}/edit")
    public String processUpdateForm(@Validated Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}
