package com.sadad.portal.common.utils;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public interface RequestResponseLogger
{
	static String CLASS_NAME = "com.sadad.portal.RequestResponseLogger";
	static final Logger logger = Logger.getLogger(CLASS_NAME);
	static final String lc = new String(System.getProperty("line.separator") + "#################################################" + System.getProperty("line.separator") + "#                    _-_-_-_-                   #"
			+ System.getProperty("line.separator") + "#################################################" + "transaction_logger_message" + "-------------------------------------------------");

	@SuppressWarnings("unchecked")
	default <T> void logRequest(String qName, Class<T> jaxbClass, Object xmlObj4Mars)
	{
		final String methodName = "logRequest";
		StringBuilder sb = new StringBuilder(lc);
		int start = sb.indexOf("_-_-_-_-");
		int end = start + "_-_-_-_-".length();
		sb.replace(start, end, "Request");
		start = sb.indexOf("transaction_logger_message");
		end = start + "transaction_logger_message".length();
		try
		{
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			JAXBElement<T> jaxbElement = new JAXBElement<T>(new QName("", qName), jaxbClass, (T) xmlObj4Mars);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			jaxbMarshaller.marshal(jaxbElement, sw);
			
			logger.log(Level.FINEST, sb.replace(start, end, sw.toString()).toString());
		}
		catch (JAXBException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	default <T> void logResponse(String qName, Class<T> jaxbClass, Object xmlObj4Mars)
	{
		final String methodName = "logResponse";
		StringBuilder sb = new StringBuilder(lc);
		int start = sb.indexOf("_-_-_-_-");
		int end = start + "_-_-_-_-".length();
		sb.replace(start, end, "Response");
		start = sb.indexOf("transaction_logger_message");
		end = start + "transaction_logger_message".length();
		
		try
		{
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			JAXBElement<T> jaxbElement = new JAXBElement<T>(new QName("", qName), jaxbClass, (T) xmlObj4Mars);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
			jaxbMarshaller.marshal(jaxbElement, sw);
			
			logger.log(Level.FINEST, sb.replace(start, end, sw.toString()).toString());
		}
		catch (JAXBException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
}
