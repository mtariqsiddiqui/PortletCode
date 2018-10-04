package com.sadad.portal.beans;

public class Customer
{
	private String officialIdNumber;
	private String officialIdType;
	private String customerStatus;
	private String customerType;

	/**
	 * @return the officialIdNumber
	 */
	public String getOfficialIdNumber()
	{
		return officialIdNumber;
	}
	
	/**
	 * @param officialIdNumber the officialIdNumber to set
	 */
	public void setOfficialIdNumber(String officialIdNumber)
	{
		this.officialIdNumber = officialIdNumber;
	}
	
	/**
	 * @return the officialIdType
	 */
	public String getOfficialIdType()
	{
		return officialIdType;
	}
	
	/**
	 * @param officialIdType the officialIdType to set
	 */
	public void setOfficialIdType(String officialIdType)
	{
		this.officialIdType = officialIdType;
	}
	
	/**
	 * @return the customerStatus
	 */
	public String getCustomerStatus()
	{
		return customerStatus;
	}
	
	/**
	 * @param customerStatus the customerStatus to set
	 */
	public void setCustomerStatus(String customerStatus)
	{
		this.customerStatus = customerStatus;
	}
	
	/**
	 * @return the customerType
	 */
	public String getCustomerType()
	{
		return customerType;
	}
	
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType)
	{
		this.customerType = customerType;
	}	
}