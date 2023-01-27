/**
 * 
 */
package com.sadad.portal.helper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ActivateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeactivateBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.ListBillCategoryResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdateBillCategoryRequestType;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BillCategorySessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BillCategoryDetailType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillCategoryHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BillCategoryHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to create bill category object in database
	 * 
	 * @param partnerKey
	 * @param billerCategory
	 * @param description
	 */
	public BillCategorySessionDataBean callCreateBillCategory(BillCategorySessionDataBean sesObj)
	{
		final String methodName = "callListBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBillCategoryRequestType billCategory = new CreateBillCategoryRequestType();
			BillCategoryDetailType billCategoryDetail = new BillCategoryDetailType();
			
			billCategoryDetail.setBillCategory(sesObj.getBillCategory());
			billCategoryDetail.setDescription(sesObj.getDescription());
			billCategoryDetail.setStatus(ConfigurationStatusEnum.ACTIVE);
			
			billCategory.setMessageHeader(getMessageHeaderType("CREATE_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			billCategory.setPartnerKey(sesObj.getBillerId());
			billCategory.setBillCategoryDetail(billCategoryDetail);
			
			partnerProfileService.createBillCategory(billCategory);
			sesObj.setGenericInfoMessage();
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
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate it in local List object
	 * 
	 * @throws DatatypeConfigurationException
	 * @throws PartnerProfileFaultMsg
	 */
	public BillCategorySessionDataBean callListBillCategory(BillCategorySessionDataBean sesObj)
	{
		final String methodName = "callListBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			sesObj.setBillCategoryList(new ArrayList<BillCategorySessionDataBean>());

			ListBillCategoryRequestType lbcReq = new ListBillCategoryRequestType();
			lbcReq.setMessageHeader(getMessageHeaderType("LIST_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			lbcReq.setPartnerKey(sesObj.getBillerId());
			ListBillCategoryResponseType lbcRes = partnerProfileService.listBillCategory(lbcReq);
			if(lbcRes != null && lbcRes.getBillCategories() != null && lbcRes.getBillCategories().getBillCategoryDetail() != null)			
			{
				for (BillCategoryDetailType bct : lbcRes.getBillCategories().getBillCategoryDetail())
				{
					BillCategorySessionDataBean bcd = new BillCategorySessionDataBean();
					bcd.setBillCategory(bct.getBillCategory());
					bcd.setDescription(bct.getDescription());
					bcd.setStatus(bct.getStatus().value());
					sesObj.getBillCategoryList().add(bcd);
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
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate into the local session object
	 * 
	 * @param partnerKey
	 * @param billCategory
	 */
	public BillCategorySessionDataBean callGetBillCategory(BillCategorySessionDataBean sesObj)
	{
		final String methodName = "callGetBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetBillCategoryRequestType gbcReq = new GetBillCategoryRequestType();
			gbcReq.setMessageHeader(getMessageHeaderType("GET_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			gbcReq.setPartnerKey(sesObj.getBillerId());
			gbcReq.setBillCategory(sesObj.getBillCategory());			
			GetBillCategoryResponseType gbcRes = partnerProfileService.getBillCategory(gbcReq);
			
			// Clear any previous detail from Session and put new Object
			// Set the service response values in Session Object
			sesObj.setSelectedBillCategory(new BillCategorySessionDataBean());
			sesObj.getSelectedBillCategory().setBillerId(sesObj.getBillerId());
			sesObj.getSelectedBillCategory().setBillCategory(gbcRes.getBillCategoryDetail().getBillCategory());
			sesObj.getSelectedBillCategory().setDescription(gbcRes.getBillCategoryDetail().getDescription());
			sesObj.getSelectedBillCategory().setStatus(gbcRes.getBillCategoryDetail().getStatus().value());
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
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to update the data in database
	 * 
	 * @param description
	 */
	public BillCategorySessionDataBean callUpdateBillCategory(BillCategorySessionDataBean sesObj)
	{
		final String methodName = "callUpdateBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			sesObj.getSelectedBillCategory().setDescription(sesObj.getDescription());

			// Call the backend service
			UpdateBillCategoryRequestType ubcReq = new UpdateBillCategoryRequestType();
			ubcReq.setMessageHeader(getMessageHeaderType("GET_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			ubcReq.setPartnerKey(sesObj.getBillerId());
			
			BillCategoryDetailType bcdt = new BillCategoryDetailType();
			bcdt.setBillCategory(sesObj.getSelectedBillCategory().getBillCategory());
			bcdt.setDescription(sesObj.getSelectedBillCategory().getDescription());
			bcdt.setStatus(ConfigurationStatusEnum.fromValue(sesObj.getSelectedBillCategory().getStatus()));
			
			ubcReq.setBillCategoryDetail(bcdt);
			partnerProfileService.updateBillCategory(ubcReq);
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
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to activate or deactivate Bill Category object
	 */
	public BillCategorySessionDataBean callActivateOrDeActivateBillCategory(BillCategorySessionDataBean sesObj)
	{
		final String methodName = "callActivateOrDeActivateBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(sesObj.getSelectedBillCategory().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateBillCategoryRequestType dbcReq = new DeactivateBillCategoryRequestType();
				dbcReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				dbcReq.setPartnerKey(sesObj.getBillerId());
				dbcReq.setBillCategory(sesObj.getSelectedBillCategory().getBillCategory());
				partnerProfileService.deactivateBillCategory(dbcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedBillCategory().setStatus(ConfigurationStatusEnum.INACTIVE.value());
			}
			else if(sesObj.getSelectedBillCategory().getStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateBillCategoryRequestType abcReq = new ActivateBillCategoryRequestType();
				abcReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILL_CATEGORY", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				abcReq.setPartnerKey(sesObj.getBillerId());
				abcReq.setBillCategory(sesObj.getSelectedBillCategory().getBillCategory());
				partnerProfileService.activateBillCategory(abcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				sesObj.getSelectedBillCategory().setStatus(ConfigurationStatusEnum.ACTIVE.value());
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
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public BillCategorySessionDataBean clearSessionBeanObject(BillCategorySessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}