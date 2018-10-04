package com.sadad.portal.beans;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.scm.common._1.AccountLifecycleEnums;
import com.sadad.scm.common._1.AccountSourceEnum;
import com.sadad.scm.common._1.PartyType;

public class Account
{
	private String accountNumber;
	private String billerId;
	private String serviceType;
	private AccountLifecycleEnums lifecycle;
	private AccountSourceEnum accountSource;
	private PartyType beneficiary;
	private XMLGregorianCalendar createDate;
	private String errorCode;
	private String errorDesc;
	private String fileName;

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
	 * @return the lifecycle
	 */
	public AccountLifecycleEnums getLifecycle()
	{
		return lifecycle;
	}

	/**
	 * @param accountLifecycleEnums
	 *            the lifecycle to set
	 */
	public void setLifecycle(AccountLifecycleEnums accountLifecycleEnums)
	{
		this.lifecycle = accountLifecycleEnums;
	}

	/**
	 * @return the accountSource
	 */
	public AccountSourceEnum getAccountSource()
	{
		return accountSource;
	}

	/**
	 * @param accountSourceEnum
	 *            the accountSource to set
	 */
	public void setAccountSource(AccountSourceEnum accountSourceEnum)
	{
		this.accountSource = accountSourceEnum;
	}

	/**
	 * @return the beneficiary
	 */
	public PartyType getBeneficiary()
	{
		return beneficiary;
	}

	/**
	 * @param partyType
	 *            the beneficiary to set
	 */
	public void setBeneficiary(PartyType partyType)
	{
		this.beneficiary = partyType;
	}

	/**
	 * @return the createDate
	 */
	public XMLGregorianCalendar getCreateDate()
	{
		return createDate;
	}

	/**
	 * @param xmlGregorianCalendar
	 *            the createDate to set
	 */
	public void setCreateDate(XMLGregorianCalendar xmlGregorianCalendar)
	{
		this.createDate = xmlGregorianCalendar;
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