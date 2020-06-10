package com.vinegrad.estateagents.controller;

import static com.vinegrad.estateagents.constant.Constants.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinegrad.estateagents.model.FilterRequirement;
import com.vinegrad.estateagents.model.Property;
import com.vinegrad.estateagents.model.PropertyType;
import com.vinegrad.estateagents.model.SortingRequirement;
import com.vinegrad.estateagents.model.SortingType;
import com.vinegrad.estateagents.service.FilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private FilterService service;

	@GetMapping
	public String filterPage(@ModelAttribute("filterForm") FilterRequirement filter, BindingResult result, Model model) {
		model.addAttribute("types", PropertyType.values());
		model.addAttribute("lastFilter", LAST_FILTER_REQUIREMENT);
		return "filter";
	}
	
	@PostMapping
	public String filter(@ModelAttribute("filterForm") FilterRequirement filter, BindingResult result, Model model, @ModelAttribute("sortForm") SortingRequirement requirement) {
		List<Property> properties = service.getFilteredProperties(filter);
		model.addAttribute("properties", properties);
		model.addAttribute("filter", filter.toString());
		model.addAttribute("sortingTypes", SortingType.values());
		LAST_FILTER_REQUIREMENT = filter;
		FILTER = filter.toString();
		return "properties";
	}
}
