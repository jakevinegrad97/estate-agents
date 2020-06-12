package com.vinegrad.estateagents.service;

import java.util.List;
import java.util.Optional;

import com.vinegrad.estateagents.model.ListingType;
import com.vinegrad.estateagents.model.Property;

public interface PropertyService {

	List<Property> getAllProperties(ListingType forSale);
	
	Optional<Property> getPropertyById(long id);

	void saveProperty(Property property);

	void saveAllProperties(List<Property> properties);

}