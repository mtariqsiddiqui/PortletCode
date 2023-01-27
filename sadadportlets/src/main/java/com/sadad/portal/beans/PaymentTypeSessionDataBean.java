/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Tariq Siddiqui
 * 
 */
public class PaymentTypeSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String billerId;
	private String paymentType;
	private String iban;
	private String settlementBankKey;
	private String settlementType;	
	private String settlementId;
	private String settlementIdType;
	private String status;
	private boolean prepaid;
	private boolean defaultPostpaid;
	private boolean reverse;
	private boolean deefault;
	private String timeLimit;
	private String accessChannels;
	private String serviceTypes;
	private boolean configureSettlementCorrelation;
	private boolean multiAccountConditionsMet;
	private ArrayList<PaymentTypeSessionDataBean> paymentTypeList;
	private PaymentTypeSessionDataBean selectedPaymentType;

	public PaymentTypeSessionDataBean()
	{
		super();
	}

	public String getBillerId()
	{
		return billerId;
	}

	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public String getSettlementBankKey()
	{
		return settlementBankKey;
	}

	public void setSettlementBankKey(String settlementBankKey)
	{
		this.settlementBankKey = settlementBankKey;
	}

	public String getSettlementType()
	{
		return settlementType;
	}

	public void setSettlementType(String settlementType)
	{
		this.settlementType = settlementType;
	}

	public String getSettlementIdType()
	{
		return settlementIdType;
	}

	public void setSettlementIdType(String settlementIdType)
	{
		this.settlementIdType = settlementIdType;
	}
	
	public boolean isConfigureSettlementCorrelation()
	{
		return configureSettlementCorrelation;
	}

	public void setConfigureSettlementCorrelation(boolean configureSettlementCorrelation)
	{
		this.configureSettlementCorrelation = configureSettlementCorrelation;
	}

	public String getSettlementId()
	{
		return settlementId;
	}

	public void setSettlementId(String settlementId)
	{
		this.settlementId = settlementId;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String configurationStatusEnum)
	{
		this.status = configurationStatusEnum;
	}

	public boolean isPrepaid()
	{
		return prepaid;
	}

	public void setPrepaid(boolean prepaid)
	{
		this.prepaid = prepaid;
	}

	public boolean isDefaultPostpaid()
	{
		return defaultPostpaid;
	}

	public void setDefaultPostpaid(boolean defaultPostpaid)
	{
		this.defaultPostpaid = defaultPostpaid;
	}

	public boolean isReverse()
	{
		return reverse;
	}

	public void setReverse(boolean reverse)
	{
		this.reverse = reverse;
	}

	public boolean isDeefault()
	{
		return deefault;
	}

	public void setDeefault(boolean deefault)
	{
		this.deefault = deefault;
	}

	public String getTimeLimit()
	{
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit)
	{
		this.timeLimit = timeLimit;
	}

	public String getAccessChannels()
	{
		return accessChannels;
	}

	public void setAccessChannels(String accessChannels)
	{
		this.accessChannels = accessChannels;
	}

	public String getServiceTypes()
	{
		return serviceTypes;
	}

	public void setServiceTypes(String serviceTypes)
	{
		this.serviceTypes = serviceTypes;
	}

	public boolean isMultiAccountConditionsMet()
	{
		return multiAccountConditionsMet;
	}

	public void setMultiAccountConditionsMet(boolean multiAccountConditionsMet)
	{
		this.multiAccountConditionsMet = multiAccountConditionsMet;
	}

	public ArrayList<PaymentTypeSessionDataBean> getPaymentTypeList()
	{
		return paymentTypeList;
	}

	public void setPaymentTypeList(ArrayList<PaymentTypeSessionDataBean> paymentTypeList)
	{
		this.paymentTypeList = paymentTypeList;
	}

	public PaymentTypeSessionDataBean getSelectedPaymentType()
	{
		return selectedPaymentType;
	}

	public void setSelectedPaymentType(PaymentTypeSessionDataBean selectedPaymentType)
	{
		this.selectedPaymentType = selectedPaymentType;
	}
}