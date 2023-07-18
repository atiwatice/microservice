package com.active.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.jms.JMSException;

@Component
public class Producer {
	
	@Autowired
	@Qualifier("jmsTemplateTopic1")
	private JmsTemplate jsmTemplate;
	
	@Value("${spring.activemq.topic1}")
	private String destinationTopic;
	
	public void send(Object input) throws JMSException, JsonProcessingException{
		String jsonString =new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(input);
		jsmTemplate.convertAndSend(destinationTopic, jsonString);
	}
}
