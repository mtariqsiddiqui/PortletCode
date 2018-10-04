package com.sadad.portal.beans;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

public class Bill
{
	private String billKey;
	private String billerId;
	private String serviceType;
	private String accountNumber;
	private String rquid;
	private String billNumber;
	private String billType;
	private String billCycle;
	private String billStatus;
	private String billCategory;
	private int paymentCount;
	private BigDecimal origianlAmount;
	private BigDecimal netAmount;
	private XMLGregorianCalendar dueDate;
	private XMLGregorianCalendar expiryDate;
	private XMLGregorianCalendar billGeneratedDate;
	private XMLGregorianCalendar billCreateionDate;
	private String errorCode;
	private String errorDesc;
	private String fileName;

	/**
	 * @return the billKey
	 */
	public String getBillKey()
	{
		return billKey;
	}

	/**
	 * @param billKey the billKey to set
	 */
	public void setBillKey(String billKey)
	{
		this.billKey = billKey;
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
	 * @return the serviceType
	 */
	public String getServiceType()
	{
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(String serviceType)
	{
		this.serviceType = serviceType;
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
	 * @return the billType
	 */
	public String getBillType()
	{
		return billType;
	}

	/**
	 * @param billType
	 *            the billType to set
	 */
	public void setBillType(String billType)
	{
		this.billType = billType;
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
	 * @return the billStatus
	 */
	public String getBillStatus()
	{
		return billStatus;
	}

	/**
	 * @param billStatus
	 *            the billStatus to set
	 */
	public void setBillStatus(String billStatus)
	{
		this.billStatus = billStatus;
	}

	/**
	 * @return the billCategory
	 */
	public String getBillCategory()
	{
		return billCategory;
	}

	/**
	 * @param billCategory
	 *            the billCategory to set
	 */
	public void setBillCategory(String billCategory)
	{
		this.billCategory = billCategory;
	}

	/**
	 * @return the paymentCount
	 */
	public int getPaymentCount()
	{
		return paymentCount;
	}

	/**
	 * @param paymentCount
	 *            the paymentCount to set
	 */
	public void setPaymentCount(int paymentCount)
	{
		this.paymentCount = paymentCount;
	}

	/**
	 * @return the origianlAmount
	 */
	public BigDecimal getOrigianlAmount()
	{
		return origianlAmount;
	}

	/**
	 * @param origianlAmount
	 *            the origianlAmount to set
	 */
	public void setOrigianlAmount(BigDecimal origianlAmount)
	{
		this.origianlAmount = origianlAmount;
	}

	/**
	 * @return the netAmount
	 */
	public BigDecimal getNetAmount()
	{
		return netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(BigDecimal netAmount)
	{
		this.netAmount = netAmount;
	}

	/**
	 * @return the dueDate
	 */
	public XMLGregorianCalendar getDueDate()
	{
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(XMLGregorianCalendar dueDate)
	{
		this.dueDate = dueDate;
	}

	/**
	 * @return the expiryDate
	 */
	public XMLGregorianCalendar getExpiryDate()
	{
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(XMLGregorianCalendar expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the billGeneratedDate
	 */
	public XMLGregorianCalendar getBillGeneratedDate()
	{
		return billGeneratedDate;
	}

	/**
	 * @param billGeneratedDate
	 *            the billGeneratedDate to set
	 */
	public void setBillGeneratedDate(XMLGregorianCalendar billGeneratedDate)
	{
		this.billGeneratedDate = billGeneratedDate;
	}

	/**
	 * @return the billCreateionDate
	 */
	public XMLGregorianCalendar getBillCreateionDate()
	{
		return billCreateionDate;
	}

	/**
	 * @param billCreateionDate
	 *            the billCreateionDate to set
	 */
	public void setBillCreateionDate(XMLGregorianCalendar billCreateionDate)
	{
		this.billCreateionDate = billCreateionDate;
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
}
