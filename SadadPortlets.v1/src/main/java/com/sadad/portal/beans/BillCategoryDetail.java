package com.sadad.portal.beans;

import com.sadad.scm.common._1.ConfigurationStatusEnum;

public class BillCategoryDetail
{
	private String billCategory;
	private String description;
	private ConfigurationStatusEnum status;

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
	public ConfigurationStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * @param configurationStatusEnum
	 *            the status to set
	 */
	public void setStatus(ConfigurationStatusEnum configurationStatusEnum)
	{
		this.status = configurationStatusEnum;
	}
}
