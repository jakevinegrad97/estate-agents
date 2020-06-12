package com.vinegrad.estateagents.service;

import static com.vinegrad.estateagents.constant.Constants.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinegrad.estateagents.model.ListingType;
import com.vinegrad.estateagents.model.Property;
import com.vinegrad.estateagents.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repository;
	
	@Override
	public void saveProperty(Property property) {
		repository.save(property);
	}
	
	@Override
	public void saveAllProperties(List<Property> properties) {
		for(Property property : properties) {
			repository.save(property);			
		}
	}
	
	@Override
	public List<Property> getAllProperties(ListingType listingType) {
		List<Property> properties = repository.findByListingType(listingType);
		PROPERTIES = properties;
		return properties;
	}

	@Override
	public Optional<Property> getPropertyById(long id) {
		return PROPERTIES.stream().filter(p -> p.getId() == id).findFirst();
	}
	
}
