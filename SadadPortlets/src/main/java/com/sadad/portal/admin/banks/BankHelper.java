/**
 * 
 */
package com.sadad.portal.admin.banks;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankByKeyRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBankByKeyResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBankRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BankDetail;
import com.sadad.portal.beans.BankSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BankFinanicialInfoType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.PartnerType;

/**
 * @author Tariq Siddiqui
 *
 */
public class BankHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BankHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private BankSessionBean bankObject = new BankSessionBean();
	
	/**
	 * @return the bankObject
	 */
	public BankSessionBean getBankObject()
	{
		return bankObject;
	}
	/**
	 * @param bankObject the bankObject to set
	 */
	public void setBankObject(BankSessionBean bankObject)
	{
		this.bankObject = bankObject;
	}
	
	/**
	 * Calls the backend webservice to create a new bank object in database
	 * 
	 * @param bankId
	 * @param bankName
	 * @param description
	 * @param suspenceAccount
	 * @param refundAccount
	 * @param sarieKey
	 */
	public void callCreateBank(String bankId, String bankName, String description, String suspenceAccount, String refundAccount, String sarieKey)
	{

		final String methodName = "callCreateBank";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBankRequestType cbReq = new CreateBankRequestType();
			cbReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER"));
			cbReq.setPartner(new PartnerType());
			cbReq.getPartner().setPartnerKey(bankId);
			cbReq.getPartner().setName(bankName);
			cbReq.getPartner().setDescription(description);
			cbReq.getPartner().setBankFinanicialInfo(new BankFinanicialInfoType());
			cbReq.getPartner().getBankFinanicialInfo().setSADADSuspenseAccount(suspenceAccount);
			cbReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(refundAccount);
			cbReq.getPartner().getBankFinanicialInfo().setSarieKey(sarieKey);
			
			partnerProfileServices.createBank(cbReq);
			
			// if it reaches here, it means response is successfull change fields manually in session object
			getBankObject().getSelectedBank().setBankId(bankId);
			getBankObject().getSelectedBank().setBankName(bankName);
			getBankObject().getSelectedBank().setDescription(description);
			getBankObject().getSelectedBank().setSuspenceAccount(suspenceAccount);
			getBankObject().getSelectedBank().setRefundAccount(refundAccount);
		}
		catch (PartnerProfileFaultMsg e)
		{
			getBankObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			logger.logp(Level.INFO, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Calls the backend webservice to update existing bank data in database.
	 * 
	 * @param bankId
	 * @param bankName
	 * @param description
	 * @param suspenceAccount
	 * @param refundAccount
	 * @param sarieKey
	 */
	public void callUpdateBank(String bankId, String bankName, String description, String suspenceAccount, String refundAccount, String sarieKey)
	{

		final String methodName = "callUpdateBank";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdateBankRequestType ubReq = new UpdateBankRequestType();
			ubReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER"));
			ubReq.setPartner(new PartnerType());
			ubReq.getPartner().setPartnerKey(bankId);
			ubReq.getPartner().setName(bankName);
			ubReq.getPartner().setDescription(description);
			ubReq.getPartner().setBankFinanicialInfo(new BankFinanicialInfoType());
			ubReq.getPartner().getBankFinanicialInfo().setSADADSuspenseAccount(suspenceAccount);
			ubReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(refundAccount);
			ubReq.getPartner().getBankFinanicialInfo().setSarieKey(sarieKey);
			
			partnerProfileServices.updateBank(ubReq);
			
			// if it reaches here, it means response is successfull change fields manually in session object
			getBankObject().getSelectedBank().setBankId(bankId);
			getBankObject().getSelectedBank().setBankName(bankName);
			getBankObject().getSelectedBank().setDescription(description);
			getBankObject().getSelectedBank().setSuspenceAccount(suspenceAccount);
			getBankObject().getSelectedBank().setRefundAccount(refundAccount);
		}
		catch (PartnerProfileFaultMsg e)
		{
			getBankObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			logger.logp(Level.INFO, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Calls the backend webservice to activate or deactivate the bank.
	 */
	public void callActivateOrDeActivateBank()
	{
		final String methodName = "callActivateOrDeActivateBank";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(getBankObject().getSelectedBank().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBankRequestType dbReq = new DeactivateBankRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILLER"));
				dbReq.setPartnerKey(getBankObject().getPartnerKey());
				partnerProfileServices.deactivateBank(dbReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBankObject().getSelectedBank().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if(getBankObject().getSelectedBank().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBankRequestType abReq = new ActivateBankRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILLER"));
				abReq.setPartnerKey(getBankObject().getPartnerKey());
				partnerProfileServices.activateBank(abReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBankObject().getSelectedBank().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			getBankObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			logger.logp(Level.INFO, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Call the backend webservice to retrieve the bank details from database.
	 * @param bankId - Bank ID of the bank for the retrival of details
	 */
	public void callGetBankByKey(String bankId)
	{
		final String methodName = "callGetBankByKey";
		logger.entering(CLASS_NAME, methodName, bankId);
		try
		{
			GetBankByKeyRequestType req = new GetBankByKeyRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BILLER_BY_KEY"));
			req.setPartnerKey(bankId);
			GetBankByKeyResponseType res = partnerProfileServices.getBankByKey(req);
			getBankObject().setSelectedBank(new BankDetail());
			getBankObject().setPartnerKey(bankId);
			getBankObject().getSelectedBank().setBankId(res.getPartner().getPartnerKey());
			getBankObject().getSelectedBank().setBankName(res.getPartner().getName());
			getBankObject().getSelectedBank().setDescription(res.getPartner().getDescription());
			getBankObject().getSelectedBank().setStatus(res.getPartner().getStatus());
			getBankObject().getSelectedBank().setSuspenceAccount(res.getPartner().getBankFinanicialInfo().getSADADSuspenseAccount());
			getBankObject().getSelectedBank().setRefundAccount(res.getPartner().getBankFinanicialInfo().getSADADRefundAccount());
			getBankObject().getSelectedBank().setSarieKey(res.getPartner().getBankFinanicialInfo().getSarieKey());								
		}
		catch (PartnerProfileFaultMsg e)
		{
			getBankObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			logger.logp(Level.INFO, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getBankObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}