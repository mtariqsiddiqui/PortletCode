package com.sadad.portal.beans;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

public class Refund
{
	private String refundId;;
	private String bankId;
	private String billerId;
	private String customerId;
	private String refundType;
	private String notificationStatus;
	private XMLGregorianCalendar expiryDate;
	private String refundTransactionNumber;
	private String paymentSptn;
	private String accountNumber;
	private String refundStatus;
	private BigDecimal amount;
	private int reconStatus;
	private String serviceId;

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
	 * @return the refundType
	 */
	public String getRefundType()
	{
		return refundType;
	}

	/**
	 * @param refundType
	 *            the refundType to set
	 */
	public void setRefundType(String refundType)
	{
		this.refundType = refundType;
	}

	/**
	 * @return the notificationStatus
	 */
	public String getNotificationStatus()
	{
		return notificationStatus;
	}

	/**
	 * @param notificationStatus
	 *            the notificationStatus to set
	 */
	public void setNotificationStatus(String notificationStatus)
	{
		this.notificationStatus = notificationStatus;
	}

	/**
	 * @return the expiryDate
	 */
	public XMLGregorianCalendar getExpiryDate()
	{
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(XMLGregorianCalendar expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the refundTransactionNumber
	 */
	public String getRefundTransactionNumber()
	{
		return refundTransactionNumber;
	}

	/**
	 * @param refundTransactionNumber
	 *            the refundTransactionNumber to set
	 */
	public void setRefundTransactionNumber(String refundTransactionNumber)
	{
		this.refundTransactionNumber = refundTransactionNumber;
	}

	/**
	 * @return the paymentSptn
	 */
	public String getPaymentSptn()
	{
		return paymentSptn;
	}

	/**
	 * @param paymentSptn
	 *            the paymentSptn to set
	 */
	public void setPaymentSptn(String paymentSptn)
	{
		this.paymentSptn = paymentSptn;
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
	 * @return the amount
	 */
	public BigDecimal getAmount()
	{
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the reconStatus
	 */
	public int getReconStatus()
	{
		return reconStatus;
	}

	/**
	 * @param reconStatus
	 *            the reconStatus to set
	 */
	public void setReconStatus(int reconStatus)
	{
		this.reconStatus = reconStatus;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId()
	{
		return serviceId;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(String serviceId)
	{
		this.serviceId = serviceId;
	}
}
