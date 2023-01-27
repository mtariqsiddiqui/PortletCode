package com.sadad.portal.beans;

import java.util.ArrayList;

public class BranchCodeSessionBean extends SadadPortalSessionBean
{
	private ArrayList<BranchCodeDetail> branchCodeList;
	private BranchCodeSessionBean branchCode;
	private BranchCodeDetail selectedBranchCode;

	public BranchCodeSessionBean()
	{
		super();
	}

	/**
	 * @return the branchCode
	 */
	public BranchCodeSessionBean getBranchCode()
	{
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(BranchCodeSessionBean branchCode)
	{
		this.branchCode = branchCode;
	}
	
	/**
	 * @return the branchCodeList
	 */
	public ArrayList<BranchCodeDetail> getBranchCodeList()
	{
		return branchCodeList;
	}

	/**
	 * @param branchCodeList the branchCodeList to set
	 */
	public void setBranchCodeList(ArrayList<BranchCodeDetail> branchCodeList)
	{
		this.branchCodeList = branchCodeList;
	}

	/**
	 * @return the selectedBranchCode
	 */
	public BranchCodeDetail getSelectedBranchCode()
	{
		return selectedBranchCode;
	}

	/**
	 * @param selectedBranchCode the selectedBranchCode to set
	 */
	public void setSelectedBranchCode(BranchCodeDetail selectedBranchCode)
	{
		this.selectedBranchCode = selectedBranchCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BranchCodeSessionBean [branchCode=" + branchCode + ", selectedBranchCode=" + selectedBranchCode + "]";
	}
}