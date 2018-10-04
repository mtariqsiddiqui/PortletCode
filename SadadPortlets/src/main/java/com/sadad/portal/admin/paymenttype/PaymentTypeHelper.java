/**
 * 
 */
package com.sadad.portal.admin.paymenttype;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivatePaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListPaymentTypeResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePaymentTypeRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.PaymentTypeDetail;
import com.sadad.portal.beans.PaymentTypeSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.AccessChannelListType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.PaymentTypeType;
import com.sadad.scm.common._1.TimeLimitEnum;

/**
 * @author Yameen
 * 
 */
public class PaymentTypeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = PaymentTypeHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private PaymentTypeSessionBean paymentTypeObject = new PaymentTypeSessionBean();

	/**
	 * @return the billCategoryObject
	 */
	public PaymentTypeSessionBean getPaymentTypeObject()
	{
		return paymentTypeObject;
	}

	/**
	 * @param billCategoryObject
	 *            the billCategoryObject to set
	 */
	public void setPaymentTypeObject(PaymentTypeSessionBean paymentTypeObject)
	{
		this.paymentTypeObject = paymentTypeObject;
	}

	/**
	 * 
	 * @param partnerKey
	 * @param paymentType
	 * @param defalt
	 * @param prepaid
	 * @param reverse
	 * @param timeLimit
	 * @param accessChannels
	 */
	public void callCreatePaymentType(String partnerKey, String paymentType, boolean defalt, boolean prepaid, boolean reverse, String timeLimit, String accessChannels)
	{
		final String methodName = "callCreatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreatePaymentTypeRequestType paymentTypeReq = new CreatePaymentTypeRequestType();
			PaymentTypeType paymentTypeDetail = new PaymentTypeType();
			
			paymentTypeReq.setMessageHeader(getMessageHeaderType("CREATE_PAYMENT_TYPE"));
			paymentTypeReq.setPartnerKey(partnerKey);
			
			paymentTypeDetail.setPaymentTypeCode(paymentType);
			paymentTypeDetail.setIsDefault(defalt);
			paymentTypeDetail.setIsPrepaid(prepaid);
			paymentTypeDetail.setCanReverse(reverse);
			paymentTypeDetail.setTimeLimit(TimeLimitEnum.valueOf(timeLimit));
			AccessChannelListType aclt = new AccessChannelListType();
			for(String ac : accessChannels.split(","))
				aclt.getAccessChannel().add(ac);
			
			if(aclt.getAccessChannel().size() > 0)
				paymentTypeDetail.setAllowedAccessChannel(aclt);
			else
				paymentTypeDetail.setAllowedAccessChannel(null);
			
			paymentTypeReq.setPaymentType(paymentTypeDetail);
			
			partnerProfileServices.createPaymentType(paymentTypeReq);
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
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	public void callListPaymentType(String partnerKey)
	{
		final String methodName = "callListPaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			getPaymentTypeObject().setPartnerKey(partnerKey);
			getPaymentTypeObject().setPaymentTypeList(new ArrayList<PaymentTypeDetail>());

			ListPaymentTypeRequestType lptReq = new ListPaymentTypeRequestType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_PAYMENT_TYPE"));
			lptReq.setPartnerKey(partnerKey);
			ListPaymentTypeResponseType lbtRes = partnerProfileServices.listPaymentType(lptReq);

			if (lbtRes.getPaymentTypes().getPaymentType() != null)
			{
				getPaymentTypeObject().setPartnerKey(lbtRes.getPartnerKey());

				for (PaymentTypeType ptt : lbtRes.getPaymentTypes().getPaymentType())
				{
					PaymentTypeDetail ptd = new PaymentTypeDetail();
					ptd.setPaymentType(ptt.getPaymentTypeCode());
					ptd.setAsDefault(ptt.isIsDefault());
					ptd.setCanReverse(ptt.isCanReverse());
					ptd.setPrepaid(ptt.isIsPrepaid());
					ptd.setStatus(ptt.getStatus());
					ptd.setTimeLimit(ptt.getTimeLimit());
					if (ptt.getAllowedAccessChannel() != null)
						ptd.setAccessChannel(ptt.getAllowedAccessChannel().getAccessChannel());

					getPaymentTypeObject().getPaymentTypeList().add(ptd);
				}
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
		logger.exiting(CLASS_NAME, methodName);
	}


	public void callGetPaymentType(String partnerKey, String paymentType)
	{
		final String methodName = "callGetPaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Clear any previous detail from Session and put new Object
			getPaymentTypeObject().setSelectedPaymentType(new PaymentTypeDetail());
			// Call the backend service
			GetPaymentTypeRequestType gptReq = new GetPaymentTypeRequestType();
			gptReq.setMessageHeader(getMessageHeaderType("GET_PAYMENT_TYPE"));
			gptReq.setPartnerKey(partnerKey);
			gptReq.setPaymentTypeCode(paymentType);
			GetPaymentTypeResponseType gbcRes = partnerProfileServices.getPaymentType(gptReq);

			// Set the value in Session Object
			getPaymentTypeObject().getSelectedPaymentType().setPaymentType(gbcRes.getPaymentType().getPaymentTypeCode());
			getPaymentTypeObject().getSelectedPaymentType().setStatus(gbcRes.getPaymentType().getStatus());
			getPaymentTypeObject().getSelectedPaymentType().setCanReverse(gbcRes.getPaymentType().isCanReverse());
			getPaymentTypeObject().getSelectedPaymentType().setAsDefault(gbcRes.getPaymentType().isIsDefault());
			getPaymentTypeObject().getSelectedPaymentType().setPrepaid(gbcRes.getPaymentType().isIsPrepaid());
			getPaymentTypeObject().getSelectedPaymentType().setTimeLimit(gbcRes.getPaymentType().getTimeLimit());
			if (gbcRes.getPaymentType().getAllowedAccessChannel() != null)
				getPaymentTypeObject().getSelectedPaymentType().setAccessChannel(gbcRes.getPaymentType().getAllowedAccessChannel().getAccessChannel());
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
		logger.exiting(CLASS_NAME, methodName);
	}

	public void callActivateOrDeActivatePaymentType()
	{
		final String methodName = "callActivateOrDeActivatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if(getPaymentTypeObject().getSelectedPaymentType().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				DeactivatePaymentTypeRequestType dptReq = new DeactivatePaymentTypeRequestType();
				dptReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_PAYMENT_TYPE"));
				dptReq.setPartnerKey(getPaymentTypeObject().getPartnerKey());
				dptReq.setPaymentTypeCode(getPaymentTypeObject().getSelectedPaymentType().getPaymentType());
				partnerProfileServices.deactivatePaymentType(dptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getPaymentTypeObject().getSelectedPaymentType().setStatus(ConfigurationStatusEnum.INACTIVE);				
			}
			else if(getPaymentTypeObject().getSelectedPaymentType().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				ActivatePaymentTypeRequestType aptReq = new ActivatePaymentTypeRequestType();
				aptReq.setMessageHeader(getMessageHeaderType("ACTIVATE_PAYMENT_TYPE"));
				aptReq.setPartnerKey(getPaymentTypeObject().getPartnerKey());
				aptReq.setPaymentTypeCode(getPaymentTypeObject().getSelectedPaymentType().getPaymentType());
				partnerProfileServices.activatePaymentType(aptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getPaymentTypeObject().getSelectedPaymentType().setStatus(ConfigurationStatusEnum.ACTIVE);				
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
		logger.exiting(CLASS_NAME, methodName);
	}

	public void callUpdatePaymentType(String partnerKey, String paymentType, boolean defalt, boolean prepaid, boolean reverse, String timeLimit, String accessChannels)
	{
		final String methodName = "callUpdatePaymentType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Creat a new PaymentType Object for service call request
			

			// Call the backend service
			UpdatePaymentTypeRequestType uptReq = new UpdatePaymentTypeRequestType();
			uptReq.setMessageHeader(getMessageHeaderType("UPDATE_PAYMENT_TYPE"));
			uptReq.setPartnerKey(partnerKey);
			
			PaymentTypeType upt = new PaymentTypeType();
			upt.setPaymentTypeCode(paymentType);
			upt.setIsDefault(defalt);
			upt.setIsPrepaid(prepaid);
			upt.setCanReverse(reverse);
			upt.setTimeLimit(TimeLimitEnum.valueOf(timeLimit));
			AccessChannelListType aclt = new AccessChannelListType();
			for(String ac : accessChannels.split(","))
				aclt.getAccessChannel().add(ac);
			
			if(aclt.getAccessChannel().size() > 0)
				upt.setAllowedAccessChannel(aclt);
			else
				upt.setAllowedAccessChannel(null);

			uptReq.setPaymentType(upt);
			partnerProfileServices.updatePaymentType(uptReq);

			// if it reaches here, it means response is successfull change status manually in session object
			getPaymentTypeObject().getSelectedPaymentType().setPaymentType(paymentType);
			getPaymentTypeObject().getSelectedPaymentType().setAsDefault(defalt);
			getPaymentTypeObject().getSelectedPaymentType().setPrepaid(prepaid);
			getPaymentTypeObject().getSelectedPaymentType().setCanReverse(reverse);
			getPaymentTypeObject().getSelectedPaymentType().setTimeLimit(TimeLimitEnum.valueOf(timeLimit));
			getPaymentTypeObject().getSelectedPaymentType().setAccessChannel(aclt.getAccessChannel());
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
		logger.exiting(CLASS_NAME, methodName);
	}
}
