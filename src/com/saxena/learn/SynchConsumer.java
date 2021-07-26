package com.bank.authentication;



import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

public class SynchConsumer {
	
	
	@Resource(lookup = "jms/ConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(lookup = "jms/Queue")private static Queue queue;
	@Resource(lookup = "jms/Topic")private static Topic topic;
	
	
	Destination dest = null;
	try {
	if (destType.equals("queue")) {
	dest = (Destination) queue;
	} else {
	dest = (Destination) topic;
	}
	}
	catch (Exception e) {
	System.err.println("Error setting destination: " + e.toString());
	e.printStackTrace();
	System.exit(1);
	
	
	Connection connection = connectionFactory.createConnection();
	Session session = connection.createSession(
	false,
	Session.AUTO_ACKNOWLEDGE);
	
	consumer = session.createConsumer(dest);
	
	connection.start();
	
	while (true) {
		Message m = consumer.receive(1);
		if (m != null) {
		if (m instanceof TextMessage) {
		message = (TextMessage) m;
		System.out.println("Reading message: " + message.getText());
		} else {
		break;
		}
		}
		}

}
