/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 *
 */
public class BankSessionBean extends SadadPortalSessionBean
{
	private ArrayList<BankDetail> inactiveBankList;
	private BankSessionBean bank;
	private BankDetail selectedBank;

	public BankSessionBean()
	{
		super();
	}

	/**
	 * @return the bank
	 */
	public BankSessionBean getBank()
	{
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(BankSessionBean bank)
	{
		this.bank = bank;
	}
	
	/**
	 * @return the inactiveBankList
	 */
	public ArrayList<BankDetail> getInactiveBankList()
	{
		return inactiveBankList;
	}

	/**
	 * @param inactiveBankList the inactiveBankList to set
	 */
	public void setInactiveBankList(ArrayList<BankDetail> inactiveBankList)
	{
		this.inactiveBankList = inactiveBankList;
	}	

	/**
	 * @return the selectedBank
	 */
	public BankDetail getSelectedBank()
	{
		return selectedBank;
	}

	/**
	 * @param selectedBank the selectedBank to set
	 */
	public void setSelectedBank(BankDetail selectedBank)
	{
		this.selectedBank = selectedBank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "BankSessionBean [bank=" + bank + ", selectedBank=" + selectedBank + "]";
	}
}