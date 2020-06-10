package com.vinegrad.estateagents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PROPERTIES")
@NoArgsConstructor
@AllArgsConstructor
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "LISTING_TYPE")
	private ListingType listingType;
	@Column(name = "PRICE")
	private long price;
	@Column(name = "PROPERTY_TYPE")
	private PropertyType propertyType;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "NUMBER_OF_BEDROOMS")
	private int numberOfBedrooms;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name="url")
	private String url;
	
	public String toString() {
		return numberOfBedrooms + " bedroom " + propertyType.getName() + " " + listingType.getName() + " in " + location;
	}



	public Property(ListingType listingType, long price, PropertyType propertyType, String location,
			int numberOfBedrooms, String description, String url) {
		this.listingType = listingType;
		this.price = price;
		this.propertyType = propertyType;
		this.location = location;
		this.numberOfBedrooms = numberOfBedrooms;
		this.description = description;
		this.url = url;
	}
}
