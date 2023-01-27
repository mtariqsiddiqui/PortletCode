package com.sadad.portal.common.utils;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class SadadXmlUtils
{
	private final static String CLASS_NAME = SadadXmlUtils.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Transform JAXB object into an XML stream
	 * 
	 * @param qName
	 *            - QName should be same as JAXB Context Class, required as @XmlRootElement – Missing from generated JAXB Classes
	 * @param jaxbClass
	 *            - Class to initialize JAXB Context
	 * @param xmlObj4Mars
	 *            - Object which needs to be converted into XML
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> String xmlMarshaller(String qName, Class<T> jaxbClass, Object xmlObj4Mars)
	{
		final String methodName = "xmlMarshaller";
		logger.entering(CLASS_NAME, methodName);

		StringWriter sw = new StringWriter();
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			JAXBElement<T> jaxbElement = new JAXBElement<T>(new QName("", qName), jaxbClass, (T) xmlObj4Mars);
			jaxbMarshaller.marshal(jaxbElement, sw);
			logger.logp(Level.FINEST, CLASS_NAME, methodName, sw.toString());
		}
		catch (JAXBException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
		logger.exiting(CLASS_NAME, methodName);
		return sw.toString();
	}
	
	/**
	 * Transform JAXB object into an XML stream
	 * 
	 * @param qName
	 *            - QName should be same as JAXB Context Class, required as @XmlRootElement – Missing from generated JAXB Classes
	 * @param jaxbClass
	 *            - Class to initialize JAXB Context
	 * @param xmlObj4Mars
	 *            - Object which needs to be converted into XML
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> String prettyXmlMarshaller(String qName, Class<T> jaxbClass, Object xmlObj4Mars)
	{
		final String methodName = "xmlMarshaller";
		logger.entering(CLASS_NAME, methodName);

		StringWriter sw = new StringWriter();
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			JAXBElement<T> jaxbElement = new JAXBElement<T>(new QName("", qName), jaxbClass, (T) xmlObj4Mars);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			jaxbMarshaller.marshal(jaxbElement, sw);
			// logger.logp(Level.FINEST, CLASS_NAME, methodName, sw.toString());
		}
		catch (JAXBException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
		logger.exiting(CLASS_NAME, methodName);
		return sw.toString();
	}
}
