/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.schema.referencedata._1.AccessChannelType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType;
import com.sadad.ebpp.schema.referencedata._1.UpdateAccessChannelRqType;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.AccessChannelSessionDataBean;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.error._1.ErrorType;


/**
 * @author Tariq Siddiqui
 * 
 */
public class AccessChannelHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = AccessChannelHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * @param accessChannel
	 */
	public AccessChannelSessionDataBean callListAccessChannel(AccessChannelSessionDataBean sesObj)
	{
		final String methodName = "callListAccessChannel";
		logger.entering(CLASS_NAME, methodName, sesObj);
		try
		{
            ListAccessChannelRqType lptReq = new ListAccessChannelRqType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			lptReq.setAccessChannel(sesObj.getAccessChannel());
			ListAccessChannelRsType lbtRes = referenceDataService.listAccessChannel(lptReq);
			if (lbtRes.getAccessChannel() != null)
			{
				sesObj.setAccessChannelList(new ArrayList<AccessChannelSessionDataBean>());
				for (AccessChannelType act : lbtRes.getAccessChannel())
				{					
					AccessChannelSessionDataBean acd = new AccessChannelSessionDataBean();
					acd.setAccessChannel(act.getAccessChannel());
					acd.setDescription(act.getDescription());
					acd.setStatus(act.getStatus().value());
					sesObj.getAccessChannelList().add(acd);
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
	 *  Calls the backend webservice to retrieve the data from database and populate it in local object
	 * @param accessChannel
	 */
	public AccessChannelSessionDataBean callGetAccessChannel(AccessChannelSessionDataBean sesObj)
	{
		final String methodName = "callGetDistrictCode";
		logger.entering(CLASS_NAME, methodName, sesObj);
		try
		{
			// Call the backend service
			ListAccessChannelRqType getAccessChannelRq = new ListAccessChannelRqType();
			getAccessChannelRq.setMessageHeader(getMessageHeaderType("GET_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			getAccessChannelRq.setAccessChannel(sesObj.getAccessChannel());
			ListAccessChannelRsType lACRes = referenceDataService.getAccessChannel(getAccessChannelRq);
			if (lACRes.getAccessChannel() != null)
			{
				// Clear any previous detail from Session and put new Object
				sesObj.setSelectedAccessChannel(new AccessChannelSessionDataBean());
				for (AccessChannelType ptt : lACRes.getAccessChannel())
				{
					sesObj.getSelectedAccessChannel().setAccessChannel(ptt.getAccessChannel());
					sesObj.getSelectedAccessChannel().setDescription(ptt.getDescription());
					sesObj.getSelectedAccessChannel().setStatus(ptt.getStatus().value());
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
	 * Calls the backend webservice to activate or deactivate the accessChannel in system.
	 */
	public AccessChannelSessionDataBean callActivateOrDeActivateAccessChannel(AccessChannelSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if(sesObj.getSelectedAccessChannel().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				DeactivateAccessChannelRqType dacReq = new DeactivateAccessChannelRqType();
				dacReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dacReq.setAccessChannel(sesObj.getAccessChannel());
				referenceDataService.deactivateAccessChannel(dacReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedAccessChannel().setStatus(ConfigurationStatusEnum.INACTIVE.value());				
			}
			else if(sesObj.getSelectedAccessChannel().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				ActivateAccessChannelRqType aacReq = new ActivateAccessChannelRqType();
				aacReq.setMessageHeader(getMessageHeaderType("ACTIVATE_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				aacReq.setAccessChannel(sesObj.getAccessChannel());
				referenceDataService.activateAccessChannel(aacReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedAccessChannel().setStatus(ConfigurationStatusEnum.ACTIVE.value());				
			}
			
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getSelectedAccessChannel().getAccessChannel(), 
					sesObj.getSelectedAccessChannel().getDescription(), 
					sesObj.getSelectedAccessChannel().getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
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
	 * @param accessChannel - Access Channel name to be created
	 * @param description - Access Channel description
	 */
	public AccessChannelSessionDataBean callCreateAccessChannel(AccessChannelSessionDataBean sesObj)
	{
		final String methodName = "callCreateAccessChannel";
		logger.entering(CLASS_NAME, methodName, sesObj);
		try
		{
			// Call the backend service
			AccessChannelType act = new AccessChannelType();
			act.setAccessChannel(sesObj.getAccessChannel());
			act.setDescription(sesObj.getDescription());
			act.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getStatus()));
			CreateAccessChannelRqType cacReq = new CreateAccessChannelRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cacReq.setAccessChannel(act);
			referenceDataService.createAccessChannel(cacReq);
			// if reaches to this point means, update was successfull
			sesObj.setGenericInfoMessage();
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getAccessChannel(), sesObj.getDescription(), sesObj.getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);			
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
	
	
	public AccessChannelSessionDataBean callUpdateAccessChannel(AccessChannelSessionDataBean sesObj)
	{
		final String methodName = "callUpdateAccessChannel";
		logger.entering(CLASS_NAME, methodName, sesObj);
		try
		{
			// Call the backend service
			AccessChannelType act = new AccessChannelType();
			act.setAccessChannel(sesObj.getAccessChannel());
			act.setDescription(sesObj.getDescription());
			act.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getSelectedAccessChannel().getStatus()));
			UpdateAccessChannelRqType uacReq = new UpdateAccessChannelRqType();
			uacReq.setMessageHeader(getMessageHeaderType("UPDATE_ACCESS_CHANNEL", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			uacReq.setAccessChannel(act);
			referenceDataService.updateAccessChannel(uacReq);
			// if reaches to this point means, update was successfull
			sesObj.getSelectedAccessChannel().setDescription(sesObj.getDescription());
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getAccessChannel(), sesObj.getDescription(), sesObj.getSelectedAccessChannel().getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_ACCESS_CHANNEL_LIST);
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
	public AccessChannelSessionDataBean clearSessionBeanObject(AccessChannelSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}