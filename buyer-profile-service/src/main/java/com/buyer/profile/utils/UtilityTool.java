package com.buyer.profile.utils;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

@Component
public class UtilityTool {

	@Autowired
	ObjectMapper objectMapper;

	public Map<String, ValueDifference<Object>> checkDiffObeject(Object input1, Object input2) {
		@SuppressWarnings("unchecked")
		Map<String, Object> object1 = objectMapper.convertValue(input1, Map.class);
		@SuppressWarnings("unchecked")
		Map<String, Object> object2 = objectMapper.convertValue(input2, Map.class);

		return Maps.difference(object1, object2).entriesDiffering();
	}

	public Map<String, String> checkDiffObjectString(Object input1, Object input2) {

		Map<String, String> returnValue = new HashMap<String, String>();

		checkDiffObeject(input1, input2).forEach((key, valueDifference) -> returnValue.put(key,
				"Before value: " + valueDifference.leftValue() + ", After value: " + valueDifference.rightValue()));

		return returnValue;

	}
}
