package com.vinegrad.estateagents.model;

public enum ListingType {

	FOR_SALE("for sale"), TO_LET("to let");
	
	private String name;
	
	private ListingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
