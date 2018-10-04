/**
 * 
 */
package com.sadad.portal.admin.accesschannel;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.schema.referencedata._1.AccessChannelType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccessChannelRsType;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.AccessChannelDetail;
import com.sadad.portal.beans.AccessChannelSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;


/**
 * @author Yameen
 * 
 */
public class AccessChannelHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = AccessChannelHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private AccessChannelSessionBean AccessChannelObject = new AccessChannelSessionBean();
	
	public AccessChannelSessionBean getAccessChannelObject()
	{
		return AccessChannelObject;
	}

	public void setAccessChannelObject(AccessChannelSessionBean accessChannelObject)
	{
		AccessChannelObject = accessChannelObject;
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * @param accessChannel
	 */
	public void callListAccessChannel(String accessChannel)
	{
		final String methodName = "callListAccessChannel";
		logger.entering(CLASS_NAME, methodName, accessChannel);
		try
		{
			getAccessChannelObject().setAccessChannel(accessChannel);
			getAccessChannelObject().setAccessChannelList(new ArrayList<AccessChannelDetail>());
            ListAccessChannelRqType lptReq = new ListAccessChannelRqType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_ACCESS_CHANNEL"));
			lptReq.setAccessChannel(accessChannel);
			ListAccessChannelRsType lbtRes = referenceDataService.listAccessChannel(lptReq);
			if (lbtRes.getAccessChannel() != null)
			{
				for (AccessChannelType ptt : lbtRes.getAccessChannel())
				{					
					AccessChannelDetail ptd = new AccessChannelDetail();
					ptd.setAccessChannel(ptt.getAccessChannel());
					ptd.setDescription(ptt.getDescription());
					ptd.setStatus(ptt.getStatus());
					getAccessChannelObject().getAccessChannelList().add(ptd);
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
		catch (ReferenceDataFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 *  Calls the backend webservice to retrieve the data from database and populate it in local object
	 * @param accessChannel
	 */
	public void callGetAccessChannel(String accessChannel)
	{
		final String methodName = "callGetDistrictCode";
		logger.entering(CLASS_NAME, methodName, accessChannel);
		try
		{
			// Clear any previous detail from Session and put new Object
			getAccessChannelObject().setSelectedAccessChannel(new AccessChannelDetail());
			// Call the backend service
			ListAccessChannelRqType getAccessChannelRq = new ListAccessChannelRqType();
			getAccessChannelRq.setMessageHeader(getMessageHeaderType("GET_ACCESS_CHANNEL"));
			getAccessChannelRq.setAccessChannel(accessChannel);
			ListAccessChannelRsType lACRes = referenceDataService.getAccessChannel(getAccessChannelRq);
			if (lACRes.getAccessChannel() != null)
			{
				for (AccessChannelType ptt : lACRes.getAccessChannel())
				{
					getAccessChannelObject().getSelectedAccessChannel().setAccessChannel(ptt.getAccessChannel());
					getAccessChannelObject().getSelectedAccessChannel().setDescription(ptt.getDescription());
					getAccessChannelObject().getSelectedAccessChannel().setStatus(ptt.getStatus());
				}
			}
		}
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls the backend webservice to activate or deactivate the accessChannel in system.
	 */
	public void callActivateOrDeActivateAccessChannel()
	{
		final String methodName = "callActivateOrDeActivateDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if(getAccessChannelObject().getSelectedAccessChannel().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				DeactivateAccessChannelRqType dacReq = new DeactivateAccessChannelRqType();
				dacReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_ACCESS_CHANNEL"));
				dacReq.setAccessChannel(getAccessChannelObject().getAccessChannel());
				referenceDataService.deactivateAccessChannel(dacReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getAccessChannelObject().getSelectedAccessChannel().setStatus(ConfigurationStatusEnum.INACTIVE);				
			}
			else if(getAccessChannelObject().getSelectedAccessChannel().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				ActivateAccessChannelRqType aacReq = new ActivateAccessChannelRqType();
				aacReq.setMessageHeader(getMessageHeaderType("ACTIVATE_ACCESS_CHANNEL"));
				aacReq.setAccessChannel(getAccessChannelObject().getAccessChannel());
				referenceDataService.activateAccessChannel(aacReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getAccessChannelObject().getSelectedAccessChannel().setStatus(ConfigurationStatusEnum.ACTIVE);				
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
		catch (ReferenceDataFault e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}		
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Call the backend webservice to create new access channel in database.
	 * 
	 * @param accessChannel - Access Channel name to be created
	 * @param description - Access Channel description
	 */
	public void callCreateAccessChannel(String accessChannel, String description)
	{
		final String methodName = "callCreateAccessChannel";
		Object params[] = { accessChannel, description };
		logger.entering(CLASS_NAME, methodName, params);
		try
		{
			// Clear any previous detail from Session and put new Object
			getAccessChannelObject().setSelectedAccessChannel(new AccessChannelDetail());
			// Call the backend service
			AccessChannelType act = new AccessChannelType();
			act.setAccessChannel(accessChannel);
			act.setDescription(description);
			act.setStatus(ConfigurationStatusEnum.ACTIVE);
			CreateAccessChannelRqType cacReq = new CreateAccessChannelRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_ACCESS_CHANNEL"));
			cacReq.setAccessChannel(act);
			referenceDataService.createAccessChannel(cacReq);
		}
		catch (NullPointerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}	
}