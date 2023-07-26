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
public class JmsConfig {

	@Value("${spring.activemq.broker-url1}")
	private String brokerUrl1;

	@Value("${spring.activemq.user1}")
	private String user1;

	@Value("${spring.activemq.password1}")
	private String password1;

	@Value("${spring.activemq.broker-url2}")
	private String brokerUrl2;

	@Value("${spring.activemq.user2}")
	private String user2;

	@Value("${spring.activemq.password2}")
	private String password2;

	@Bean("connectionFactory1")
	public ActiveMQConnectionFactory connectionFactory1() {
		if ("".equals(user1)) {
			return new ActiveMQConnectionFactory(brokerUrl1);
		}
		return new ActiveMQConnectionFactory(user1, password1, brokerUrl1);
	}

	@Bean("jmsFactoryTopic1")
	public JmsListenerContainerFactory<?> jmsFactoryTopic1(
			@Qualifier("connectionFactory1") ConnectionFactory connecctionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connecctionFactory);
		factory.setPubSubDomain(true);
		factory.setClientId("producer");
		factory.setSubscriptionDurable(true);
		return factory;
	}

	@Bean("jmsTemplateTopic1")
	public JmsTemplate jmsTemplateTopic1() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory1());
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setDestinationResolver(destinationResolver1());
		jmsTemplate.setDeliveryPersistent(true);
		
		return jmsTemplate;
	}

	@Bean("jmsTemplate1")
	public JmsTemplate jmsTemplate1() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory1());
		
		template.setPubSubDomain(true);
		template.setDestinationResolver(destinationResolver1());
		template.setDeliveryPersistent(true);

		return template;
	}

	@Bean("destinationResolver1")
	DynamicDestinationResolver destinationResolver1() {
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
