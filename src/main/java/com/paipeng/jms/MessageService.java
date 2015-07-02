package com.paipeng.jms;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MessageService
 */

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/jms/queue/exampleQueue") })
public class MessageService implements MessageListener {

	@Inject
	private Logger logger;

	/**
	 * Default constructor.
	 */
	public MessageService() {
		// TODO Auto-generated constructor stub
	}

	public static MessageService Instance() {
		MessageService messageService = new MessageService();

		return messageService;
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			logger.info("===> MyMDB Received: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	

}
