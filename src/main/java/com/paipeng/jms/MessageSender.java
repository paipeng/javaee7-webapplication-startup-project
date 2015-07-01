package com.paipeng.jms;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;


@RequestScoped
public class MessageSender {
	@Inject
	private JMSContext context;

	@Resource(mappedName = "java:jboss/jms/queue/exampleQueue")
	private Queue myQueue;

	public MessageSender() {

	}
	
	public static MessageSender Instance() {
		MessageSender sender = new MessageSender();
		return sender;
	}

	public void sendMessage(String text) {

		try {
			context.createProducer().send(myQueue, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}