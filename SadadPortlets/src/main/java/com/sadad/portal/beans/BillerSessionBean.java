/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;


/**
 * @author Tariq Siddiqui
 *
 */
public class BillerSessionBean extends SadadPortalSessionBean
{
	private ArrayList<BillerDetail> inactiveBillerList;
	private BillerSessionBean biller;
	private BillerDetail selectedBiller;

	public BillerSessionBean()
	{
		super();
	}

	/**
	 * @return the biller
	 */
	public BillerSessionBean getBiller()
	{
		return biller;
	}

	/**
	 * @param biller the biller to set
	 */
	public void setBiller(BillerSessionBean biller)
	{
		this.biller = biller;
	}
	
	/**
	 * @return the inactiveBillerList
	 */
	public ArrayList<BillerDetail> getInactiveBillerList()
	{
		return inactiveBillerList;
	}

	/**
	 * @param inactiveBillerList the inactiveBillerList to set
	 */
	public void setInactiveBillerList(ArrayList<BillerDetail> inactiveBillerList)
	{
		this.inactiveBillerList = inactiveBillerList;
	}

	/**
	 * @return the selectedBiller
	 */
	public BillerDetail getSelectedBiller()
	{
		return selectedBiller;
	}

	/**
	 * @param selectedBiller the selectedBiller to set
	 */
	public void setSelectedBiller(BillerDetail selectedBiller)
	{
		this.selectedBiller = selectedBiller;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BillerSessionBean [biller=" + biller + ", selectedBiller=" + selectedBiller + "]";
	}
}