package com.sadad.portal.common.utils;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.delegate.factory.implementation.SadadServicesEndPointUrls;

public class SadadMessagingClient
{
	private final static String CLASS_NAME = SadadMessagingClient.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final ResourceBundle rb = ResourceBundle.getBundle("com.sadad.SadadServicesEndPointUrls");
	private static final String[] JMS_CONNECTION_ID = SadadServicesEndPointUrls.JMS_CONNECTION_ID.split(",");

	/**
	 * Put message into the queue of MQ 
	 * @param jmsConnectionId - connection id defined in SadadServicesEndPointUrls properties file
	 * @param msg - message to put in the queue
	 */
	public static void sendMessage(String jmsConnectionId, String msg)
	{
		final String methodName = "sendMessage";
		logger.entering(CLASS_NAME, methodName, jmsConnectionId);
		
		Context jndiContext = null;
		QueueConnectionFactory queueConnectionFactory = null;
		QueueConnection queueConnection = null;
		QueueSession queueSession = null;
		Queue queue = null;
		QueueSender queueSender = null;
		TextMessage txtMessage = null;
		
		String queueJndi = null, queueConnectionFactoryJndi = null;
		
		for(String s : JMS_CONNECTION_ID)
		{
			if(s.equals(jmsConnectionId))
			{
				queueJndi = rb.getString(jmsConnectionId + PortalConstant.JNDI_QUEUE_PREFIX);
				queueConnectionFactoryJndi = rb.getString(jmsConnectionId + PortalConstant.JNDI_QUEUE_CONNECTION_FACTORY_PREFIX);
				break;
			}
		}
		
		try
		{
			jndiContext = new InitialContext();
			queueConnectionFactory = (QueueConnectionFactory) jndiContext.lookup(queueConnectionFactoryJndi);
			queue = (Queue) jndiContext.lookup(queueJndi);

			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			queueSender = queueSession.createSender(queue);
			txtMessage = queueSession.createTextMessage();
			txtMessage.setText(msg);
			queueSender.send(txtMessage);
		}
		catch (NamingException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (JMSException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		finally
		{
			if (queueConnection != null)
			{
				try { queueConnection.close(); }
				catch (Exception e) {throw new IllegalStateException(e);}
			}
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}