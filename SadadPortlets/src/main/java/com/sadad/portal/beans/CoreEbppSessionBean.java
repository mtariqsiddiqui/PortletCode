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

public abstract class CoreEbppSessionBean extends SadadPortalSessionBean
{
	protected String accountNumber;
	protected Account account;
	protected Customer customer;
	protected String associationKey;
	protected HashMap<String, Association> association;
	protected String billKey;
	protected HashMap<String, Bill> bills;
	protected String paymentKey;
	protected HashMap<String, Payment> payments;
	protected String refundKey;
	protected HashMap<String, Refund> refunds;
	protected List<BusinessRule> businessRules;
	protected List<Audit> audits;

	
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
		if(audits == null)
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
