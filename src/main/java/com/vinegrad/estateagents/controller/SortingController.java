package com.vinegrad.estateagents.controller;

import static com.vinegrad.estateagents.constant.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinegrad.estateagents.model.SortingRequirement;
import com.vinegrad.estateagents.model.SortingType;
import com.vinegrad.estateagents.service.SortingService;

@Controller
public class SortingController {

	@Autowired
	private SortingService service;
	
	@RequestMapping("/sort")
	public String sort(@ModelAttribute("sortForm") SortingRequirement requirement, BindingResult result, Model model) {
		model.addAttribute("properties", service.sortProperties(requirement));
		model.addAttribute("sortingTypes", SortingType.values());
		model.addAttribute("LET", LET);
		model.addAttribute("filter", FILTER);
		return "properties";
	}
}
