/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBranchCodeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBankBranchResponseType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BranchCodeSessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BranchDetailType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 *
 */
public class BranchCodeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BranchCodeHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to retrieve the list of bank branches
	 * @param bankCode - Bank Code against which list of bank branches will be retrieves
	 */
	public BranchCodeSessionDataBean callListBankBranch(BranchCodeSessionDataBean sesObj)
	{
		final String methodName = "callListBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListBankBranchRequestType req = new ListBankBranchRequestType();
			req.setMessageHeader(getMessageHeaderType("LIST_BANK_BRANCH", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setPartnerKey(sesObj.getBankId());
			ListBankBranchResponseType res = partnerProfileService.listBankBranch(req);
			sesObj.setBranchCodeList(new ArrayList<BranchCodeSessionDataBean>());
			for (BranchDetailType bdt : res.getBranches().getBranchDetail())
			{
				BranchCodeSessionDataBean bcd = new BranchCodeSessionDataBean();
				bcd.setBranchCode(bdt.getBranchCode());
				bcd.setStatus(bdt.getStatus().value());
				sesObj.getBranchCodeList().add(bcd);
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to create a new branchCode object in database
	 * 
	 * @param bankCode - Bank Code for which branch would be created
	 * @param branchCode - Branch Code to be created
	 */
	public BranchCodeSessionDataBean callCreateBankBranch(BranchCodeSessionDataBean sesObj)
	{
		final String methodName = "callCreateBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBankBranchRequestType cbbReq = new CreateBankBranchRequestType();
			cbbReq.setMessageHeader(getMessageHeaderType("CREATE_BANK_BRANCH", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cbbReq.setPartnerKey(sesObj.getBankId());
			cbbReq.setBranchCode(sesObj.getBranchCode());

			partnerProfileService.createBankBranch(cbbReq);
			sesObj.setGenericInfoMessage();
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * Calls the backend webservice to activate or deactivate the bankBranch.
	 */
	public BranchCodeSessionDataBean callActivateOrDeActivateBankBranch(BranchCodeSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(sesObj.getSelectedBranchCode().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBankBranchRequestType dbReq = new DeactivateBankBranchRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BANK_BRANCH", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dbReq.setPartnerKey(sesObj.getBankId());
				dbReq.setBranchCode(sesObj.getSelectedBranchCode().getBranchCode());
				partnerProfileService.deactivateBankBranch(dbReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedBranchCode().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if(sesObj.getSelectedBranchCode().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBankBranchRequestType abReq = new ActivateBankBranchRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BANK_BRANCH", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				abReq.setPartnerKey(sesObj.getBankId());
				abReq.setBranchCode(sesObj.getSelectedBranchCode().getBranchCode());
				partnerProfileService.activateBankBranch(abReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedBranchCode().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Call the backend webservice to retrieve the branchCode details from database.
	 * @param branchCodeId - BranchCode ID of branchCode for the retrival of details 
	 */
	public BranchCodeSessionDataBean callGetBankBranch(BranchCodeSessionDataBean sesObj)
	{
		final String methodName = "callGetBankBranch";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetBranchCodeRequestType req = new GetBranchCodeRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BANK_BRANCH_BY_KEY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setPartnerKey(sesObj.getBankId());
			req.setBranchCode(sesObj.getBranchCode());
			GetBranchCodeResponseType res = partnerProfileService.getBankBranch(req);

			// Clear any previous detail from Session and put new Object
			// Set the service response values in Session Object
			sesObj.setSelectedBranchCode(new BranchCodeSessionDataBean());
			sesObj.setBankId(res.getBranchDetail().getBankKey());
			sesObj.getSelectedBranchCode().setBranchCode(res.getBranchDetail().getBranchCode());
			sesObj.getSelectedBranchCode().setStatus(res.getBranchDetail().getStatus().value());
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public BranchCodeSessionDataBean clearSessionBeanObject(BranchCodeSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}