/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillCategorySessionBean extends SadadPortalSessionBean
{
	private ArrayList<BillCategoryDetail> billCategoryList;
	private BillCategorySessionBean billerBillCategory;
	private BillCategoryDetail selectedBillCategory;

	public BillCategorySessionBean()
	{
		super();
	}
	
	/**
	 * @return the billerBillCategory
	 */
	public BillCategorySessionBean getBillerBillCategory()
	{
		return billerBillCategory;
	}

	/**
	 * @param billerBillCategory
	 *            the billerBillCategory to set
	 */
	public void setBillerBillCategory(BillCategorySessionBean billerBillCategory)
	{
		this.billerBillCategory = billerBillCategory;
	}

	/**
	 * @return the billCategoryList
	 */
	public ArrayList<BillCategoryDetail> getBillCategoryList()
	{
		return billCategoryList;
	}

	/**
	 * @return 
	 * @return the billCategoryList
	 */
	public void setBillCategoryList(ArrayList<BillCategoryDetail> blc)
	{
		this.billCategoryList = blc;
	}

	/**
	 * @return the selectedBillCategory
	 */
	public BillCategoryDetail getSelectedBillCategory()
	{
		return selectedBillCategory;
	}

	/**
	 * @param selectedBillCategory the selectedBillCategory to set
	 */
	public void setSelectedBillCategory(BillCategoryDetail selectedBillCategory)
	{
		this.selectedBillCategory = selectedBillCategory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BillCategorySessionBean [billCategoryList=" + billCategoryList + ", billerBillCategory=" + billerBillCategory + ", selectedBillCategory=" + selectedBillCategory + "]";
	}
}