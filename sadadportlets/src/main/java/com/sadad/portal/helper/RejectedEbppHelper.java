/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.wsdl.bulkuploadquery._1.BulkQueryFault;
import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.Bill;
import com.sadad.portal.beans.Payment;
import com.sadad.portal.beans.RejectedEbppSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.schema.service.bulkuploadquery._1.EntityTypeEnum;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRsType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRsType;
import com.sadad.schema.service.bulkuploadquery._1.RejectedAccountType;
import com.sadad.schema.service.bulkuploadquery._1.RejectedBillType;
import com.sadad.schema.service.bulkuploadquery._1.RejectedPaymentType;
import com.sadad.scm.error._1.ErrorType;

/**
 * @author Tariq Siddiqui
 *
 */
public class RejectedEbppHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = RejectedEbppHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	// Bulk Upload Query Calls Code Starts Here
	/**
	 * Calls the backend webservice to get the single rejected account or bill or payment or refund,
	 * based on the input paramenter.
	 * 
	 * @param coreObj - RejectedEbppSessionDataBean object which contains the values for input parameter
	 * @return coreObj - RejectedEbppSessionDataBean object which contains the values for rendering on page
	 */
	public RejectedEbppSessionDataBean callBulkUploadService_GetRejected(RejectedEbppSessionDataBean coreObj)
	{
		final String methodName = "callBulkUploadService_GetRejected";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetRejectedRqType req = new GetRejectedRqType();
			req.setMessageHeader(getMessageHeaderType("BULK_UPLOAD-GET_REJECTED", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setSearchType(EntityTypeEnum.fromValue(coreObj.getSearchType()));			
			req.setRqUID(coreObj.getRquid());
			if(coreObj.getBillerId() != null)
				req.setBillerKey(coreObj.getBillerId());
			// Biller users can only check data for their organisation
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());
			
			if(coreObj.getEbppEntityKey() != null)
			{
				if(coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.ACCOUNT.value()))
					req.setAccountKey(coreObj.getEbppEntityKey());
				if(coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.BILL.value()))
					req.setBillKey(coreObj.getEbppEntityKey());
				if(coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.PAYMENT.value()))
					req.setBLRPTN(coreObj.getEbppEntityKey());
			}

			GetRejectedRsType res = bulkUploadService.getRejected(req);
			coreObj.setRquid(res.getRqUID());

			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.ACCOUNT.value()))
			{
				coreObj.setRejectedAccounts(null);
				Account ra = new Account();
				ra.setFileName(res.getFileName());
				ra.setErrorCode(String.valueOf(res.getStatus().getStatusCode()));
				ra.setErrorDesc(res.getStatus().getStatusDesc());
				ra.setAccountNumber(res.getAccountInfo().getAccountKey());
				ra.setBillerId(res.getAccountInfo().getBillerKey());
				ra.setServiceType(res.getAccountInfo().getServiceType());
				coreObj.setBillerId(ra.getBillerId());
				coreObj.getRejectedAccounts().add(ra);
			}
			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.BILL.value()))
			{
				coreObj.setRejectedBills(null);
				Bill rb = new Bill();
				rb.setFileName(res.getFileName());
				rb.setErrorCode(String.valueOf(res.getStatus().getStatusCode()));
				rb.setErrorDesc(res.getStatus().getStatusDesc());
				rb.setBillNumber((res.getBill().getBillKey()));
				rb.setBillerId(res.getBill().getBillerKey());
				rb.setBillCategory(res.getBill().getBillCategory());
				rb.setBillCycle(res.getBill().getBillCycle());
				rb.setServiceType(res.getBill().getServiceType());
				coreObj.setBillerId(rb.getBillerId());
				coreObj.getRejectedBills().add(rb);
			}
			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.PAYMENT.value()))
			{
				coreObj.setRejectedPayments(null);
				Payment rp = new Payment();
				rp.setFileName(res.getFileName());
				rp.setErrorCode(String.valueOf(res.getStatus().getStatusCode()));
				rp.setErrorDesc(res.getStatus().getStatusDesc());
				rp.setBillerTransactionNumber(res.getPaymentInfo().getPayment().getBLRPTN());
				rp.setBillerId(res.getPaymentInfo().getPaymentReference().getBillerKey());
				coreObj.setBillerId(rp.getBillerId());
				coreObj.getRejectedPayments().add(rp);
			}
		}
		catch (BulkQueryFault e)
		{
			coreObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(coreObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					coreObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					coreObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			coreObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return coreObj;
	}
	
	/**
	 * Calls the backend webservice to get the list of rejected accounts or bills or payments or refunds,
	 * based on the input paramenter.
	 * 
	 * @param coreObj - RejectedEbppSessionDataBean object which contains the values for input parameter
	 * @return coreObj - RejectedEbppSessionDataBean object which contains the values for rendering on page
	 */
	public RejectedEbppSessionDataBean callBulkUploadService_ListRejected(RejectedEbppSessionDataBean coreObj)
	{
		final String methodName = "callBulkUploadService_ListRejected";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListRejectedRqType req = new ListRejectedRqType();
			req.setMessageHeader(getMessageHeaderType("BULK_UPLOAD-LIST_REJECTED", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setSearchType(EntityTypeEnum.fromValue(coreObj.getSearchType()));			
			req.setRqUID(coreObj.getRquid());

			if(coreObj.getBillerId() != null)
				req.setBillerKey(coreObj.getBillerId());
			// Biller users can only check data for their organisation
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());

			ListRejectedRsType res = bulkUploadService.listRejected(req);
			coreObj.setRquid(res.getRqUID());

			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.ACCOUNT.value()))
			{
				coreObj.setRejectedAccounts(null);
				for (RejectedAccountType rat : res.getRejectedAccount())
				{
					Account ra = new Account();
					ra.setFileName(res.getFileName());
					ra.setErrorCode(String.valueOf(rat.getStatus().getStatusCode()));
					ra.setErrorDesc(rat.getStatus().getStatusDesc());
					ra.setAccountNumber(rat.getAccountInfo().getAccountKey());
					ra.setBillerId(rat.getAccountInfo().getBillerKey());
					ra.setServiceType(rat.getAccountInfo().getServiceType());
					coreObj.setBillerId(ra.getBillerId());
					coreObj.getRejectedAccounts().add(ra);
				}
			}
			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.BILL.value()))
			{
				coreObj.setRejectedBills(null);
				for (RejectedBillType rbt : res.getRejectedBill())
				{
					Bill rb = new Bill();
					rb.setFileName(res.getFileName());
					rb.setErrorCode(String.valueOf(rbt.getStatus().getStatusCode()));
					rb.setErrorDesc(rbt.getStatus().getStatusDesc());
					rb.setBillNumber((rbt.getBill().getBillKey()));
					rb.setBillerId(rbt.getBill().getBillerKey());
					rb.setBillCategory(rbt.getBill().getBillCategory());
					rb.setBillCycle(rbt.getBill().getBillCycle());
					rb.setServiceType(rbt.getBill().getServiceType());
					coreObj.setBillerId(rb.getBillerId());
					coreObj.getRejectedBills().add(rb);
				}
			}
			if (coreObj.getSearchType().equalsIgnoreCase(EntityTypeEnum.PAYMENT.value()))
			{
				coreObj.setRejectedPayments(null);
				for (RejectedPaymentType rpt : res.getRejectedPayment())
				{
					Payment rp = new Payment();
					rp.setFileName(res.getFileName());
					rp.setErrorCode(String.valueOf(rpt.getStatus().getStatusCode()));
					rp.setErrorDesc(rpt.getStatus().getStatusDesc());
					rp.setBillerTransactionNumber(rpt.getPaymentInfo().getPayment().getBLRPTN());
					rp.setBillerId(rpt.getPaymentInfo().getPaymentReference().getBillerKey());
					coreObj.setBillerId(rp.getBillerId());
					coreObj.getRejectedPayments().add(rp);
				}
			}
		}
		catch (BulkQueryFault e)
		{
			coreObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(coreObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					coreObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					coreObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			coreObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return coreObj;
	}
	// Bulk Upload Query Calls Code Ends Here
	
	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public RejectedEbppSessionDataBean clearSessionBeanObject(RejectedEbppSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}
