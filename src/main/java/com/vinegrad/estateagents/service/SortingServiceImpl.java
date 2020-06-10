package com.vinegrad.estateagents.service;

import static com.vinegrad.estateagents.constant.Constants.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vinegrad.estateagents.model.Property;
import com.vinegrad.estateagents.model.SortingRequirement;

@Service
public class SortingServiceImpl implements SortingService {
	
	private final Comparator<Property> comparator = Comparator.comparing(Property::getPrice);

	@Override
	public List<Property> sortProperties(SortingRequirement req) {
		switch(req.getType()) {
		case HIGHEST:
			return orderOnPrice(comparator.reversed());
		case LOWEST:
			return orderOnPrice(comparator);
		default:
			return LATEST_SEARCHES;
		}
	}
	
	 private List<Property> orderOnPrice(Comparator<Property> comparator) {
		 return LATEST_SEARCHES.stream().sorted(comparator).collect(Collectors.toList());
	 }
}
