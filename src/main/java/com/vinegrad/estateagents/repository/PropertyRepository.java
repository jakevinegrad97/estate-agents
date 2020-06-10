package com.vinegrad.estateagents.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinegrad.estateagents.model.ListingType;
import com.vinegrad.estateagents.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
	
	List<Property> findByListingType(ListingType listingType);
	
}
