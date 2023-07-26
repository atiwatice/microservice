package com.active.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Session;

@Configuration
@EnableJms
public class JmsConfigConsumer {


	@Value("${spring.activemq.broker-url2}")
	private String brokerUrl2;

	@Value("${spring.activemq.user2}")
	private String user2;

	@Value("${spring.activemq.password2}")
	private String password2;


	@Bean("connectionFactory2")
	public ActiveMQConnectionFactory connectionFactory2() {
		if ("".equals(user2)) {
			return new ActiveMQConnectionFactory(brokerUrl2);
		}
		return new ActiveMQConnectionFactory(user2, password2, brokerUrl2);
	}
	
	
	@Bean("jmsListenerContainerFactory")
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory(@Qualifier("connectionFactory2") ConnectionFactory connecctionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connecctionFactory);
		factory.setPubSubDomain(true);
		factory.setClientId("consumer");
		factory.setSubscriptionDurable(true);
		factory.setDestinationResolver(destinationResolver2());
		return factory;
	}
	
	@Bean("jmsTemplateTopic2")
	public JmsTemplate jmsTemplateTopic2() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory2());
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setDestinationResolver(destinationResolver2());
		jmsTemplate.setDeliveryPersistent(true);
		return jmsTemplate;
	}
	
	@Bean("jmsTemplate2")
	public JmsTemplate jmsTemplate2() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory2());
		
		template.setPubSubDomain(true);
		template.setDestinationResolver(destinationResolver2());
		template.setDeliveryPersistent(true);

		return template;
	}
	
	@Bean("destinationResolver2")
	DynamicDestinationResolver destinationResolver2() {
		return new DynamicDestinationResolver() {
			@Override
			public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain)
					throws JMSException {
				if (destinationName.endsWith("Topic")) {
					pubSubDomain = true;
				} else {
					pubSubDomain = false;
				}
				return super.resolveDestinationName(session, destinationName, pubSubDomain);
			}
		};
	}
	
}
