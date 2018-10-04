package com.sadad.portal.beans;

import com.sadad.scm.common._1.ConfigurationStatusEnum;

public class BranchCodeDetail
{
	private String branchCode;
	private ConfigurationStatusEnum status;

	/**
	 * @return the branchCode
	 */
	public String getBranchCode()
	{
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}

	/**
	 * @return the status
	 */
	public ConfigurationStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ConfigurationStatusEnum status)
	{
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BranchCodeDetail [branchCode=" + branchCode + ", status=" + status + "]";
	}
}