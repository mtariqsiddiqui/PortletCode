/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerSettlementCorrelationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillerSettlementCorrelationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerDetailsResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerSettlementCorrelationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillerSettlementCorrelationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.PaymentTypeSessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.AccessChannelListType;
import com.sadad.scm.common._1.BankAccountType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.PartnerConfigurationAttributeType;
import com.sadad.scm.common._1.PartnerConfigurationType;
import com.sadad.scm.common._1.PartnerConfigurationsType;
import com.sadad.scm.common._1.PaymentTypeType;
import com.sadad.scm.common._1.ServiceTypeListType;
import com.sadad.scm.common._1.SettlementAccountType;
import com.sadad.scm.common._1.SettlementCorrelationType;
import com.sadad.scm.common._1.TimeLimitEnum;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class PaymentTypeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = PaymentTypeHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Call backend service to create new payment type for biller
	 * 
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callCreatePaymentType(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callCreatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreatePaymentTypeRequestType paymentTypeReq = new CreatePaymentTypeRequestType();
			PaymentTypeType paymentTypeDetail = new PaymentTypeType();

			paymentTypeReq.setMessageHeader(getMessageHeaderType("CREATE_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			paymentTypeReq.setPartnerKey(sesObj.getBillerId());
			paymentTypeDetail.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getStatus()));
			paymentTypeDetail.setPaymentTypeCode(sesObj.getPaymentType());
			paymentTypeDetail.setIsDefault(sesObj.isDeefault());
			paymentTypeDetail.setIsPrepaid(sesObj.isPrepaid());
			paymentTypeDetail.setCanReverse(sesObj.isReverse());
			paymentTypeDetail.setTimeLimit(TimeLimitEnum.valueOf(sesObj.getTimeLimit()));
			AccessChannelListType aclt = new AccessChannelListType();
			if (sesObj.getAccessChannels() != null)
				for (String ac : sesObj.getAccessChannels().split(","))
					aclt.getAccessChannel().add(ac.trim());

			if (aclt.getAccessChannel().size() > 0)
				paymentTypeDetail.setAllowedAccessChannel(aclt);
			else
				paymentTypeDetail.setAllowedAccessChannel(null);

			ServiceTypeListType stlt = new ServiceTypeListType();
			if (sesObj.getServiceTypes() != null)
				for (String st : sesObj.getServiceTypes().split(","))
					stlt.getServiceType().add(st.trim());

			if (stlt.getServiceType().size() > 0)
				paymentTypeDetail.setAllowedServiceTypes(stlt);
			else
				paymentTypeDetail.setAllowedServiceTypes(null);

			paymentTypeReq.setPaymentType(paymentTypeDetail);

			partnerProfileService.createPaymentType(paymentTypeReq);
			sesObj.setGenericInfoMessage();
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
	 * Calls backend webservice to retrieve the data from database and populate it in local List object
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callListPaymentType(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callListPaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			sesObj.setPaymentTypeList(new ArrayList<PaymentTypeSessionDataBean>());

			ListPaymentTypeRequestType lptReq = new ListPaymentTypeRequestType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			lptReq.setPartnerKey(sesObj.getBillerId());
			ListPaymentTypeResponseType lbtRes = partnerProfileService.listPaymentType(lptReq);
			sesObj.setBillerId(lbtRes.getPartnerKey());

			if (lbtRes.getPaymentTypes() != null)
			{
				for (PaymentTypeType ptt : lbtRes.getPaymentTypes().getPaymentType())
				{
					PaymentTypeSessionDataBean ptsb = new PaymentTypeSessionDataBean();
					ptsb.setPaymentType(ptt.getPaymentTypeCode());
					ptsb.setDeefault(ptt.isIsDefault());
					ptsb.setReverse(ptt.isCanReverse());
					ptsb.setPrepaid(ptt.isIsPrepaid());
					ptsb.setDefaultPostpaid(ptt.isIsDefaultPostPaid());
					ptsb.setStatus(ptt.getStatus() != null ? ptt.getStatus().value() : null);
					ptsb.setTimeLimit(ptt.getTimeLimit().value());

					String stChnls = null;
					if (ptt.getAllowedAccessChannel() != null && ptt.getAllowedAccessChannel().getAccessChannel().size() > 0)
					{
						StringBuilder sb = new StringBuilder();
						for (String ac : ptt.getAllowedAccessChannel().getAccessChannel())
							sb.append(ac).append(", ");

						stChnls = sb.toString().trim();
						stChnls = stChnls.substring(0, stChnls.lastIndexOf(','));
					}
					ptsb.setAccessChannels(stChnls);
					sesObj.getPaymentTypeList().add(ptsb);
				}
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
	 * Call backend service to retrieve existing payment type for biller.
	 * 
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callGetPaymentType(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callGetPaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetPaymentTypeRequestType gptReq = new GetPaymentTypeRequestType();
			gptReq.setMessageHeader(getMessageHeaderType("GET_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			gptReq.setPartnerKey(sesObj.getBillerId());
			gptReq.setPaymentTypeCode(sesObj.getPaymentType());
			GetPaymentTypeResponseType gptRes = partnerProfileService.getPaymentType(gptReq);

			// Set the value in Session Object
			sesObj.setSelectedPaymentType(new PaymentTypeSessionDataBean()); // Clear any previous detail from Session and put new Object
			sesObj.getSelectedPaymentType().setPaymentType(gptRes.getPaymentType().getPaymentTypeCode());
			sesObj.getSelectedPaymentType().setStatus(gptRes.getPaymentType().getStatus() != null ? gptRes.getPaymentType().getStatus().value() : null);
			sesObj.getSelectedPaymentType().setReverse(gptRes.getPaymentType().isCanReverse());
			sesObj.getSelectedPaymentType().setDeefault(gptRes.getPaymentType().isIsDefault());
			sesObj.getSelectedPaymentType().setPrepaid(gptRes.getPaymentType().isIsPrepaid());
			sesObj.getSelectedPaymentType().setDefaultPostpaid(gptRes.getPaymentType().isIsDefaultPostPaid());
			sesObj.getSelectedPaymentType().setTimeLimit(gptRes.getPaymentType().getTimeLimit().value());

			String stChnls = null;
			if (gptRes.getPaymentType().getAllowedAccessChannel() != null && gptRes.getPaymentType().getAllowedAccessChannel().getAccessChannel().size() > 0)
			{
				StringBuilder sb = new StringBuilder();
				for (String ac : gptRes.getPaymentType().getAllowedAccessChannel().getAccessChannel())
					sb.append(ac).append(", ");

				stChnls = sb.toString().trim();
				stChnls = stChnls.substring(0, stChnls.lastIndexOf(','));
			}
			sesObj.getSelectedPaymentType().setAccessChannels(stChnls);
			
			String stPmtyps = null;
			if (gptRes.getPaymentType().getAllowedServiceTypes() != null && gptRes.getPaymentType().getAllowedServiceTypes().getServiceType().size() > 0)
			{
				StringBuilder sb = new StringBuilder();
				for (String pt : gptRes.getPaymentType().getAllowedServiceTypes().getServiceType())
					sb.append(pt).append(", ");

				stPmtyps = sb.toString().trim();
				stPmtyps = stPmtyps.substring(0, stPmtyps.lastIndexOf(','));
			}
			sesObj.getSelectedPaymentType().setServiceTypes(stPmtyps);
			

			sesObj.getSelectedPaymentType().setMultiAccountConditionsMet(isSubscribedToMultiAccount(sesObj.getBillerId()));
			sesObj = getSettlementCorrelationsFromPartnerDetails(sesObj);
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
	 * Calls backend webservice to activate or deactivate existing payment type for biller.
	 * 
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callActivateOrDeActivatePaymentType(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if (sesObj.getSelectedPaymentType().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				DeactivatePaymentTypeRequestType dptReq = new DeactivatePaymentTypeRequestType();
				dptReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dptReq.setPartnerKey(sesObj.getBillerId());
				dptReq.setPaymentTypeCode(sesObj.getSelectedPaymentType().getPaymentType());
				partnerProfileService.deactivatePaymentType(dptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedPaymentType().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if (sesObj.getSelectedPaymentType().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				ActivatePaymentTypeRequestType aptReq = new ActivatePaymentTypeRequestType();
				aptReq.setMessageHeader(getMessageHeaderType("ACTIVATE_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				aptReq.setPartnerKey(sesObj.getBillerId());
				aptReq.setPaymentTypeCode(sesObj.getSelectedPaymentType().getPaymentType());
				partnerProfileService.activatePaymentType(aptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedPaymentType().setStatus(ConfigurationStatusEnum.ACTIVE.value());
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
	 * Calls backend webservice to update an existing payment type for biller. 
	 * 
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callUpdatePaymentType(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callUpdatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Creat a new PaymentType Object for service call request

			// Call the backend service
			UpdatePaymentTypeRequestType uptReq = new UpdatePaymentTypeRequestType();
			uptReq.setMessageHeader(getMessageHeaderType("UPDATE_PAYMENT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			uptReq.setPartnerKey(sesObj.getBillerId());

			PaymentTypeType upt = new PaymentTypeType();
			upt.setPaymentTypeCode(sesObj.getPaymentType());
			upt.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getStatus()));
			upt.setIsDefault(sesObj.isDeefault());
			upt.setIsPrepaid(sesObj.isPrepaid());
			upt.setIsDefaultPostPaid(sesObj.isDefaultPostpaid());
			upt.setCanReverse(sesObj.isReverse());
			upt.setStatus(sesObj.getStatus() != null ? ConfigurationStatusEnum.fromValue(sesObj.getStatus()) : null);
			upt.setTimeLimit(TimeLimitEnum.valueOf(sesObj.getTimeLimit()));
			AccessChannelListType aclt = new AccessChannelListType();
			if (sesObj.getAccessChannels() != null)
				for (String ac : sesObj.getAccessChannels().split(","))
					aclt.getAccessChannel().add(ac.trim());

			if (aclt.getAccessChannel().size() > 0)
				upt.setAllowedAccessChannel(aclt);
			else
				upt.setAllowedAccessChannel(null);
			
			ServiceTypeListType stlt = new ServiceTypeListType();
			if (sesObj.getServiceTypes() != null)
				for (String st : sesObj.getServiceTypes().split(","))
					stlt.getServiceType().add(st);

			if (stlt.getServiceType().size() > 0)
				upt.setAllowedServiceTypes(stlt);
			else
				upt.setAllowedServiceTypes(null);
				
			// if(sesObj.getIban() != null)
			// {
			// upt.setFinancialAccount(new FinancialAccountType());
			// upt.getFinancialAccount().setSettlementAccount(new SettlementAccountType());
			// upt.getFinancialAccount().setBankAccount(new BankAccountType());
			// upt.getFinancialAccount().getBankAccount().setType(sesObj.getPaymentType());
			// upt.getFinancialAccount().getBankAccount().setNumber(sesObj.getIban());
			// }

			uptReq.setPaymentType(upt);

			partnerProfileService.updatePaymentType(uptReq);
			// if it reaches here it means response is successfull, then update the sesObj
			sesObj.getSelectedPaymentType().setDeefault(sesObj.isDeefault());
			sesObj.getSelectedPaymentType().setPrepaid(sesObj.isPrepaid());
//			sesObj.getSelectedPaymentType().setDefaultPostpaid(sesObj.isDefaultPostpaid());
			sesObj.getSelectedPaymentType().setReverse(sesObj.isReverse());
			sesObj.getSelectedPaymentType().setTimeLimit(sesObj.getTimeLimit());
			sesObj.getSelectedPaymentType().setStatus(sesObj.getStatus());
			sesObj.getSelectedPaymentType().setAccessChannels(sesObj.getAccessChannels());
			sesObj.getSelectedPaymentType().setServiceTypes(sesObj.getServiceTypes());
			sesObj.getSelectedPaymentType().setIban(sesObj.getIban());
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
	 * This method work as a delegate and call Create or Update BillerSettlementCorrelation methods based on the condition
	 * 
	 * @param sesObj
	 * @return
	 */
	public PaymentTypeSessionDataBean callCreateOrUpdateBillerSettlementCorrelation(PaymentTypeSessionDataBean sesObj)
	{
		if(sesObj.getSelectedPaymentType().isConfigureSettlementCorrelation())
			sesObj = callUpdateBillerSettlementCorrelation(sesObj);
		else
			sesObj = callCreateBillerSettlementCorrelation(sesObj);
		
		return sesObj;
	}
	
	/**
	 * Call backend service to create biller settlement correlation.
	 * 
	 * @param sesObj
	 * @return
	 */
	private PaymentTypeSessionDataBean callCreateBillerSettlementCorrelation(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callCreateBillerSettlementCorrelation";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBillerSettlementCorrelationRequestType req = new CreateBillerSettlementCorrelationRequestType();
			req.setMessageHeader(getMessageHeaderType("CREATE_BILLER_SETTLEMENT_CORRELATION", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			SettlementCorrelationType sct = new SettlementCorrelationType();
			sct.setBillerKey(sesObj.getBillerId());
			sct.setSettlementCorrelator(sesObj.getPaymentType());
			// Setting Bank Account Values
			sct.setBankAccount(new BankAccountType());
			sct.getBankAccount().setNumber(sesObj.getIban());
			sct.getBankAccount().setType("PT-SBA");
			// Setting Settlement Account Values
			sct.setSettlementAccount(new SettlementAccountType());
			sct.getSettlementAccount().setSettlementIDType("PAYMENT_TYPE");
			req.setSettlementCorrelation(sct);
			
			CreateBillerSettlementCorrelationResponseType res = partnerProfileService.createBillerSettlementCorrelation(req);
			sesObj.getSelectedPaymentType().setSettlementId(res.getSettlementCorrelation().getSettlementAccount().getSettlementID());
			sesObj.getSelectedPaymentType().setIban(sesObj.getIban());
//			sesObj.setGenericInfoMessage();
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
	  * Call backend service to update biller settlement correlation
	  * 
	  * @param sesObj
	  * @return
	  */
	private PaymentTypeSessionDataBean callUpdateBillerSettlementCorrelation(PaymentTypeSessionDataBean sesObj)
	{
		final String methodName = "callUpdateBillerSettlementCorrelation";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdateBillerSettlementCorrelationRequestType req = new UpdateBillerSettlementCorrelationRequestType();
			req.setMessageHeader(getMessageHeaderType("UPDATE_BILLER_SETTLEMENT_CORRELATION", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setSettlementCorrelation(new SettlementCorrelationType());
			// Setting Settlement Correlation
			req.getSettlementCorrelation().setBillerKey(sesObj.getBillerId());
			req.getSettlementCorrelation().setSettlementCorrelator(sesObj.getPaymentType());
			// Setting Bank Account Values
			req.getSettlementCorrelation().setBankAccount(new BankAccountType());
			req.getSettlementCorrelation().getBankAccount().setBankKey(sesObj.getSelectedPaymentType().getSettlementBankKey());
			req.getSettlementCorrelation().getBankAccount().setNumber(sesObj.getIban());
			req.getSettlementCorrelation().getBankAccount().setType("PT-SBA");
			// Setting Settlement Account Values
			req.getSettlementCorrelation().setSettlementAccount(new SettlementAccountType());
			req.getSettlementCorrelation().getSettlementAccount().setSettlementID(sesObj.getSelectedPaymentType().getSettlementId());
			req.getSettlementCorrelation().getSettlementAccount().setSettlementIDType("PAYMENT_TYPE");

			UpdateBillerSettlementCorrelationResponseType res = partnerProfileService.updateBillerSettlementCorrelation(req);
			sesObj.getSelectedPaymentType().setSettlementId(res.getSettlementCorrelation().getSettlementAccount().getSettlementID());
			sesObj.getSelectedPaymentType().setIban(sesObj.getIban());
//			sesObj.setGenericInfoMessage();
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
	public PaymentTypeSessionDataBean clearSessionBeanObject(PaymentTypeSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}

	/**
	 * Call backend service to retrieve settlement correlation from partner details. 
	 * 
	 * @param sesObj
	 * @return
	 * @throws Exception
	 */
	private PaymentTypeSessionDataBean getSettlementCorrelationsFromPartnerDetails(PaymentTypeSessionDataBean sesObj) throws Exception
	{
		final String methodName = "getSettlementCorrelationsFromPartnerDetails";
		logger.entering(CLASS_NAME, methodName, sesObj.getBillerId());
		
		GetPartnerDetailsRequestType req = new GetPartnerDetailsRequestType();
		req.setMessageHeader(getMessageHeaderType("GET_PARTNER_SETTLEMENT_CORRELATIONS"));
		req.setPartnerKey(sesObj.getBillerId());
		GetPartnerDetailsResponseType res = partnerProfileService.getPartnerDetails(req);
		if (res.getPartner().getBillerFinanicialInfo() != null)
		{
			if (res.getPartner().getBillerFinanicialInfo().getSettlementCorrelations().size() > 0)
			{
				for (SettlementCorrelationType sct : res.getPartner().getBillerFinanicialInfo().getSettlementCorrelations())
				{
					if (sct.getSettlementCorrelator().equalsIgnoreCase(sesObj.getSelectedPaymentType().getPaymentType()) && sct.getSettlementAccount().getSettlementIDType().equals("PAYMENT_TYPE"))
					{
						sesObj.getSelectedPaymentType().setSettlementId(sct.getSettlementAccount().getSettlementID());
						sesObj.getSelectedPaymentType().setIban(sct.getBankAccount().getNumber());
						sesObj.getSelectedPaymentType().setSettlementBankKey(sct.getBankKey());
						sesObj.getSelectedPaymentType().setSettlementType(sct.getBankAccount().getType());
						sesObj.getSelectedPaymentType().setSettlementIdType(sct.getSettlementAccount().getSettlementIDType());
						sesObj.getSelectedPaymentType().setConfigureSettlementCorrelation(true);
						break;
					}
				}
			}
		}
		else
		{
			sesObj.getSelectedPaymentType().setConfigureSettlementCorrelation(false);
		}

		logger.exiting(CLASS_NAME, methodName, sesObj.getSelectedPaymentType().getSettlementId());
		return sesObj;
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
		boolean[] result = { false, false, false };

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

					if (pcat.getAttributeName().equals("SUBSCRIPTION_TYPE"))
						result[2] = pcat.getValue().get(0).equalsIgnoreCase("PAYMENT_TYPE_BASED");
				}

			}
		}
		catch (Exception e) 
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}
		
		logger.exiting(CLASS_NAME, methodName, (result[0] && result[1] && result[2]));
		return (result[0] && result[1] && result[2]);
	}
}