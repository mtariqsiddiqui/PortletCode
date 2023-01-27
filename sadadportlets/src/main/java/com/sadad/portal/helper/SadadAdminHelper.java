package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.SadadAdminSessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.PartnerConfigurationAttributeType;
import com.sadad.scm.common._1.PartnerConfigurationAttributesType;
import com.sadad.scm.common._1.PartnerConfigurationType;
import com.sadad.scm.error._1.ErrorType;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */
public class SadadAdminHelper extends PortalServiceCallHelper
{
	public static boolean CACHE_REFRESH_FLAG = true;
	private static final String CLASS_NAME = SadadAdminHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	public SadadAdminSessionDataBean callGetSADAD(SadadAdminSessionDataBean sesObj)
	{
		final String methodName = "callGetSADAD";
		logger.entering(CLASS_NAME, methodName);
		if (CACHE_REFRESH_FLAG || sesObj == null)
		{
			sesObj = new SadadAdminSessionDataBean();
			sesObj.setLanguageCode("EN");
			try
			{
				GetSADADRequestType req = new GetSADADRequestType();
				req.setMessageHeader(getMessageHeaderType("GET_SADAD", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				GetSADADResponseType res = partnerProfileService.getSADAD(req);
				sesObj.setSadadId(res.getSADADDetail().getPartnerKey());
				sesObj.setSadadName(res.getSADADDetail().getName());
				sesObj.setSadadDescription("SADAD ORGANIZATION ENTITY"); // TODO - remove the hard-coded value
				sesObj.setSadadCurrentAccount(res.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankAccount().getNumber());
				sesObj.setAccountBankId(res.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankKey());
				sesObj.setAccountBankName(res.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankName());

				for(PartnerConfigurationType pct : res.getSADADDetail().getConfigurations())
				{
					if(pct.getConfigurationName().equals("REFUND_SYSTEM_CONFIGURATION")) // TODO - Read configuration name from Sada Dynamic Config porperties
					{
						for(PartnerConfigurationAttributeType pcat : pct.getAttributes().getAttribute())
						{
							if(pcat.getAttributeName().equals("SADAD_REFUND_LIMITS")) // TODO - Read attribute name from Sada Dynamic Config porperties
							{
								sesObj.setRefundConfigId(pcat.getId());
								sesObj.setRefundAttributeId(pcat.getAttributeId());
								sesObj.setRefundMaxLimit(Integer.valueOf(pcat.getValue().get(0)));
								break;
							}
						}
						break;
					}
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
			CACHE_REFRESH_FLAG = false;
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Call the backend webservice to update the SADAD information
	 * @param accountNumber - Bank account number to be updated
	 * @param bankId - Bank ID of SADAD current account
	 */
	public SadadAdminSessionDataBean callUpdateSADAD(SadadAdminSessionDataBean sesObj)
	{
		final String methodName = "callUpdateSADAD";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdateSADADRequestType sadadRequestType = new UpdateSADADRequestType();
			sadadRequestType.setMessageHeader(getMessageHeaderType("UPDATE_SADAD", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			sadadRequestType.setSADADAccount(sesObj.getSadadCurrentAccount());
			sadadRequestType.setBankKey(sesObj.getAccountBankId());
			partnerProfileService.updateSADAD(sadadRequestType);

			// Update MAX_REFUND_LIMIT
			UpdatePartnerConfigurationRequestType req = new UpdatePartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("UPDATE_SADAD_CONFIGURATION", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setPartnerKey(sesObj.getSadadId());
			PartnerConfigurationType pct = new PartnerConfigurationType();
			pct.setConfigurationName("REFUND_SYSTEM_CONFIGURATION"); // TODO - Read configuration name from Sada Dynamic Config porperties
			PartnerConfigurationAttributesType pcats = new PartnerConfigurationAttributesType();
			PartnerConfigurationAttributeType pcat = new PartnerConfigurationAttributeType();
			pcat.setAttributeName("SADAD_REFUND_LIMITS");// TODO - Read attribute name from Sada Dynamic Config porpertiesa
			pcat.setId(sesObj.getRefundConfigId());
			pcat.setAttributeId(sesObj.getRefundAttributeId());
			pcat.getValue().add(String.valueOf(sesObj.getRefundMaxLimit()));
			pcats.getAttribute().add(pcat);
			pct.setAttributes(pcats);
			req.setPartnerConfiguration(pct);
			partnerProfileService.updatePartnerConfiguration(req);
			// sesObj.setGenericInfoMessage();
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
		CACHE_REFRESH_FLAG = true;
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
}