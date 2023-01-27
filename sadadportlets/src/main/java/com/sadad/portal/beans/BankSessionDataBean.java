/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tariq Siddiqui
 *
 */
public class BankSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String bankId;
	private String bankName;
	private String description;
	private String status;
	private String suspenceAccount;
	private String refundAccount;
	private String sarieKey;
	
	private ArrayList<BankSessionDataBean> inactiveBankList;
	private BankSessionDataBean selectedBank;
	
	private HashMap<String, BankSessionDataBean> bankMap = new HashMap<String, BankSessionDataBean>();	
	
	public BankSessionDataBean()
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
	 * @return the bankName
	 */
	public String getBankName()
	{
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
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
	 * @return the suspenceAccount
	 */
	public String getSuspenceAccount()
	{
		return suspenceAccount;
	}

	/**
	 * @param suspenceAccount the suspenceAccount to set
	 */
	public void setSuspenceAccount(String suspenceAccount)
	{
		this.suspenceAccount = suspenceAccount;
	}

	/**
	 * @return the refundAccount
	 */
	public String getRefundAccount()
	{
		return refundAccount;
	}

	/**
	 * @param refundAccount the refundAccount to set
	 */
	public void setRefundAccount(String refundAccount)
	{
		this.refundAccount = refundAccount;
	}

	/**
	 * @return the sarieKey
	 */
	public String getSarieKey()
	{
		return sarieKey;
	}

	/**
	 * @param sarieKey the sarieKey to set
	 */
	public void setSarieKey(String sarieKey)
	{
		this.sarieKey = sarieKey;
	}

	/**
	 * @return the inactiveBankList
	 */
	public ArrayList<BankSessionDataBean> getInactiveBankList()
	{
		return inactiveBankList;
	}

	/**
	 * @param inactiveBankList the inactiveBankList to set
	 */
	public void setInactiveBankList(ArrayList<BankSessionDataBean> inactiveBankList)
	{
		this.inactiveBankList = inactiveBankList;
	}	

	/**
	 * @return the selectedBank
	 */
	public BankSessionDataBean getSelectedBank()
	{
		return selectedBank;
	}

	/**
	 * @param selectedBank the selectedBank to set
	 */
	public void setSelectedBank(BankSessionDataBean selectedBank)
	{
		this.selectedBank = selectedBank;
	}

	/**
	 * @return the billerMap
	 */
	public HashMap<String, BankSessionDataBean> getBankMap()
	{
		if(bankMap != null)
			return bankMap;
		else
			return new HashMap<String, BankSessionDataBean>();
	}
}