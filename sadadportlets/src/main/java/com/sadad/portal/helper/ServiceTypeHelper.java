/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.schema.referencedata._1.AccountTypeType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccountTypeRqType;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.ServiceTypeSessionDataBean;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ServiceTypeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = ServiceTypeHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	public ServiceTypeSessionDataBean callListAccountType(ServiceTypeSessionDataBean sesObj)//(String serviceType)
	{
		final String methodName = "callListAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListAccountTypeRqType lptReq = new ListAccountTypeRqType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_ACCOUNT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			lptReq.setServiceType(sesObj.getServiceTypeCode());
			
			ListAccountTypeRsType lbtRes = referenceDataService.listAccountType(lptReq);
			sesObj.setServiceTypeList(new ArrayList<ServiceTypeSessionDataBean>());
			if (lbtRes.getAccountType() != null)
			{
				for (AccountTypeType ptt : lbtRes.getAccountType())
				{
					ServiceTypeSessionDataBean st = new ServiceTypeSessionDataBean();
					st.setServiceTypeCode(ptt.getServiceType());
					st.setDescription(ptt.getDescription());
					st.setStatus(ptt.getStatus().value());

					sesObj.getServiceTypeList().add(st);
				}
			}
		}
		catch (ReferenceDataFault e)
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

	public ServiceTypeSessionDataBean callGetAccountType(ServiceTypeSessionDataBean sesObj)//(String serviceType)
	{
		final String methodName = "callGetAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			ListAccountTypeRqType getAccountTypeRq = new ListAccountTypeRqType();
			getAccountTypeRq.setMessageHeader(getMessageHeaderType("GET_ACCOUNT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			getAccountTypeRq.setServiceType(sesObj.getServiceTypeCode());
			ListAccountTypeRsType lACRes = referenceDataService.getAccountType(getAccountTypeRq);

			// Clear any previous detail from Session and put new Object
			sesObj.setSelectedServiceType(new ServiceTypeSessionDataBean());
			
			if (lACRes.getAccountType() != null)
			{
				for (AccountTypeType ptt : lACRes.getAccountType())
				{
					sesObj.getSelectedServiceType().setServiceTypeCode(ptt.getServiceType());
					sesObj.getSelectedServiceType().setDescription(ptt.getDescription());
					sesObj.getSelectedServiceType().setStatus(ptt.getStatus().value());
				}
			}
		}
		catch (ReferenceDataFault e)
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
	 * Call to change the status of the Service Type, from ACTIVE to INACTIVE, and from INACTIVE to ACTIVE
	 * @param sesObj
	 * @return
	 */
	public ServiceTypeSessionDataBean callActivateOrDeActivateAccountType(ServiceTypeSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if(sesObj.getSelectedServiceType().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				DeactivateAccountTypeRqType dptReq = new DeactivateAccountTypeRqType();
				dptReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_ACCOUNT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dptReq.setServiceType(sesObj.getServiceTypeCode());
				referenceDataService.deactivateAccountType(dptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedServiceType().setStatus(ConfigurationStatusEnum.INACTIVE.value());				
			}
			else if(sesObj.getSelectedServiceType().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				ActivateAccountTypeRqType aptReq = new ActivateAccountTypeRqType();
				aptReq.setMessageHeader(getMessageHeaderType("ACTIVATE_ACCOUNT_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				aptReq.setServiceType(sesObj.getServiceTypeCode());
				referenceDataService.activateAccountType(aptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedServiceType().setStatus(ConfigurationStatusEnum.ACTIVE.value());				
			}
			
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getSelectedServiceType().getServiceTypeCode(), 
					sesObj.getSelectedServiceType().getDescription(), 
					sesObj.getSelectedServiceType().getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
		}
		catch (ReferenceDataFault e)
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
	 * Call the backend webservice to create new access channel in database.
	 *  
	 * @param serviceType
	 * @param description
	 */
	public ServiceTypeSessionDataBean callCreateServiceType(ServiceTypeSessionDataBean sesObj)
	{
		final String methodName = "callCreateServiceType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			AccountTypeType act = new AccountTypeType();
			act.setServiceType(sesObj.getServiceTypeCode());
			act.setDescription(sesObj.getDescription());
			act.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getStatus()));
			CreateAccountTypeRqType cacReq = new CreateAccountTypeRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_SERVICE_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cacReq.setAccountType(act);
			referenceDataService.createAccountType(cacReq);
			// if reaches to this point means, update was successfull
			sesObj.setGenericInfoMessage();			
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getServiceTypeCode(),sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
		}
		catch (ReferenceDataFault e)
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
	 * Call the backend webservice to update the existing access channel in database.
	 * @param sesObj
	 * @return
	 */
	public ServiceTypeSessionDataBean callUpdateAccountType(ServiceTypeSessionDataBean sesObj)
	{
		final String methodName = "callCreateServiceType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			AccountTypeType act = new AccountTypeType();
			act.setServiceType(sesObj.getServiceTypeCode());
			act.setDescription(sesObj.getDescription());
			act.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getSelectedServiceType().getStatus()));
			UpdateAccountTypeRqType uacReq = new UpdateAccountTypeRqType();
			uacReq.setMessageHeader(getMessageHeaderType("UPDATE_SERVICE_TYPE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			uacReq.setAccountType(act);
			referenceDataService.updateAccountType(uacReq);
			// if it reaches here it means there is no issue, so update the sesObj values
			sesObj.getSelectedServiceType().setServiceTypeCode(sesObj.getServiceTypeCode());
			sesObj.getSelectedServiceType().setDescription(sesObj.getDescription());
			
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getServiceTypeCode(),sesObj.getDescription(), sesObj.getSelectedServiceType().getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCOUNT_TYPE_LIST);
		}
		catch (ReferenceDataFault e)
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
	public ServiceTypeSessionDataBean clearSessionBeanObject(ServiceTypeSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}