package com.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.active.entity.Employee;
import com.active.service.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.jms.JMSException;

@RestController
public class ProducerController {

	@Autowired
	Producer producer;

	@GetMapping("/testproducek")
	public String testProduce() {

		try {
			producer.send(Employee.builder().id("1").name("John").age(15).build());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (JMSException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "testProduce";
	}

	@GetMapping("/testQueue")
	public String testProduceQueue() {

		try {
			producer.sendQueue(Employee.builder().id("2").name("Kelvin").age(20).build());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (JMSException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "testProduce";
	}

}
