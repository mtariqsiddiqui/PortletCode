package com.sadad.portal.beans;

public class SadadAdminSessionBean extends SadadPortalSessionBean
{
	private String sadadId;
	private String sadadName;
	private String sadadDescription;
	private String sadadCurrentAccount;
	private String accountBankId;
	private String accountBankName;
	private int refundMaxLimit;

	public SadadAdminSessionBean()
	{
		super();
	}

	/**
	 * @return the sadadId
	 */
	public String getSadadId()
	{
		return sadadId;
	}

	/**
	 * @param sadadId
	 *            the sadadId to set
	 */
	public void setSadadId(String sadadId)
	{
		this.sadadId = sadadId;
	}

	/**
	 * @return the sadadName
	 */
	public String getSadadName()
	{
		return sadadName;
	}

	/**
	 * @param sadadName
	 *            the sadadName to set
	 */
	public void setSadadName(String sadadName)
	{
		this.sadadName = sadadName;
	}

	/**
	 * @return the sadadDescription
	 */
	public String getSadadDescription()
	{
		return sadadDescription;
	}

	/**
	 * @param sadadDescription
	 *            the sadadDescription to set
	 */
	public void setSadadDescription(String sadadDescription)
	{
		this.sadadDescription = sadadDescription;
	}

	/**
	 * @return the sadadCurrentAccount
	 */
	public String getSadadCurrentAccount()
	{
		return sadadCurrentAccount;
	}

	/**
	 * @param sadadCurrentAccount
	 *            the sadadCurrentAccount to set
	 */
	public void setSadadCurrentAccount(String sadadCurrentAccount)
	{
		this.sadadCurrentAccount = sadadCurrentAccount;
	}

	/**
	 * @return the accountBankId
	 */
	public String getAccountBankId()
	{
		return accountBankId;
	}

	/**
	 * @param accountBankId
	 *            the accountBankId to set
	 */
	public void setAccountBankId(String accountBankId)
	{
		this.accountBankId = accountBankId;
	}

	/**
	 * @return the accountBankName
	 */
	public String getAccountBankName()
	{
		return accountBankName;
	}

	/**
	 * @param accountBankName
	 *            the accountBankName to set
	 */
	public void setAccountBankName(String accountBankName)
	{
		this.accountBankName = accountBankName;
	}

	/**
	 * @return the refundMaxLimit
	 */
	public int getRefundMaxLimit()
	{
		return refundMaxLimit;
	}

	/**
	 * @param refundMaxLimit
	 *            the refundMaxLimit to set
	 */
	public void setRefundMaxLimit(int refundMaxLimit)
	{
		this.refundMaxLimit = refundMaxLimit;
	}
}
