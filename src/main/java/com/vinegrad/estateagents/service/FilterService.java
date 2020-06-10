package com.vinegrad.estateagents.service;

import java.util.List;

import com.vinegrad.estateagents.model.FilterRequirement;
import com.vinegrad.estateagents.model.Property;

public interface FilterService {

	List<Property> getFilteredProperties(FilterRequirement req);

}