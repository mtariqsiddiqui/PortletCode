package com.sadad.portal.beans;

import java.util.LinkedHashMap;

import com.sadad.portal.constant.PortalConstant;
//import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.constant.SadadDynamicDataConfiguration;

/**
 * @author Tariq Siddiqui
 * 
 */
public class IbanSessionDataBean extends SadadPortalSessionDataBean
{
	private String iban;
	private String settlementId;
	private String fromDate;
	private String toDate;
	private String billerId;
	private String customerIdType;
	private String customerId;
	private String accountType;
	private String status;
	private String createDate;
	private String action;
	private String justification;
	private LinkedHashMap<String, IbanRecordBean> ibans;
	private String ibanKey;
	private String billerStatus;
	private int pageNumber;
	private int totalPages;
	private char fetchOperator;

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public String getSettlementId()
	{
		return settlementId;
	}

	public void setSettlementId(String settlementId)
	{
		this.settlementId = settlementId;
	}

	public String getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	public String getToDate()
	{
		return toDate;
	}

	public void setToDate(String toDate)
	{
		this.toDate = toDate;
	}

	public String getBillerId()
	{
		return billerId;
	}

	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	public String getCustomerIdType()
	{
		return customerIdType;
	}

	public void setCustomerIdType(String customerIdType)
	{
		this.customerIdType = customerIdType;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getJustification()
	{
		return justification;
	}

	public void setJustification(String justification)
	{
		this.justification = justification;
	}

	public LinkedHashMap<String, IbanRecordBean> getIbans()
	{
		if (ibans == null)
			ibans = new LinkedHashMap<String, IbanRecordBean>();
		return ibans;
	}

	public String getIbanKey()
	{
		return ibanKey;
	}

	public void setIbanKey(String ibanKey)
	{
		this.ibanKey = ibanKey;
	}

	public boolean isIbanMaker()
	{
		return (this.userGroups.indexOf(SadadDynamicDataConfiguration.GROUP_FOR_IBAN_MAKER) >= 0);
	}

	public boolean isIbanChecker()
	{
		return (this.userGroups.indexOf(SadadDynamicDataConfiguration.GROUP_FOR_IBAN_CHECKER) >= 0);
	}

	public String getBillerStatus()
	{
		return billerStatus;
	}

	public void setBillerStatus(String billerStatus)
	{
		this.billerStatus = billerStatus;
	}
	
	// TODO - Remove the below commented code as it is not used anywhere
	// TODO - Remove the code also from ApproveIbanDetails.jsp file 
//	public static String ACTION_CREATE = "CREATE";
//	public static String ACTION_ACTIVATE = "ACTIVATE";
//	public static String ACTION_DEACTIVATE = "DEACTIVATE";
//	public static String ACTION_APPROVE = "APPROVE";
//	public static String ACTION_REJECT = "REJECT";

//	public static String getACTION_CREATE()
//	{
//		return ACTION_CREATE;
//	}
//
//	public static String getACTION_ACTIVATE()
//	{
//		return ACTION_ACTIVATE;
//	}
//
//	public static String getACTION_DEACTIVATE()
//	{
//		return ACTION_DEACTIVATE;
//	}
//
//	public static String getACTION_APPROVE()
//	{
//		return ACTION_APPROVE;
//	}
//
//	public static String getACTION_REJECT()
//	{
//		return ACTION_REJECT;
//	}

	public boolean isAllowUpdate(IbanRecordBean rec)
	{
		if(rec.getCurrentRecord() == null) // When current record does not exist, record can't be ACTIVATE / DEACTIVATE
			return false;
		else if(rec.getPendingRecord() != null) // When pending record exist, record can't be Updated or Activate/Deactivate
			return false;			
		else if(rec.getCurrentRecord().getStatus().equalsIgnoreCase(PortalConstant.STATUS_ACTIVE))
			return true;
		else
			return false;	
	}

	public int getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public char getFetchOperator()
	{
		return fetchOperator;
	}

	public void setFetchOperator(char fetchOperator)
	{
		this.fetchOperator = fetchOperator;
	}
}