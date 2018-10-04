package com.sadad.ebpp.portal;

import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.ebpp.portal.delegate.factory.ServiceDelegateFactory;
import com.sadad.ebpp.portal.delegate.factory.clients.AccountQueryDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.BillSearchDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CustomerDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.PartnerProfileServiceDelegate;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSAMARequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSAMAResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryResponseType;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchFault;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.scm.common._1.MessageHeaderType;
import com.sadad.scm.common._1.SADADChannelTypeEnums;
import com.sadad.scm.common._1.ServiceMsgTypeSType;
import com.sadad.scm.common.system._1.LanguagePrefSType;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */
public class App
{
	static PartnerProfileServiceDelegate ppsd = ServiceDelegateFactory.getInstance().getPartnerProfileServiceDelegate();
	static AccountQueryDelegate aqsd = ServiceDelegateFactory.getInstance().getAccountQueryDelegate();
	static BillSearchDelegate bsd = ServiceDelegateFactory.getInstance().getBillSearchDelegate(); 

	public static void main(String[] args)
	{
		try
		{
			Class customerClass = CustomerDelegateImpl.class;
			System.out.println(customerClass);
			
			Field[] customerFields = customerClass.getFields();
			
			for(Field f : customerFields)
				System.out.println(f);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void callGetBillerList() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		GetBillerListRequestType billerList = new GetBillerListRequestType();
		billerList.setMessageHeader(getMessageHeaderType("GET_BILLER_LIST"));
		GetBillerListResponseType billerListResponseType = ppsd.getBillerList(billerList);
	}

	@SuppressWarnings("unused")
	private static void callGetBankList() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		GetBankListRequestType bankList = new GetBankListRequestType();
		bankList.setMessageHeader(getMessageHeaderType("GET_BANK_LIST"));
		GetBankListResponseType bankListResponseType = ppsd.getBankList(bankList);
	}

	@SuppressWarnings("unused")
	private static void callGetSADAD() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		GetSADADRequestType sadadRequestType = new GetSADADRequestType();
		sadadRequestType.setMessageHeader(getMessageHeaderType("GET_SADAD"));
		GetSADADResponseType sadadResponseType = ppsd.getSADAD(sadadRequestType);
	}

	@SuppressWarnings("unused")
	private static void callGetSAMA() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		GetSAMARequestType samaRequestType = new GetSAMARequestType();
		samaRequestType.setMessageHeader(getMessageHeaderType("GET_SAMA"));
		samaRequestType.setPartnerKey("001");
		GetSAMAResponseType samaResponseType = ppsd.getSAMA(samaRequestType);
	}
	
	@SuppressWarnings("unused")
	private static void listBillCategory() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		ListBillCategoryRequestType lbcReq = new ListBillCategoryRequestType();
		lbcReq.setMessageHeader(getMessageHeaderType("LIST_BILL_CATEGORY"));
		lbcReq.setPartnerKey("001");
		ListBillCategoryResponseType lbcRes = ppsd.listBillCategory(lbcReq);
	}
	
	@SuppressWarnings("unused")
	private static void getBillCategory() throws DatatypeConfigurationException, PartnerProfileFaultMsg
	{
		GetBillCategoryRequestType gbcReq = new GetBillCategoryRequestType();
		gbcReq.setMessageHeader(getMessageHeaderType("GET_BILL_CATEGORY"));
		gbcReq.setPartnerKey("001");
		gbcReq.setBillCategory("GSHT");
		GetBillCategoryResponseType gbcRes = ppsd.getBillCategory(gbcReq);		
	}
	
	@SuppressWarnings("unused")
	private static void getByKey() throws DatatypeConfigurationException, AccountQueryFault
	{
		// Call the backend service
		GetByKeyRqType rqst = new GetByKeyRqType();
		rqst.setMessageHeader(getMessageHeaderType("ACCOUNT_GET_BY_KEY"));
		rqst.setBillerKey("001");
		rqst.setAccountKey("0509414446");
		GetByKeyRsType rspn = aqsd.getByKey(rqst);
	}
	
	private static void getByBillNumber() throws BillSearchFault, DatatypeConfigurationException
	{
		GetByBillNumberRqType req = new GetByBillNumberRqType();
		req.setMessageHeader(getMessageHeaderType("GET_BY_BILL_NUMBER"));
		req.setBillerKey("001");
		req.setBillKey("00100");
		GetByBillNumberRsType res = bsd.getByBillNumber(req);
	}
	
	private static MessageHeaderType getMessageHeaderType(String msgCode) throws DatatypeConfigurationException
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
}
