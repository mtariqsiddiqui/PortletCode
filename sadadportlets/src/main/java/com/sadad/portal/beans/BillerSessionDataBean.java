/**
 * 
 */
package com.sadad.portal.beans;

import java.util.HashMap;


/**
 * @author Tariq Siddiqui
 *
 */
public class BillerSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String billerType;
	private String billerId;
	private String billerName;
	private String billerArabicName;	
	private String description;
	private String status;
	private String billingAccountBankId;
	private String billingAccountType;
	private String billingAccountNumber;
	private String refundAccountBankId;
	private String refundAccountType;
	private String refundAccountNumber;
	private String defaultSettlementSettlementId;
	private boolean generateSettlementId;
	
//	private ArrayList<BillerSessionDataBean> inactiveBillerList;
	private BillerSessionDataBean selectedBiller;
	
	private HashMap<String, BillerSessionDataBean> billerMap = new HashMap<String, BillerSessionDataBean>();	

	public BillerSessionDataBean()
	{
		super();
	}

	public String getBillerType()
	{
		return billerType;
	}

	public void setBillerType(String billerType)
	{
		this.billerType = billerType;
	}

	public String getBillerId()
	{
		return billerId;
	}

	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	public String getBillerName()
	{
		return billerName;
	}

	public void setBillerName(String billerName)
	{
		this.billerName = billerName;
	}

	public String getBillerArabicName()
	{
		return billerArabicName;
	}

	public void setBillerArabicName(String billerArabicName)
	{
		this.billerArabicName = billerArabicName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getBillingAccountBankId()
	{
		return billingAccountBankId;
	}

	public void setBillingAccountBankId(String billingAccountBankId)
	{
		this.billingAccountBankId = billingAccountBankId;
	}

	public String getBillingAccountType()
	{
		return billingAccountType;
	}

	public void setBillingAccountType(String billingAccountType)
	{
		this.billingAccountType = billingAccountType;
	}

	public String getBillingAccountNumber()
	{
		return billingAccountNumber;
	}

	public void setBillingAccountNumber(String billingAccountNumber)
	{
		this.billingAccountNumber = billingAccountNumber;
	}

	public String getRefundAccountBankId()
	{
		return refundAccountBankId;
	}

	public void setRefundAccountBankId(String refundAccountBankId)
	{
		this.refundAccountBankId = refundAccountBankId;
	}

	public String getRefundAccountType()
	{
		return refundAccountType;
	}

	public void setRefundAccountType(String refundAccountType)
	{
		this.refundAccountType = refundAccountType;
	}

	public String getRefundAccountNumber()
	{
		return refundAccountNumber;
	}

	public void setRefundAccountNumber(String refundAccountNumber)
	{
		this.refundAccountNumber = refundAccountNumber;
	}

	public String getDefaultSettlementSettlementId()
	{
		return defaultSettlementSettlementId;
	}

	public void setDefaultSettlementSettlementId(String defaultSettlementSettlementId)
	{
		this.defaultSettlementSettlementId = defaultSettlementSettlementId;
	}
		
	public boolean isGenerateSettlementId()
	{
		return generateSettlementId;
	}

	public void setGenerateSettlementId(boolean generateSettlementId)
	{
		this.generateSettlementId = generateSettlementId;
	}

//	public ArrayList<BillerSessionDataBean> getInactiveBillerList()
//	{
//		return inactiveBillerList;
//	}
//
//	public void setInactiveBillerList(ArrayList<BillerSessionDataBean> inactiveBillerList)
//	{
//		this.inactiveBillerList = inactiveBillerList;
//	}

	public BillerSessionDataBean getSelectedBiller()
	{
		return selectedBiller;
	}

	public void setSelectedBiller(BillerSessionDataBean selectedBiller)
	{
		this.selectedBiller = selectedBiller;
	}

	public HashMap<String, BillerSessionDataBean> getBillerMap()
	{
		if(billerMap != null)
			return billerMap;
		else
			return new HashMap<String, BillerSessionDataBean>();
	}
}