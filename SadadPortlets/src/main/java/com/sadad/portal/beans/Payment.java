package com.sadad.portal.beans;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.scm.common._1.PaymentLifecycleEnums;

public class Payment
{
	private String sadadNumber;
	private String bankNumber;
	private String reversalNumber;
	private String groupNumber;
	private String billerTransactionNumber;
	private String billerId;
	private String billNumber;
	private String accountNumber;
	private String billCycle;
	private String bankName;
	private String accessChannel;
	private String checkDigit;
	private String branchCode;
	private String districtCode;
	private String paymentType;
	private String paymentMethod;
	private String serviceId;
	private String beneficiaryId;
	private String customerId;
	private String refundId;
	private PaymentLifecycleEnums paymentStatus;
	private BigDecimal amount;
	private XMLGregorianCalendar processingDate;
	private String errorCode;
	private String errorDesc;
	private String fileName;
	
	/**
	 * @return the sadadNumber
	 */
	public String getSadadNumber()
	{
		return sadadNumber;
	}

	/**
	 * @param sadadNumber
	 *            the sadadNumber to set
	 */
	public void setSadadNumber(String sadadNumber)
	{
		this.sadadNumber = sadadNumber;
	}

	/**
	 * @return the bankNumber
	 */
	public String getBankNumber()
	{
		return bankNumber;
	}

	/**
	 * @param bankNumber
	 *            the bankNumber to set
	 */
	public void setBankNumber(String bankNumber)
	{
		this.bankNumber = bankNumber;
	}

	/**
	 * @return the reversalNumber
	 */
	public String getReversalNumber()
	{
		return reversalNumber;
	}

	/**
	 * @param reversalNumber
	 *            the reversalNumber to set
	 */
	public void setReversalNumber(String reversalNumber)
	{
		this.reversalNumber = reversalNumber;
	}

	/**
	 * @return the groupNumber
	 */
	public String getGroupNumber()
	{
		return groupNumber;
	}

	/**
	 * @param groupNumber
	 *            the groupNumber to set
	 */
	public void setGroupNumber(String groupNumber)
	{
		this.groupNumber = groupNumber;
	}

	/**
	 * @return the billerTransactionNumber
	 */
	public String getBillerTransactionNumber()
	{
		return billerTransactionNumber;
	}

	/**
	 * @param billerTransactionNumber
	 *            the billerTransactionNumber to set
	 */
	public void setBillerTransactionNumber(String billerTransactionNumber)
	{
		this.billerTransactionNumber = billerTransactionNumber;
	}

	/**
	 * @return the billerId
	 */
	public String getBillerId()
	{
		return billerId;
	}

	/**
	 * @param billerId
	 *            the billerId to set
	 */
	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	/**
	 * @return the billNumber
	 */
	public String getBillNumber()
	{
		return billNumber;
	}

	/**
	 * @param billNumber
	 *            the billNumber to set
	 */
	public void setBillNumber(String billNumber)
	{
		this.billNumber = billNumber;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the billCycle
	 */
	public String getBillCycle()
	{
		return billCycle;
	}

	/**
	 * @param billCycle
	 *            the billCycle to set
	 */
	public void setBillCycle(String billCycle)
	{
		this.billCycle = billCycle;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName()
	{
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	/**
	 * @return the accessChannel
	 */
	public String getAccessChannel()
	{
		return accessChannel;
	}

	/**
	 * @param accessChannel
	 *            the accessChannel to set
	 */
	public void setAccessChannel(String accessChannel)
	{
		this.accessChannel = accessChannel;
	}

	/**
	 * @return the checkDigit
	 */
	public String getCheckDigit()
	{
		return checkDigit;
	}

	/**
	 * @param checkDigit
	 *            the checkDigit to set
	 */
	public void setCheckDigit(String checkDigit)
	{
		this.checkDigit = checkDigit;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode()
	{
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}

	/**
	 * @return the districtCode
	 */
	public String getDistrictCode()
	{
		return districtCode;
	}

	/**
	 * @param districtCode
	 *            the districtCode to set
	 */
	public void setDistrictCode(String districtCode)
	{
		this.districtCode = districtCode;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType()
	{
		return paymentType;
	}

	/**
	 * @param paymentType
	 *            the paymentType to set
	 */
	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 *            the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId()
	{
		return serviceId;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(String serviceId)
	{
		this.serviceId = serviceId;
	}

	/**
	 * @return the beneficiaryId
	 */
	public String getBeneficiaryId()
	{
		return beneficiaryId;
	}

	/**
	 * @param beneficiaryId
	 *            the beneficiaryId to set
	 */
	public void setBeneficiaryId(String beneficiaryId)
	{
		this.beneficiaryId = beneficiaryId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId()
	{
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	/**
	 * @return the refundId
	 */
	public String getRefundId()
	{
		return refundId;
	}

	/**
	 * @param refundId
	 *            the refundId to set
	 */
	public void setRefundId(String refundId)
	{
		this.refundId = refundId;
	}

	/**
	 * @return the paymentStatus
	 */
	public PaymentLifecycleEnums getPaymentStatus()
	{
		return paymentStatus;
	}

	/**
	 * @param paymentLifecycleEnums
	 *            the paymentStatus to set
	 */
	public void setPaymentStatus(PaymentLifecycleEnums paymentLifecycleEnums)
	{
		this.paymentStatus = paymentLifecycleEnums;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount()
	{
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the processingDate
	 */
	public XMLGregorianCalendar getProcessingDate()
	{
		return processingDate;
	}

	/**
	 * @param processingDate the processingDate to set
	 */
	public void setProcessingDate(XMLGregorianCalendar processingDate)
	{
		this.processingDate = processingDate;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc()
	{
		return errorDesc;
	}

	/**
	 * @param errorDesc
	 *            the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc)
	{
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Payment [" + (sadadNumber != null ? "sadadNumber=" + sadadNumber + ", " : "") + (bankNumber != null ? "bankNumber=" + bankNumber + ", " : "") + (reversalNumber != null ? "reversalNumber=" + reversalNumber + ", " : "")
				+ (groupNumber != null ? "groupNumber=" + groupNumber + ", " : "") + (billerTransactionNumber != null ? "billerTransactionNumber=" + billerTransactionNumber + ", " : "")
				+ (billerId != null ? "billerId=" + billerId + ", " : "") + (billNumber != null ? "billNumber=" + billNumber + ", " : "") + (accountNumber != null ? "accountNumber=" + accountNumber + ", " : "")
				+ (billCycle != null ? "billCycle=" + billCycle + ", " : "") + (bankName != null ? "bankName=" + bankName + ", " : "") + (accessChannel != null ? "accessChannel=" + accessChannel + ", " : "")
				+ (checkDigit != null ? "checkDigit=" + checkDigit + ", " : "") + (branchCode != null ? "branchCode=" + branchCode + ", " : "") + (districtCode != null ? "districtCode=" + districtCode + ", " : "")
				+ (paymentType != null ? "paymentType=" + paymentType + ", " : "") + (paymentMethod != null ? "paymentMethod=" + paymentMethod + ", " : "") + (serviceId != null ? "serviceId=" + serviceId + ", " : "")
				+ (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") + (customerId != null ? "customerId=" + customerId + ", " : "") + (refundId != null ? "refundId=" + refundId + ", " : "")
				+ (paymentStatus != null ? "paymentStatus=" + paymentStatus + ", " : "") + (amount != null ? "amount=" + amount + ", " : "") + (processingDate != null ? "processingDate=" + processingDate + ", " : "")
				+ (errorCode != null ? "errorCode=" + errorCode + ", " : "") + (errorDesc != null ? "errorDesc=" + errorDesc + ", " : "") + (fileName != null ? "fileName=" + fileName : "") + "]";
	}
}