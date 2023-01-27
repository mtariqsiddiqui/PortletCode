package com.sadad.portal.beans;

import java.util.ArrayList;

public class BranchCodeSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String bankId;
	private String branchCode;
	private String status;
	private ArrayList<BranchCodeSessionDataBean> branchCodeList;
	private BranchCodeSessionDataBean selectedBranchCode;

	public BranchCodeSessionDataBean()
	{
		super();
	}

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
	 * @return the branchCode
	 */
	public String getBranchCode()
	{
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
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
	 * @return the branchCodeList
	 */
	public ArrayList<BranchCodeSessionDataBean> getBranchCodeList()
	{
		return branchCodeList;
	}

	/**
	 * @param branchCodeList the branchCodeList to set
	 */
	public void setBranchCodeList(ArrayList<BranchCodeSessionDataBean> branchCodeList)
	{
		this.branchCodeList = branchCodeList;
	}

	/**
	 * @return the selectedBranchCode
	 */
	public BranchCodeSessionDataBean getSelectedBranchCode()
	{
		return selectedBranchCode;
	}

	/**
	 * @param selectedBranchCode the selectedBranchCode to set
	 */
	public void setSelectedBranchCode(BranchCodeSessionDataBean selectedBranchCode)
	{
		this.selectedBranchCode = selectedBranchCode;
	}

	@Override
	public String toString()
	{
		return "BranchCodeSessionDataBean [" + (bankId != null ? "bankId=" + bankId + ", " : "") + (branchCode != null ? "branchCode=" + branchCode + ", " : "") + (status != null ? "status=" + status + ", " : "")
				+ (branchCodeList != null ? "branchCodeList=" + branchCodeList + ", " : "") + (selectedBranchCode != null ? "selectedBranchCode=" + selectedBranchCode : "") + "]";
	}
}