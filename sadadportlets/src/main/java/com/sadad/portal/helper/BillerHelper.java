/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.StatusUpdateType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerStatusRqType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnersStatusTypeEnums;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BillerSessionDataBean;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BankAccountType;
import com.sadad.scm.common._1.BillerFinanicialInfoType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.FinancialAccountType;
import com.sadad.scm.common._1.PartnerConfigurationAttributeType;
import com.sadad.scm.common._1.PartnerConfigurationType;
import com.sadad.scm.common._1.PartnerConfigurationsType;
import com.sadad.scm.common._1.PartnerType;
import com.sadad.scm.common._1.PartnerTypeEnums;
import com.sadad.scm.common._1.SettlementAccountType;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 *
 */
public class BillerHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BillerHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);


	/**
	 * Calls the backend webservice to create a new biller or an aggregator object in database
	 * 
	 * @param sesObj
	 * @return
	 */
	public BillerSessionDataBean callCreatePartner(BillerSessionDataBean sesObj)
	{
		final String methodName = "callCreatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreatePartnerRequestType cbReq = new CreatePartnerRequestType();
			cbReq.setMessageHeader(getMessageHeaderType("CREATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cbReq.setPartner(new PartnerType());
			cbReq.getPartner().setType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
			cbReq.getPartner().setPartnerKey(sesObj.getBillerId());
			cbReq.getPartner().setName(sesObj.getBillerName());
			cbReq.getPartner().setArabicName(sesObj.getBillerArabicName());
			cbReq.getPartner().setDescription(sesObj.getDescription());
			cbReq.getPartner().setType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
			cbReq.getPartner().setStatus(sesObj.getStatus());

			cbReq.getPartner().setBillerFinanicialInfo(new BillerFinanicialInfoType());
			cbReq.getPartner().getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankKey(sesObj.getBillingAccountBankId());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(sesObj.getBillingAccountBankId());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(sesObj.getBillingAccountNumber());
			cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setType("SBA");
			// if optional refund account is not provided then set refund acc same as billing acc
			if (sesObj.getRefundAccountBankId() == null || sesObj.getRefundAccountNumber() == null)
			{
				cbReq.getPartner().getBillerFinanicialInfo().setRefundAccount(cbReq.getPartner().getBillerFinanicialInfo().getBillingAccount());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}
			else
			{
				cbReq.getPartner().getBillerFinanicialInfo().setRefundAccount(new FinancialAccountType());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankKey(sesObj.getRefundAccountBankId());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankAccount(new BankAccountType());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setBankKey(sesObj.getRefundAccountBankId());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setNumber(sesObj.getRefundAccountNumber());
				cbReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}

			partnerProfileService.createPartner(cbReq);
			// if reaches to this point means, update was successful
			sesObj.setGenericInfoMessage();
			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getBillerId(), sesObj.getBillerName(), sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(uplc);
			if(sesObj.getBillerType().equalsIgnoreCase(PartnerTypeEnums.BILLER.name()))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BILLER_LIST);
			else if(sesObj.getBillerType().equalsIgnoreCase(PartnerTypeEnums.AGGREGATOR.name()))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_AGGREGATOR_LIST);

			// Fixing defect 3335
			sesObj.setBillerId(null);
			sesObj.setBillerName(null);
			sesObj.setDescription(null);
			sesObj.setStatus(null);
			sesObj.setBillingAccountBankId(null);
			sesObj.setBillingAccountBankId(null);
			sesObj.setBillingAccountNumber(null);
			sesObj.setRefundAccountBankId(null);
			sesObj.setRefundAccountNumber(null);
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Calls the backend webservice to update existing biller or aggregator data in database.
	 * 
	 * @param sesObj
	 * @return
	 */
	public BillerSessionDataBean callUpdatePartner(BillerSessionDataBean sesObj)
	{
		final String methodName = "callUpdatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdatePartnerRequestType ubReq = new UpdatePartnerRequestType();
			ubReq.setMessageHeader(getMessageHeaderType("UPDATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			ubReq.setPartner(new PartnerType());
			ubReq.getPartner().setPartnerKey(sesObj.getBillerId());
			ubReq.getPartner().setName(sesObj.getBillerName());
			ubReq.getPartner().setArabicName(sesObj.getBillerArabicName());
			ubReq.getPartner().setType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
			ubReq.getPartner().setDescription(sesObj.getDescription());
			ubReq.getPartner().setBillerFinanicialInfo(new BillerFinanicialInfoType());

			ubReq.getPartner().getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankKey(sesObj.getBillingAccountBankId());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(sesObj.getBillingAccountBankId());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(sesObj.getBillingAccountNumber());
			ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().setType("SBA");
			// if optional refund account is not provided then set refund acc same as billing acc
			if (sesObj.getRefundAccountBankId() == null || sesObj.getRefundAccountNumber() == null)
			{
				ubReq.getPartner().getBillerFinanicialInfo().setRefundAccount(ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}
			else
			{
				ubReq.getPartner().getBillerFinanicialInfo().setRefundAccount(new FinancialAccountType());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankKey(sesObj.getRefundAccountBankId());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().setBankAccount(new BankAccountType());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setBankKey(sesObj.getRefundAccountBankId());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setNumber(sesObj.getRefundAccountNumber());
				ubReq.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}
			// if optional settlement ID is empty
			if (sesObj.isGenerateSettlementId() || sesObj.getSelectedBiller().isGenerateSettlementId())
			{
				ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().setSettlementAccount(new SettlementAccountType());
				ubReq.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount().setSettlementIDType("DEFAULT");
			}

			ubReq.getPartner().setStatus(sesObj.getStatus());
			UpdatePartnerResponseType res = partnerProfileService.updatePartner(ubReq);
			// Fix defect 3974
			if(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount() != null && res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount().getSettlementID() != null)
				sesObj.getSelectedBiller().setDefaultSettlementSettlementId(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount().getSettlementID());
			// if reaches to this point means, update was successful
			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getBillerId(), sesObj.getBillerName(), sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(uplc);
			if(sesObj.getBillerType().equalsIgnoreCase(PartnerTypeEnums.BILLER.name()))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BILLER_LIST);
			else if(sesObj.getBillerType().equalsIgnoreCase(PartnerTypeEnums.AGGREGATOR.name()))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_AGGREGATOR_LIST);
			
			// Updating the selected biller updates to reflect the changes on biller details page
			sesObj.getSelectedBiller().setBillerName(sesObj.getBillerName());
			sesObj.getSelectedBiller().setBillerArabicName(sesObj.getBillerArabicName());
			sesObj.getSelectedBiller().setDescription(sesObj.getDescription());
			sesObj.getSelectedBiller().setBillingAccountBankId(sesObj.getBillingAccountBankId());
			sesObj.getSelectedBiller().setBillingAccountNumber(sesObj.getBillingAccountNumber());
			// if optional refund account is not provided then set refund acc same as billing acc
			if (sesObj.getRefundAccountBankId() == null || sesObj.getRefundAccountNumber() == null)
			{
				sesObj.getSelectedBiller().setRefundAccountBankId(sesObj.getBillingAccountBankId());
				sesObj.getSelectedBiller().setRefundAccountNumber(sesObj.getBillingAccountNumber());
			}
			else
			{
				sesObj.getSelectedBiller().setRefundAccountBankId(sesObj.getRefundAccountBankId());
				sesObj.getSelectedBiller().setRefundAccountNumber(sesObj.getRefundAccountNumber());
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Calls the backend webservice to activate or deactivate the biller.
	 * This method is deprecated, use callUpdatePartnerStatus instead.
	 * 
	 * @param sesObj
	 * @return sesObj
	 */
	@Deprecated
	public BillerSessionDataBean callActivateOrDeActivateBiller(BillerSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateBiller";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if (sesObj.getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBillerRequestType dbReq = new DeactivateBillerRequestType();
				dbReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dbReq.setPartnerKey(sesObj.getSelectedBiller().getBillerId());
				partnerProfileService.deactivateBiller(dbReq);
				// if it reaches here, it means response is successful change status manually in session object
				sesObj.getSelectedBiller().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if (sesObj.getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBillerRequestType abReq = new ActivateBillerRequestType();
				abReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILLER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				abReq.setPartnerKey(sesObj.getSelectedBiller().getBillerId());
				partnerProfileService.activateBiller(abReq);
				// if it reaches here, it means response is successful change status manually in session object
				sesObj.getSelectedBiller().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}

			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getSelectedBiller().getBillerId(), sesObj.getSelectedBiller().getBillerName(), sesObj.getSelectedBiller().getDescription(), sesObj.getSelectedBiller().getStatus());
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BILLER_LIST);
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Calls the backend webservice to change the status of partner (Biller or Aggregator) in dtabase.
	 * 
	 * @param sesObj
	 * @return
	 */
	public BillerSessionDataBean callUpdatePartnerStatus(BillerSessionDataBean sesObj)
	{
		final String methodName = "callUpdatePartnerStatus";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if (sesObj.getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				UpdatePartnerStatusRqType dcReq = new UpdatePartnerStatusRqType();
				dcReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_PARTNER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				StatusUpdateType partner = new StatusUpdateType();
				partner.setPartnerKey(sesObj.getSelectedBiller().getBillerId());
				partner.setPartnerType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
				partner.setStatusCode(UpdatePartnersStatusTypeEnums.DEACTIVATE);
				dcReq.setPartner(partner);
				partnerProfileService.updatePartnerStatus(dcReq);
				// if it reaches here, it means response is successful change status manually in session object
				sesObj.getSelectedBiller().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if (sesObj.getSelectedBiller().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				UpdatePartnerStatusRqType acReq = new UpdatePartnerStatusRqType();
				acReq.setMessageHeader(getMessageHeaderType("ACTIVATE_PARTNER", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				StatusUpdateType partner = new StatusUpdateType();
				partner.setPartnerKey(sesObj.getSelectedBiller().getBillerId());
				partner.setPartnerType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
				partner.setStatusCode(UpdatePartnersStatusTypeEnums.ACTIVATE);
				acReq.setPartner(partner);
				partnerProfileService.updatePartnerStatus(acReq);
				// if it reaches here, it means response is successful change status manually in session object
				sesObj.getSelectedBiller().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}

			// Updating the Application Level Cache
			PartnerListCacheSummary uplc = new PartnerListCacheSummary(sesObj.getSelectedBiller().getBillerId(), sesObj.getSelectedBiller().getBillerName(), sesObj.getSelectedBiller().getDescription(), sesObj.getSelectedBiller().getStatus());
			sesObj.setCacheObj(uplc);
			if(sesObj.getBillerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_BILLER_LIST);
			else if(sesObj.getBillerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_AGGREGATOR))
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_AGGREGATOR_LIST);
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Call the backend webservice to retrieve the biller details from database.
	 * 
	 * @param billerId
	 *            - Biller ID of biller for the retrival of details
	 */
	public BillerSessionDataBean callGetPartnerDetails(BillerSessionDataBean sesObj) // callGetBillerByKey
	{
		final String methodName = "callGetPartnerDetails";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerDetailsRequestType req = new GetPartnerDetailsRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_BILLER_BY_KEY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setPartnerKey(sesObj.getBillerId());
			GetPartnerDetailsResponseType res = partnerProfileService.getPartnerDetails(req);
			sesObj.setSelectedBiller(new BillerSessionDataBean());
			sesObj.getSelectedBiller().setBillerId(res.getPartner().getPartnerKey());
			sesObj.getSelectedBiller().setBillerName(res.getPartner().getName());
			sesObj.getSelectedBiller().setBillerArabicName(res.getPartner().getArabicName());
			sesObj.getSelectedBiller().setBillerType(res.getPartner().getType().name());
			sesObj.getSelectedBiller().setDescription(res.getPartner().getDescription());
			sesObj.getSelectedBiller().setStatus(res.getPartner().getStatus());
			sesObj.getSelectedBiller().setBillingAccountBankId(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankKey());
			sesObj.getSelectedBiller().setBillingAccountType(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().getType());
			sesObj.getSelectedBiller().setBillingAccountNumber(res.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().getNumber());
			if (res.getPartner().getBillerFinanicialInfo().getRefundAccount() != null)
			{
				sesObj.getSelectedBiller().setRefundAccountBankId(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankKey());
				sesObj.getSelectedBiller().setRefundAccountType(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().getType());
				sesObj.getSelectedBiller().setRefundAccountNumber(res.getPartner().getBillerFinanicialInfo().getRefundAccount().getBankAccount().getNumber());
			}

			// Settlement MultiAccount and IBAN Management updates
			boolean isSubscribedToMultiAccount = isSubscribedToMultiAccount(sesObj.getBillerId());
			if (isSubscribedToMultiAccount) // SETTLEMENT_MULTI_ACCOUNT = True && IS_MULTI_ACCOUNT = True
			{
				String settlementId = null;
				if (res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount() != null
						&& res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount().getSettlementIDType() != null)
				{
					settlementId = res.getPartner().getBillerFinanicialInfo().getBillingAccount().getSettlementAccount().getSettlementID();
					sesObj.getSelectedBiller().setGenerateSettlementId(isSubscribedToMultiAccount && settlementId == null);
				}
				else
				{
					sesObj.getSelectedBiller().setGenerateSettlementId(isSubscribedToMultiAccount && settlementId == null);	
					settlementId = (settlementId == null ? "#Click Update to GENERATE Settlement ID#" : settlementId);
				}
				sesObj.getSelectedBiller().setDefaultSettlementSettlementId(settlementId);										
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	 * Calls the backend webservice to retrieve the list of all billers.
	 * 
	 * @param sesObj
	 * @return
	 */
	public BillerSessionDataBean callGetPartnerList(BillerSessionDataBean sesObj)
	{
		final String methodName = "callGetBillerList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerListRequestType billerListRq = new GetPartnerListRequestType();
			billerListRq.setMessageHeader(getMessageHeaderType("GET_BILLER_LIST"));
			billerListRq.setPartnerType(PartnerTypeEnums.valueOf(sesObj.getBillerType()));
			if (sesObj.getStatus() != null)
				if (sesObj.getStatus().equalsIgnoreCase("active"))
					billerListRq.setActiveOnly(true);
				else
					billerListRq.setActiveOnly(false);

			GetPartnerListResponseType billerListResponseType = partnerProfileService.getPartnerList(billerListRq);
			sesObj.getBillerMap().clear();
			for (PartnerType pt : billerListResponseType.getPartner())
			{
				BillerSessionDataBean blc = new BillerSessionDataBean();
				blc.setBillerId(pt.getPartnerKey());
				blc.setBillerName(pt.getName());
				blc.setDescription(pt.getDescription());
				blc.setStatus(pt.getStatus());
				sesObj.getBillerMap().put(pt.getPartnerKey(), blc);
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
	public BillerSessionDataBean clearSessionBeanObject(BillerSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}

	/**
	 * Calls the backend webservice to check whether is subscribed to MULTI_ACCOUNT configuration
	 * 
	 * @param billerId
	 * @return True if subscribe or False if not
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	private boolean isSubscribedToMultiAccount(String billerId)
	{
		boolean[] result = { false, false };

		final String methodName = "isSubscribedToMultiAccount";
		logger.entering(CLASS_NAME, methodName, billerId);

		try
		{
			GetPartnerConfigurationRequestType req = new GetPartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_PARTNER_CONFIGURATION"));
			req.setPartnerKey(billerId);
			req.setConfigurationName("SETTLEMENT_MULTI_ACCOUNT");
			req.setActiveOnly(true);

			GetPartnerConfigurationResponseType res = partnerProfileService.getPartnerConfiguration(req);
			PartnerConfigurationsType pct = res.getPartnerConfigurations().get(0);
			PartnerConfigurationType pct1 = pct.getPartnerConfiguration().get(0);
			result[0] = true;
			// IS_MULTI_ACCOUNT
			if (pct1.getAttributes() != null && pct1.getAttributes().getAttribute().size() > 0)
			{
				for (PartnerConfigurationAttributeType pcat : pct1.getAttributes().getAttribute())
				{
					if (pcat.getAttributeName().equals("IS_MULTI_ACCOUNT"))
						result[1] = Boolean.valueOf(pcat.getValue().get(0));
				}
			}
		}
		catch (Exception e)
		{
			logger.logp(Level.WARNING, CLASS_NAME, methodName, e.getMessage());
		}
		
		logger.exiting(CLASS_NAME, methodName, (result[0] && result[1]));
		return (result[0] && result[1]);
	}
}