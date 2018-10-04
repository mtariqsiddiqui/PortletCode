package com.sadad.portal.ebpp.accounts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.billsearch._1.ExtBillType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.Association;
import com.sadad.portal.beans.Bill;
import com.sadad.portal.beans.Payment;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.scm.common._1.AssociatedCustomerType;
import com.sadad.scm.common._1.PaymentInfoType;
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * @author Tariq Siddiqui
 * 
 */
public class AccountsHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = AccountsHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private QueryAccountSessionBean queryAccountObject = new QueryAccountSessionBean(0);
	private RejectedAccountsSessionBean rejectedAccountsObject = new RejectedAccountsSessionBean(0);

	/**
	 * @return the queryAccountObject
	 */
	public QueryAccountSessionBean getQueryAccountObject()
	{
		return queryAccountObject;
	}

	/**
	 * @param queryAccountObject
	 *            the queryAccountObject to set
	 */
	public void setQueryAccountObject(QueryAccountSessionBean queryAccountObject)
	{
		this.queryAccountObject = queryAccountObject;
	}
	
	/**
	 * @return the rejectedAccountsObject
	 */
	public RejectedAccountsSessionBean getRejectedAccountsObject()
	{
		return rejectedAccountsObject;
	}

	/**
	 * @param rejectedAccountsObject the rejectedAccountsObject to set
	 */
	public void setRejectedAccountsObject(RejectedAccountsSessionBean rejectedAccountsObject)
	{
		this.rejectedAccountsObject = rejectedAccountsObject;
	}

	/**
	 * 
	 * @param partnerKey
	 * @param accountKey
	 */
	public void getByKey(String partnerKey, String accountKey)
	{
		final String methodName = "getByKey";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			if(accountKey.equals("DELETE_THIS_CONDITION"))
			{			
				// Set the Initial Data in Session object
				getQueryAccountObject().setPartnerKey(partnerKey);
				getQueryAccountObject().setAccountNumber(accountKey);

				// Call the backend service
				GetByKeyRqType rqst = new GetByKeyRqType();
				rqst.setMessageHeader(getMessageHeaderType("ACCOUNT_GET_BY_KEY"));
				rqst.setBillerKey(partnerKey);
				rqst.setAccountKey(accountKey);
				GetByKeyRsType rspn = accountServices.getByKey(rqst);

				// Set the service response values in Session Object
				Account account = new Account();
				account.setAccountNumber(rspn.getAccountInfo().getAccountKey());
				account.setBillerId(rspn.getAccountInfo().getBillerKey());
				account.setServiceType(rspn.getAccountInfo().getServiceType());
				account.setLifecycle(rspn.getAccountInfo().getLifecycle());
				account.setAccountSource(rspn.getAccountInfo().getAccountSource());
				account.setBeneficiary(rspn.getAccountInfo().getBeneficiary());
				account.setCreateDate(rspn.getAccountInfo().getCreateDate());

				getQueryAccountObject().setAccount(account);
			}
		}
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (AccountQueryFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
	}


	/**
	 * Fetch all the associations for specific account number and for specific biller
	 * @param partnerKey - Biller Id for searching
	 * @param accountKey - Customer account number for searching
	 */
	public void listByAccountAssociaitons(String partnerKey, String accountKey)
	{
		final String methodName = "listByAccountAssociaitons";
		logger.entering(CLASS_NAME, methodName, new Object[] {partnerKey, accountKey});
		
		try
		{
			// Set the Initial Data in Session object
			getQueryAccountObject().setPartnerKey(partnerKey);

			ListByAccountRqType req = new ListByAccountRqType();
			req.setMessageHeader(getMessageHeaderType("CUSTOMER_LIST_BY_ACCOUNT"));
			req.setBillerKey(partnerKey);
			req.setAccountKey(accountKey);			
			ListByAccountRsType res = customerServices.listByAccount(req);
			
			// TODO Starts from here .....
			for (@SuppressWarnings("unused") AssociatedCustomerType act : res.getAccountCustomersAssn().getAssociatedCustomer()) 
			{
				@SuppressWarnings("unused")
				Association asc = new Association();
//				asc.setCustomerStatus(act.getCustomer().getPartyStatus());
			}
		}		
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		catch (CustomerFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	
	/**
	 * Fetch all the bills for specific account number for and specific biller
	 * @param partnerKey - Biller Id for searching
	 * @param accountKey - Customer account number for searching
	 */
	public void listBillsByAccountNumber(String partnerKey, String accountKey)
	{
		final String methodName = "listBillsByAccountNumber";
		logger.entering(CLASS_NAME, methodName, new Object[] {partnerKey, accountKey});
		
		try
		{
			getQueryAccountObject().setPartnerKey(partnerKey);

			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType req = new com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType();
			req.setMessageHeader(getMessageHeaderType("LIST_BILLS_BY_ACCOUNT"));
			req.setAccountKey(accountKey);
			req.setBillerKey(partnerKey);
			
			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType res = billservices.listByAccount(req);
			
			for (ExtBillType rb : res.getBills())
			{
				Bill b = new Bill();
				b.setBillNumber(rb.getBillId());
				b.setRquid(rb.getRqUID());
				b.setOrigianlAmount(rb.getOriginalAmount());
				b.setPaymentCount(rb.getPaymentsCount());
				b.setBillCreateionDate(rb.getCreateDate());
				
				getQueryAccountObject().getBills().put(b.getBillNumber(), b);
			}
		}
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (BillSearchFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}		
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Fetch all the payments for specific account number and for specific biller
	 * @param partnerKey - Biller Id for searching
	 * @param accountKey - Customer account number for searching
	 */
	public void listPaymentsByAccountNumber(String partnerKey, String accountKey)
	{
		final String methodName = "listPaymentsByAccountNumber";
		logger.entering(CLASS_NAME, methodName, new Object[] {partnerKey, accountKey});
		
		try
		{
			com.sadad.schema.service.corepayment._1.ListByAccountRqType req = new com.sadad.schema.service.corepayment._1.ListByAccountRqType();
			req.setMessageHeader(getMessageHeaderType("LIST_PAYMENTS_BY_ACCOUNT"));
			com.sadad.schema.service.corepayment._1.ListByAccountRsType res = paymentServices.listByAccount(req);
			
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				// Transaction Info
				pmt.setSadadNumber(pit.getPayment().getPaymentKey());
				pmt.setBankNumber(pit.getPayment().getBNKPTN());
				pmt.setReversalNumber(pit.getPayment().getBNKRVL());
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId());
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN());
				// Bill Info
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setBillNumber(pit.getPaymentReference().getBillKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey());
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle());
				// Payment Info
				pmt.setBankName(pit.getPayment().getIssuerBankName());
				pmt.setAccessChannel(pit.getPayment().getAccessChannel());
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit());
				pmt.setBranchCode(pit.getPayment().getBranchCode());
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode());
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod());
				pmt.setServiceId(pit.getPaymentExtn().getServiceType());
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate());
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState());
				pmt.setDistrictCode(pit.getPayment().getDistrictCode());
				pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary().getPartyId());
				pmt.setCustomerId(pit.getPayment().getPayor().getPartyId());
//				pmt.setRefundId(refundId);

				getQueryAccountObject().getPayments().put(pmt.getSadadNumber(), pmt);
			}
			
		}
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (PaymentFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
//	public void listByCustomer(String partnerKey, String partyId, boolean activeOnly)
//	{
//		final String methodName = "callGetBillCategory";
//		logger.entering(CLASS_NAME, methodName);
//
//		try
//		{
//			// Set the Initial Data in Session object
//			getQueryAccountObject().setPartnerKey(partnerKey);
//			getQueryAccountObject().getCustomers().setOfficialIdNumber(partyId);
//
//			ListByCustomerRqType req = new ListByCustomerRqType();
//			req.setBillerKey(partnerKey);
//			req.setInclOnlyActive(activeOnly);
//			req.getPayor().setPartyId(partyId);
//			
//			ListByCustomerRsType res = 	accountServices.listByCustomer(req);
//			res.getCustomerAccountsAssn().getCustomer();
//		}		
//		catch (NullPointerException e)
//		{
//			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
//			if (logger.isLoggable(Level.FINEST))
//				e.printStackTrace();
//		}
//		catch (AccountQueryFault e)
//		{
//			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
//			if (logger.isLoggable(Level.FINEST))
//				e.printStackTrace();
//		}
//
//		logger.exiting(CLASS_NAME, methodName);
//	}
	
}