/**
 * 
 */
package com.sadad.portal.helper;

import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.ebpp.portal.delegate.factory.ServiceDelegateFactory;
import com.sadad.ebpp.portal.delegate.factory.clients.AccountQueryDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.BillSearchDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CorePaymentDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CustomerDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.PartnerProfileServiceDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.ReferenceDataServiceDelegate;
import com.sadad.scm.common._1.MessageHeaderType;
import com.sadad.scm.common._1.SADADChannelTypeEnums;
import com.sadad.scm.common._1.ServiceMsgTypeSType;
import com.sadad.scm.common.system._1.LanguagePrefSType;

/**
 * @author Tariq Siddiqui
 *
 */
public abstract class PortalServiceCallHelper
{
	/**
	 * Service Delegate variables to be used by all its sub classes
	 */
	protected static PartnerProfileServiceDelegate partnerProfileServices = ServiceDelegateFactory.getInstance().getPartnerProfileServiceDelegate();
	protected static AccountQueryDelegate accountServices = ServiceDelegateFactory.getInstance().getAccountQueryDelegate();
	protected static BillSearchDelegate billservices = ServiceDelegateFactory.getInstance().getBillSearchDelegate();
	protected static CustomerDelegate customerServices = ServiceDelegateFactory.getInstance().getCustomerDelegate();
	protected static CorePaymentDelegate paymentServices = ServiceDelegateFactory.getInstance().getCorePaymentDelegate();
	protected static ReferenceDataServiceDelegate referenceDataService = ServiceDelegateFactory.getInstance().getReferenceDataServiceDelegate();
	
	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param initiatorKey
	 * @param providerKey
	 * @param consumerId
	 * @param endUser
	 * @param msgCode
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException
	 */
	protected static MessageHeaderType getMessageHeaderType(String initiatorKey, String providerKey, String consumerId, String endUser, String msgCode) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey(initiatorKey);
		msgHeader.setServiceProviderKey(providerKey);
		msgHeader.setServiceConsumerId(consumerId);
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		msgHeader.setLang(LanguagePrefSType.EN_GB);
		msgHeader.setEndUserID(endUser);
		msgHeader.setApplicationID("EBPP_Portal");
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.EBPP);
		return msgHeader;
	}

	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param msgCode
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException
	 */
	protected static MessageHeaderType getMessageHeaderType(String msgCode) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey("I_AM_SERVICE_INITIATOR_KEY");
		msgHeader.setServiceProviderKey("I_AM_SERVICE_PROVIDER_KEY");
		msgHeader.setServiceConsumerId("I_AM_SERVICE_CONSUMER_ID");
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		msgHeader.setLang(LanguagePrefSType.EN_GB);
		msgHeader.setEndUserID("tariq");
		msgHeader.setApplicationID("EBPP_Portal");
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.EBPP);
		return msgHeader;
	}

	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param initiatorKey
	 * @param providerKey
	 * @param consumerId
	 * @param lang
	 * @param endUser
	 * @param appId
	 * @param compression
	 * @param msgCode
	 * @param msgType
	 * @param channelType
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	protected static MessageHeaderType getMessageHeaderType(String initiatorKey, String providerKey, String consumerId, LanguagePrefSType lang, String endUser, String appId, 
			boolean compression, String msgCode, ServiceMsgTypeSType msgType, SADADChannelTypeEnums channelType) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey(initiatorKey);
		msgHeader.setServiceProviderKey(providerKey);
		msgHeader.setServiceConsumerId(consumerId);
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		msgHeader.setLang(lang);
		msgHeader.setEndUserID(endUser);
		msgHeader.setApplicationID(appId);
		msgHeader.setCompressed(compression);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(msgType);
		msgHeader.setChannel(channelType);
		return msgHeader;
	}
}
