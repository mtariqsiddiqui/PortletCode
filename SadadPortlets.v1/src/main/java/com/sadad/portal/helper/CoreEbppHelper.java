/**
 * 
 */
package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.customer._1.ActivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRsType;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.Association;
import com.sadad.portal.beans.CoreEbppSessionBean;
import com.sadad.portal.beans.Customer;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;
import com.sadad.scm.common._1.AccountInfoType;
import com.sadad.scm.common._1.AssociatedAccountType;
import com.sadad.scm.common._1.AssociatedCustomerType;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.PartyIdTypeType;
import com.sadad.scm.common._1.PartyType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class CoreEbppHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = CoreEbppHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	// AccountQuery Calls Code Starts Here
	/**
	 * Calls the backend webservice to get the customer by key (i.e ID type and ID number)
	 * 
	 * @param coreObj - Session bean object which will be manipulated with service call results
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callAccountService_GetByKey(CoreEbppSessionBean coreObj)
	{
		final String methodName = "callAccountService_GetByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			com.sadad.schema.service.accountquery._1.GetByKeyRqType actReq = new com.sadad.schema.service.accountquery._1.GetByKeyRqType();
			actReq.setMessageHeader(getMessageHeaderType("ACCOUNT-GET_BY_KEY"));
			actReq.setBillerKey(coreObj.getBillerId());
			actReq.setAccountKey(coreObj.getAccountNumber());
			com.sadad.schema.service.accountquery._1.GetByKeyRsType  actRes = accountServices.getByKey(actReq);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.setAccount(new Account());
			coreObj.getAccount().setAccountNumber(actRes.getAccountInfo().getAccountKey());
			coreObj.getAccount().setBillerId(actRes.getAccountInfo().getBillerKey());
			coreObj.getAccount().setServiceType(actRes.getAccountInfo().getServiceType());
			coreObj.getAccount().setLifecycle(actRes.getAccountInfo().getLifecycle());
			coreObj.getAccount().setAccountSource(actRes.getAccountInfo().getAccountSource());
		}
		catch (AccountQueryFault e)
		{
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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
	 * @param officialIdNumber - Customer Official ID number to be searched
	 * @param officialIdType - Customer Official ID Type to be searched
	 * @param billerId - Biller Id to be searched 
	 * @param coreObj - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callAccountService_ListByCustomer(CoreEbppSessionBean coreObj)
	{
		final String methodName = "callAccountService_ListByCustomer";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			ListByCustomerRqType actReq = new ListByCustomerRqType();
			actReq.setMessageHeader(getMessageHeaderType("CUSTOMER-LIST-BY-CUSTOMER"));
			if (coreObj.getBillerId() != null)
				actReq.setBillerKey(coreObj.getBillerId());
			actReq.setPayor(new PartyType());
			actReq.getPayor().setPartyId(coreObj.getCustomerId());
			actReq.getPayor().setPartyIdType(PartyIdTypeType.valueOf(coreObj.getCustomerIdType()));
			ListByCustomerRsType actRes = accountServices.listByCustomer(actReq);

			// if it reaches here, it means response is successfull change status manually in session object
			PartyType custParty = actRes.getCustomerAccountsAssn().getCustomer();
			coreObj.setCustomer(new Customer());
			coreObj.getCustomer().setOfficialIdNumber(custParty.getPartyId());
			coreObj.getCustomer().setOfficialIdType(custParty.getPartyIdType().value());
			coreObj.getCustomer().setCustomerStatus(custParty.getPartyStatus().value());
			coreObj.getCustomer().setCustomerType(custParty.getPartyType().value());
			
			if(actRes.getCustomerAccountsAssn().getAssociatedAccount().size() > 0)
			{
				coreObj.setAssociation(null);
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
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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

	// CustomerPort Calls Code Starts Here 
	/**
	 * Calls the backend webservice to activate or deactivate the Customer
	 * 
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callCustomerService_ActivateOrDeActivateCustomer(CoreEbppSessionBean coreObj)
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
				cdr.setMessageHeader(getMessageHeaderType("DEACTIVATE_CUSTOMER"));
				cdr.setPayor(new PartyType());
				cdr.getPayor().setPartyId(coreObj.getCustomer().getOfficialIdNumber());
				cdr.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomer().getOfficialIdType()));
				customerServices.deactivate(cdr);

				// if it reaches here, it means response is successfull change status manually in session object
				coreObj.getCustomer().setCustomerStatus("INACTIVE");
			}
			else if (coreObj.getCustomer().getCustomerStatus().equalsIgnoreCase(ConfigurationStatusEnum.INACTIVE.value()))
			{
				// Call the backend service - Activate
				ActivateRqType car = new ActivateRqType();
				car.setMessageHeader(getMessageHeaderType("ACTIVATE_CUSTOMER"));
				car.setPayor(new PartyType());
				car.getPayor().setPartyId(coreObj.getCustomer().getOfficialIdNumber());
				car.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomer().getOfficialIdType()));
				customerServices.activate(car);

				// if it reaches here, it means response is successfull change status manually in session object
				coreObj.getCustomer().setCustomerStatus("ACTIVE");
			}
		}
		catch (CustomerFault e)
		{
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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
	 * @param officialIdNumber - Customer Official ID number to be searched
	 * @param officialIdType - Customer Official ID Type to be searched
	 * @param coreObj - Session bean object which will be manipulated with service call results
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callCustomerService_GetByKey(CoreEbppSessionBean coreObj)
	{
		final String methodName = "callCustomerService_GetByKey";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			GetByKeyRqType cstReq = new GetByKeyRqType();
			cstReq.setMessageHeader(getMessageHeaderType("CUSTOMER-GET_BY_KEY"));
			cstReq.setPayor(new PartyType());
			cstReq.getPayor().setPartyId(coreObj.getCustomerId());
			cstReq.getPayor().setPartyIdType(PartyIdTypeType.fromValue(coreObj.getCustomerIdType()));
			GetByKeyRsType  cstRes = customerServices.getByKey(cstReq);

			// if it reaches here, it means response is successfull change status manually in session object
			coreObj.setCustomer(new Customer());
			coreObj.getCustomer().setOfficialIdNumber(coreObj.getCustomerId());
			coreObj.getCustomer().setOfficialIdType(coreObj.getCustomerIdType());
			coreObj.getCustomer().setCustomerStatus(cstRes.getStatus().value());
		}
		catch (CustomerFault e)
		{
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callCustomerService_ListByAccount(CoreEbppSessionBean coreObj)
	{
		final String methodName = "callCustomerService_ListByAccount";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service - Activate
			ListByAccountRqType cstReq = new ListByAccountRqType();
			cstReq.setMessageHeader(getMessageHeaderType("CUSTOMER-LIST_BY_ACCOUNT"));
			cstReq.setBillerKey(coreObj.getBillerId());
			cstReq.setAccountKey(coreObj.getAccountNumber());
			ListByAccountRsType cstRes = customerServices.listByAccount(cstReq);

			// if it reaches here, it means response is successfull change status manually in session object
			AccountInfoType accountInfo = cstRes.getAccountCustomersAssn().getAccountInfo();
			coreObj.setAccount(new Account());
			coreObj.getAccount().setAccountNumber(accountInfo.getAccountKey());
			coreObj.getAccount().setBillerId(accountInfo.getBillerKey());
			coreObj.getAccount().setServiceType(accountInfo.getServiceType());
			coreObj.getAccount().setLifecycle(accountInfo.getLifecycle());
			coreObj.getAccount().setAccountSource(accountInfo.getAccountSource());

			if(cstRes.getAccountCustomersAssn().getAssociatedCustomer().size() > 0)
			{
				coreObj.setAssociation(null);
				for(AssociatedCustomerType act : cstRes.getAccountCustomersAssn().getAssociatedCustomer())
				{
					Association asc = new Association();
					PartyType pt = act.getCustomer();
					asc.setOfficialIdNumber(pt.getPartyId());
					asc.setOfficialIdType(pt.getPartyIdType().value());
					asc.setCustomerStatus(pt.getPartyStatus().value());
					asc.setAssociationType(act.getAssnType().value());
					if(act.getAssociatedBy().getBankKey() != null)
						asc.setAssigningOrganization(act.getAssociatedBy().getBankKey());
					if(act.getAssociatedBy().getBillerKey() != null)
						asc.setAssigningOrganization(act.getAssociatedBy().getBillerKey());

					coreObj.getAssociation().put(asc.getOfficialIdNumber(), asc);
				}
			}
		}
		catch (CustomerFault e)
		{
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callCustomerService_ListByBill(CoreEbppSessionBean coreObj)
	{
		// TODO - This service is not required on Portal Screens
		final String methodName = "callCustomerService_ListByBill";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Call the backend service
			ListByBillRqType cstReq = new ListByBillRqType();
			cstReq.setMessageHeader(getMessageHeaderType("CUSTOMER-LIST_BY_BILL"));
			cstReq.setBillerKey(coreObj.getPartnerKey());
			cstReq.setBillKey(coreObj.getBillKey());
			ListByBillRsType cstRes = customerServices.listByBill(cstReq);

			// if it reaches here, it means response is successfull change status manually in session object
			AccountInfoType accountInfo = cstRes.getAccountCustomersAssn().getAccountInfo();
			coreObj.setAccount(new Account());
			coreObj.getAccount().setAccountNumber(accountInfo.getAccountKey());
			coreObj.getAccount().setBillerId(accountInfo.getBillerKey());
			coreObj.getAccount().setServiceType(accountInfo.getServiceType());
			coreObj.getAccount().setLifecycle(accountInfo.getLifecycle());
			coreObj.getAccount().setAccountSource(accountInfo.getAccountSource());

			if(cstRes.getAccountCustomersAssn().getAssociatedCustomer().size() > 0)
			{
				PartyType pt = cstRes.getAccountCustomersAssn().getAssociatedCustomer().get(0).getCustomer();
				coreObj.setCustomer(new Customer());
				coreObj.getCustomer().setOfficialIdNumber(pt.getPartyId());
				coreObj.getCustomer().setOfficialIdType(pt.getPartyIdType().value());
				coreObj.getCustomer().setCustomerType(pt.getPartyType().value());
				coreObj.getCustomer().setCustomerStatus(pt.getPartyStatus().value());
			}
		}
		catch (CustomerFault e)
		{
			coreObj.setErrorMessage(e.getFaultInfo().getDescription());
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
	 * @param coreObj
	 *            - Session bean object contain the necessary informaiton to populate the SOAP request
	 * @return coreObj after the reflected updates from SOAP response
	 */
	public CoreEbppSessionBean callCustomerService_CustomerDisassociation(CoreEbppSessionBean coreObj)
	{
		// TODO - incomplete implementation
		return coreObj;
	}
	// CustomerPort Calls Code Ends Here 
}
