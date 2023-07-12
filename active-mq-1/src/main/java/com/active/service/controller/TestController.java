package com.active.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.active.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class TestController {
	@Autowired
	ProducerService producer;
	
	@GetMapping("/testttttt")
	public String test() {
		
		try {
			producer.sendToTopic();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test";
	}
}
