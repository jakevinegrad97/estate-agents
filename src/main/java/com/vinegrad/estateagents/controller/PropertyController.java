package com.vinegrad.estateagents.controller;

import static com.vinegrad.estateagents.constant.Constants.*;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinegrad.estateagents.model.FilterRequirement;
import com.vinegrad.estateagents.model.ListingType;
import com.vinegrad.estateagents.model.SortingRequirement;
import com.vinegrad.estateagents.model.SortingType;
import com.vinegrad.estateagents.service.PropertyService;

@Controller
public class PropertyController {
	
	@Autowired
	private PropertyService service;

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/sales")
	public String seeForSales(@ModelAttribute("filterForm") FilterRequirement filter, BindingResult result) {
		LET = false;
		LATEST_SEARCHES = service.getAllProperties(ListingType.FOR_SALE);
		return "filter";
	}
	
	@RequestMapping(value = "/lets")
	public String seeToLets(@ModelAttribute("filterForm") FilterRequirement filter, BindingResult result) {
		LET = true;
		LATEST_SEARCHES = service.getAllProperties(ListingType.TO_LET);
		return "filter";
	}
	
	@RequestMapping(value = "/property/{id}")
	public String seeProperty(@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("property", service.getPropertyById(id).orElseThrow());
		} catch(NoSuchElementException e) {
			System.err.println("No such id " + id);
		}
		model.addAttribute("LET", LET);
		return "property";
	}
	
}
