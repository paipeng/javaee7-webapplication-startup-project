package com.paipeng.jms.client;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;

public class JMSClient {

	private static ConnectionFactory init() {
		TransportConfiguration transportConfiguration = new TransportConfiguration(
				NettyConnectorFactory.class.getName());

		ConnectionFactory factory = (ConnectionFactory) HornetQJMSClient
				.createConnectionFactoryWithoutHA(JMSFactoryType.CF, transportConfiguration);
		return factory;
	}
	
	private static ConnectionFactory init2() {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "remote://localhost:4446");
		// env.put(Context.SECURITY_PRINCIPAL, "guest");
		// env.put(Context.SECURITY_CREDENTIALS, "");
		InitialContext context;
		try {
			context = new InitialContext(env);
			String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
			ConnectionFactory factory = (ConnectionFactory) context.lookup(connectionFactoryString);

			return factory;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		/*
		
		 
		*/

		try {
			ConnectionFactory factory = init();
			
			
			// The queue name should match the jms-queue name in standalone.xml
			Queue queue = HornetQJMSClient.createQueue("QueueOne");
			Connection connection;

			connection = factory.createConnection();
			Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);

			MessageProducer producer = session.createProducer(queue);

			// 1. Sending TextMessage to the Queue
			TextMessage message = session.createTextMessage();
			message.setText("Hello EJB3 MDB Queue!!!");
			producer.send(message);
			System.out.println("1. Sent TextMessage to the Queue");
			/*
			 * //2. Sending ObjectMessage to the Queue ObjectMessage objMsg =
			 * session.createObjectMessage();
			 * 
			 * 
			 * Employee employee = new Employee(); employee.setId(2163);
			 * employee.setName("Kumar"); employee.setDesignation("CTO");
			 * employee.setSalary(100000); objMsg.setObject(employee);
			 * 
			 * producer.send(objMsg); System.out.println(
			 * "2. Sent ObjectMessage to the Queue");
			 */
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
