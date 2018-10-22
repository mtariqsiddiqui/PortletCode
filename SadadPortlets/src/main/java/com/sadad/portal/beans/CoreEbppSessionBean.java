/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tariq Siddiqui
 * 
 */

public class CoreEbppSessionBean extends SadadPortalSessionBean
{
	private String accountNumber;
	private String bankId;
	private String billerId;
	private String billNumber;
	private String refundId;
	private String paymentId;
	private String paymentIdType;
	private String customerId;
	private String customerIdType;
	private String fromDate;
	private String dateRange;
	
	private Account account;
	private Customer customer;
	
	private String associationKey;
	private HashMap<String, Association> association;
	
	private String billKey;
	private HashMap<String, Bill> bills;
	
	private String paymentKey;
	private HashMap<String, Payment> payments;
	
	private String refundKey;
	private HashMap<String, Refund> refunds;

	private List<BusinessRule> businessRules;
	private List<Audit> audits;

	public CoreEbppSessionBean()
	{
		super();
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the bankId
	 */
	public String getBankId()
	{
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(String bankId)
	{
		this.bankId = bankId;
	}

	/**
	 * @return the billerId
	 */
	public String getBillerId()
	{
		return billerId;
	}

	/**
	 * @param billerId
	 *            the billerId to set
	 */
	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	/**
	 * @return the billNumber
	 */
	public String getBillNumber()
	{
		return billNumber;
	}

	/**
	 * @param billNumber
	 *            the billNumber to set
	 */
	public void setBillNumber(String billNumber)
	{
		this.billNumber = billNumber;
	}

	/**
	 * @return the refundId
	 */
	public String getRefundId()
	{
		return refundId;
	}

	/**
	 * @param refundId
	 *            the refundId to set
	 */
	public void setRefundId(String refundId)
	{
		this.refundId = refundId;
	}

	/**
	 * @return the paymentId
	 */
	public String getPaymentId()
	{
		return paymentId;
	}

	/**
	 * @param paymentId
	 *            the paymentId to set
	 */
	public void setPaymentId(String paymentId)
	{
		this.paymentId = paymentId;
	}

	/**
	 * @return the paymentIdType
	 */
	public String getPaymentIdType()
	{
		return paymentIdType;
	}

	/**
	 * @param paymentIdType
	 *            the paymentIdType to set
	 */
	public void setPaymentIdType(String paymentIdType)
	{
		this.paymentIdType = paymentIdType;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId()
	{
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	/**
	 * @return the customerIdType
	 */
	public String getCustomerIdType()
	{
		return customerIdType;
	}

	/**
	 * @param customerIdType
	 *            the customerIdType to set
	 */
	public void setCustomerIdType(String customerIdType)
	{
		this.customerIdType = customerIdType;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate()
	{
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	/**
	 * @return the dateRange
	 */
	public String getDateRange()
	{
		return dateRange;
	}

	/**
	 * @param dateRange
	 *            the dateRange to set
	 */
	public void setDateRange(String dateRange)
	{
		this.dateRange = dateRange;
	}

	/**
	 * @return the account
	 */
	public Account getAccount()
	{
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account)
	{
		this.account = account;
	}

	/**
	 * @return the billKey
	 */
	public String getBillKey()
	{
		return billKey;
	}

	/**
	 * @param billKey
	 *            the billKey to set
	 */
	public void setBillKey(String billKey)
	{
		this.billKey = billKey;
	}

	/**
	 * @return the bills
	 */
	public HashMap<String, Bill> getBills()
	{
		if (bills == null)
			bills = new HashMap<String, Bill>();
		return bills;
	}

	/**
	 * @return the customers
	 */
	public Customer getCustomer()
	{
		return customer;
	}

	/**
	 * @param customers
	 *            the customers to set
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	/**
	 * @return the paymentKey
	 */
	public String getPaymentKey()
	{
		return paymentKey;
	}

	/**
	 * @param paymentKey
	 *            the paymentKey to set
	 */
	public void setPaymentKey(String paymentKey)
	{
		this.paymentKey = paymentKey;
	}

	/**
	 * @return the payments
	 */
	public HashMap<String, Payment> getPayments()
	{
		if (payments == null)
			payments = new HashMap<String, Payment>();
		return payments;
	}

	/**
	 * @return the associationKey
	 */
	public String getAssociationKey()
	{
		return associationKey;
	}

	/**
	 * @param associationKey
	 *            the associationKey to set
	 */
	public void setAssociationKey(String associationKey)
	{
		this.associationKey = associationKey;
	}

	/**
	 * @return the association
	 */
	public HashMap<String, Association> getAssociation()
	{
		if (association == null)
			association = new HashMap<String, Association>();
		return association;
	}

	/**
	 * @param association the association to set
	 */
	public void setAssociation(HashMap<String, Association> association)
	{
		this.association = association;
	}

	/**
	 * @return the refundKey
	 */
	public String getRefundKey()
	{
		return refundKey;
	}

	/**
	 * @param refundKey
	 *            the refundKey to set
	 */
	public void setRefundKey(String refundKey)
	{
		this.refundKey = refundKey;
	}

	/**
	 * @return the businessRules
	 */
	public List<BusinessRule> getBusinessRules()
	{
		if (businessRules == null)
			businessRules = new ArrayList<BusinessRule>();
		return businessRules;
	}

	/**
	 * @return the audits
	 */
	public List<Audit> getAudits()
	{
		if (audits == null)
			audits = new ArrayList<Audit>();
		return audits;
	}

	/**
	 * @return the refunds
	 */
	public HashMap<String, Refund> getRefunds()
	{
		if (refunds == null)
			refunds = new HashMap<String, Refund>();
		return refunds;
	}
}