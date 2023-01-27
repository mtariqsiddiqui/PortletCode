/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillCategorySessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String billerId;	
	private String billCategory;
	private String description;
	private String status;
	private ArrayList<BillCategorySessionDataBean> billCategoryList;
	private BillCategorySessionDataBean selectedBillCategory;

	public BillCategorySessionDataBean()
	{
		super();
	}
	
	/**
	 * @return the billerId
	 */
	public String getBillerId()
	{
		return billerId;
	}

	/**
	 * @param billerId the billerId to set
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
	 * @param billCategory the billCategory to set
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
	 * @return the billCategoryList
	 */
	public ArrayList<BillCategorySessionDataBean> getBillCategoryList()
	{
		return billCategoryList;
	}

	/**
	 * @param billCategoryList the billCategoryList to set
	 */
	public void setBillCategoryList(ArrayList<BillCategorySessionDataBean> billCategoryList)
	{
		this.billCategoryList = billCategoryList;
	}

	/**
	 * @return the selectedBillCategory
	 */
	public BillCategorySessionDataBean getSelectedBillCategory()
	{
		return selectedBillCategory;
	}

	/**
	 * @param selectedBillCategory the selectedBillCategory to set
	 */
	public void setSelectedBillCategory(BillCategorySessionDataBean selectedBillCategory)
	{
		this.selectedBillCategory = selectedBillCategory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BillCategorySessionDataBean [" + (billerId != null ? "billerId=" + billerId + ", " : "") + (billCategory != null ? "billCategory=" + billCategory + ", " : "") + (description != null ? "description=" + description + ", " : "")
				+ (status != null ? "status=" + status + ", " : "") + (billCategoryList != null ? "billCategoryList=" + billCategoryList + ", " : "") + (selectedBillCategory != null ? "selectedBillCategory=" + selectedBillCategory : "")
				+ "]";
	}
}