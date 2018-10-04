/**
 * 
 */
package com.sadad.portal.admin.billers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.soap.SOAPFaultException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerByKeyRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillerByKeyResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BillerDetail;
import com.sadad.portal.beans.BillerSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BankAccountType;
import com.sadad.scm.common._1.BillerFinanicialInfoType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.FinancialAccountType;
import com.sadad.scm.common._1.PartnerType;

/**
 * @author Tariq Siddiqui
 *
 */
public class BillerHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BillerHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private BillerSessionBean billerObject = new BillerSessionBean();
	
	/**
	 * @return the billerObject
	 */
	public BillerSessionBean getBillerObject()
	{
		return billerObject;
	}
	/**
	 * @param billerObject the billerObject to set
	 */
	public void setBillerObject(BillerSessionBean billerObject)
	{
		this.billerObject = billerObject;
	}
	
	/**
	 * Calls the backend webservice to create a new biller object in database
	 * 
	 * @param billerId - Biller Id to be created
	 * @param billerName - Biller name of new biller
	 * @param description - Biller description
	 * @param billingAccountBank - Biller's billing account bank name
	 * @param billingAccountNumber - Biller's billing account's bank account number
	 * @param refundAccountBank - Biller's refund account's bank name
	 * @param refundAccountNumber - Biller's refund account's bank account number
	 */
	public void callCreateBiller(String billerId, String billerName, String description, String billingAccountBank, String billingAccountNumber,  String refundAccountBank, String refundAccountNumber)
	{
		final String methodName = "callCreateBiller";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBillerRequestType cbReq = new CreateBillerRequestType();
			cbReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER"));
			cbReq.setPartner(new PartnerType());
			cbReq.getPartner().setPartnerKey(billerId);
			cbReq.getPartner().setName(billerName);
			cbReq.getPartner().setDescription(description);
			cbReq.getPartner().setBillerFinanicialInfo(new BillerFinanicialInfoType());
			cbReq.getPartner().getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankKey(billingAccountBank);
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(billingAccountBank);
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(billingAccountNumber);
			cbReq.getPartner().getBillerFinanicialInfo().setRefundAccount(new FinancialAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankKey(refundAccountBank);
			cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankAccount(new BankAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setBankKey(refundAccountBank);
			cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setNumber(refundAccountNumber);
			
			partnerProfileServices.createBiller(cbReq);
			
			// if it reaches here, it means response is successfull change fields manually in session object
			getBillerObject().getSelectedBiller().setBillerId(billerId);
			getBillerObject().getSelectedBiller().setBillerName(billerName);
			getBillerObject().getSelectedBiller().setDescription(description);
			getBillerObject().getSelectedBiller().setBillingAccountBankId(billingAccountBank);
			getBillerObject().getSelectedBiller().setBillingAccountNumber(billingAccountNumber);
			getBillerObject().getSelectedBiller().setRefundAccountBankId(refundAccountBank);
			getBillerObject().getSelectedBiller().setRefundAccountNumber(refundAccountNumber);			
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
		catch (PartnerProfileFaultMsg e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (SOAPFaultException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls the backend webservice to update existing biller data in database.
	 * 
	 * @param billerId - Biller Id to be created
	 * @param billerName - Biller name of new biller
	 * @param description - Biller description
	 * @param billingAccountBank - Biller's billing account bank name
	 * @param billingAccountNumber - Biller's billing account's bank account number
	 * @param refundAccountBank - Biller's refund account's bank name
	 * @param refundAccountNumber - Biller's refund account's bank account number
	 */
	public void callUpdateBiller(String billerId, String billerName, String description, String billingAccountBank, String billingAccountNumber,  String refundAccountBank, String refundAccountNumber)
	{
		final String methodName = "callUpdateBiller";
		Object[] params =  { billerId, billerName, description, billingAccountBank, billingAccountNumber,  refundAccountBank, refundAccountNumber };
		logger.entering(CLASS_NAME, methodName, params);
		try
		{
			UpdateBillerRequestType ubReq = new UpdateBillerRequestType();
			ubReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER"));
			ubReq.setPartner(new PartnerType());
			ubReq.getPartner().setPartnerKey(billerId);
			ubReq.getPartner().setName(billerName);
			ubReq.getPartner().setDescription(description);
			ubReq.getPartner().setBillerFinanicialInfo(new BillerFinanicialInfoType());
			ubReq.getPartner().getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankKey(billingAccountBank);
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(billingAccountBank);
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(billingAccountNumber);
			ubReq.getPartner().getBillerFinanicialInfo().setRefundAccount(new FinancialAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankKey(refundAccountBank);
			ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankAccount(new BankAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setBankKey(refundAccountBank);
			ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setNumber(refundAccountNumber);
			
			partnerProfileServices.updateBiller(ubReq);
			
			// if it reaches here, it means response is successfull change fields manually in session object
			getBillerObject().getSelectedBiller().setBillerId(billerId);
			getBillerObject().getSelectedBiller().setBillerName(billerName);
			getBillerObject().getSelectedBiller().setDescription(description);
			getBillerObject().getSelectedBiller().setBillingAccountBankId(billingAccountBank);
			getBillerObject().getSelectedBiller().setBillingAccountNumber(billingAccountNumber);
			getBillerObject().getSelectedBiller().setRefundAccountBankId(refundAccountBank);
			getBillerObject().getSelectedBiller().setRefundAccountNumber(refundAccountNumber);
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
		catch (PartnerProfileFaultMsg e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (SOAPFaultException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Calls the backend webservice to activate or deactivate the biller.
	 */
	public void callActivateOrDeActivateBiller()
	{
		final String methodName = "callActivateOrDeActivateBiller";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(getBillerObject().getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBillerRequestType dbReq = new DeactivateBillerRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILLER"));
				dbReq.setPartnerKey(getBillerObject().getPartnerKey());
				partnerProfileServices.deactivateBiller(dbReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBillerObject().getSelectedBiller().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if(getBillerObject().getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBillerRequestType abReq = new ActivateBillerRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILLER"));
				abReq.setPartnerKey(getBillerObject().getPartnerKey());
				partnerProfileServices.activateBiller(abReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBillerObject().getSelectedBiller().setStatus(ConfigurationStatusEnum.ACTIVE.value());
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
		catch (PartnerProfileFaultMsg e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (SOAPFaultException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}		
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Call the backend webservice to retrieve the biller details from database.
	 * @param billerId - Biller ID of biller for the retrival of details 
	 */
	public void callGetBillerByKey(String billerId)
	{
		final String methodName = "callGetBillerByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetBillerByKeyRequestType req = new GetBillerByKeyRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BILLER_BY_KEY"));
			req.setPartnerKey(billerId);
			GetBillerByKeyResponseType res = partnerProfileServices.getBillerByKey(req);
			getBillerObject().setSelectedBiller(new BillerDetail());
			getBillerObject().setPartnerKey(billerId);
			getBillerObject().getSelectedBiller().setBillerId(res.getPartner().getPartnerKey());
			getBillerObject().getSelectedBiller().setBillerName(res.getPartner().getName());
			getBillerObject().getSelectedBiller().setDescription(res.getPartner().getDescription());
			getBillerObject().getSelectedBiller().setStatus(res.getPartner().getStatus());
			getBillerObject().getSelectedBiller().setBillingAccountBankId(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankKey());
			getBillerObject().getSelectedBiller().setBillingAccountType(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().getType());
			getBillerObject().getSelectedBiller().setBillingAccountNumber(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().getNumber());
			getBillerObject().getSelectedBiller().setRefundAccountBankId(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankKey());
			getBillerObject().getSelectedBiller().setRefundAccountType(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().getType());
			getBillerObject().getSelectedBiller().setRefundAccountNumber(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().getNumber());						
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
		catch (PartnerProfileFaultMsg e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (SOAPFaultException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}