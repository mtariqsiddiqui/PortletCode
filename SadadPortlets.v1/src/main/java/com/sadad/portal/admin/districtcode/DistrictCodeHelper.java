/**
 * 
 */
package com.sadad.portal.admin.districtcode;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.schema.referencedata._1.ActivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.CreateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.DeactivateDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.DistrictCodeType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRqType;
import com.sadad.ebpp.schema.referencedata._1.ListDistrictCodeRsType;
import com.sadad.ebpp.wsdl.referencedataservice._1.ReferenceDataFault;
import com.sadad.portal.beans.DistrictCodeDetail;
import com.sadad.portal.beans.DistrictCodeSessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;

/**
 * @author Yameen
 * 
 */
public class DistrictCodeHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = DistrictCodeHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private DistrictCodeSessionBean DistrictCodeObject = new DistrictCodeSessionBean();

	/**
	 * @return the billCategoryObject
	 */
	public DistrictCodeSessionBean getDistrictCodeObject()
	{
		return DistrictCodeObject;
	}

	/**
	 * @param billCategoryObject
	 *            the billCategoryObject to set
	 */
	public void setDistrictCodeObject(DistrictCodeSessionBean DistrictCodeObject)
	{
		this.DistrictCodeObject = DistrictCodeObject;
	}

	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * @param districtCode
	 */
	public void callListDistrictCode()
	{
		final String methodName = "callListDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
//			getDistrictCodeObject().setDistrictCode(districtCode);
			getDistrictCodeObject().setDistrictCodeList(new ArrayList<DistrictCodeDetail>());
			
			ListDistrictCodeRqType ldcReq = new ListDistrictCodeRqType();
			ldcReq.setMessageHeader(getMessageHeaderType("LIST_DISTRICT_CODE"));
//			ldcReq.setDistrictCode(districtCode);
			ListDistrictCodeRsType ldcRes = referenceDataService.listDistrictCode(ldcReq);
			if (ldcRes.getDistrictCode() != null)
			{
				for (DistrictCodeType dct : ldcRes.getDistrictCode())
				{
					DistrictCodeDetail dcd = new DistrictCodeDetail();
					dcd.setDistrictCode(dct.getDistrictCode());
					dcd.setDescription(dct.getDescription());
					dcd.setStatus(dct.getStatus());
					getDistrictCodeObject().getDistrictCodeList().add(dcd);
				}
			}
		}
		catch (ReferenceDataFault e)
		{
			getDistrictCodeObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local object 
	 * @param DistrictCode
	 */
	public void callGetDistrictCode(String DistrictCode)
	{
		final String methodName = "callGetDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Clear any previous detail from Session and put new Object
			getDistrictCodeObject().setSelectedDistrictCode(new DistrictCodeDetail());

			ListDistrictCodeRqType ldcReq = new ListDistrictCodeRqType();
			ldcReq.setMessageHeader(getMessageHeaderType("GET_DISTRICT_CODE"));
			ldcReq.setDistrictCode(DistrictCode);
			ListDistrictCodeRsType ldcRes = referenceDataService.listDistrictCode(ldcReq);
			
			if (ldcRes.getDistrictCode() != null && ldcRes.getDistrictCode().size() == 1)
			{
				DistrictCodeType dct = ldcRes.getDistrictCode().get(0);
				
				getDistrictCodeObject().getSelectedDistrictCode().setDistrictCode(dct.getDistrictCode());
				getDistrictCodeObject().getSelectedDistrictCode().setDescription(dct.getDescription());
				getDistrictCodeObject().getSelectedDistrictCode().setStatus(dct.getStatus());
			}
		}
		catch (ReferenceDataFault e)
		{
			getDistrictCodeObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls the backend webservice to activate or deactivate the districtCode in system.
	 */
	public void callActivateOrDeActivateDistrictCode()
	{
		final String methodName = "callActivateOrDeActivateDistrictCode";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Get the value from session object
			if (getDistrictCodeObject().getSelectedDistrictCode().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				DeactivateDistrictCodeRqType ddcReq = new DeactivateDistrictCodeRqType();
				ddcReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_DISTRICT_CODE"));
				ddcReq.setDistrictCode(getDistrictCodeObject().getDistrictCode());
				referenceDataService.deactivateDistrictCode(ddcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getDistrictCodeObject().getSelectedDistrictCode().setStatus(ConfigurationStatusEnum.INACTIVE);
			}
			else if (getDistrictCodeObject().getSelectedDistrictCode().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				ActivateDistrictCodeRqType adcReq = new ActivateDistrictCodeRqType();
				adcReq.setMessageHeader(getMessageHeaderType("ACTIVATE_DISTRICT_CODE"));
				adcReq.setDistrictCode(getDistrictCodeObject().getDistrictCode());
				referenceDataService.activateDistrictCode(adcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getDistrictCodeObject().getSelectedDistrictCode().setStatus(ConfigurationStatusEnum.ACTIVE);
			}
		}
		catch (ReferenceDataFault e)
		{
			getDistrictCodeObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Calls the backend webservice to create a new district code in database
	 * 
	 * @param districtCode - District Code to be created
	 * @param description - Description for the District Code
	 */
	public void callCreateDistrictCode(String districtCode, String description)
	{
		final String methodName = "callCreateDistrictCode";
		Object params[] = { districtCode, description };
		logger.entering(CLASS_NAME, methodName, params);
		try
		{
			// Clear any previous detail from Session and put new Object
			getDistrictCodeObject().setSelectedDistrictCode(new DistrictCodeDetail());
			// Call the backend service
			DistrictCodeType dct = new DistrictCodeType();
			dct.setDistrictCode(districtCode);
			dct.setDescription(description);
			dct.setStatus(ConfigurationStatusEnum.ACTIVE);
			CreateDistrictCodeRqType cacReq = new CreateDistrictCodeRqType();
			cacReq.setMessageHeader(getMessageHeaderType("CREATE_DISTRICT_CODE"));
			cacReq.setDistrictCode(dct);
			referenceDataService.createDistrictCode(cacReq);
		}
		catch (ReferenceDataFault e)
		{
			getDistrictCodeObject().setErrorMessage(e.getFaultInfo().getDescription());
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (DatatypeConfigurationException e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			getDistrictCodeObject().setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}