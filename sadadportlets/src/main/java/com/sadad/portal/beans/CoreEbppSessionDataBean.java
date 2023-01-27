/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Tariq Siddiqui
 * 
 */

public class CoreEbppSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String accountNumber;
	private String bankId;
	private String billerId;
	private String billNumber;
	private String billCategory;
	private String billType;
	private String billGenerationDate;
	private String refundId;
	private String paymentId;
	private String paymentIdType;
	private String customerId;
	private String customerIdType;
	private String fromDate;
	private String dateRange;
	private String refundStatus;
	private String notiStatus;
	private String reconStatus;
	private String status;

	private String accountKey;
	private LinkedHashMap<String, Account> accounts;
	private Customer customer;

	private String associationKey;
	private LinkedHashMap<String, Association> association;

	private String billKey;
	private LinkedHashMap<String, Bill> bills;

	 private String paymentKey;
	 private LinkedHashMap<String, Payment> payments;

	private String splKey;
	private LinkedHashMap<String, SadadPaymentLog> spls;

	private String refundKey;
	private LinkedHashMap<String, Refund> refunds;
	private List<BusinessRule> businessRules;

	private int pageNumber;
	private String showCounterFor;

	public CoreEbppSessionDataBean()
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
	 * @return the billCategory
	 */
	public String getBillCategory()
	{
		return billCategory;
	}

	/**
	 * @param billCategory the billCategory to set
	 */
	public void setBillCategory(String billCategory)
	{
		this.billCategory = billCategory;
	}

	/**
	 * @return the billType
	 */
	public String getBillType()
	{
		return billType;
	}

	/**
	 * @param billType the billType to set
	 */
	public void setBillType(String billType)
	{
		this.billType = billType;
	}

	/**
	 * @return the billGenerationDate
	 */
	public String getBillGenerationDate()
	{
		return billGenerationDate;
	}

	/**
	 * @param billGenerationDate the billGenerationDate to set
	 */
	public void setBillGenerationDate(String billGenerationDate)
	{
		this.billGenerationDate = billGenerationDate;
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
	 * @return the refundStatus
	 */
	public String getRefundStatus()
	{
		return refundStatus;
	}

	/**
	 * @param refundStatus
	 *            the refundStatus to set
	 */
	public void setRefundStatus(String refundStatus)
	{
		this.refundStatus = refundStatus;
	}

	/**
	 * @return the notiStatus
	 */
	public String getNotiStatus()
	{
		return notiStatus;
	}

	/**
	 * @param notiStatus
	 *            the notiStatus to set
	 */
	public void setNotiStatus(String notiStatus)
	{
		this.notiStatus = notiStatus;
	}

	/**
	 * @return the reconStatus
	 */
	public String getReconStatus()
	{
		return reconStatus;
	}

	/**
	 * @param reconStatus
	 *            the reconStatus to set
	 */
	public void setReconStatus(String reconStatus)
	{
		this.reconStatus = reconStatus;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
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
	public LinkedHashMap<String, Bill> getBills()
	{
		if (bills == null)
			bills = new LinkedHashMap<String, Bill>();
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
	 * @return the accountKey
	 */
	public String getAccountKey()
	{
		return this.accountKey;
	}

	/**
	 * @param accountKey
	 *            the accountKey to set
	 */
	public void setAccountKey(String accountKey)
	{
		this.accountKey = accountKey;
	}

	/**
	 * @return the accounts
	 */
	public LinkedHashMap<String, Account> getAccounts()
	{
		if (accounts == null)
			accounts = new LinkedHashMap<String, Account>();
		return accounts;
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
	public LinkedHashMap<String, Payment> getPayments()
	{
		if (payments == null)
			payments = new LinkedHashMap<String, Payment>();
		return payments;
	}

	/**
	 * @return the splKey
	 */
	public String getSplKey()
	{
		return splKey;
	}

	/**
	 * @param splKey the splKey to set
	 */
	public void setSplKey(String splKey)
	{
		this.splKey = splKey;
	}

	/**
	 * @return the spls
	 */
	public LinkedHashMap<String, SadadPaymentLog> getSpls()
	{
		if(spls == null)
			spls = new LinkedHashMap<String, SadadPaymentLog>();
		return spls;
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
	public LinkedHashMap<String, Association> getAssociation()
	{
		if (association == null)
			association = new LinkedHashMap<String, Association>();
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
	 * @return the refunds
	 */
	public LinkedHashMap<String, Refund> getRefunds()
	{
		if (refunds == null)
			refunds = new LinkedHashMap<String, Refund>();
		return refunds;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber()
	{
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the showCounterFor
	 */
	public String getShowCounterFor()
	{
		return showCounterFor;
	}

	/**
	 * @param showCounterFor the showCounterFor to set
	 */
	public void setShowCounterFor(String showCounterFor)
	{
		this.showCounterFor = showCounterFor;
	}
}