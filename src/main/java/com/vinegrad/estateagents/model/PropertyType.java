package com.vinegrad.estateagents.model;

public enum PropertyType {

	DETACHED("detached house"), SEMI_DETACHED("semi-detached house"), TERRACED("terraced house"),
	FLAT("flat"), BUNGALOW("bungalow");
	
	private String name;
	
	PropertyType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String display() {
		String hyphenated = String.valueOf(this).replace("_", "-");
		return hyphenated.substring(0, 1).toUpperCase() + hyphenated.substring(1, hyphenated.length()).toLowerCase();
	}
	
} 
