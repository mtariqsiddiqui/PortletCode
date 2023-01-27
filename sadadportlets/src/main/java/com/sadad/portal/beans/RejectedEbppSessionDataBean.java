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

public class RejectedEbppSessionDataBean extends SadadPortalSessionDataBean
{
	private String billerId;
	private String rquid;
	private String searchType;
	private String ebppEntityKey;
	private List<Account> rejectedAccounts;
	private List<Bill> rejectedBills;
	private List<Payment> rejectedPayments;

	public RejectedEbppSessionDataBean()
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
	 * @return the searchType
	 */
	public String getSearchType()
	{
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType)
	{
		this.searchType = searchType;
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

	/**
	 * @return the rejectedAccounts
	 */
	public List<Account> getRejectedAccounts()
	{
		if (rejectedAccounts == null)
			rejectedAccounts = new ArrayList<Account>();
		return rejectedAccounts;
	}
	
	public void setRejectedAccounts(ArrayList<Account> ala)
	{
		rejectedAccounts = ala;
	}
	
	/**
	 * @return the rejectedBills
	 */
	public List<Bill> getRejectedBills()
	{
		if (rejectedBills == null)
			rejectedBills = new ArrayList<Bill>();
		return rejectedBills;
	}

	public void setRejectedBills(ArrayList<Bill> alb)
	{
		rejectedBills = alb;
	}

	/**
	 * @return the rejectedPayments
	 */
	public List<Payment> getRejectedPayments()
	{
		if (rejectedPayments == null)
			rejectedPayments = new ArrayList<Payment>();
		return rejectedPayments;
	}
	
	public void setRejectedPayments(ArrayList<Payment> alp)
	{
		rejectedPayments = alp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final int maxLen = 10;
		return "RejectedEbppSessionDataBean [" + (billerId != null ? "billerId=" + billerId + ", " : "") + (rquid != null ? "rquid=" + rquid + ", " : "") + (searchType != null ? "searchType=" + searchType + ", " : "")
				+ (ebppEntityKey != null ? "ebppEntityKey=" + ebppEntityKey + ", " : "") + (rejectedAccounts != null ? "rejectedAccounts=" + rejectedAccounts.subList(0, Math.min(rejectedAccounts.size(), maxLen)) + ", " : "")
				+ (rejectedBills != null ? "rejectedBills=" + rejectedBills.subList(0, Math.min(rejectedBills.size(), maxLen)) + ", " : "")
				+ (rejectedPayments != null ? "rejectedPayments=" + rejectedPayments.subList(0, Math.min(rejectedPayments.size(), maxLen)) : "") + "]";
	}
}