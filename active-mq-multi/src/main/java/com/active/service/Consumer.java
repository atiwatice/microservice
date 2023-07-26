package com.active.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
	
	@JmsListener(destination = "${spring.activemq.topic1}")
	public void listen(String msg) {
		log.info(msg);
	}
	
	@JmsListener(destination = "${spring.activemq.queue1}")
	public void listenQueue(String msg) {
		log.info(msg);
	}
}
