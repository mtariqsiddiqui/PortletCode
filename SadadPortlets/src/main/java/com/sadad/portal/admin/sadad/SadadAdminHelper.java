package com.sadad.portal.admin.sadad;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetSADADResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateSADADRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.SadadAdminSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */
public class SadadAdminHelper extends PortalServiceCallHelper
{
	public static boolean CACHE_REFRESH_FLAG = true;
	private static final String CLASS_NAME = SadadAdminHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private SadadAdminSessionBean sadadAdminObject ;
	
	/**
	 * @return the sadadAdminObject
	 */
	public SadadAdminSessionBean getSadadAdminObject()
	{
		return sadadAdminObject;
	}

	/**
	 * @param sadadAdminObject the sadadAdminObject to set
	 */
	public void setSadadAdminObject(SadadAdminSessionBean sadadAdminObject)
	{
		this.sadadAdminObject = sadadAdminObject;
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	public void callGetSADAD()
	{
		final String methodName = "callGetSADAD";
		logger.entering(CLASS_NAME, methodName);
		if (CACHE_REFRESH_FLAG || sadadAdminObject == null)
		{
			sadadAdminObject = new SadadAdminSessionBean();
			try
			{
				GetSADADRequestType sadadRequestType = new GetSADADRequestType();
				sadadRequestType.setMessageHeader(getMessageHeaderType("GET_SADAD"));
				GetSADADResponseType sadadResponseType = partnerProfileServices.getSADAD(sadadRequestType);
				sadadAdminObject.setSadadId(sadadResponseType.getSADADDetail().getPartnerKey());
				sadadAdminObject.setSadadName(sadadResponseType.getSADADDetail().getName());
				sadadAdminObject.setSadadDescription("SADAD ORGANIZATION ENTITY");
				sadadAdminObject.setSadadCurrentAccount(sadadResponseType.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankAccount().getNumber());
				sadadAdminObject.setAccountBankId(sadadResponseType.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankKey());
				sadadAdminObject.setAccountBankName(sadadResponseType.getSADADDetail().getSADADFinanicialInfo().getSADADCurrentAccount().getBankName());
				sadadAdminObject.setRefundMaxLimit(5); // TODO read it from the call response
				setSadadAdminObject(sadadAdminObject);
			}
			catch (PartnerProfileFaultMsg e)
			{
				sadadAdminObject.setErrorMessage(e.getFaultInfo().getDescription());
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				logger.logp(Level.SEVERE, CLASS_NAME, "getSadadAdmin", e.getFaultInfo().getDescription());

				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				sadadAdminObject.setGenericErrorMessage();
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				sadadAdminObject.setGenericErrorMessage();
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			CACHE_REFRESH_FLAG = false;
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	/**
	 * Call the backend webservice to update the SADAD information
	 * @param accountNumber - Bank account number to be updated
	 * @param bankId - Bank ID of SADAD current account
	 */
	public void callUpdateSADAD(String accountNumber, String bankId)
	{
		final String methodName = "callUpdateSADAD";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UpdateSADADRequestType sadadRequestType = new UpdateSADADRequestType();
			sadadRequestType.setMessageHeader(getMessageHeaderType("UPDATE_SADAD"));
			sadadRequestType.setSADADAccount(accountNumber);
			sadadRequestType.setBankKey(bankId);
			partnerProfileServices.updateSADAD(sadadRequestType);

			sadadAdminObject.setSadadCurrentAccount(accountNumber);
			sadadAdminObject.setAccountBankId(bankId);
			sadadAdminObject.setRefundMaxLimit(9);
			sadadAdminObject.setGenericInfoMessage();
		}
		catch (PartnerProfileFaultMsg e)
		{
			sadadAdminObject.setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			sadadAdminObject.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sadadAdminObject.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		CACHE_REFRESH_FLAG = true;
		logger.exiting(CLASS_NAME, methodName);
	}
}