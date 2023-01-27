package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.CreatePartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.StatusUpdateRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.TransferPartnerRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnerStatusRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRqType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersDetailsRsType;
import com.sadad.ebpp.scm.schema.partnermanagementservice._1.UpdatePartnersStatusTypeEnums;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerListResponseType;
import com.sadad.ebpp.wsdl.partnermanagementservice._1.PartnerManagementFault;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.SubBillerSessionDataBean;
import com.sadad.portal.common.cache.PartnerListCacheSummary;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BankAccountType;
import com.sadad.scm.common._1.BillerFinanicialInfoType;
import com.sadad.scm.common._1.FinancialAccountType;
import com.sadad.scm.common._1.GovIdTypeEnum;
import com.sadad.scm.common._1.PartnerBusinessInfoType;
import com.sadad.scm.common._1.PartnerManagementType;
import com.sadad.scm.common._1.PartnerType;
import com.sadad.scm.common._1.PartnerTypeEnums;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;

public class SubBillerHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = SubBillerHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	public SubBillerSessionDataBean setAggregatorId(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "setAggregatorId";
		logger.entering(CLASS_NAME, methodName);
		
		if(sesObj.getPartnerType().equals(PortalConstant.PARTNER_TYPE_AGGREGATOR))
		{
			sesObj.setAggregatorId(sesObj.getPartnerKey());
		}
		// Set the Aggregator Stauts directly from Partner List Cache Summary, for not to update any biller under INACTIVE AGGREGATOR
//		sesObj.setAggregatorStatus(PartnerListCacheSummary.getAggregatorList().get(sesObj.getAggregatorId()).getPartnerStatus());

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Toggle the status of a sub-biller entity, method calls the corresponding backend web-service method
	 * 
	 * @param sesObj - SessionBean Object holding the required values set from the HTML form submission
	 * @return the same SessionBean Object after performing an update
	 */
	public SubBillerSessionDataBean callActivateOrDeActivateBiller(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateBiller";
		logger.entering(CLASS_NAME, methodName);
		
		try
		{
			UpdatePartnerStatusRqType toggleReq = new UpdatePartnerStatusRqType();
			toggleReq.setMessageHeader(getMessageHeaderType(sesObj.getPartnerKey(), "PMSURQ", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			StatusUpdateRqType toggleStatus = new StatusUpdateRqType();
			toggleStatus.setPartnerKey(sesObj.getBillerId());
			if(sesObj.getSelectedSubBiller().getStatus().equalsIgnoreCase("INACTIVE"))
				toggleStatus.setStatusCode(UpdatePartnersStatusTypeEnums.ACTIVATE);
			else if(sesObj.getSelectedSubBiller().getStatus().equalsIgnoreCase("ACTIVE"))
				toggleStatus.setStatusCode(UpdatePartnersStatusTypeEnums.DEACTIVATE);
			// Fix defect # 
			else if(sesObj.getSelectedSubBiller().getStatus().equalsIgnoreCase("CLOSED"))
				toggleStatus.setStatusCode(UpdatePartnersStatusTypeEnums.CLOSE);
			toggleStatus.setJustification(sesObj.getJustification());
			toggleReq.getPartner().add(toggleStatus);
			UpdatePartnerStatusRsType toggleRes = partnerManagementService.updatePartnerStatus(toggleReq);
			if (toggleRes.getPartner().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(toggleRes.getPartner().get(0).getStatus().getStatusCode());
				faultInfo.setDescription(toggleRes.getPartner().get(0).getStatus().getStatusDesc());

				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			else
			{
//				sesObj.setGenericInfoMessage();
				if (sesObj.getSelectedSubBiller().getStatus().equalsIgnoreCase("INACTIVE"))
					sesObj.getSelectedSubBiller().setStatus("ACTIVE");
				else 
					sesObj.getSelectedSubBiller().setStatus("INACTIVE");
				sesObj.setStatus(sesObj.getSelectedSubBiller().getStatus());
			}
		}
		catch (PartnerManagementFault e)
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
	 * Close the sub-biller entity, method calls the corresponding backend web-service method
	 * 
	 * @param sesObj - SessionBean Object holding the required values set from the HTML form submission
	 * @return the same SessionBean Object after performing an update
	 */
	public SubBillerSessionDataBean callCloseSubBiller(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callCloseSubBiller";
		logger.entering(CLASS_NAME, methodName);
		
		try
		{
			UpdatePartnerStatusRqType closureReq = new UpdatePartnerStatusRqType();
			closureReq.setMessageHeader(getMessageHeaderType(sesObj.getPartnerKey(), "PMSURQ", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			StatusUpdateRqType closureStatus = new StatusUpdateRqType();
			closureStatus.setPartnerKey(sesObj.getBillerId());
			closureStatus.setStatusCode(UpdatePartnersStatusTypeEnums.CLOSE);
			closureStatus.setJustification(sesObj.getJustification());
			closureReq.getPartner().add(closureStatus);
			UpdatePartnerStatusRsType closureRes = partnerManagementService.updatePartnerStatus(closureReq);
			sesObj.setStatus(closureRes.getPartner().get(0).getStatus().getStatusDesc());
			if (closureRes.getPartner().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(closureRes.getPartner().get(0).getStatus().getStatusCode());
				faultInfo.setDescription(closureRes.getPartner().get(0).getStatus().getStatusDesc());

				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
		}
		catch (PartnerManagementFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
//				else
//					sesObj.setGenericErrorMessage();

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
	 * Calls the backend webservice to retrieve the list of all billers by type.
	 * 
	 * @param sesObj
	 * @return
	 */
	public SubBillerSessionDataBean callGetPartnerList(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callGetPartnerList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerListRequestType plRq = new GetPartnerListRequestType();
			plRq.setMessageHeader(getMessageHeaderType("GET_SUBBILLER_LIST"));
			plRq.setPartnerType(PartnerTypeEnums.SUBBILLER);
			plRq.setOwnerKey(sesObj.getAggregatorId());
			
			if (sesObj.getStatus() != null)
				if (sesObj.getStatus().equalsIgnoreCase("active"))
					plRq.setActiveOnly(true);
				else
					plRq.setActiveOnly(false);

			GetPartnerListResponseType plRs = partnerProfileService.getPartnerList(plRq);
			sesObj.getSubBillerMap().clear();
			for (PartnerType pt : plRs.getPartner())
			{
				SubBillerSessionDataBean sbo = new SubBillerSessionDataBean();
				sbo.setBillerId(pt.getPartnerKey());
				sbo.setBillerNameEnglish(pt.getName());
				sbo.setStatus(pt.getStatus());
				sesObj.getSubBillerMap().put(pt.getPartnerKey(), sbo);
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
	 * Calls the backend webservice to retrieve the details of partner by type.
	 * 
	 * @param sesObj
	 * @return
	 */
	public SubBillerSessionDataBean callGetPartnerDetails(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callGetPartnerDetails";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetPartnerDetailsRequestType pdrq = new GetPartnerDetailsRequestType();
			pdrq.setMessageHeader(getMessageHeaderType("GET_PARTNER_DETAILS"));
			pdrq.setPartnerKey(sesObj.getBillerId());
			GetPartnerDetailsResponseType pdrs = partnerProfileService.getPartnerDetails(pdrq);
			sesObj.setSelectedSubBiller(new SubBillerSessionDataBean());
			sesObj.getSelectedSubBiller().setBillerId(pdrs.getPartner().getPartnerKey());
			sesObj.getSelectedSubBiller().setBillerNameEnglish(pdrs.getPartner().getName());
			sesObj.getSelectedSubBiller().setBillerNameArabic(pdrs.getPartner().getArabicName());
			sesObj.getSelectedSubBiller().setStatus(pdrs.getPartner().getStatus());
			sesObj.getSelectedSubBiller().setShortName(pdrs.getPartner().getShortName());
			sesObj.getSelectedSubBiller().setBillingAccountBankId(pdrs.getPartner().getBillerFinanicialInfo() != null ? pdrs.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankKey() : null);
			sesObj.getSelectedSubBiller().setIbanNumber(pdrs.getPartner().getBillerFinanicialInfo() != null ? pdrs.getPartner().getBillerFinanicialInfo().getBillingAccount().getBankAccount().getNumber() : null);
			sesObj.getSelectedSubBiller().setLegalIdType(pdrs.getPartner().getBusinessInfo().getGovIDType() != null ? pdrs.getPartner().getBusinessInfo().getGovIDType().value() : null);
			sesObj.getSelectedSubBiller().setLegalIdNumber(pdrs.getPartner().getBusinessInfo().getGovIDNumber() != null ? pdrs.getPartner().getBusinessInfo().getGovIDNumber() : null);
			sesObj.getSelectedSubBiller().setAddress(pdrs.getPartner().getBusinessInfo().getAddress() != null ? pdrs.getPartner().getBusinessInfo().getAddress() : null);
			sesObj.getSelectedSubBiller().setEmail(pdrs.getPartner().getBusinessInfo().getEmail() != null ? pdrs.getPartner().getBusinessInfo().getEmail() : null);
			sesObj.getSelectedSubBiller().setLandline(pdrs.getPartner().getBusinessInfo().getLandline() != null ? pdrs.getPartner().getBusinessInfo().getLandline() : null);
			sesObj.getSelectedSubBiller().setMobile(pdrs.getPartner().getBusinessInfo().getMobileNumber() != null ? pdrs.getPartner().getBusinessInfo().getMobileNumber() : null);
			sesObj.getSelectedSubBiller().setTradeLicenseExpiryDate(pdrs.getPartner().getBusinessInfo().getTradeLicenseExpiryDate() != null ? pdrs.getPartner().getBusinessInfo().getTradeLicenseExpiryDate().toString() : null);
			sesObj.getSelectedSubBiller().setVatNumber(pdrs.getPartner().getBusinessInfo().getVATNumber() != null ? pdrs.getPartner().getBusinessInfo().getVATNumber() : null);
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
	 * Calls the backend webservice to create subbiller partner type.
	 * 
	 * @param sesObj
	 * @return
	 */
	public SubBillerSessionDataBean callCreatePartner(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callCreatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreatePartnerRqType crtPartner = new CreatePartnerRqType();	
			crtPartner.setMessageHeader(getMessageHeaderType(sesObj.getPartnerKey(), "PMCRRQ", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			PartnerManagementType pmt = new PartnerManagementType();
			pmt.setType(PartnerTypeEnums.SUBBILLER);
			pmt.setName(sesObj.getBillerNameEnglish());
			pmt.setArabicName(sesObj.getBillerNameArabic());
//			pmt.setCategory(sesObj.getBusinessCategory()); // Fix defect # 4322
			pmt.setOwnerKey(sesObj.getAggregatorId());
			pmt.setShortName(sesObj.getShortName());
			pmt.setDescription(sesObj.getBillerNameEnglish());
			// Setting Financial Information
			if (sesObj.getBillingAccountBankId() != null && sesObj.getIbanNumber() != null)
			{
				pmt.setBillerFinanicialInfo(new BillerFinanicialInfoType());
				pmt.getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
				pmt.getBillerFinanicialInfo().getBillingAccount().setBankKey(sesObj.getBillingAccountBankId());
				pmt.getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(sesObj.getBillingAccountBankId());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(sesObj.getIbanNumber());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setType("SBA");
				// Setting Refund Account as Billing Account
				pmt.getBillerFinanicialInfo().setRefundAccount(pmt.getBillerFinanicialInfo().getBillingAccount());
				pmt.getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}
			// Setting Business Information 
			pmt.setBusinessInfo(new PartnerBusinessInfoType());
			pmt.getBusinessInfo().setGovIDType(GovIdTypeEnum.fromValue(sesObj.getLegalIdType()));
			pmt.getBusinessInfo().setGovIDNumber(sesObj.getLegalIdNumber());
			pmt.getBusinessInfo().setBusinessCategoryCode(sesObj.getBusinessCategory());
			pmt.getBusinessInfo().setAddress(sesObj.getAddress());
			pmt.getBusinessInfo().setLandline(sesObj.getLandline());
			pmt.getBusinessInfo().setMobileNumber(sesObj.getMobile());
			pmt.getBusinessInfo().setEmail(sesObj.getEmail());
			pmt.getBusinessInfo().setVATNumber(sesObj.getVatNumber());
			try
			{
				if(sesObj.getTradeLicenseExpiryDate() != null)
					pmt.getBusinessInfo().setTradeLicenseExpiryDate(sesObj.parseXmlDate(sesObj.getTradeLicenseExpiryDate()));
			}
			catch (IllegalArgumentException e)
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(80009);
				faultInfo.setDescription("Date should be in Hijri format.");
				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			crtPartner.getPartner().add(pmt);
			
			CreatePartnerRsType crtPrtRes = partnerManagementService.createPartner(crtPartner);
						
			if (crtPrtRes.getPartnerRecord().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(crtPrtRes.getPartnerRecord().get(0).getStatus().getStatusCode());
				faultInfo.setDescription(crtPrtRes.getPartnerRecord().get(0).getStatus().getStatusDesc());

				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			else
			{
				// if reaches to this point means, update was successful
				sesObj.setGenericInfoMessage();

				// Updating the Application Level Cache
				PartnerListCacheSummary uplc = new PartnerListCacheSummary(crtPrtRes.getPartnerRecord().get(0).getPartner().getPartnerKey(), sesObj.getBillerNameEnglish(), sesObj.getBillerNameEnglish(), sesObj.getStatus());
				sesObj.setCacheObj(uplc);
				sesObj.setCacheParent(sesObj.getAggregatorId());
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST);
			}
			// Fixing defect 3335
			sesObj.setBillerId(null);
			sesObj.setBillerNameEnglish(null);
			sesObj.setBillerNameArabic(null);
			sesObj.setStatus(null);
			sesObj.setBillingAccountBankId(null);
			sesObj.setIbanNumber(null);
			sesObj.setLegalIdNumber(null);
			sesObj.setLegalIdType(null);
			sesObj.setTradeLicenseExpiryDate(null);
			sesObj.setShortName(null);
			sesObj.setAddress(null);
			sesObj.setLandline(null);
			sesObj.setMobile(null);
			sesObj.setEmail(null);
			sesObj.setVatNumber(null);
		}
		catch (PartnerManagementFault e)
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
	 * Calls the backend webservice to create subbiller partner type.
	 * 
	 * @param sesObj
	 * @return
	 */
	public SubBillerSessionDataBean callUpdatePartner(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callUpdatePartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdatePartnersDetailsRqType updPartner = new UpdatePartnersDetailsRqType();
			updPartner.setMessageHeader(getMessageHeaderType(sesObj.getPartnerKey(), "PMUPRQ", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			PartnerManagementType pmt = new PartnerManagementType();
			// setting the Partner Basic Information
			pmt.setPartnerKey(sesObj.getBillerId());
			pmt.setName(sesObj.getBillerNameEnglish());
			pmt.setArabicName(sesObj.getBillerNameArabic());
			pmt.setType(PartnerTypeEnums.SUBBILLER);
//			pmt.setCategory(sesObj.getBusinessCategory()); // Fix defect # 4322
			pmt.setOwnerKey(sesObj.getAggregatorId());
			pmt.setShortName(sesObj.getShortName());
			pmt.setDescription(sesObj.getBillerNameEnglish());
			// Setting Financial Information
			if (sesObj.getBillingAccountBankId() != null && sesObj.getIbanNumber() != null)
			{
				pmt.setBillerFinanicialInfo(new BillerFinanicialInfoType());
				pmt.getBillerFinanicialInfo().setBillingAccount(new FinancialAccountType());
				pmt.getBillerFinanicialInfo().getBillingAccount().setBankKey(sesObj.getBillingAccountBankId());
				pmt.getBillerFinanicialInfo().getBillingAccount().setBankAccount(new BankAccountType());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setBankKey(sesObj.getBillingAccountBankId());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setNumber(sesObj.getIbanNumber());
				pmt.getBillerFinanicialInfo().getBillingAccount().getBankAccount().setType("SBA");
				// Setting Refund Account as Billing Account
				pmt.getBillerFinanicialInfo().setRefundAccount(pmt.getBillerFinanicialInfo().getBillingAccount());
				pmt.getBillerFinanicialInfo().getRefundAccount().getBankAccount().setType("BRA");
			}
			// Setting Business Information 
			pmt.setBusinessInfo(new PartnerBusinessInfoType());
			pmt.getBusinessInfo().setGovIDType(GovIdTypeEnum.fromValue(sesObj.getLegalIdType()));
			pmt.getBusinessInfo().setGovIDNumber(sesObj.getLegalIdNumber());
			pmt.getBusinessInfo().setBusinessCategoryCode(sesObj.getBusinessCategory()); 
			pmt.getBusinessInfo().setAddress(sesObj.getAddress());
			pmt.getBusinessInfo().setLandline(sesObj.getLandline());
			pmt.getBusinessInfo().setMobileNumber(sesObj.getMobile());
			pmt.getBusinessInfo().setEmail(sesObj.getEmail());
			pmt.getBusinessInfo().setVATNumber(sesObj.getVatNumber());
			try
			{			
				if(sesObj.getTradeLicenseExpiryDate() != null)
					pmt.getBusinessInfo().setTradeLicenseExpiryDate(sesObj.parseXmlDate(sesObj.getTradeLicenseExpiryDate()));
			}
			catch (IllegalArgumentException e)
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(80009);
				faultInfo.setDescription("Date should be in Hijri format.");
				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			updPartner.getPartner().add(pmt);
			UpdatePartnersDetailsRsType updPrtRes = partnerManagementService.updatePartnersDetails(updPartner);
			if (updPrtRes.getPartnerRecord().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(updPrtRes.getPartnerRecord().get(0).getStatus().getStatusCode());
				faultInfo.setDescription(updPrtRes.getPartnerRecord().get(0).getStatus().getStatusDesc());

				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			else
			{
				// if reaches to this point means, update was successful
				// sesObj.setGenericInfoMessage();

				// Updating the Application Level Cache
				PartnerListCacheSummary uplc = new PartnerListCacheSummary(updPrtRes.getPartnerRecord().get(0).getPartner().getPartnerKey(), sesObj.getBillerNameEnglish(), sesObj.getBillerNameEnglish(), sesObj.getStatus());
				sesObj.setCacheObj(uplc);
				sesObj.setCacheParent(sesObj.getAggregatorId());
				sesObj.setCacheRefreshType(PortalConstant.LOOKUP_AGGREGATOR_BILLER_LIST);
			}
			// if it reaches here, this means update is successful
			sesObj.getSelectedSubBiller().setBillerNameEnglish(sesObj.getBillerNameEnglish());
			sesObj.getSelectedSubBiller().setBillerNameArabic(sesObj.getBillerNameArabic());
			sesObj.getSelectedSubBiller().setShortName(sesObj.getShortName());
			sesObj.getSelectedSubBiller().setBillingAccountBankId(sesObj.getBillingAccountBankId());
			sesObj.getSelectedSubBiller().setIbanNumber(sesObj.getIbanNumber());
			sesObj.getSelectedSubBiller().setTradeLicenseExpiryDate(sesObj.getTradeLicenseExpiryDate());
			sesObj.getSelectedSubBiller().setLegalIdType(sesObj.getLegalIdType());
			sesObj.getSelectedSubBiller().setLegalIdNumber(sesObj.getLegalIdNumber());
			sesObj.getSelectedSubBiller().setBusinessCategory(sesObj.getBusinessCategory());
			sesObj.getSelectedSubBiller().setAddress(sesObj.getAddress());
			sesObj.getSelectedSubBiller().setLandline(sesObj.getLandline());
			sesObj.getSelectedSubBiller().setMobile(sesObj.getMobile());
			sesObj.getSelectedSubBiller().setEmail(sesObj.getEmail());
			sesObj.getSelectedSubBiller().setVatNumber(sesObj.getVatNumber());
		}
		catch (PartnerManagementFault e)
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
	 * Calls the backend webservice to transfer subbiller from one aggregator to another.
	 * 
	 * @param sesObj
	 * @return
	 */
	public SubBillerSessionDataBean callTransferPartner(SubBillerSessionDataBean sesObj)
	{
		final String methodName = "callTransferPartner";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			TransferPartnerRqType trnPrt = new TransferPartnerRqType();
			trnPrt.setMessageHeader(getMessageHeaderType(sesObj.getPartnerKey(), "PMTRRQ", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			trnPrt.getPartnerKey().add(0, sesObj.getBillerId());
			TransferPartnerRsType trnPrtRs = partnerManagementService.transferPartner(trnPrt);
			if (trnPrtRs.getPartner().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(trnPrtRs.getPartner().get(0).getStatus().getStatusCode());
				faultInfo.setDescription(trnPrtRs.getPartner().get(0).getStatus().getStatusDesc());

				PartnerManagementFault ft = new PartnerManagementFault("", faultInfo);
				throw ft;
			}
			else
			{
//				sesObj.setSettlementId(trnPrtRs.getPartner().get(0).getTransferExpectedDate());
			}
			sesObj.setGenericInfoMessage();
		}
		catch (PartnerManagementFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else sesObj.setGenericErrorMessage();

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
}