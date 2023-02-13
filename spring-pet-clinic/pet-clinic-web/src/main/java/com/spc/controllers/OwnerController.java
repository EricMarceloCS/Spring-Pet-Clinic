package com.spc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spc.models.Owner;
import com.spc.services.OwnerService;



@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	
	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listOwners(Model model) {
		model.addAttribute("owners", this.ownerService.findAll());
		return "owners/index";
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(this.ownerService.findById(ownerId));
		return mav;
	}
	
	// Find Owners //
	@RequestMapping("find")
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/findOwners";
	}
	

	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if(owner.getLastName() == null) {
			owner.setLastName("");
		}
		
		List<Owner> results = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		if(results.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		}else if(results.size() == 1) {
			owner = results.get(0);
			return "redirect:/owners/" + owner.getId();
		}else {
			model.addAttribute("selections", results);
			return "owners/ownersList";
		}
	}
	// Create Owner //
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/CreateOrUpdateOwnerForm";
	}
	
	@PostMapping("/new")
	public String processCreationForm(@Validated Owner owner, BindingResult result) {
		if(result.hasErrors()) {
			return "owners/CreateOrUpdateOwnerForm";
		}else {
			Owner savedOwner = this.ownerService.save(owner);
			return "redirect:/owners/" + savedOwner.getId();
		}
	}
	
	// Update Owner //
	@GetMapping("/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
		model.addAttribute(ownerService.findById(ownerId));
		return "owners/CreateOrUpdateOwnerForm";
	}
	
	@PostMapping("/{ownerId}/edit")
	public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result, @PathVariable Long ownerId) {
		if(result.hasErrors()) {
			return "owners/CreateOrUpdateOwnerForm";
		}else {
			owner.setId(ownerId);
			Owner savedOwner =this.ownerService.save(owner);
			return "redirect:/owners/" + savedOwner.getId();
		}
	}
	
}
