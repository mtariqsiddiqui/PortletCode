/**
 * 
 */
package com.sadad.portal.admin.branchcode;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.soap.SOAPFaultException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BranchCodeDetail;
import com.sadad.portal.beans.BranchCodeSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BranchDetailType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;

/**
 * @author Tariq Siddiqui
 *
 */
public class BranchCodeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BranchCodeHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private BranchCodeSessionBean branchCodeObject = new BranchCodeSessionBean();
	
	/**
	 * @return the branchCodeObject
	 */
	public BranchCodeSessionBean getBranchCodeObject()
	{
		return branchCodeObject;
	}
	/**
	 * @param branchCodeObject the branchCodeObject to set
	 */
	public void setBranchCodeObject(BranchCodeSessionBean branchCodeObject)
	{
		this.branchCodeObject = branchCodeObject;
	}

	/**
	 * Calls the backend webservice to retrieve the list of bank branches
	 * @param bankCode - Bank Code against which list of bank branches will be retrieves
	 */
	public void callListBankBranch(String bankCode)
	{
		final String methodName = "callListBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			getBranchCodeObject().setPartnerKey(bankCode);
			ListBankBranchRequestType req = new ListBankBranchRequestType();
			req.setMessageHeader(getMessageHeaderType("LIST_BANK_BRANCH"));
			req.setPartnerKey(bankCode);
			ListBankBranchResponseType res = partnerProfileServices.listBankBranch(req);
			getBranchCodeObject().setBranchCodeList(new ArrayList<BranchCodeDetail>());
			for(BranchDetailType bdt : res.getBranches().getBranchDetail())
			{
				BranchCodeDetail bcd = new BranchCodeDetail();
				bcd.setBranchCode(bdt.getBranchCode());
				bcd.setStatus(bdt.getStatus());
				getBranchCodeObject().getBranchCodeList().add(bcd);
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
	 * Calls the backend webservice to create a new branchCode object in database
	 * 
	 * @param bankCode - Bank Code for which branch would be created
	 * @param branchCode - Branch Code to be created
	 */
	public void callCreateBankBranch(String bankCode, String branchCode)
	{
		final String methodName = "callCreateBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBankBranchRequestType cbbReq = new CreateBankBranchRequestType();
			cbbReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER"));
			cbbReq.setPartnerKey(bankCode);
			cbbReq.setBranchCode(branchCode);

			partnerProfileServices.createBankBranch(cbbReq);
			
			// if it reaches here, it means response is successfull change fields manually in session object
			getBranchCodeObject().getSelectedBranchCode().setBranchCode(branchCode);
			getBranchCodeObject().getSelectedBranchCode().setStatus(ConfigurationStatusEnum.ACTIVE);
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
	 * Calls the backend webservice to activate or deactivate the bankBranch.
	 */
	public void callActivateOrDeActivateBankBranch()
	{
		final String methodName = "callActivateOrDeActivateBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(getBranchCodeObject().getSelectedBranchCode().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				// Call the backend service - DeActivate
				DeactivateBankBranchRequestType dbReq = new DeactivateBankBranchRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILLER"));
				dbReq.setPartnerKey(getBranchCodeObject().getPartnerKey());
				dbReq.setBranchCode(getBranchCodeObject().getSelectedBranchCode().getBranchCode());
				partnerProfileServices.deactivateBankBranch(dbReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBranchCodeObject().getSelectedBranchCode().setStatus(ConfigurationStatusEnum.INACTIVE);
			}
			else if(getBranchCodeObject().getSelectedBranchCode().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				// Call the backend service - Activate
				ActivateBankBranchRequestType abReq = new ActivateBankBranchRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILLER"));
				abReq.setPartnerKey(getBranchCodeObject().getPartnerKey());
				abReq.setBranchCode(getBranchCodeObject().getSelectedBranchCode().getBranchCode());
				partnerProfileServices.activateBankBranch(abReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBranchCodeObject().getSelectedBranchCode().setStatus(ConfigurationStatusEnum.ACTIVE);
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
	 * Call the backend webservice to retrieve the branchCode details from database.
	 * @param branchCodeId - BranchCode ID of branchCode for the retrival of details 
	 */
	public void callGetBankBranch(String bankCode, String branchCode)
	{
		final String methodName = "callGetBankBranch";
		Object params[] = { bankCode, branchCode };
		logger.entering(CLASS_NAME, methodName, params);
		try
		{
			// Call the backend service
			GetBranchCodeRequestType req = new GetBranchCodeRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BILLER_BY_KEY"));
			req.setPartnerKey(bankCode);
			req.setBranchCode(branchCode);
			GetBranchCodeResponseType res = partnerProfileServices.getBankBranch(req);

			// Clear any previous detail from Session and put new Object
			// Set the service response values in Session Object
			getBranchCodeObject().setSelectedBranchCode(new BranchCodeDetail());
			getBranchCodeObject().setPartnerKey(res.getBranchDetail().getBankKey());
			getBranchCodeObject().getSelectedBranchCode().setBranchCode(res.getBranchDetail().getBranchCode());
			getBranchCodeObject().getSelectedBranchCode().setStatus(res.getBranchDetail().getStatus());
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