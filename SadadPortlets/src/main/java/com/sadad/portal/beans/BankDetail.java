package com.sadad.portal.beans;

public class BankDetail
{
	String bankId;
	String bankName;
	String description;
	String status;
	String suspenceAccount;
	String refundAccount;
	String sarieKey;
	
	/**
	 * @return the bankId
	 */
	public String getBankId()
	{
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(String bankId)
	{
		this.bankId = bankId;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName()
	{
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * @param description the description to set
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
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	/**
	 * @return the suspenceAccount
	 */
	public String getSuspenceAccount()
	{
		return suspenceAccount;
	}
	/**
	 * @param suspenceAccount the suspenceAccount to set
	 */
	public void setSuspenceAccount(String suspenceAccount)
	{
		this.suspenceAccount = suspenceAccount;
	}
	/**
	 * @return the refundAccount
	 */
	public String getRefundAccount()
	{
		return refundAccount;
	}
	/**
	 * @param refundAccount the refundAccount to set
	 */
	public void setRefundAccount(String refundAccount)
	{
		this.refundAccount = refundAccount;
	}
	
	/**
	 * @return the sarieKey
	 */
	public String getSarieKey()
	{
		return sarieKey;
	}
	/**
	 * @param sarieKey the sarieKey to set
	 */
	public void setSarieKey(String sarieKey)
	{
		this.sarieKey = sarieKey;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BankDetail [bankId=" + bankId + ", bankName=" + bankName + ", description=" + description + ", status=" + status + ", suspenceAccount=" + suspenceAccount + ", refundAccount=" + refundAccount + "]";
	}

}
