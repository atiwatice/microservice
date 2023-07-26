package com.kafka.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.ListenableFuture;
import com.kafka.model.User;

@Service
public class KafKaProducerService {
	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

	// 1. General topic with string payload

	@Value(value = "${general.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// 2. Topic with user object payload

	@Value(value = "${user.topic.name}")
	private String userTopicName;

	@Autowired
	private KafkaTemplate<String, User> userKafkaTemplate;

	public void sendMessage(String message) {

		CompletableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topicName, message);

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveCreateUserLog(User user) {
		@SuppressWarnings("unchecked")
		ListenableFuture<SendResult<String, User>> future = (ListenableFuture<SendResult<String, User>>) this.userKafkaTemplate
				.send(userTopicName, user);

//		future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
//			@Override
//			public void onSuccess(SendResult<String, User> result) {
//				logger.info("User created: " + user + " with offset: " + result.getRecordMetadata().offset());
//			}
//
//			@Override
//			public void onFailure(Throwable ex) {
//				logger.error("User created : " + user, ex);
//			}
//		});
	}
}
