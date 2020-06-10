package com.vinegrad.estateagents.service;

import static com.vinegrad.estateagents.constant.Constants.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vinegrad.estateagents.model.FilterRequirement;
import com.vinegrad.estateagents.model.Property;

@Service
public class FilterServiceImpl implements FilterService {

	@Override
	public List<Property> getFilteredProperties(FilterRequirement req) {
		LATEST_SEARCHES = PROPERTIES.stream().filter(req::test).collect(Collectors.toList());
		return LATEST_SEARCHES;
	}
	
}
