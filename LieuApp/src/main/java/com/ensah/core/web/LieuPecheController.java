package com.ensah.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensah.core.bo.Contact;
import com.ensah.core.bo.LieuPeche;
import com.ensah.core.services.ILieuPecheService;

import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;


@Controller
public class LieuPecheController {
	
	@Autowired
	private ILieuPecheService iLieuPecheService;
	
	public LieuPecheController() {
		
	}
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("showForm", false);
	}
	
//	@RequestMapping(value={"/form","/"})
//	public String from() {
//		return "locationForm";
//	}
	
	@RequestMapping(value = {"/home","/"})
	public String showForm(Model model) {
		model.addAttribute("action", "addLocation");
		model.addAttribute("locationModel", new LieuPeche());
		model.addAttribute("showForm", true);
		model.addAttribute("locationList", iLieuPecheService.getAllLieuPeche());

		return "locationForm";
	}
	

	@PostMapping("/addLocation")
	public String addLocation(@Valid @ModelAttribute("locationModel") LieuPeche lieuPeche, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "Les données sont invalides.");
			System.out.print(model.getAttribute("locationModel"));
			System.out.print("Les données sont invalides.");

		} else {
			iLieuPecheService.addLieuPeche(lieuPeche);
			model.addAttribute("infoMsg", "LieuPeche ajouté avec succès");
			System.out.print("Les données sont valides.");
		}
		model.addAttribute("locationList", iLieuPecheService.getAllLieuPeche());

		return "redirect:/home";
	}
	
	@PostMapping("/serachFishingplace")
	public String serachContact(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("locationList", iLieuPecheService.searchLieuPeche(keyword));
		System.out.print(keyword);
		System.out.print(iLieuPecheService.searchLieuPeche(keyword));
		return "locationForm";
	}
	
	@GetMapping("/deleteLocation/{id}")
	public String deleteContact(@PathVariable("id") Long id, Model model) {
		iLieuPecheService.deleteLieuPeche(id);
		model.addAttribute("infoMsg", "Lieu supprimé avec succès");
		model.addAttribute("locationList", iLieuPecheService.getAllLieuPeche());

		return "locationForm";

	}
	
	@GetMapping("/updateLocation/{id}")
	public String updateContactForm(@PathVariable("id") Long id, Model model) {
		LieuPeche lieuPeche = iLieuPecheService.getLieuPecheById(id);
		model.addAttribute("locationModel", lieuPeche);
		model.addAttribute("action", "updateContact");
		model.addAttribute("showForm", true);
		model.addAttribute("contactList", iLieuPecheService.getAllLieuPeche());

		return "locationForm";

	}
	
	@GetMapping("/allfichingPlaces")
	public String allfichingPlaces(@Valid @ModelAttribute("locationModel") LieuPeche lieuPeche, BindingResult bindingResult,
			Model model) {
		model.addAttribute("locationList", iLieuPecheService.getAllLieuPeche());
		return "locationForm";
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public String handleConstraintViolationException() {
		return "error";
	    
	}
}
