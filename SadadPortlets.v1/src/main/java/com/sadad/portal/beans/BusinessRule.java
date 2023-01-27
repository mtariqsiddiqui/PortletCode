package com.sadad.portal.beans;

public class BusinessRule
{
	private String billerId;
	private String billCategory;
	private String ruleType;
	private String ruleStatus;

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
	 * @return the billCategory
	 */
	public String getBillCategory()
	{
		return billCategory;
	}

	/**
	 * @param billCategory
	 *            the billCategory to set
	 */
	public void setBillCategory(String billCategory)
	{
		this.billCategory = billCategory;
	}

	/**
	 * @return the ruleType
	 */
	public String getRuleType()
	{
		return ruleType;
	}

	/**
	 * @param ruleType
	 *            the ruleType to set
	 */
	public void setRuleType(String ruleType)
	{
		this.ruleType = ruleType;
	}

	/**
	 * @return the ruleStatus
	 */
	public String getRuleStatus()
	{
		return ruleStatus;
	}

	/**
	 * @param ruleStatus
	 *            the ruleStatus to set
	 */
	public void setRuleStatus(String ruleStatus)
	{
		this.ruleStatus = ruleStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BusinessRule [billerId=" + billerId + ", billCategory=" + billCategory + ", ruleType=" + ruleType + ", ruleStatus=" + ruleStatus + "]";
	}	
}