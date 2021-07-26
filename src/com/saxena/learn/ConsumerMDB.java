package com.mdbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/PERSISTENTQ1"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "country='US'"), })
@TransactionManagement(TransactionManagementType.BEAN)
public class ConsumerMDB implements MessageListener {

	@Resource
	private MessageDrivenContext context;

	@Resource(mappedName = "java:MySqlXADS")
	private DataSource dataSource;

	public void onMessage(Message arg0) {
		System.out.println("Message Recieved ......");
		Connection connection = null;
		UserTransaction tx;
		try {
			tx = context.getUserTransaction();
			tx.begin();
			connection = dataSource.getConnection();
			String sql = "insert into sampletx values (1,2)";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			throw new SQLException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
