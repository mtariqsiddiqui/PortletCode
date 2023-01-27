/**
 * 
 */
package com.sadad.portal.admin.servicetype;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.schema.referencedata._1.AccountTypeType;
import com.sadad.ebpp.schema.referencedata._1.ActivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListAccountTypeRsType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.ServiceTypeDetail;
import com.sadad.portal.beans.ServiceTypeSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;


/**
 * @author Yameen
 * 
 */
public class ServiceTypeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = ServiceTypeHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private ServiceTypeSessionBean ServiceTypeObject = new ServiceTypeSessionBean();

	public ServiceTypeSessionBean getServiceTypeObject()
	{
		return ServiceTypeObject;
	}

	public void setServiceTypeObject(ServiceTypeSessionBean serviceTypeObject)
	{
		ServiceTypeObject = serviceTypeObject;
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	public void callListAccountType(String serviceType)
	{
		final String methodName = "callListAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			getServiceTypeObject().setServiceType(serviceType);
			getServiceTypeObject().setServiceTypeList(new ArrayList<ServiceTypeDetail>());
		
			ListAccountTypeRqType lptReq = new ListAccountTypeRqType();
			lptReq.setMessageHeader(getMessageHeaderType("LIST_ACCOUNT_TYPE"));
			lptReq.setServiceType(serviceType);
			
			ListAccountTypeRsType lbtRes = referenceDataService.listAccountType(lptReq);
			if (lbtRes.getAccountType() != null)
			{
				for (AccountTypeType ptt : lbtRes.getAccountType())
				{
					ServiceTypeDetail ptd = new ServiceTypeDetail();
					ptd.setServiceType(ptt.getServiceType());
					ptd.setDescription(ptt.getDescription());
					ptd.setStatus(ptt.getStatus());
				
					getServiceTypeObject().getServiceTypeList().add(ptd);
				}
			}
		}
		catch (ReferenceDataFault e)
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
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}	
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * 
	 * @param serviceType
	 */
	public void callGetAccountType(String serviceType)
	{
		final String methodName = "callGetAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Clear any previous detail from Session and put new Object
			getServiceTypeObject().setSelectedServiceType(new ServiceTypeDetail());
			
			// Call the backend service
			ListAccountTypeRqType getAccountTypeRq = new ListAccountTypeRqType();
			getAccountTypeRq.setMessageHeader(getMessageHeaderType("GET_ACCOUNT_TYPE"));
			getAccountTypeRq.setServiceType(serviceType);
			ListAccountTypeRsType lACRes = referenceDataService.getAccountType(getAccountTypeRq);
			if (lACRes.getAccountType() != null)
			{
				for (AccountTypeType ptt : lACRes.getAccountType())
				{
					getServiceTypeObject().getSelectedServiceType().setServiceType(ptt.getServiceType());
					getServiceTypeObject().getSelectedServiceType().setDescription(ptt.getDescription());
					getServiceTypeObject().getSelectedServiceType().setStatus(ptt.getStatus());
				}
			}
		}
		catch (ReferenceDataFault e)
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
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * 
	 */
	public void callActivateOrDeActivateAccountType()
	{
		final String methodName = "callActivateOrDeActivateAccountType";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if(getServiceTypeObject().getSelectedServiceType().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				DeactivateAccountTypeRqType dptReq = new DeactivateAccountTypeRqType();
				dptReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_ACCOUNT_TYPE"));
				dptReq.setServiceType(getServiceTypeObject().getServiceType());
				referenceDataService.deactivateAccountType(dptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getServiceTypeObject().getSelectedServiceType().setStatus(ConfigurationStatusEnum.INACTIVE);				
			}
			else if(getServiceTypeObject().getSelectedServiceType().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				ActivateAccountTypeRqType aptReq = new ActivateAccountTypeRqType();
				aptReq.setMessageHeader(getMessageHeaderType("ACTIVATE_ACCOUNT_TYPE"));
				aptReq.setServiceType(getServiceTypeObject().getServiceType());
				referenceDataService.activateAccountType(aptReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getServiceTypeObject().getSelectedServiceType().setStatus(ConfigurationStatusEnum.ACTIVE);				
			}
		}
		catch (ReferenceDataFault e)
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
		catch (Exception e)
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
	public void callCreateServiceType(String serviceType, String description)
	{
		final String methodName = "callCreateServiceType";
		Object params[] = { serviceType, description };
		logger.entering(CLASS_NAME, methodName, params);
		try
		{
			// Clear any previous detail from Session and put new Object
			getServiceTypeObject().setSelectedServiceType(new ServiceTypeDetail());
			// Call the backend service
			AccountTypeType act = new AccountTypeType();
			act.setServiceType(serviceType);
			act.setDescription(description);
			act.setStatus(ConfigurationStatusEnum.ACTIVE);
			CreateAccountTypeRqType cacReq = new CreateAccountTypeRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_SERVICE_TYPE"));
			cacReq.setAccountType(act);
			referenceDataService.createAccountType(cacReq);
		}
		catch (ReferenceDataFault e)
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
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}	
		logger.exiting(CLASS_NAME, methodName);
	}

	public void callUpdateAccountType(String parameter, String parameter2)
	{
		// TODO Auto-generated method stub
		
	}
}
