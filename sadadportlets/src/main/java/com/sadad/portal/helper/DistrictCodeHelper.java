/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.schema.referencedata._1.ActivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.DistrictCodeType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRsType;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.DistrictCodeSessionDataBean;
import com.sadad.portal.common.cache.ReferenceDataListCache;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class DistrictCodeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = DistrictCodeHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * @param districtCode
	 */
	public DistrictCodeSessionDataBean callListDistrictCode(DistrictCodeSessionDataBean sesObj)
	{
		final String methodName = "callListDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			sesObj.setDistrictCodeList(new ArrayList<DistrictCodeSessionDataBean>());
			
			ListDistrictCodeRqType ldcReq = new ListDistrictCodeRqType();
			ldcReq.setMessageHeader(getMessageHeaderType("LIST_DISTRICT_CODE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			// ldcReq.setDistrictCode(districtCode);
			ListDistrictCodeRsType ldcRes = referenceDataService.listDistrictCode(ldcReq);
			if (ldcRes.getDistrictCode() != null)
			{
				for (DistrictCodeType dct : ldcRes.getDistrictCode())
				{
					DistrictCodeSessionDataBean dcd = new DistrictCodeSessionDataBean();
					dcd.setDistrictCode(dct.getDistrictCode());
					dcd.setDescription(dct.getDescription());
					dcd.setStatus(dct.getStatus().value());
					sesObj.getDistrictCodeList().add(dcd);
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
	 * Calls the backend webservice to retrieve the data from database and populate it in local object 
	 * @param DistrictCode
	 */
	public DistrictCodeSessionDataBean callGetDistrictCode(DistrictCodeSessionDataBean sesObj)
	{
		final String methodName = "callGetDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Clear any previous detail from Session and put new Object
			sesObj.setSelectedDistrictCode(new DistrictCodeSessionDataBean());

			ListDistrictCodeRqType ldcReq = new ListDistrictCodeRqType();
			ldcReq.setMessageHeader(getMessageHeaderType("GET_DISTRICT_CODE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			ldcReq.setDistrictCode(sesObj.getDistrictCode());
			ListDistrictCodeRsType ldcRes = referenceDataService.listDistrictCode(ldcReq);

			if (ldcRes.getDistrictCode() != null && ldcRes.getDistrictCode().size() == 1)
			{
				DistrictCodeType dct = ldcRes.getDistrictCode().get(0);
				sesObj.getSelectedDistrictCode().setDistrictCode(dct.getDistrictCode());
				sesObj.getSelectedDistrictCode().setDescription(dct.getDescription());
				sesObj.getSelectedDistrictCode().setStatus(dct.getStatus().value());
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
	 * Calls the backend webservice to activate or deactivate the districtCode in system.
	 */
	public DistrictCodeSessionDataBean callActivateOrDeActivateDistrictCode(DistrictCodeSessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if (sesObj.getSelectedDistrictCode().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				DeactivateDistrictCodeRqType ddcReq = new DeactivateDistrictCodeRqType();
				ddcReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_DISTRICT_CODE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				ddcReq.setDistrictCode(sesObj.getDistrictCode());
				referenceDataService.deactivateDistrictCode(ddcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedDistrictCode().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if (sesObj.getSelectedDistrictCode().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				ActivateDistrictCodeRqType adcReq = new ActivateDistrictCodeRqType();
				adcReq.setMessageHeader(getMessageHeaderType("ACTIVATE_DISTRICT_CODE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				adcReq.setDistrictCode(sesObj.getDistrictCode());
				referenceDataService.activateDistrictCode(adcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedDistrictCode().setStatus(ConfigurationStatusEnum.ACTIVE.value());
			}
			
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getSelectedDistrictCode().getDistrictCode(), 
					sesObj.getSelectedDistrictCode().getDescription(), 
					sesObj.getSelectedDistrictCode().getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_DISTRICT_LIST);
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
	 * Calls the backend webservice to create a new district code in database
	 * 
	 * @param districtCode - District Code to be created
	 * @param description - Description for the District Code
	 */
	public DistrictCodeSessionDataBean callCreateDistrictCode(DistrictCodeSessionDataBean sesObj)
	{
		final String methodName = "callCreateDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			DistrictCodeType dct = new DistrictCodeType();
			dct.setDistrictCode(sesObj.getDistrictCode());
			dct.setDescription(sesObj.getDistrictCode());
			dct.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getStatus()));
			CreateDistrictCodeRqType cacReq = new CreateDistrictCodeRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_DISTRICT_CODE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			cacReq.setDistrictCode(dct);
			referenceDataService.createDistrictCode(cacReq);
			// if reaches to this point means, update was successfull
			sesObj.setGenericInfoMessage();
			// Updating the Application Level Cache
			ReferenceDataListCache udlc = new ReferenceDataListCache(sesObj.getDistrictCode(), sesObj.getDistrictCode(), sesObj.getStatus());
			sesObj.setCacheObj(udlc);
			sesObj.setCacheRefreshType(PortalConstant.LOOKUP_DISTRICT_LIST);
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
	public DistrictCodeSessionDataBean clearSessionBeanObject(DistrictCodeSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}