package com.vinegrad.estateagents.model;

public enum SortingType {

	RECOMMENDED("Recommended"), HIGHEST("Price - Highest First"), LOWEST("Price - Lowest First");
	
	private String name;
	
	private SortingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
