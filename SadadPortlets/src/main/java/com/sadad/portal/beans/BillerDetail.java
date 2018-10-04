package com.sadad.portal.beans;

public class BillerDetail
{
	String billerId;
	String billerName;
	String description;
	String status;
	String billingAccountBankId;
	String billingAccountType;
	String billingAccountNumber;
	String refundAccountBankId;
	String refundAccountType;
	String refundAccountNumber;

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
	 * @return the billerName
	 */
	public String getBillerName()
	{
		return billerName;
	}

	/**
	 * @param billerName
	 *            the billerName to set
	 */
	public void setBillerName(String billerName)
	{
		this.billerName = billerName;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
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
	 * @return the billingAccountBankId
	 */
	public String getBillingAccountBankId()
	{
		return billingAccountBankId;
	}

	/**
	 * @param billingAccountBankId
	 *            the billingAccountBankId to set
	 */
	public void setBillingAccountBankId(String billingAccountBankId)
	{
		this.billingAccountBankId = billingAccountBankId;
	}

	/**
	 * @return the billingAccountType
	 */
	public String getBillingAccountType()
	{
		return billingAccountType;
	}

	/**
	 * @param billingAccountType
	 *            the billingAccountType to set
	 */
	public void setBillingAccountType(String billingAccountType)
	{
		this.billingAccountType = billingAccountType;
	}

	/**
	 * @return the billingAccountNumber
	 */
	public String getBillingAccountNumber()
	{
		return billingAccountNumber;
	}

	/**
	 * @param billingAccountNumber
	 *            the billingAccountNumber to set
	 */
	public void setBillingAccountNumber(String billingAccountNumber)
	{
		this.billingAccountNumber = billingAccountNumber;
	}

	/**
	 * @return the refundAccountBankId
	 */
	public String getRefundAccountBankId()
	{
		return refundAccountBankId;
	}

	/**
	 * @param refundAccountBankId
	 *            the refundAccountBankId to set
	 */
	public void setRefundAccountBankId(String refundAccountBankId)
	{
		this.refundAccountBankId = refundAccountBankId;
	}

	/**
	 * @return the refundAccountType
	 */
	public String getRefundAccountType()
	{
		return refundAccountType;
	}

	/**
	 * @param refundAccountType
	 *            the refundAccountType to set
	 */
	public void setRefundAccountType(String refundAccountType)
	{
		this.refundAccountType = refundAccountType;
	}

	/**
	 * @return the refundAccountNumber
	 */
	public String getRefundAccountNumber()
	{
		return refundAccountNumber;
	}

	/**
	 * @param refundAccountNumber
	 *            the refundAccountNumber to set
	 */
	public void setRefundAccountNumber(String refundAccountNumber)
	{
		this.refundAccountNumber = refundAccountNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BillerDetail [billerId=" + billerId + ", billerName=" + billerName + ", description=" + description + ", status=" + status + ", billingAccountBankId=" + billingAccountBankId + ", billingAccountType=" + billingAccountType
				+ ", billingAccountNumber=" + billingAccountNumber + ", refundAccountBankId=" + refundAccountBankId + ", refundAccountType=" + refundAccountType + ", refundAccountNumber=" + refundAccountNumber + "]";
	}
}