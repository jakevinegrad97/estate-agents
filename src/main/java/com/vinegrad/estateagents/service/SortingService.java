package com.vinegrad.estateagents.service;

import java.util.List;

import com.vinegrad.estateagents.model.Property;
import com.vinegrad.estateagents.model.SortingRequirement;
import com.vinegrad.estateagents.model.SortingType;

public interface SortingService {

	List<Property> sortProperties(SortingRequirement requirement);

}