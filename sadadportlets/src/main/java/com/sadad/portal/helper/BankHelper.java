/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBankRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BankSessionDataBean;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BankFinanicialInfoType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.PartnerType;
import com.sadad.scm.common._1.PartnerTypeEnums;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 *
 */
public class BankHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BankHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to create a new bank object in database
	 * 
	 * @param sesObj
	 * @return
	 */
	public BankSessionDataBean callCreatePartner(BankSessionDataBean sesObj)
	{
		final String methodName = "callCreatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreatePartnerRequestType cbReq = new CreatePartnerRequestType();
			cbReq.setMessageHeader(getMessageHeaderType("CREATE_BANK", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cbReq.setPartner(new PartnerType());
			cbReq.getPartner().setPartnerKey(sesObj.getBankId());
			cbReq.getPartner().setName(sesObj.getBankName());
			cbReq.getPartner().setDescription(sesObj.getDescription());
			cbReq.getPartner().setType(PartnerTypeEnums.BANK);
			cbReq.getPartner().setStatus(sesObj.getStatus());
			cbReq.getPartner().setBankFinanicialInfo(new BankFinanicialInfoType());
			cbReq.getPartner().getBankFinanicialInfo().setSADADSuspenseAccount(sesObj.getSuspenceAccount());
			// Fix defect 2731 - send SADADSuspenseAccount as SADADRefundAccount in case SADADRefundAccount is null 
			if(sesObj.getRefundAccount() != null)
				cbReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(sesObj.getRefundAccount());
			else
				cbReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(sesObj.getSuspenceAccount());
			
			cbReq.getPartner().getBankFinanicialInfo().setSarieKey(sesObj.getSarieKey());

			partnerProfileService.createPartner(cbReq);
			// if reaches to this point means, update was successful
			sesObj.setGenericInfoMessage();
			
			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getBankId(), sesObj.getBankName(), sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BANK_LIST);
			
			//Fixing defect 3335
			sesObj.setBankId(null);
			sesObj.setBankName(null); 
			sesObj.setDescription(null);
			sesObj.setStatus(null);
			sesObj.setSuspenceAccount(null);
			sesObj.setRefundAccount(null);
			sesObj.setSarieKey(null);
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
	 * Calls the backend webservice to update existing bank data in database.
	 * 
	 * @param bankId
	 * @param bankName
	 * @param description
	 * @param suspenceAccount
	 * @param refundAccount
	 * @param sarieKey
	 */
	public BankSessionDataBean callUpdatePartner(BankSessionDataBean sesObj)
	{

		final String methodName = "callUpdatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdatePartnerRequestType ubReq = new UpdatePartnerRequestType();
			ubReq.setMessageHeader(getMessageHeaderType("UPDATE_BANK", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			ubReq.setPartner(new PartnerType());
			ubReq.getPartner().setPartnerKey(sesObj.getBankId());
			ubReq.getPartner().setName(sesObj.getBankName());
			ubReq.getPartner().setDescription(sesObj.getDescription());
			ubReq.getPartner().setBankFinanicialInfo(new BankFinanicialInfoType());
			ubReq.getPartner().getBankFinanicialInfo().setSADADSuspenseAccount(sesObj.getSuspenceAccount());
			// Fix defect 2731 - send SADADSuspenseAccount as SADADRefundAccount in case SADADRefundAccount is null
			if(sesObj.getRefundAccount() != null)
				ubReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(sesObj.getRefundAccount());
			else
				ubReq.getPartner().getBankFinanicialInfo().setSADADRefundAccount(sesObj.getSuspenceAccount());
			
			ubReq.getPartner().getBankFinanicialInfo().setSarieKey(sesObj.getSarieKey());

			partnerProfileService.updatePartner(ubReq);
			// if reaches to this point means, update was successfull
			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getBankId(), sesObj.getBankName(), sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BANK_LIST);
			// Updating the selected bank updates to reflect the changes on bank details page
			sesObj.getSelectedBank().setBankId(sesObj.getBankId());
			sesObj.getSelectedBank().setBankName(sesObj.getBankName());
			sesObj.getSelectedBank().setDescription(sesObj.getDescription());
			sesObj.getSelectedBank().setSuspenceAccount(sesObj.getSuspenceAccount());
			if(sesObj.getRefundAccount() != null)
				sesObj.getSelectedBank().setRefundAccount(sesObj.getRefundAccount());
			else
				sesObj.getSelectedBank().setRefundAccount(sesObj.getSuspenceAccount());

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
	 * Calls the backend webservice to activate or deactivate the bank.
	 */
	public BankSessionDataBean callActivateOrDeActivateBank(BankSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateBank";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(sesObj.getSelectedBank().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBankRequestType dbReq = new DeactivateBankRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dbReq.setPartnerKey(sesObj.getSelectedBank().getBankId());
				partnerProfileService.deactivateBank(dbReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedBank().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if(sesObj.getSelectedBank().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBankRequestType abReq = new ActivateBankRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				abReq.setPartnerKey(sesObj.getSelectedBank().getBankId());
				partnerProfileService.activateBank(abReq);
				// if it reaches here, it means response is successful change status manually in session object
				sesObj.getSelectedBank().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}

			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getSelectedBank().getBankId(), 
					sesObj.getSelectedBank().getBankName(), 
					sesObj.getSelectedBank().getDescription(), 
					sesObj.getSelectedBank().getStatus());
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BANK_LIST);			
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
	 * Call the backend webservice to retrieve the bank details from database.
	 * @param bankId - Bank ID of the bank for the retrival of details
	 */
	public BankSessionDataBean callGetPartnerDetails(BankSessionDataBean sesObj) // callGetBankByKey
	{
		final String methodName = "callGetBankByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerDetailsRequestType req = new GetPartnerDetailsRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BILLER_BY_KEY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setPartnerKey(sesObj.getBankId());
			GetPartnerDetailsResponseType res = partnerProfileService.getPartnerDetails(req);
			sesObj.setSelectedBank(new BankSessionDataBean());
			sesObj.getSelectedBank().setBankId(res.getPartner().getPartnerKey());
			sesObj.getSelectedBank().setBankName(res.getPartner().getName());
			sesObj.getSelectedBank().setDescription(res.getPartner().getDescription());
			sesObj.getSelectedBank().setStatus(res.getPartner().getStatus());
			sesObj.getSelectedBank().setSuspenceAccount(res.getPartner().getBankFinanicialInfo().getSADADSuspenseAccount());
			sesObj.getSelectedBank().setRefundAccount(res.getPartner().getBankFinanicialInfo().getSADADRefundAccount());
			sesObj.getSelectedBank().setSarieKey(res.getPartner().getBankFinanicialInfo().getSarieKey());								
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
	 * Call the backend webservice to retreive the list of billers
	 * @param sesObj
	 * @return
	 */
	public BankSessionDataBean callGetPartnerList(BankSessionDataBean sesObj) // callGetBankList
	{
		final String methodName = "callGetPartnerList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerListRequestType bankListRq = new GetPartnerListRequestType();
			bankListRq.setMessageHeader(getMessageHeaderType("GET_BANK_LIST"));
			bankListRq.setPartnerType(PartnerTypeEnums.BANK);
			if(sesObj.getStatus() != null)
				if(sesObj.getStatus().equalsIgnoreCase("active"))
					bankListRq.setActiveOnly(true);
				else
					bankListRq.setActiveOnly(false);

			GetPartnerListResponseType bankListResponseType = partnerProfileService.getPartnerList(bankListRq);
			sesObj.getBankMap().clear();
			for (PartnerType pt : bankListResponseType.getPartner())
			{
				BankSessionDataBean blc = new BankSessionDataBean();
				blc.setBankId(pt.getPartnerKey());
				blc.setBankName(pt.getName());
				blc.setDescription(pt.getDescription());
				blc.setStatus(pt.getStatus());
				sesObj.getBankMap().put(pt.getPartnerKey(), blc);
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
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public BankSessionDataBean clearSessionBeanObject(BankSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}