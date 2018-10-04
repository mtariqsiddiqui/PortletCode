/**
 * 
 */
package com.sadad.portal.admin.billcategory;

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
import com.sadad.portal.beans.BillCategoryDetail;
import com.sadad.portal.beans.BillCategorySessionBean;
import com.sadad.portal.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.BillCategoryDetailType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillCategoryHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BillCategoryHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	private BillCategorySessionBean billCategoryObject = new BillCategorySessionBean();

	/**
	 * @return the billCategoryObject
	 */
	public BillCategorySessionBean getBillCategoryObject()
	{
		return billCategoryObject;
	}

	/**
	 * @param billCategoryObject
	 *            the billCategoryObject to set
	 */
	public void setBillCategoryObject(BillCategorySessionBean billCategoryObject)
	{
		this.billCategoryObject = billCategoryObject;
	}

	
	/**
	 * Calls the backend webservice to create bill category object in database
	 * 
	 * @param partnerKey
	 * @param billerCategory
	 * @param description
	 */
	public void callCreateBillCategory(String partnerKey, String billerCategory, String description)
	{
		final String methodName = "callListBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CreateBillCategoryRequestType billCategory = new CreateBillCategoryRequestType();
			BillCategoryDetailType billCategoryDetail = new BillCategoryDetailType();
			
			billCategoryDetail.setBillCategory(billerCategory);
			billCategoryDetail.setDescription(description);
			billCategoryDetail.setStatus(ConfigurationStatusEnum.ACTIVE);
			
			billCategory.setMessageHeader(getMessageHeaderType("CREATE_BILL_CATEGORY"));
			billCategory.setPartnerKey(partnerKey);
			billCategory.setBillCategoryDetail(billCategoryDetail);
			
			partnerProfileServices.createBillCategory(billCategory);
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
	public void callListBillCategory(String partnerKey)
	{
		final String methodName = "callListBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			getBillCategoryObject().setBillCategoryList(new ArrayList<BillCategoryDetail>());
			getBillCategoryObject().setPartnerKey(partnerKey);
			ListBillCategoryRequestType lbcReq = new ListBillCategoryRequestType();
			lbcReq.setMessageHeader(getMessageHeaderType("LIST_BILL_CATEGORY"));
			lbcReq.setPartnerKey(partnerKey);
			ListBillCategoryResponseType lbcRes = partnerProfileServices.listBillCategory(lbcReq);

			if (lbcRes.getBillCategories().getBillCategoryDetail() != null)
			{
				for (BillCategoryDetailType bct : lbcRes.getBillCategories().getBillCategoryDetail())
				{
					BillCategoryDetail bcd = new BillCategoryDetail();
					bcd.setBillCategory(bct.getBillCategory());
					bcd.setDescription(bct.getDescription());
					bcd.setStatus(bct.getStatus());

					getBillCategoryObject().getBillCategoryList().add(bcd);
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
	
	/**
	 * Calls the backend webservice to retrieve the data from database and populate into the local session object
	 * 
	 * @param partnerKey
	 * @param billCategory
	 */
	public void callGetBillCategory(String partnerKey, String billCategory)
	{
		final String methodName = "callGetBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetBillCategoryRequestType gbcReq = new GetBillCategoryRequestType();
			gbcReq.setMessageHeader(getMessageHeaderType("GET_BILL_CATEGORY"));
			gbcReq.setPartnerKey(partnerKey);
			gbcReq.setBillCategory(billCategory);			
			GetBillCategoryResponseType gbcRes = partnerProfileServices.getBillCategory(gbcReq);
			
			// Clear any previous detail from Session and put new Object
			// Set the service response values in Session Object
			getBillCategoryObject().setSelectedBillCategory(new BillCategoryDetail());
			getBillCategoryObject().getSelectedBillCategory().setBillCategory(gbcRes.getBillCategoryDetail().getBillCategory());
			getBillCategoryObject().getSelectedBillCategory().setDescription(gbcRes.getBillCategoryDetail().getDescription());
			getBillCategoryObject().getSelectedBillCategory().setStatus(gbcRes.getBillCategoryDetail().getStatus());
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
	 * Calls the backend webservice to update the data in database
	 * 
	 * @param description
	 */
	public void callUpdateBillCategory(String description)
	{
		final String methodName = "callUpdateBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			getBillCategoryObject().getSelectedBillCategory().setDescription(description);

			// Call the backend service
			UpdateBillCategoryRequestType ubcReq = new UpdateBillCategoryRequestType();
			ubcReq.setMessageHeader(getMessageHeaderType("GET_BILL_CATEGORY"));
			ubcReq.setPartnerKey(getBillCategoryObject().getPartnerKey());
			
			BillCategoryDetailType bcdt = new BillCategoryDetailType();
			bcdt.setBillCategory(getBillCategoryObject().getSelectedBillCategory().getBillCategory());
			bcdt.setDescription(getBillCategoryObject().getSelectedBillCategory().getDescription());
			bcdt.setStatus(getBillCategoryObject().getSelectedBillCategory().getStatus());
			
			ubcReq.setBillCategoryDetail(bcdt);
			partnerProfileServices.updateBillCategory(ubcReq);
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
	 * Calls the backend webservice to activate or deactivate Bill Category object
	 */
	public void callActivateOrDeActivateBillCategory()
	{
		final String methodName = "callActivateOrDeActivateBillCategory";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if(getBillCategoryObject().getSelectedBillCategory().getStatus().equals(ConfigurationStatusEnum.ACTIVE))
			{
				// Call the backend service - DeActivate
				DeactivateBillCategoryRequestType dbcReq = new DeactivateBillCategoryRequestType();
				dbcReq.setMessageHeader(getMessageHeaderType("DEACTIVATE_BILL_CATEGORY"));
				dbcReq.setPartnerKey(getBillCategoryObject().getPartnerKey());
				dbcReq.setBillCategory(getBillCategoryObject().getSelectedBillCategory().getBillCategory());
				partnerProfileServices.deactivateBillCategory(dbcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBillCategoryObject().getSelectedBillCategory().setStatus(ConfigurationStatusEnum.INACTIVE);
			}
			else if(getBillCategoryObject().getSelectedBillCategory().getStatus().equals(ConfigurationStatusEnum.INACTIVE))
			{
				// Call the backend service - Activate
				ActivateBillCategoryRequestType abcReq = new ActivateBillCategoryRequestType();
				abcReq.setMessageHeader(getMessageHeaderType("ACTIVATE_BILL_CATEGORY"));
				abcReq.setPartnerKey(getBillCategoryObject().getPartnerKey());
				abcReq.setBillCategory(getBillCategoryObject().getSelectedBillCategory().getBillCategory());
				partnerProfileServices.activateBillCategory(abcReq);
				// if it reaches here, it means response is successfull change status manually in session object
				getBillCategoryObject().getSelectedBillCategory().setStatus(ConfigurationStatusEnum.ACTIVE);
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
}
