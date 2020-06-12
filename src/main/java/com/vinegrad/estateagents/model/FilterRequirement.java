package com.vinegrad.estateagents.model;

import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequirement {

	private String location;
	private long minPrice;
	private long maxPrice;
	private PropertyType propertyType;
	private int minNumberOfBedrooms;
	private int maxNumberOfBedrooms;
	
	private Predicate<Property> predicate = p -> true;
	
	public boolean test(Property property) {
		if(location != null && !location.equals("")) {
			predicate = predicate.and(p -> p.getLocation().equalsIgnoreCase(location));
		}
		if(minPrice > maxPrice) {
			long temp = minPrice;
			minPrice = maxPrice;
			maxPrice = temp;
		}
		if(minPrice != 0) {
			predicate = predicate.and(p -> p.getPrice() >= minPrice);
		}
		if(maxPrice != 0) {
			predicate = predicate.and(p -> p.getPrice() <= maxPrice);
		}
		if(propertyType != null) {
			predicate = predicate.and(p -> p.getPropertyType().equals(propertyType));
		}
		if(minNumberOfBedrooms > maxNumberOfBedrooms) {
			int temp = minNumberOfBedrooms;
			minNumberOfBedrooms = maxNumberOfBedrooms;
			maxNumberOfBedrooms = temp;
		}
		if(minNumberOfBedrooms != 0) {
			predicate = predicate.and(p -> p.getNumberOfBedrooms() >= minNumberOfBedrooms);
		}
		if(maxNumberOfBedrooms != 0) {
			predicate = predicate.and(p -> p.getNumberOfBedrooms() <= maxNumberOfBedrooms);
		}
		return predicate.test(property);
	}
	
	public String toString() {
		String result = "";
		if(propertyType != null) {
			result += propertyType.getName() + "s";
		} else {
			result += "properties";
		}
		if(location != null && !location.equals("")) {
			result += " in " + location;
		}
		if(minPrice != 0 && maxPrice != 0) {
			result += ", between £" + minPrice + " and £" + maxPrice;
		} else if(minPrice != 0) {
			result += ", over £" + minPrice;
		} else if(maxPrice != 0) {
			result += ", under £" + maxPrice;
		}
		result += ".";
		return result;
	}
	
	
}
