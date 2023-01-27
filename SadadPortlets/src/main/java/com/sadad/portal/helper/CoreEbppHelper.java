/**
 * 
 */
package com.sadad.portal.helper;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.auditservice._1.EntityHistoryResponseType;
import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRqType;
import com.sadad.ebpp.scm.schema.auditservice._1.ListAuditRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ExtBillType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListBillStatusType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType;
import com.sadad.ebpp.scm.schema.customer._1.AccountsType;
import com.sadad.ebpp.scm.schema.customer._1.ActivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRqType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRsType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationResponseType;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.auditservice._1.ListAuditFault;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundFault;
import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.Association;
import com.sadad.portal.beans.Audit;
import com.sadad.portal.beans.Bill;
import com.sadad.portal.beans.BusinessRule;
import com.sadad.portal.beans.CoreEbppSessionDataBean;
import com.sadad.portal.beans.Customer;
import com.sadad.portal.beans.Payment;
import com.sadad.portal.beans.Refund;
import com.sadad.portal.beans.SadadPaymentLog;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.constant.SadadDynamicDataConfiguration;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;
import com.sadad.schema.service.accountquery._1.ListByKeysRqType;
import com.sadad.schema.service.accountquery._1.ListByKeysRsType;
import com.sadad.schema.service.corepayment._1.BillersType;
import com.sadad.schema.service.corepayment._1.CancelRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRqType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRsType;
import com.sadad.schema.service.corepayment._1.ListByIdRqType;
import com.sadad.schema.service.corepayment._1.ListByIdRsType;
import com.sadad.schema.service.corepayment._1.ListByPayorRqType;
import com.sadad.schema.service.corepayment._1.ListByPayorRsType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRqType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRsType;
import com.sadad.schema.service.corepayment._1.SPLPaymentInfoType;
import com.sadad.schema.service.corepayment._1.UncancelRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqTypePortal;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsTypePortal;
import com.sadad.schema.service.refundsearch._1.RefundType;
import com.sadad.schema.service.refundsearch._1.RefundsType;
import com.sadad.scm.common._1.AccountIdType;
import com.sadad.scm.common._1.AccountInfoType;
import com.sadad.scm.common._1.AssociatedAccountType;
import com.sadad.scm.common._1.AssociatedCustomerType;
import com.sadad.scm.common._1.BillTypeEnums;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.CustIdCType;
import com.sadad.scm.common._1.OfficialIdTypeCType;
import com.sadad.scm.common._1.PartnerConfigurationsType;
import com.sadad.scm.common._1.PartyIdTypeType;
import com.sadad.scm.common._1.PartyType;
import com.sadad.scm.common._1.PaymentInfoType;
import com.sadad.scm.common._1.PaymentLifecycleEnums;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */
public class CoreEbppHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = CoreEbppHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	// AccountQuery Calls Code Starts Here
	/**
	 * Calls the backend webservice to get the account by key (i.e ID type and ID number)
	 * 
	 * @param coreObj
	 *            - Session bean object which will be manipulated with service call results
	 * @return coreObj after the reflected updates from SOAP response
	 * 
	 * @deprecated use {@link callAccountService_ListByKeys(CoreEbppSessionDataBean)} instead
	 */
	@Deprecated
	public CoreEbppSessionDataBean callAccountService_GetByKey(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callAccountService_GetByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			com.sadad.schema.service.accountquery._1.GetByKeyRqType actReq = new com.sadad.schema.service.accountquery._1.GetByKeyRqType();
			actReq.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "ACCOUNT-GET_BY_KEY", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			actReq.setBillerKey(coreObj.getBillerId());
			actReq.setAccountKey(coreObj.getAccountNumber());
			com.sadad.schema.service.accountquery._1.GetByKeyRsType  actRes = accountService.getByKey(actReq);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getAccounts().clear();
			Account act = new Account();
			act.setAccountNumber(actRes.getAccountInfo().getAccountKey());
			act.setBillerId(actRes.getAccountInfo().getBillerKey());
			act.setServiceType(actRes.getAccountInfo().getServiceType());
			act.setLifecycle(actRes.getAccountInfo().getLifecycle());
			act.setAccountSource(actRes.getAccountInfo().getAccountSource());
			coreObj.getAccounts().put(act.getAccountNumber(), act);
			coreObj.setAccountKey(act.getAccountNumber());
		}
		catch (AccountQueryFault e)
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
	 * Calls the backend webservice to get the multiple accounts by key (i.e ID type and ID number)
	 * 
	 * @param coreObj
	 *            - Session bean object which will be manipulated with service call results
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callAccountService_ListByKeys(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callAccountService_GetByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListByKeysRqType lstActReq = new ListByKeysRqType();
			lstActReq.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "ACCOUNT-LIST_BY_KEYS", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			// Set biller key from session if user is from biller organisation
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				lstActReq.setBillerKey(coreObj.getPartnerKey());
			else // get the input from HTML Form
				lstActReq.setBillerKey(coreObj.getBillerId());

			for(String ak : coreObj.getAccountNumber().split(" "))
				lstActReq.getAccountKey().add(ak);
			ListByKeysRsType  lstActRes = accountService.listByKeys(lstActReq);
			
			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getAccounts().clear();
			for(AccountInfoType ait : lstActRes.getAccountInfo())
			{
				Account act = new Account();
				act.setAccountNumber(ait.getAccountKey());
				act.setBillerId(ait.getBillerKey());
				act.setServiceType(ait.getServiceType());
				act.setLifecycle(ait.getLifecycle());
				act.setAccountSource(ait.getAccountSource());

				coreObj.getAccounts().put(act.getAccountNumber(), act);
			}
		}
		catch (AccountQueryFault e)
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
	 * Calls the backend webservice to get the acount info by providing customer info
	 * 
	 * @param officialIdNumber
	 *            - Customer Official ID number to be searched
	 * @param officialIdType
	 *            - Customer Official ID Type to be searched
	 * @param billerId
	 *            - Biller Id to be searched
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callAccountService_ListByCustomer(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callAccountService_ListByCustomer";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			ListByCustomerRqType actReq = new ListByCustomerRqType();
			actReq.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "ACCOUNT-LIST_BY_CUSTOMER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER) )
				actReq.setBillerKey(coreObj.getPartnerKey());
			actReq.setPayor(new PartyType());
			actReq.getPayor().setPartyId(coreObj.getCustomerId());
			actReq.getPayor().setPartyIdType(PartyIdTypeType.valueOf(coreObj.getCustomerIdType()));
			ListByCustomerRsType actRes = accountService.listByCustomer(actReq);

			// if it reaches here, it means response is successfull change status manually in session object
			PartyType custParty = actRes.getCustomerAccountsAssn().getCustomer();
			coreObj.setCustomer(new Customer());
			coreObj.getCustomer().setOfficialIdNumber(custParty.getPartyId());
			coreObj.getCustomer().setOfficialIdType(custParty.getPartyIdType().value());
			coreObj.getCustomer().setCustomerStatus(custParty.getPartyStatus().value());
			coreObj.getCustomer().setCustomerType(custParty.getPartyType().value());
			
			if(actRes.getCustomerAccountsAssn().getAssociatedAccount().size() > 0)
			{
				coreObj.getAssociation().clear();
				for(AssociatedAccountType aat : actRes.getCustomerAccountsAssn().getAssociatedAccount())
				{
					String key = aat.getAccountInfo().getAccountKey() + "_" + aat.getAccountInfo().getBillerKey(); 
					Association asc = new Association();
					asc.setAccountNumber(aat.getAccountInfo().getAccountKey());
					asc.setAccountStatus(aat.getAccountInfo().getLifecycle().value());
					asc.setBillerId(aat.getAccountInfo().getBillerKey());
					asc.setOfficialIdNumber(custParty.getPartyId());
					asc.setOfficialIdType(custParty.getPartyIdType().value());
					asc.setCustomerStatus(custParty.getPartyStatus().value());
					asc.setAssociationType(aat.getAssnType().value());
					if(aat.getAssociatedBy().getBankKey() != null)
						asc.setAssigningOrganization(aat.getAssociatedBy().getBankKey());
					if(aat.getAssociatedBy().getBillerKey() != null)
						asc.setAssigningOrganization(aat.getAssociatedBy().getBillerKey());
					coreObj.getAssociation().put(key, asc);
				}
			}
		}
		catch (AccountQueryFault e)
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
	// AccountQuery Calls Code Ends Here 	

	// BillSearch Calls Code Starts Here	
	/**
	 * Calls the backend webservice to get the bill by biller key and bill number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callBillService_GetByBillNumber(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callBillService_GetByBillNumber";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetByBillNumberRqType req = new GetByBillNumberRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "BILL-GET_BY_BILL_NUMBER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			// Set biller key from session if user is from biller organisation
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());
			else // get the input from HTML Form
				req.setBillerKey(coreObj.getBillerId());

			// req.setBillKey(coreObj.getBillNumber()); Fix for defect 2999
			for(String bk : coreObj.getBillNumber().split(" "))
				req.getBillKey().add(bk);
			GetByBillNumberRsType res = billService.getByBillNumber(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getBills().clear();
			for(ExtBillType rBill : res.getBill())
			{
				Bill bill = new Bill();
				bill.setBillKey(rBill.getBillId());	
				bill.setBillNumber(rBill.getBillKey());
				bill.setBillerId(rBill.getBillerKey());
				bill.setAccountNumber(rBill.getAccountKey());
				bill.setBillCategory(rBill.getBillCategory());
				bill.setServiceType(rBill.getServiceType());
				bill.setNetAmount(rBill.getAmountDue());
				bill.setDueDate(rBill.getDueDate());
				bill.setBillCycle(rBill.getBillCycle());
				bill.setBillGeneratedDate(rBill.getGenerationDate());
				bill.setExpiryDate(rBill.getExpiryDate());
				// Modified after Ramy introduced Current Bill Status in Bill Schema
				// bill.setBillStatus(ebt.getBillLifecycle().value());
				bill.setBillStatus(rBill.getCurrentBillStatus());
				bill.setBillType(rBill.getBillType().value());
				bill.setOrigianlAmount(rBill.getOriginalAmount());
				bill.setPaymentCount(rBill.getPaymentsCount());
				coreObj.getBills().put(bill.getBillKey(), bill);
			}
		}
		catch (BillSearchFault e)
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
	 * Calls the backend webservice to get the bill by biller key and bill number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callBillService_ListByAccount(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callBillService_ListByAccount";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType req = new com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType();
			
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(),"BILL-LIST_BY_ACCOUNT", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBillerKey(coreObj.getBillerId());
			req.setAccountKey(coreObj.getAccountNumber());
			
			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType res = billService.listByAccount(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getBills().clear();
			for(ExtBillType rBill : res.getBills())
			{
				Bill bill = new Bill();
				bill.setBillKey(rBill.getBillId());
				bill.setBillNumber(rBill.getBillKey());
				bill.setBillerId(rBill.getBillerKey());
				bill.setAccountNumber(rBill.getAccountKey());
				bill.setBillCategory(rBill.getBillCategory());
				bill.setServiceType(rBill.getServiceType());
				bill.setNetAmount(rBill.getAmountDue());
				bill.setDueDate(rBill.getDueDate());
				bill.setBillCycle(rBill.getBillCycle());
				bill.setBillGeneratedDate(rBill.getGenerationDate());
				bill.setExpiryDate(rBill.getExpiryDate());
				// Modified after Ramy introduced Bill Current Status in Bill Schema
				// bill.setBillStatus(rBill.getBillLifecycle().value());
				bill.setBillStatus(rBill.getCurrentBillStatus());
				bill.setBillType(rBill.getBillType().value());
				bill.setOrigianlAmount(rBill.getOriginalAmount());
				bill.setPaymentCount(rBill.getPaymentsCount());
				coreObj.getBills().put(bill.getBillKey(), bill);
			}
		}
		catch (BillSearchFault e)
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
	 * Calls the backend webservice to get the bill by biller key and bill number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callBillService_ListByCustomer(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callBillService_ListByCustomer";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType req = new com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "BILL-LIST_BY_CUSTOMER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setCustomer(new CustIdCType());
			req.getCustomer().setOfficialId(coreObj.getCustomerId());
			req.getCustomer().setOfficialIdType(OfficialIdTypeCType.valueOf(coreObj.getCustomerIdType()));
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());
			req.setStatus(ListBillStatusType.valueOf(coreObj.getStatus()));

			com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType res = billService.listByCustomer(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getBills().clear();
			for(ExtBillType rBill : res.getBills())
			{
				Bill bill = new Bill();
				bill.setBillKey(rBill.getBillId());
				bill.setBillNumber(rBill.getBillKey());
				bill.setBillerId(rBill.getBillerKey());
				bill.setAccountNumber(rBill.getAccountKey());
				bill.setBillCategory(rBill.getBillCategory());
				bill.setServiceType(rBill.getServiceType());
				bill.setNetAmount(rBill.getAmountDue());
				bill.setDueDate(rBill.getDueDate());
				bill.setBillCycle(rBill.getBillCycle());
				bill.setBillGeneratedDate(rBill.getGenerationDate());
				bill.setExpiryDate(rBill.getExpiryDate());
				// Modified after Ramy introduced Bill Current Status in Bill Schema
				// bill.setBillStatus(rBill.getBillLifecycle().value());
				bill.setBillStatus(rBill.getCurrentBillStatus());
				bill.setBillType(rBill.getBillType().value());
				bill.setOrigianlAmount(rBill.getOriginalAmount());
				bill.setPaymentCount(rBill.getPaymentsCount());
				coreObj.getBills().put(bill.getBillKey(), bill);
			}
		}
		catch (BillSearchFault e)
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
	 * Calls the backend webservice to get the bill number by payment ID.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary information to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callBillService_ListByPayment(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callBillService_ListByPayment";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			ListByPaymentRqType req = new ListByPaymentRqType();
			
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "BILL-LIST_BY_PAYMENT", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBillerKey(coreObj.getBillerId());
			req.setPaymentKey(coreObj.getPaymentId());
			
			ListByPaymentRsType res = billService.listByPayment(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getBills().clear();
			for(ExtBillType rBill : res.getBills())
			{
				Bill bill = new Bill();
				bill.setBillKey(rBill.getBillId());
				bill.setBillNumber(rBill.getBillKey());
				bill.setBillerId(rBill.getBillerKey());
				bill.setAccountNumber(rBill.getAccountKey());
				bill.setBillCategory(rBill.getBillCategory());
				bill.setServiceType(rBill.getServiceType());
				bill.setNetAmount(rBill.getAmountDue());
				bill.setDueDate(rBill.getDueDate());
				bill.setBillCycle(rBill.getBillCycle());
				bill.setBillGeneratedDate(rBill.getGenerationDate());
				bill.setExpiryDate(rBill.getExpiryDate());
				// Modified after Ramy introduced Bill Current Status in Bill Schema
				// bill.setBillStatus(rBill.getBillLifecycle().value());
				bill.setBillStatus(rBill.getCurrentBillStatus());
				bill.setBillCycle(rBill.getBillCycle());
				bill.setBillType(rBill.getBillType().value());
				bill.setOrigianlAmount(rBill.getOriginalAmount());
				bill.setPaymentCount(rBill.getPaymentsCount());
				coreObj.getBills().put(bill.getBillKey(), bill);
			}
		}
		catch (BillSearchFault e)
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
	 * Calls the backend webservice to get the bill number by payment ID.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary information to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPartnerProfile_GetPartnerConfiguration(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callPartnerProfile_GetPartnerConfiguration";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			GetPartnerConfigurationRequestType req = new GetPartnerConfigurationRequestType();
			
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PARTNER_PROFILE-GET-PARTNER-CONFIGURATION", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			
			req.setPartnerKey(coreObj.getBillerId());
			req.setIdentifier(coreObj.getBillCategory());
			
			GetPartnerConfigurationResponseType res = partnerProfileService.getPartnerConfiguration(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getBusinessRules().clear();
			for(PartnerConfigurationsType pct : res.getPartnerConfigurations())
			{
				boolean display = false;
				for (String dr : SadadDynamicDataConfiguration.BILLER_BILL_RULES_CONFIGURATION_NAMES)
				{
					if (dr.equals(pct.getConfiguration().getName()))
					{
						display = true;
						break;
					}
				}
				if (display)
				{
					BusinessRule bRule = new BusinessRule();
					bRule.setBillerId(res.getPartnerKey());
					bRule.setBillCategory(coreObj.getBillCategory());
					bRule.setRuleType(pct.getConfiguration().getName());
					bRule.setRuleStatus(pct.getConfiguration().getStatus().value());
					coreObj.getBusinessRules().add(bRule);
				}
			}
		}
		catch (PartnerProfileFaultMsg e)
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
	
	// BillSearch Calls Code Ends Here	
	
	// CustomerPort Calls Code Starts Here
	/**
	 * Calls the backend webservice to association the customer from billing account number
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_CustomerAssociation(CoreEbppSessionDataBean coreObj)
	{
		// TODO - Coding completed, but not tested.
		// TODO - Most probably the customer association is done by upload not by portal
		final String methodName = "callCustomerService_CustomerAssociation";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			CustProfileAssnRqType req = new CustProfileAssnRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CUSTOMER_ASSOCIATION", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPayor(new PartyType());
			req.getPayor().setPartyId(coreObj.getCustomerId());
			req.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
			
			AccountsType act = new AccountsType();
			act.setRecordNumber(1);
			AccountIdType aidt = new AccountIdType();
			aidt.setAccountKey(coreObj.getAccountNumber());
			aidt.setBillerKey(coreObj.getBillerId());
			act.setAccount(aidt);
			req.getAccounts().add(act);
			CustProfileAssnRsType res = customerService.customerAssociation(req);
			
			// if it reaches here, it means response is successful add association manually in session object
			String key = aidt.getAccountKey() + "_" + aidt.getBillerKey(); 
			Association asc = new Association();
			asc.setAccountNumber(aidt.getAccountKey());
			// TODO Still below these two commented properties need to be set
			// TODO figure it out how.
//			asc.setAccountStatus(aat.getAccountInfo().getLifecycle().value());
			asc.setBillerId(aidt.getBillerKey());
			asc.setOfficialIdNumber(res.getPayor().getPartyId());
			asc.setOfficialIdType(res.getPayor().getPartyIdType().value());
			asc.setCustomerStatus(res.getPayor().getPartyStatus().value());
//			asc.setAssociationType(aat.getAssnType().value());

			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				asc.setAssigningOrganization(coreObj.getPartnerKey());
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				asc.setAssigningOrganization(coreObj.getPartnerKey());

			coreObj.getAssociation().put(key, asc);			
		}
		catch (CustomerFault e)
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
	 * Calls the backend webservice to disassociate the customer from billing account number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_CustomerDisassociation(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomerService_CustomerDisassociation";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			CustProfileDisassnRqType req = new CustProfileDisassnRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CUSTOMER_DISASSOCIATION", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPayor(new PartyType());
			req.getPayor().setPartyId(coreObj.getCustomerId());
			req.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
			
			AccountsType act = new AccountsType();
			act.setRecordNumber(1);
			AccountIdType aidt = new AccountIdType();
			aidt.setAccountKey(coreObj.getAccountNumber());
			aidt.setBillerKey(coreObj.getBillerId());
			act.setAccount(aidt);
			req.getAccounts().add(act);
			customerService.customerDisassociation(req);
			// if it reaches here, it means response is successfull delete association manually in session object
			coreObj.getAssociation().remove(coreObj.getAssociationKey());
		}
		catch (CustomerFault e)
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
	 * Calls the backend webservice to activate or deactivate the Customer
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_ActivateOrDeActivateCustomer(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomerService_ActivateOrDeActivateCustomer";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Set the value in Session Object
			if (coreObj.getCustomer().getCustomerStatus().equalsIgnoreCase(ConfigurationStatusEnum.ACTIVE.value()))
			{
				// Call the backend service - DeActivate
				DeactivateRqType cdr = new DeactivateRqType();
				cdr.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "DEACTIVATE_CUSTOMER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
				cdr.setPayor(new PartyType());
				cdr.getPayor().setPartyId(coreObj.getCustomerId());
				cdr.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
				customerService.deactivate(cdr);

				// if it reaches here, it means response is successfull change status manually in session object
				coreObj.getCustomer().setCustomerStatus("INACTIVE");
			}
			else if (coreObj.getCustomer().getCustomerStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateRqType car = new ActivateRqType();
				car.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "ACTIVATE_CUSTOMER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
				car.setPayor(new PartyType());
				car.getPayor().setPartyId(coreObj.getCustomer().getOfficialIdNumber());
				car.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomer().getOfficialIdType()));
				customerService.activate(car);

				// if it reaches here, it means response is successfull change status manually in session object
				coreObj.getCustomer().setCustomerStatus("ACTIVE");
			}
		}
		catch (CustomerFault e)
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
	 * Calls the backend webservice to get the customer by key (i.e ID type and ID number)
	 * 
	 * @param coreObj
	 *            - Session bean object which will be manipulated with service call results
	 * @return coreObj - after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_GetByKey(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomerService_GetByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			GetByKeyRqType cstReq = new GetByKeyRqType();
			cstReq.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CUSTOMER-GET_BY_KEY", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			cstReq.setPayor(new PartyType());
			cstReq.getPayor().setPartyId(coreObj.getCustomerId());
			cstReq.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
			GetByKeyRsType  cstRes = customerService.getByKey(cstReq);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.setCustomer(new Customer());
			coreObj.getCustomer().setOfficialIdNumber(coreObj.getCustomerId());
			coreObj.getCustomer().setOfficialIdType(coreObj.getCustomerIdType());
			coreObj.getCustomer().setCustomerStatus(cstRes.getStatus().value());
		}
		catch (CustomerFault e)
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
	 * Calls the backend webservice to get the customer by biller key and billing account number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_ListByAccount(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomerService_ListByAccount";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			ListByAccountRqType lstActReq = new ListByAccountRqType();
			lstActReq.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CUSTOMER-LIST_BY_ACCOUNT", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			// Start of Fix defect 2679
			// To bypass the S1 Portal behaviour, which is an empty respone if Channel is Portal, 
			// EBPP Channel is set to display the error message 
//			lstActReq.getMessageHeader().setChannel(SADADChannelTypeEnums.EBPP); // For fixing 3261 Channel set back to Portal
			// End of Fix defect 2679
			lstActReq.setBillerKey(coreObj.getBillerId());
			lstActReq.setAccountKey(coreObj.getAccountNumber());
			ListByAccountRsType cstRes = customerService.listByAccount(lstActReq);

			// if it reaches here, it means response is successfull change status manually in session object
			if (cstRes.getAccountCustomersAssn() != null) // To Fix 2679 defect the NULL checking is added.
			{
				AccountInfoType accountInfo = cstRes.getAccountCustomersAssn().getAccountInfo();
				coreObj.getAccounts().clear();
				Account acc = new Account();
				acc.setAccountNumber(accountInfo.getAccountKey());
				acc.setBillerId(accountInfo.getBillerKey());
				acc.setServiceType(accountInfo.getServiceType());
				acc.setLifecycle(accountInfo.getLifecycle());
				acc.setAccountSource(accountInfo.getAccountSource());
				coreObj.getAccounts().put(acc.getAccountNumber(), acc);

				if(cstRes.getAccountCustomersAssn().getAssociatedCustomer().size() > 0)
				{
					coreObj.getAssociation().clear();
					for(AssociatedCustomerType act : cstRes.getAccountCustomersAssn().getAssociatedCustomer())
					{
						Association asc = new Association();
						PartyType pt = act.getCustomer();
						asc.setAccountNumber(accountInfo.getAccountKey());
						asc.setBillerId(accountInfo.getBillerKey());
						asc.setOfficialIdNumber(pt.getPartyId());
						asc.setOfficialIdType(pt.getPartyIdType().value());
						asc.setCustomerStatus(pt.getPartyStatus().value());
						asc.setAssociationType(act.getAssnType().value());
						if(act.getAssociatedBy() != null) // Put this condition as per Ramy Sabry instructions
						{
							if(act.getAssociatedBy().getBankKey() != null)
								asc.setAssigningOrganization(act.getAssociatedBy().getBankKey());
							if(act.getAssociatedBy().getBillerKey() != null)
								asc.setAssigningOrganization(act.getAssociatedBy().getBillerKey());
						}
						coreObj.getAssociation().put(asc.getOfficialIdNumber(), asc);
					}
				}				
			}
		}
		catch (CustomerFault e)
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
	 * Calls the backend webservice to get the customer by biller key and bill number
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callCustomerService_ListByBill(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomerService_ListByBill";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			ListByBillRqType req = new ListByBillRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CUSTOMER-LIST_BY_BILL", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBillerKey(coreObj.getBillerId());
			req.setBillKey(coreObj.getBillKey());
			ListByBillRsType res = customerService.listByBill(req);

			// if it reaches here, it means response is successfull change status manually in session object
			AccountInfoType accountInfo = res.getAccountCustomersAssn().getAccountInfo();
			Account act = new Account();
			act.setAccountNumber(accountInfo.getAccountKey());
			act.setBillerId(accountInfo.getBillerKey());
			act.setServiceType(accountInfo.getServiceType());
			act.setLifecycle(accountInfo.getLifecycle());
			act.setAccountSource(accountInfo.getAccountSource());

			if(res.getAccountCustomersAssn().getAssociatedCustomer().size() > 0)
			{
				PartyType pt = res.getAccountCustomersAssn().getAssociatedCustomer().get(0).getCustomer();
				coreObj.setCustomer(new Customer());
				coreObj.getCustomer().setOfficialIdNumber(pt.getPartyId());
				coreObj.getCustomer().setOfficialIdType(pt.getPartyIdType().value());
				coreObj.getCustomer().setCustomerType(pt.getPartyType().value());
				coreObj.getCustomer().setCustomerStatus(pt.getPartyStatus().value());
			}
		}
		catch (CustomerFault e)
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
	// CustomerPort Calls Code Ends Here 
	
	// Core Payment Calls Code Starts Here
	/**
	 * Calls the backend webservice to get the all the payments by account number and biller id.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListByAccount(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListByAccount";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			com.sadad.schema.service.corepayment._1.ListByAccountRqType req = new com.sadad.schema.service.corepayment._1.ListByAccountRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-LIST_BY_ACCOUNT", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setAccountKey(coreObj.getAccountNumber());
			req.setBillerKey(coreObj.getBillerId());
			// Set the Bank Key for logged in bank user
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				req.setBankKey(coreObj.getPartnerKey());
			
			com.sadad.schema.service.corepayment._1.ListByAccountRsType res = paymentService.listByAccount(req);
			
			// if it reaches here, it means response is successful change status manually in session object
			coreObj.getPayments().clear();
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				pmt.setSadadNumber(pit.getPayment().getPaymentKey() != null ? pit.getPayment().getPaymentKey() : null);
				pmt.setBankNumber(pit.getPayment().getBNKPTN() != null ? pit.getPayment().getBNKPTN() : null);
				pmt.setReversalNumber(pit.getPayment().getBNKRVL() != null ? pit.getPayment().getBNKRVL() : null);
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN() != null ? pit.getPayment().getBLRPTN() : null);
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId() != null ? pit.getPayment().getGroupPaymentId() : null);
				
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey() != null ? pit.getPaymentReference().getAccountKey() : null);
				pmt.setBillNumber(pit.getPaymentReference().getBillKey() != null ? pit.getPaymentReference().getBillKey() : null);
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle() != null ? pit.getPaymentReference().getBillCycle() : null);
				
				pmt.setBankId(pit.getPayment().getAcquirerBankKey() != null ? pit.getPayment().getAcquirerBankKey() : null);
				pmt.setAccessChannel(pit.getPayment().getAccessChannel() != null ? pit.getPayment().getAccessChannel() : null);
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit() != null ? pit.getPayment().getCheckDigit() : null);
				pmt.setBranchCode(pit.getPayment().getBranchCode() != null ? pit.getPayment().getBranchCode() : null);
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode() != null ? pit.getPaymentExtn().getPaymentTypeCode() : null);
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod() != null ? pit.getPayment().getPaymentMethod() : null);
				pmt.setServiceId(pit.getPaymentExtn().getServiceType() != null ? pit.getPaymentExtn().getServiceType() : null);
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate() != null ? pit.getPayment().getPartnerTransDate() : null);
				String beneficiaryIdType = pit.getPaymentExtn().getBeneficiary() != null ? pit.getPaymentExtn().getBeneficiary().getPartyIdType().value() : "";
				pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary() != null ? beneficiaryIdType + pit.getPaymentExtn().getBeneficiary().getPartyId() : null);
				pmt.setDistrictCode(pit.getPayment().getDistrictCode() != null ? pit.getPayment().getDistrictCode() : null);
				String customerIdType = pit.getPayment().getPayor() != null ? pit.getPayment().getPayor().getPartyIdType().value() : "";
				pmt.setCustomerId((pit.getPayment().getPayor() != null ? customerIdType + pit.getPayment().getPayor().getPartyId() : null));
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState() != null ? pit.getPayment().getLifecycleState() : null);

				if(pit.getRefund() != null && pit.getRefund().size() > 0)
				{
					String allRefunds = "";
					for (com.sadad.scm.common._1.RefundType r : pit.getRefund())
						allRefunds = allRefunds + r.getPartnerRefKey() + ", ";

					pmt.setRefundId(allRefunds.substring(0, allRefunds.lastIndexOf(',')));
				}

				coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			}
		}
		catch(PaymentFault e)
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
	 * Calls the backend webservice to get all the payments by beneficiary id and type.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListByBeneficiary(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListByBeneficiary";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListByBeneficiaryRqType req = new ListByBeneficiaryRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-LIST_BY_BENEFICIARY", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBeneficiary(new CustIdCType());
			req.getBeneficiary().setOfficialId(coreObj.getCustomerId());
			req.getBeneficiary().setOfficialIdType(OfficialIdTypeCType.valueOf(coreObj.getCustomerIdType()));
			req.setDateRange(null);

			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				req.setBankKey(coreObj.getPartnerKey());

			ListByBeneficiaryRsType res = paymentService.listByBeneficiary(req);
			
			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getPayments().clear();
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				pmt.setSadadNumber(pit.getPayment().getPaymentKey() != null ? pit.getPayment().getPaymentKey() : null);
				pmt.setBankNumber(pit.getPayment().getBNKPTN() != null ? pit.getPayment().getBNKPTN() : null);
				pmt.setReversalNumber(pit.getPayment().getBNKRVL() != null ? pit.getPayment().getBNKRVL() : null);
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN() != null ? pit.getPayment().getBLRPTN() : null);
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId() != null ? pit.getPayment().getGroupPaymentId() : null);
				
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey() != null ? pit.getPaymentReference().getAccountKey() : null);
				pmt.setBillNumber(pit.getPaymentReference().getBillKey() != null ? pit.getPaymentReference().getBillKey() : null);
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle() != null ? pit.getPaymentReference().getBillCycle() : null);
				
				pmt.setBankId(pit.getPayment().getAcquirerBankKey() != null ? pit.getPayment().getAcquirerBankKey() : null);
				pmt.setAccessChannel(pit.getPayment().getAccessChannel() != null ? pit.getPayment().getAccessChannel() : null);
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit() != null ? pit.getPayment().getCheckDigit() : null);
				pmt.setBranchCode(pit.getPayment().getBranchCode() != null ? pit.getPayment().getBranchCode() : null);
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode() != null ? pit.getPaymentExtn().getPaymentTypeCode() : null);
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod() != null ? pit.getPayment().getPaymentMethod() : null);
				pmt.setServiceId(pit.getPaymentExtn().getServiceType() != null ? pit.getPaymentExtn().getServiceType() : null);
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate() != null ? pit.getPayment().getPartnerTransDate() : null);
				String beneficiaryIdType = pit.getPaymentExtn().getBeneficiary() != null ? pit.getPaymentExtn().getBeneficiary().getPartyIdType().value() : "";
				pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary() != null ? beneficiaryIdType + pit.getPaymentExtn().getBeneficiary().getPartyId() : null);
				pmt.setDistrictCode(pit.getPayment().getDistrictCode() != null ? pit.getPayment().getDistrictCode() : null);
				String customerIdType = pit.getPayment().getPayor() != null ? pit.getPayment().getPayor().getPartyIdType().value() : "";
				pmt.setCustomerId((pit.getPayment().getPayor() != null ? customerIdType + pit.getPayment().getPayor().getPartyId() : null));
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState() != null ? pit.getPayment().getLifecycleState() : null);

				if(pit.getRefund() != null && pit.getRefund().size() > 0)
				{
					String allRefunds = "";
					for (com.sadad.scm.common._1.RefundType r : pit.getRefund())
						allRefunds = allRefunds + r.getPartnerRefKey() + ", ";

					pmt.setRefundId(allRefunds.substring(0, allRefunds.lastIndexOf(',')));
				}

				coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			}
		}
		catch(PaymentFault e)
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
	 * Calls the backend webservice to get all the payments by biller id and bill number.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListByBillId(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListByBillId";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListByBillIdRqType req = new ListByBillIdRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-LIST_BY_BILLID", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBillId(coreObj.getBillNumber());
			req.setBillerKey(coreObj.getBillerId());
			// Set bank key for logged in user bank
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				req.setBankKey(coreObj.getPartnerKey());
			// Fix for retrieving Payments from Bill Details page, instead of calling PaymentsByBillIdOrByAccount
			req.setBillKey(coreObj.getBillKey());
			req.setAccountKey(coreObj.getAccountNumber());
			req.setBillCategory(coreObj.getBillCategory());
			req.setBillType(BillTypeEnums.fromValue(coreObj.getBillType()));
			req.setGenerationDate(coreObj.parseXmlFullDate(coreObj.getBillGenerationDate()));
			ListByBillIdRsType res = paymentService.listByBillId(req);
			
			coreObj.getPayments().clear();
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				pmt.setSadadNumber(pit.getPayment().getPaymentKey() != null ? pit.getPayment().getPaymentKey() : null);
				pmt.setBankNumber(pit.getPayment().getBNKPTN() != null ? pit.getPayment().getBNKPTN() : null);
				pmt.setReversalNumber(pit.getPayment().getBNKRVL() != null ? pit.getPayment().getBNKRVL() : null);
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN() != null ? pit.getPayment().getBLRPTN() : null);
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId() != null ? pit.getPayment().getGroupPaymentId() : null);
				
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey() != null ? pit.getPaymentReference().getAccountKey() : null);
				pmt.setBillNumber(pit.getPaymentReference().getBillKey() != null ? pit.getPaymentReference().getBillKey() : null);
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle() != null ? pit.getPaymentReference().getBillCycle() : null);
				
				pmt.setBankId(pit.getPayment().getAcquirerBankKey() != null ? pit.getPayment().getAcquirerBankKey() : null);
				pmt.setAccessChannel(pit.getPayment().getAccessChannel() != null ? pit.getPayment().getAccessChannel() : null);
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit() != null ? pit.getPayment().getCheckDigit() : null);
				pmt.setBranchCode(pit.getPayment().getBranchCode() != null ? pit.getPayment().getBranchCode() : null);
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode() != null ? pit.getPaymentExtn().getPaymentTypeCode() : null);
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod() != null ? pit.getPayment().getPaymentMethod() : null);
				pmt.setServiceId(pit.getPaymentExtn().getServiceType() != null ? pit.getPaymentExtn().getServiceType() : null);
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate() != null ? pit.getPayment().getPartnerTransDate() : null);
				String beneficiaryIdType = pit.getPaymentExtn().getBeneficiary() != null ? pit.getPaymentExtn().getBeneficiary().getPartyIdType().value() : "";
				pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary() != null ? beneficiaryIdType + pit.getPaymentExtn().getBeneficiary().getPartyId() : null);
				pmt.setDistrictCode(pit.getPayment().getDistrictCode() != null ? pit.getPayment().getDistrictCode() : null);
				String customerIdType = pit.getPayment().getPayor() != null ? pit.getPayment().getPayor().getPartyIdType().value() : "";
				pmt.setCustomerId((pit.getPayment().getPayor() != null ? customerIdType + pit.getPayment().getPayor().getPartyId() : null));
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState() != null ? pit.getPayment().getLifecycleState() : null);

				if(pit.getRefund() != null && pit.getRefund().size() > 0)
				{
					String allRefunds = "";
					for (com.sadad.scm.common._1.RefundType r : pit.getRefund())
						allRefunds = allRefunds + r.getPartnerRefKey() + ", ";

					pmt.setRefundId(allRefunds.substring(0, allRefunds.lastIndexOf(',')));
				}

				coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			}
		}
		catch(PaymentFault e)
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
	 * Calls the backend webservice to get the payment by payment id.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListById(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListById";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListByIdRqType req = new ListByIdRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-LIST_BY_ID", coreObj.getRemoteUser(), coreObj.getLanguageCode()));

			if(coreObj.getBankId() != null)
				req.setBankKey(coreObj.getBankId());
			//Add the bank key from logged in session
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				req.setBankKey(coreObj.getPartnerKey());

			if(coreObj.getBillerId() != null)
				req.setBillerKey(coreObj.getBillerId());
			// Add the biller or an aggregator key from logged in session
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());

			if(coreObj.getPaymentIdType().equalsIgnoreCase("SPTN"))
				req.setPaymentKey(coreObj.getPaymentId());
			else if(coreObj.getPaymentIdType().equalsIgnoreCase("BNKPTN"))
				req.setBNKPTN(coreObj.getPaymentId());
			else if(coreObj.getPaymentIdType().equalsIgnoreCase("BNKRVL"))
				req.setBNKRVL(coreObj.getPaymentId());
			else if(coreObj.getPaymentIdType().equalsIgnoreCase("BLRPTN"))
				req.setBLRPTN(coreObj.getPaymentId());
			else if(coreObj.getPaymentIdType().equalsIgnoreCase("GroupPaymentId"))
				req.setGroupPaymentId(coreObj.getPaymentId());


			ListByIdRsType res = paymentService.listById(req);
			
			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getPayments().clear();
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				pmt.setSadadNumber(pit.getPayment().getPaymentKey() != null ? pit.getPayment().getPaymentKey() : null);
				pmt.setBankNumber(pit.getPayment().getBNKPTN() != null ? pit.getPayment().getBNKPTN() : null);
				pmt.setReversalNumber(pit.getPayment().getBNKRVL() != null ? pit.getPayment().getBNKRVL() : null);
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN() != null ? pit.getPayment().getBLRPTN() : null);
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId() != null ? pit.getPayment().getGroupPaymentId() : null);
				
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey() != null ? pit.getPaymentReference().getAccountKey() : null);
				pmt.setBillNumber(pit.getPaymentReference().getBillKey() != null ? pit.getPaymentReference().getBillKey() : null);
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle() != null ? pit.getPaymentReference().getBillCycle() : null);
				
				pmt.setBankId(pit.getPayment().getAcquirerBankKey() != null ? pit.getPayment().getAcquirerBankKey() : null);
				pmt.setAccessChannel(pit.getPayment().getAccessChannel() != null ? pit.getPayment().getAccessChannel() : null);
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit() != null ? pit.getPayment().getCheckDigit() : null);
				pmt.setBranchCode(pit.getPayment().getBranchCode() != null ? pit.getPayment().getBranchCode() : null);
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode() != null ? pit.getPaymentExtn().getPaymentTypeCode() : null);
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod() != null ? pit.getPayment().getPaymentMethod() : null);
				pmt.setServiceId(pit.getPaymentExtn().getServiceType() != null ? pit.getPaymentExtn().getServiceType() : null);
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate() != null ? pit.getPayment().getPartnerTransDate() : null);
				String beneficiaryIdType = pit.getPaymentExtn().getBeneficiary() != null ? pit.getPaymentExtn().getBeneficiary().getPartyIdType().value() : "";
				pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary() != null ? beneficiaryIdType + pit.getPaymentExtn().getBeneficiary().getPartyId() : null);
				pmt.setDistrictCode(pit.getPayment().getDistrictCode() != null ? pit.getPayment().getDistrictCode() : null);
				String customerIdType = pit.getPayment().getPayor() != null ? pit.getPayment().getPayor().getPartyIdType().value() : "";
				pmt.setCustomerId((pit.getPayment().getPayor() != null ? customerIdType + pit.getPayment().getPayor().getPartyId() : null));
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState() != null ? pit.getPayment().getLifecycleState() : null);

				if(pit.getRefund() != null && pit.getRefund().size() > 0)
				{
					String allRefunds = "";
					for (com.sadad.scm.common._1.RefundType r : pit.getRefund())
						allRefunds = allRefunds + r.getPartnerRefKey() + ", ";

					pmt.setRefundId(allRefunds.substring(0, allRefunds.lastIndexOf(',')));
				}

				coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			}
		}
		catch(PaymentFault e)
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
	 * Calls the backend webservice to get the payment by payor id. This method is called for getting all payment for MOI Billers
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListByPayor(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListByPayor";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListByPayorRqType req = new ListByPayorRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-LIST_BY_PAYOR", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPayor(new CustIdCType());
			req.getPayor().setOfficialId(coreObj.getCustomerId());
			req.getPayor().setOfficialIdType(OfficialIdTypeCType.valueOf(coreObj.getCustomerIdType()));
			// Add bank key if logged-in user belongs to any bank
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD) || coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
			{
				if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
					req.setBankKey(coreObj.getPartnerKey());

				// Add all the MOI Billers defined in the SadadDynamicDataConfiguration.properties for SADAD and Bank Users 
				req.setBillers(new BillersType());
				for(String moibiller : SadadDynamicDataConfiguration.MOI_BILLERS)
					req.getBillers().getBillerKey().add(moibiller);
			}
			else if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER)) // The biller should be one of the MOI biller
			{
				req.setBillers(new BillersType());
				for(String moibiller : SadadDynamicDataConfiguration.MOI_BILLERS)
				{
					if(coreObj.getPartnerKey().equalsIgnoreCase(moibiller)) // Add the matching biller only
						req.getBillers().getBillerKey().add(moibiller);
				}
			}

			// Start Fix for defect 3374
			if(coreObj.getPageNumber() == 0)
				coreObj.setPageNumber(1);
			req.setPage(coreObj.getPageNumber());
			// End Fix for defect 3374
			ListByPayorRsType res = paymentService.listByPayor(req);
			
			// if it reaches here, it means response is successfull change status manually in session object
			if(coreObj.getPageNumber() == 1)
				coreObj.getPayments().clear();
			for(PaymentInfoType pit : res.getPaymentInfo())
			{
				Payment pmt = new Payment();
				pmt.setSadadNumber(pit.getPayment().getPaymentKey() != null ? pit.getPayment().getPaymentKey() : null);
				pmt.setBankNumber(pit.getPayment().getBNKPTN() != null ? pit.getPayment().getBNKPTN() : null);
				pmt.setReversalNumber(pit.getPayment().getBNKRVL() != null ? pit.getPayment().getBNKRVL() : null);
				pmt.setBillerTransactionNumber(pit.getPayment().getBLRPTN() != null ? pit.getPayment().getBLRPTN() : null);
				pmt.setGroupNumber(pit.getPayment().getGroupPaymentId() != null ? pit.getPayment().getGroupPaymentId() : null);
				
				pmt.setBillerId(pit.getPaymentReference().getBillerKey());
				pmt.setAccountNumber(pit.getPaymentReference().getAccountKey() != null ? pit.getPaymentReference().getAccountKey() : null);
				pmt.setBillNumber(pit.getPaymentReference().getBillKey() != null ? pit.getPaymentReference().getBillKey() : null);
				pmt.setBillCycle(pit.getPaymentReference().getBillCycle() != null ? pit.getPaymentReference().getBillCycle() : null);
				
				pmt.setBankId(pit.getPayment().getAcquirerBankKey() != null ? pit.getPayment().getAcquirerBankKey() : null);
				pmt.setAccessChannel(pit.getPayment().getAccessChannel() != null ? pit.getPayment().getAccessChannel() : null);
				pmt.setAmount(pit.getPayment().getAmount());
				pmt.setCheckDigit(pit.getPayment().getCheckDigit() != null ? pit.getPayment().getCheckDigit() : null);
				pmt.setBranchCode(pit.getPayment().getBranchCode() != null ? pit.getPayment().getBranchCode() : null);
				pmt.setPaymentType(pit.getPaymentExtn().getPaymentTypeCode() != null ? pit.getPaymentExtn().getPaymentTypeCode() : null);
				pmt.setPaymentMethod(pit.getPayment().getPaymentMethod() != null ? pit.getPayment().getPaymentMethod() : null);
				pmt.setProcessingDate(pit.getPayment().getPartnerTransDate() != null ? pit.getPayment().getPartnerTransDate() : null);
				
				// pmt.setServiceId(pit.getPaymentExtn().getServiceType() != null ? pit.getPaymentExtn().getServiceType() : null);
				// pmt.setBeneficiaryId(pit.getPaymentExtn().getBeneficiary() != null ? pit.getPaymentExtn().getBeneficiary().getPartyId() : null);
				// MOI Payments Beneficiary ID is coming in PaymentReference -> PartnerService -> Beneficiary ID --> Party ID
				pmt.setBeneficiaryId(pit.getPaymentReference().getPartnerService() != null ? pit.getPaymentReference().getPartnerService().getBeneficiaryId().getPartyIdType() +
						pit.getPaymentReference().getPartnerService().getBeneficiaryId().getPartyId() : null);
				pmt.setServiceId(pit.getPaymentReference().getPartnerService() != null ? pit.getPaymentReference().getPartnerService().getService().getServiceCode() : null);

				pmt.setDistrictCode(pit.getPayment().getDistrictCode() != null ? pit.getPayment().getDistrictCode() : null);
				String customerIdType = pit.getPayment().getPayor() != null ? pit.getPayment().getPayor().getPartyIdType().value() : "";
				pmt.setCustomerId((pit.getPayment().getPayor() != null ? customerIdType + pit.getPayment().getPayor().getPartyId() : null));
				pmt.setPaymentStatus(pit.getPayment().getLifecycleState() != null ? pit.getPayment().getLifecycleState() : null);

				if(pit.getRefund() != null && pit.getRefund().size() > 0)
				{
					String allRefunds = "";
					for (com.sadad.scm.common._1.RefundType r : pit.getRefund())
						allRefunds = allRefunds + r.getPartnerRefKey() + ", ";

					pmt.setRefundId(allRefunds.substring(0, allRefunds.lastIndexOf(',')));
				}
				
				coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			}
			
			if(coreObj.getPayments().size() % 100 == 0)
				coreObj.setPageNumber(coreObj.getPageNumber()+1);
			else
				coreObj.setPageNumber(-1); // Setting -1 value will not display Fetch more data button on JSP page
		}
		catch(PaymentFault e)
		{
			if(e.getFaultInfo().getCode() == 13030) // ERROR:13030:The Page requested in the request is out of Page Ranges
				coreObj.setPageNumber(-1); // Setting -1 value will not display Fetch more data button on JSP page
			else
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
	 * Calls the backend webservice to get the SPL payments by payment id. This method is called for getting SPL payments
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_ListSPLPayments(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_ListSPLPayments";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListSPLPaymentsRqType req = new ListSPLPaymentsRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-UNCANCEL", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPaymentKey(coreObj.getPaymentId());
			ListSPLPaymentsRsType res = paymentService.listSPLPayments(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getSpls().clear();
			int ikey = 0;
			for (SPLPaymentInfoType pit : res.getSPLPaymentInfo())
			{
				SadadPaymentLog spl = new SadadPaymentLog();
				spl.setInteratorKey("" + ikey++);
				spl.setPaymentKey(pit.getPaymentKey() != null ? pit.getPaymentKey() : null);
				spl.setBankNumber(pit.getBNKPTN() != null ? pit.getBNKPTN() : null);
				spl.setAmount(pit.getAmount());

				spl.setStatus(pit.getStatus() != null ? pit.getStatus() : null);

				coreObj.getSpls().put(spl.getInteratorKey(), spl);
			}
		}
		catch(PaymentFault e)
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
	 * Call the backend webservice to cancel the payment using payment key
	 *    
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_Cancel(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_Cancel";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			CancelRqType req = new CancelRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-CANCEL", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPaymentKey(coreObj.getPaymentId());

			paymentService.cancel(req);
			Payment pmt = coreObj.getPayments().get(coreObj.getPaymentId());
			pmt.setPaymentStatus(PaymentLifecycleEnums.CANCELED);
			coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			coreObj.setGenericInfoMessage();
		}
		catch(PaymentFault e)
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
	 * Call the backend webservice to cancel the payment using payment key
	 *    
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callPaymentService_UnCancel(CoreEbppSessionDataBean coreObj) 
	{
		final String methodName = "callPaymentService_UnCancel";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			UncancelRqType req = new UncancelRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "PAYMENT-UNCANCEL", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setPaymentKey(coreObj.getPaymentId());
			paymentService.uncancel(req);
			Payment pmt = coreObj.getPayments().get(coreObj.getPaymentId());
			pmt.setPaymentStatus(PaymentLifecycleEnums.ADVISED);
			coreObj.getPayments().put(pmt.getSadadNumber(), pmt);
			coreObj.setGenericInfoMessage();
		}
		catch(PaymentFault e)
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
	
	
	// Core Payment Calls Code Ends Here
	
	// Refund Search Calls Code Starts Here
	/**
	 * Calls the backend webservice to get the refund by id.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callRefundService_GetRefund(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callRefundService_GetRefund";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GetRefundRqType req = new GetRefundRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "REFUND-GET_REFUND", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setRefundKey(coreObj.getRefundId());
			// Set Partner Key for logged-in users
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK) ||
					coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER)) 
				req.setPartnerKey(coreObj.getPartnerKey());

			GetRefundRsType res = refundService.getRefund(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getRefunds().clear();
			RefundType rt = res.getRefund();
			if(rt != null)
			{
				// TODO - Remove this temporary fix this should be filtered in backend WAS Service.
				if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK) && !coreObj.getPartnerKey().equalsIgnoreCase(rt.getBankKey()))
					return coreObj;
				// Temporary fix until backend is not changed by passing if logged-in biller is not matched with one coming in response
				if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER) && !coreObj.getPartnerKey().equalsIgnoreCase(rt.getBillerKey()))
					return coreObj;

				Refund rfd = new Refund();
				rfd.setRefundId(rt.getRefundKey());
				rfd.setBankId(rt.getBankKey());
				rfd.setBillerId(rt.getBillerKey());
				rfd.setCustomerId(rt.getOfficialIdType() + rt.getOfficialId());
				rfd.setPaymentSptn(rt.getSADADTransactionNumber());
				rfd.setRefundStatus(rt.getRefundStatusType().value());
				rfd.setNotificationStatus(rt.getNotificationStatusType() != null ? rt.getNotificationStatusType().value() : "");
				rfd.setRefundType(rt.getRefundType().value());
				rfd.setAmount(rt.getCurAmt() != null ? rt.getCurAmt() : new BigDecimal(0.00));
				if(rt.getExpiryDate() != null )
					rfd.setExpiryDate(rt.getExpiryDate());
				rfd.setRefundTransactionNumber(rt.getExternalRefundKey());
				rfd.setServiceId(rt.getServiceID() != null ? rt.getServiceID() : "");
				rfd.setAccountNumber(rt.getCustomerAccountNumber() != null ? rt.getCustomerAccountNumber() : "");

				coreObj.getRefunds().put(rfd.getRefundId(), rfd);
			}
		}
		catch (RefundFault e)
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
	 * Calls the backend webservice to get the refund by biller or bank id.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callRefundService_ListRefund(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callRefundService_ListRefund";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListRefundRqType req = new ListRefundRqType();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "REFUND-LIST_REFUND", coreObj.getRemoteUser(), coreObj.getLanguageCode()));

			if(coreObj.getBankId() != null)
				req.setBankKey(coreObj.getBankId());
			//Add the bank key from logged in session
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				req.setBankKey(coreObj.getPartnerKey());

			if(coreObj.getBillerId() != null)
				req.setBillerKey(coreObj.getBillerId());
			//Add the biller key from logged in session
			if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				req.setBillerKey(coreObj.getPartnerKey());
			
			req.setFromDate(coreObj.parseXmlDate(coreObj.getFromDate()));
			req.setToDate(coreObj.getNextDate(coreObj.getFromDate(), Integer.parseInt(coreObj.getDateRange())));

			if(coreObj.getRefundStatus() != null)
				req.setRefundStatus(coreObj.getRefundStatus());
			if(coreObj.getNotiStatus() != null)
				req.setNotifyStatus(coreObj.getNotiStatus());
			if(coreObj.getReconStatus() != null)
				req.setReconStatus(coreObj.getReconStatus());

			ListRefundRsType res = refundService.listRefund(req);

			// if it reaches here, it means response is successful change status manually in session object
			coreObj.getRefunds().clear();
			for(RefundsType rt : res.getRefunds())
			{
				Refund rfd = new Refund();
				rfd.setRefundId(rt.getRefundKey());
				rfd.setBankId(rt.getBankKey());
				rfd.setBillerId(rt.getBillerKey() != null ? rt.getBillerKey() : "");
				rfd.setCustomerId(rt.getOfficialIdType() + rt.getOfficialId());
				rfd.setPaymentSptn(rt.getSADADTransactionNumber());
				rfd.setRefundStatus(rt.getRefundStatusType().value());
				rfd.setNotificationStatus(rt.getNotificationStatusType() != null ? rt.getNotificationStatusType().value() : "");
				rfd.setRefundType(rt.getRefundType().value());
				rfd.setAmount(rt.getCurAmt() != null ? rt.getCurAmt() : BigDecimal.valueOf(0.00));
				if(rt.getExpiryDate() != null )
					rfd.setExpiryDate(rt.getExpiryDate());
				rfd.setRefundTransactionNumber(rt.getExternalRefundKey());
				rfd.setServiceId(rt.getServiceID() != null ? rt.getServiceID() : "");
				rfd.setAccountNumber(rt.getCustomerAccountNumber() != null ? rt.getCustomerAccountNumber() : "");

				coreObj.getRefunds().put(rfd.getRefundId(), rfd);
			}
		}
		catch (RefundFault e)
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
	 * Calls the backend webservice to get the refund by biller or bank id.
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionDataBean callRefundService_ListRefundPortal(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callRefundService_ListRefundPortal";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListRefundRqTypePortal req = new ListRefundRqTypePortal();
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "REFUND-LIST_REFUND_BY_CUSTOMER", coreObj.getRemoteUser(), coreObj.getLanguageCode()));

			PartyType customer = new PartyType();		
			customer.setPartyId(coreObj.getCustomerId());
			customer.setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
			req.setCustomer(customer);

			ListRefundRsTypePortal res = refundService.listRefundPortal(req);

			// if it reaches here, it means response is successful change status manually in session object
			coreObj.getRefunds().clear();
			for(RefundsType rt : res.getRefundsPortal())
			{
				// TODO - Filter Bank or Biller based on Logged in user
				// Temporary fix until backend is not changed by passing if logged-in bank is not matched with one coming in response
				if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK) && !coreObj.getPartnerKey().equalsIgnoreCase(rt.getBankKey()))
					continue;
				// Temporary fix until backend is not changed by passing if logged-in biller is not matched with one coming in response
				if(coreObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER) && !coreObj.getPartnerKey().equalsIgnoreCase(rt.getBillerKey()))
					continue;

				Refund rfd = new Refund();
				rfd.setRefundId(rt.getRefundKey());
				rfd.setBankId(rt.getBankKey());
				rfd.setBillerId(rt.getBillerKey());
				rfd.setCustomerId(rt.getOfficialIdType() + rt.getOfficialId());
				rfd.setPaymentSptn(rt.getSADADTransactionNumber());
				rfd.setRefundStatus(rt.getRefundStatusType().value());
				rfd.setNotificationStatus(rt.getNotificationStatusType() != null ? rt.getNotificationStatusType().value() : "");
				rfd.setRefundType(rt.getRefundType().value());
				rfd.setAmount(rt.getCurAmt() != null ? rt.getCurAmt() : new BigDecimal(0.00));
				if(rt.getExpiryDate() != null )
					rfd.setExpiryDate(rt.getExpiryDate());
				rfd.setRefundTransactionNumber(rt.getExternalRefundKey());
				rfd.setServiceId(rt.getServiceID() != null ? rt.getServiceID() : "");
				rfd.setAccountNumber(rt.getCustomerAccountNumber() != null ? rt.getCustomerAccountNumber() : "");

				coreObj.getRefunds().put(rfd.getRefundId(), rfd);
			}
		}
		catch (RefundFault e)
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
	// Refund Search Calls Code Ends Here

	// Custom methods for handling special scenarios
	public CoreEbppSessionDataBean callCustomised_GetPaymentsByBillIdOrByAccount(CoreEbppSessionDataBean coreObj)
	{
		if(coreObj.getBillNumber() != null)
			coreObj = callPaymentService_ListByBillId(coreObj);
		else
			coreObj = callPaymentService_ListByAccount(coreObj);
		return coreObj;
	}
	
	public CoreEbppSessionDataBean callCustomised_ShowCounterPartBill(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callCustomised_ShowCounterPartBill";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType req = new com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType();
			
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "BILL-COUNTER_PART", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setBillerKey(coreObj.getBillerId());
			req.setAccountKey(coreObj.getAccountNumber());
			req.setStatus(ListBillStatusType.ACTIVE);
			
			com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType res = billService.listByAccount(req);
			boolean noCounterPartFound = true;
			// if it reaches here, it means response is successful change status manually in session object
			if(res.getBills().size() > 0)
			{
				for(ExtBillType rBill : res.getBills())
				{
					if(coreObj.getShowCounterFor().equalsIgnoreCase(rBill.getBillType().value()))
						continue;

					if(coreObj.getJsonObj() != null)
					{
						char col = ':';
						char comma = ',';
						char quote = '"';
						char ob = '{';
						char cb = '}';
						
						StringBuilder response = new StringBuilder();
						
						response.append(ob);
						response.append(quote).append("billNumber").append(quote).append(col);
						response.append(quote).append(rBill.getBillKey() != null ? rBill.getBillKey() : "").append(quote).append(comma);
						response.append(quote).append("billType").append(quote).append(col);
						response.append(quote).append(rBill.getBillType().value()).append(quote).append(comma);
						response.append(quote).append("origianlAmount").append(quote).append(col);
						response.append(quote).append(rBill.getOriginalAmount()).append(quote).append(comma);
						response.append(quote).append("billGeneratedDate").append(quote).append(col);
						response.append(quote).append(rBill.getGenerationDate()).append(quote).append(comma);
						response.append(quote).append("billCycle").append(quote).append(col);
						response.append(quote).append(rBill.getBillCycle() != null ? rBill.getBillCycle() : "").append(quote).append(comma);
						response.append(quote).append("billCategory").append(quote).append(col);
						response.append(quote).append(rBill.getBillCategory() != null ? rBill.getBillCategory() : "").append(quote).append(comma);
						response.append(quote).append("netAmount").append(quote).append(col);
						response.append(quote).append(rBill.getAmountDue()).append(quote).append(comma);
						response.append(quote).append("expiryDate").append(quote).append(col);
						response.append(quote).append(rBill.getExpiryDate() != null ? rBill.getExpiryDate() : "").append(quote).append(comma);
						response.append(quote).append("paymentCount").append(quote).append(col);						
						response.append(quote).append(rBill.getPaymentsCount()).append(quote);
						response.append(cb);
						coreObj.setJsonObj(response.toString());
						noCounterPartFound = false;
						break;
					}
				}
			}
			if(noCounterPartFound)
			{
				// Throwing BillSearchFault with code 10004
				String message = "No bill found for the search criteria.";
				FaultType ft = new FaultType();
				ft.setType(ErrorType.BUSINESS);
				ft.setSeverity(SeverityType.ERROR);
				ft.setCode(10004);
				ft.setDescription(message);
				throw new BillSearchFault(message, ft);
			}
		}
		catch (BillSearchFault e)
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
	// Custom methods for handling special scenarios
	
	// Start of Audit for EBPP Section
	public CoreEbppSessionDataBean callAuditService_ListAudit(CoreEbppSessionDataBean coreObj)
	{
		final String methodName = "callAuditService_ListAudit";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			ListAuditRqType req = new ListAuditRqType();
			
			req.setMessageHeader(getMessageHeaderType(coreObj.getPartnerKey(), "CORE_OBJ_LIST_AUDIT", coreObj.getRemoteUser(), coreObj.getLanguageCode()));
			req.setEntity(coreObj.getAuditEntity());
			req.setSadadKey(coreObj.getAuditSadadKey());
			
			ListAuditRsType res = auditService.listAudit(req);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.getAudits().clear();
			int k = 0;
			for(EntityHistoryResponseType rAdt : res.getEntityHistoryResponse())
			{
				Audit audit = new Audit();
				audit.setAuditAction(rAdt.getAction());
				audit.setAuditDate(rAdt.getTimestamp());
				audit.setAuditOption("");
				audit.setAuditSource(rAdt.getSource());
				audit.setAuditType(rAdt.getMSGCD());
				audit.setAuditSourceId(rAdt.getRQUID());
				coreObj.getAudits().put(k++, audit);
			}
		}
		catch (ListAuditFault e)
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
	// End  of Audit for EBPP Section
	
	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public CoreEbppSessionDataBean clearSessionBeanObject(CoreEbppSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}