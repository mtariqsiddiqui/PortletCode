/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tariq Siddiqui
 * 
 */

public class RejectedEbppSessionBean extends SadadPortalSessionBean
{
	private String rquid;
	private String ebppEntityKey;
	
	public RejectedEbppSessionBean()
	{
		super();
	}
	
	/**
	 * @return the rquid
	 */
	public String getRquid()
	{
		return rquid;
	}

	/**
	 * @param rquid
	 *            the rquid to set
	 */
	public void setRquid(String rquid)
	{
		this.rquid = rquid;
	}
	
	/**
	 * @return the ebppEntityKey
	 */
	public String getEbppEntityKey()
	{
		return ebppEntityKey;
	}

	/**
	 * @param ebppEntityKey
	 *            the ebppEntityKey to set
	 */
	public void setEbppEntityKey(String ebppEntityKey)
	{
		this.ebppEntityKey = ebppEntityKey;
	}

	private List<Bill> rejectedBills;

	/**
	 * @return the rejectedBills
	 */
	public List<Bill> getRejectedBills()
	{
		if(rejectedBills == null)
			rejectedBills = new ArrayList<Bill>();
		return rejectedBills;
	}

	private List<Payment> rejectedPayments;

	/**
	 * @return the rejectedPayments
	 */
	public List<Payment> getRejectedPayments()
	{
		if(rejectedPayments == null)
			rejectedPayments = new ArrayList<Payment>();
		return rejectedPayments;
	}


	private List<Account> rejectedAccounts;
	
	/**
	 * @return the rejectedAccounts
	 */
	public List<Account> getRejectedAccounts()
	{
		if (rejectedAccounts == null)
			rejectedAccounts = new ArrayList<Account>();
		return rejectedAccounts;
	}
}
