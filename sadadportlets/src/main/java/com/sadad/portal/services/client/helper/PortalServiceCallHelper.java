/**
 * 
 */
package com.sadad.portal.services.client.helper;

import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.portal.beans.SadadPortalSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.delegate.factory.ServiceDelegateFactory;
import com.sadad.portal.services.delegate.factory.implementation.AccountQueryDelegate;
import com.sadad.portal.services.delegate.factory.implementation.AuditServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillerNotificationDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CacheServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CorePaymentDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CustomerDelegate;
import com.sadad.portal.services.delegate.factory.implementation.FileManagementServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.IbanManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerConfigurationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerProfileServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationCutoffServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.ReferenceDataServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.RefundSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.SettlementInstructuionsReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.TestConnectivityDelegate;
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
	protected static final ResourceBundle rb = ResourceBundle.getBundle(PortalConstant.SADAD_COMMOM_RESOURCE);

	// protected static variables are used to call web service operations in 
	protected static AccountQueryDelegate accountService = ServiceDelegateFactory.getInstance().getAccountQueryDelegate();
	protected static AuditServiceDelegate auditService = ServiceDelegateFactory.getInstance().getAuditServiceDelegate();
	protected static BillSearchDelegate billService = ServiceDelegateFactory.getInstance().getBillSearchDelegate();
	protected static BillerNotificationDelegate billerNotificationService = ServiceDelegateFactory.getInstance().getBillerNotificationDelegate();
	protected static BulkUploadDelegate bulkUploadService = ServiceDelegateFactory.getInstance().getBulkUploadDelegate();
	protected static BulkUploadConfirmationServiceDelegate bulkUpldCnfrmAcctService = ServiceDelegateFactory.getInstance().getBulkUploadConfirmationServiceDelegate(BulkUploadConfirmationServiceTypeEnum.ACCOUNTS);
	protected static BulkUploadConfirmationServiceDelegate bulkUpldCnfrmBillService = ServiceDelegateFactory.getInstance().getBulkUploadConfirmationServiceDelegate(BulkUploadConfirmationServiceTypeEnum.BILLS);
	protected static BulkUploadConfirmationServiceDelegate bulkUpldCnfrmPmntService = ServiceDelegateFactory.getInstance().getBulkUploadConfirmationServiceDelegate(BulkUploadConfirmationServiceTypeEnum.PAYMENTS);
	protected static CacheServiceDelegate cacheService = ServiceDelegateFactory.getInstance().getCacheServiceDelegate();
	protected static CustomerDelegate customerService = ServiceDelegateFactory.getInstance().getCustomerDelegate();
	protected static FileManagementServiceDelegate fileService = ServiceDelegateFactory.getInstance().getFileManagementServiceDelegate();
	protected static IbanManagementDelegate ibanService = ServiceDelegateFactory.getInstance().getIbanManagementDelegate();	
	protected static PartnerConfigurationServiceDelegate partnerConfigService = ServiceDelegateFactory.getInstance().getPartnerConfigurationServiceDelegate();
	protected static PartnerManagementDelegate  partnerManagementService = ServiceDelegateFactory.getInstance().getPartnerManagementDelegate();	
	protected static PartnerProfileServiceDelegate partnerProfileService = ServiceDelegateFactory.getInstance().getPartnerProfileServiceDelegate();
	protected static CorePaymentDelegate paymentService = ServiceDelegateFactory.getInstance().getCorePaymentDelegate();
	protected static ReconciliationCutoffServiceDelegate reconCutOffService = ServiceDelegateFactory.getInstance().getReconciliationCutoffServiceDelegate();
	protected static ReconciliationReportServiceDelegate reconReportBankService = ServiceDelegateFactory.getInstance().getReconciliationReportServiceDelegate(ReconciliationReportServiceTypeEnum.BANKS);
	protected static ReconciliationReportServiceDelegate reconReportBillerService = ServiceDelegateFactory.getInstance().getReconciliationReportServiceDelegate(ReconciliationReportServiceTypeEnum.BILLERS);
	protected static ReferenceDataServiceDelegate referenceDataService = ServiceDelegateFactory.getInstance().getReferenceDataServiceDelegate();
	protected static RefundSearchDelegate refundService =  ServiceDelegateFactory.getInstance().getRefundSearchDelegate();
	protected static SettlementInstructuionsReportServiceDelegate stltInstRptServie = ServiceDelegateFactory.getInstance().getSettlementInstructuionsReportServiceDelegate();
	protected static TestConnectivityDelegate connectionService =  ServiceDelegateFactory.getInstance().getTestConnectivityDelegate();

	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param initiatorKey - sets the request initiator in message header
	 * @param providerKey - sets the request provider in message header
	 * @param consumerId - sets the consumer Id in message header
	 * @param lang - sets the request language code in message header
	 * @param endUser - sets the request end user in message header
	 * @param msgCode - sets the message code in message header
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException
	 */
	protected static MessageHeaderType getMessageHeaderType(String initiatorKey, String providerKey, String consumerId, String lang, String endUser, String msgCode) throws DatatypeConfigurationException
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
		if (lang.equalsIgnoreCase("en"))
			msgHeader.setLang(LanguagePrefSType.EN_GB);
		else if (lang.equalsIgnoreCase("ar"))
			msgHeader.setLang(LanguagePrefSType.AR_SA);
		msgHeader.setEndUserID(endUser);
		msgHeader.setApplicationID("PORTAL_APP"); // EBPP_Portal
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.PORTAL);
		return msgHeader;
	}

	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param msgCode - Message Code to be set
	 * @param endUse - End User Id to be set
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException 
	 */
	protected static MessageHeaderType getMessageHeaderType(String svcConsumer, String msgCode, String endUser, String lang) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey(svcConsumer);
		msgHeader.setServiceProviderKey("SADAD-001");
		msgHeader.setServiceConsumerId(svcConsumer);
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		if (lang.equalsIgnoreCase("en"))
			msgHeader.setLang(LanguagePrefSType.EN_GB);
		else if (lang.equalsIgnoreCase("ar"))
			msgHeader.setLang(LanguagePrefSType.AR_SA);
		msgHeader.setEndUserID(endUser);
		msgHeader.setApplicationID("PORTAL_APP"); // EBPP_Portal
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.PORTAL);
		return msgHeader;
	}
	
	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param msgCode - Message Code to be set
	 * @param endUse - End User Id to be set
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException 
	 */
	protected static MessageHeaderType getMessageHeaderType(String msgCode, String endUser, String lang) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey("SERVICE_INITIATOR_KEY");
		msgHeader.setServiceProviderKey("SADAD-001");
		msgHeader.setServiceConsumerId("SERVICE_CONSUMER_ID");
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		if (lang.equalsIgnoreCase("en"))
			msgHeader.setLang(LanguagePrefSType.EN_GB);
		else if (lang.equalsIgnoreCase("ar"))
			msgHeader.setLang(LanguagePrefSType.AR_SA);
		msgHeader.setEndUserID(endUser);
		msgHeader.setApplicationID("PORTAL_APP"); // EBPP_Portal
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.PORTAL);
		return msgHeader;
	}
	
	/**
	 * Returns an object of MessageHeaderType which can be used in calling S2 backend webservice.
	 * 
	 * @param msgCode - Message Code to be set
	 * @return MessageHeaderType msgHeader
	 * @throws DatatypeConfigurationException
	 */
	protected static MessageHeaderType getMessageHeaderType(String msgCode) throws DatatypeConfigurationException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar now = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		MessageHeaderType msgHeader = new MessageHeaderType();
		msgHeader.setServiceInitiatorKey("SERVICE_INITIATOR_KEY");
		msgHeader.setServiceProviderKey("SADAD-001");
		msgHeader.setServiceConsumerId("SERVICE_CONSUMER_ID");
		msgHeader.setRqUID(UUID.randomUUID().toString());
		msgHeader.setUUID(UUID.randomUUID().toString());
		msgHeader.setDate(now);
		msgHeader.setLang(LanguagePrefSType.EN_GB);
		msgHeader.setEndUserID("portal_user");
		msgHeader.setApplicationID("PORTAL_APP"); // EBPP_Portal
		msgHeader.setCompressed(false);
		msgHeader.setMsgCode(msgCode);
		msgHeader.setServiceMsgType(ServiceMsgTypeSType.XML);
		msgHeader.setChannel(SADADChannelTypeEnums.PORTAL);
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
	
	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, 
	 * partner type, user type and user groups values back in object
	 * 
	 * @param sesObj - session object which needs to be cleared
	 * @param castTo - Java Class in which session object should be casted while returning
	 * @return - sesObj, session object after clearing, restoring and casted to the required type 
	 */
	protected <T> T clearSessionBeanObject(SadadPortalSessionDataBean sesObj, Class<T> castTo)
	{
		// Save the fields for restoration
		String container1 = sesObj.getScreen().getContainer1();
		String partnerKey = sesObj.getPartnerKey();
		String partnerType = sesObj.getPartnerType();
		String userType = sesObj.getUserType();
		String userGroups = sesObj.getUserGroups();
		String ltpaTokenValue = sesObj.getLtpaTokenValue();
		sesObj = null;
		try
		{
			// Restore the saved fields
			sesObj = (SadadPortalSessionDataBean) castTo.newInstance();
			sesObj.getScreen().setContainer1(container1);
			sesObj.setPartnerKey(partnerKey);
			sesObj.setPartnerType(partnerType);
			sesObj.setUserType(userType);
			sesObj.setUserGroups(userGroups);
			sesObj.setLtpaTokenValue(ltpaTokenValue);
		}
		catch (IllegalAccessException | InstantiationException e)
		{
			return null;
		}
		// return the object after casting it to required class
		return castTo.cast(sesObj);
	}
}
